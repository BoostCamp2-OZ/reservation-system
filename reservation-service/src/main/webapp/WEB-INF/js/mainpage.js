/**
 * Created by ODOL on 2017. 7. 10..
 */
var API_ROOT_URL = '/api/';
var ROOT_URL = '/main/';
var CONTENT_TYPE_JSON = "application/json; charset=UTF-8";
var CONTENT_TYPE_DEFAULT = "application/x-www-form-urlencoded"
var GLOBAL_VAR = {
    //selector wrapping by jquery
    $headerClass: $('header.header_tit'),
    $lnkLogoClass: $('a.lnk_logo'),
    $btnMyClass: $('a.btn_my'),
    $eventTabLst: $('ul.event_tab_lst'),
    $lstEventBox: $('ul.lst_event_box'),
    $wrapEventBox: $('div.wrap_event_box'),
    $pEventLstTxt: $('span.pink'),
    $btnMore: $('div.more>button'),

    //selector
    lnkLogoClass: "a.lnk_logo",

    //global
    $selectedCategory: $('ul.event_tab_lst>li:first-child').find("a"),
    activeCategory: 0,
    productList: [],
    offset: 0
};


(function (window) {

    var commonAPIModule = {
        bindEventOnClick: function ($wrapperDom, targetDom, func) {
            $wrapperDom.on('click', targetDom, func);
        },

        ajax: function (data, url, dataType, type, contentType) {
            return $.ajax({
                data: JSON.stringify(data),
                url: url,
                dataType: dataType,
                type: type,
                contentType: ((contentType === undefined) ? CONTENT_TYPE_DEFAULT : CONTENT_TYPE_JSON)
            });
        },

        getActiveProducts: function (activeCategoryId, productList) {
            var activeProducts = {
                count: 0,
                products: []
            };
            for (var i in productList) {
                if (activeCategoryId === 0 || productList[i].categoryId === activeCategoryId) {
                    activeProducts.count++;
                    activeProducts.products.push(productList[i]);
                }
            }
            return activeProducts;
        }
    };

    //event box(product list)
    var productListModule = {
        init: function () {
            this.renderProductList(4);
        },

        renderProductList: function (limit) {
            var url;
            var category = GLOBAL_VAR.activeCategory;
            if(category !== 0 ) {
                url = API_ROOT_URL + "products/" + category + "?offset=" + GLOBAL_VAR.offset + "&limit=" +limit;
            } else {
                url  = API_ROOT_URL + "products?offset=" + GLOBAL_VAR.offset + "&limit=" +limit;
            }
            var getProducts = commonAPIModule.ajax(undefined, url, "json", "get", "json");
            getProducts.then(function (products) {
                GLOBAL_VAR.productList = products;
                productListModule.appendElement(category, products);
                GLOBAL_VAR.offset = GLOBAL_VAR.offset + products.length;
            });
        },

        appendElement: function (activeCategoryId, products) {
            // var activeProducts = commonAPIModule.getActiveProducts(activeCategoryId, productList);
            // var products = activeProducts.products;
            // for (var i = GLOBAL_VAR.offset; i < (limit + GLOBAL_VAR.offset); i++) {
            for(var i in products) {
                var $target = ((i % 2 === 0) ? $('ul.left') : $('ul.right'));
                var element = productListModule.eventBoxElement(
                    products[i].categoryId, products[i].name, products[i].saveFileName, products[i].placeName, products[i].description);
                $target.append(element);
            }
        },

        eventBoxElement: function (id, imgAlt, imgSrc, smallLocation, pDescription) {
            var template = $('#productListTemplate').html();
            var templateScript = Handlebars.compile(template);
            var context = {
                "id": id,
                "imgAlt": imgAlt,
                "imgSrc": imgSrc,
                "smallLocation": smallLocation,
                "pDescription": pDescription
            };
            var element = templateScript(context);
            return element;
        },

        removeListItem: function ($parentElement) {
            var target = $parentElement.find("li.item");
            $(target).remove();
            GLOBAL_VAR.offset = 0;
            // if (GLOBAL_VAR.activeCategory === 0) {
            //     $(target).show();
            // } else {
            //     $(target.filter(function (item) {
            //         return $(item).data("category") !== GLOBAL_VAR.activeCategory;
            //     })).hide();
            //
            //     $(target.filter(function (i, item) {
            //         return $(item).data("category") === GLOBAL_VAR.activeCategory;
            //     })).show();
            // }
        }
    }


    //category select section
    var categoryModule = {
        init: function () {
            this.renderCategoryList();
            this.bindClickEvent();
            this.setActiveProductsCount();
        },

        bindClickEvent: function () {
            commonAPIModule.bindEventOnClick(GLOBAL_VAR.$eventTabLst, "a.anchor", categoryModule.setActive.bind(this));
            commonAPIModule.bindEventOnClick(GLOBAL_VAR.$btnMore, productListModule.renderProductList.bind(undefined, 2));
        },

        setActive: function (event) {
            event.stopPropagation();
            GLOBAL_VAR.$selectedCategory.removeClass("active");
            var $eventTarget = $(event.target).closest("li").find("a.anchor");
            $eventTarget.addClass("active");
            GLOBAL_VAR.$selectedCategory = $eventTarget;
            GLOBAL_VAR.activeCategory = $eventTarget.closest(".item").data("category");
            productListModule.removeListItem(GLOBAL_VAR.$lstEventBox);
            productListModule.renderProductList(4);
            // categoryModule.setActiveProductsCount();
        },

        setActiveProductsCount: function () {
            var count = 0;
            // if (GLOBAL_VAR.activeCategory === 0) {
            //     count = GLOBAL_VAR.productList.length;
            // } else {
            //     for (var i in GLOBAL_VAR.productList) {
            //         count = ((GLOBAL_VAR.productList[i].categoryId === GLOBAL_VAR.activeCategory ) ? count+1 : count);
            //     }
            // }
            var getCount = commonAPIModule.ajax(undefined, API_ROOT_URL + "products/count", "json", "get", "json");
            getCount.then(function (count) {
                GLOBAL_VAR.$pEventLstTxt.text(count + "개");
            });
        },

        renderCategoryList: function () {
            var getCategories = commonAPIModule.ajax(undefined, API_ROOT_URL + "categories/", "json", "get", "json");
            getCategories.then(function (categories) {
                var defaultCategory = {
                    id: 0,
                    name: "전체"
                };
                var addCategory = [defaultCategory];
                categoryModule.appendElement(addCategory.concat(categories));
            })
        },

        appendElement: function (elements) {
            for (var i in elements) {
                GLOBAL_VAR.$eventTabLst.append(categoryModule.categoryListElement(elements[i].id, elements[i].name));
            }
            GLOBAL_VAR.$selectedCategory = $('ul.event_tab_lst>li:first-child').find("a.anchor");
            GLOBAL_VAR.$selectedCategory.addClass("active");
            $('ul.event_tab_lst>li:last-child').find("a.anchor").addClass("last");
        },

        categoryListElement: function (id, name) {
            var template = $('#categoryListTemplate').html();
            var templateScript = Handlebars.compile(template);
            var context = {
                "id": id,
                "name": name
            };
            var element = templateScript(context);
            return element;
        }
    };

//head section
    var headFunctions = {
        init: function () {
            this.bindClickEvent();
        },

        bindClickEvent: function () {
            commonAPIModule.bindEventOnClick(GLOBAL_VAR.$headerClass, GLOBAL_VAR.lnkLogoClass, headFunctions.moveToLocation.bind(undefined, ROOT_URL));
        },

        moveToLocation: function (url) {
            document.location.href = url;
        }

    };

    headFunctions.init();
    categoryModule.init();
    productListModule.init();


})(window);






