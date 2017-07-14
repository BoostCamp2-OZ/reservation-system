/**
 * 
 */
(function(window) {
	'use strict';

    /**
     * 
     * --------------------------------------------------------------------------------------
     * 카테고리 
     * Category
     * --------------------------------------------------------------------------------------
     * 
     */

    var Category = {
        init : function () {
            this.categoryTemplate = Handlebars.compile($('#category-template').html());
            this.getAllCategories()
            this.bindEvents()
        },

        bindEvents : function () {
            $('ul.event_tab_lst').on('click', '.item', this.changeEventTab)
        },

        changeEventTab : function () {
            var $clickedTab = $(this);
            var categoryId = $clickedTab.data('category');

            // call & categoryId!
            var result = Products.getProductsByCategoryId.call(Products, categoryId);

            result.done(function(res) {
                // toggle button
                $('.event_tab_lst .item .anchor').removeClass('active');
                $clickedTab.find('.anchor').addClass('active');

                // rendering
                Products.rendering(res);
            });

            result.fail(function(err) {
                alert('현재 카테고리에 데이터가 없습니다.');
            })
        },

        getAllCategories : function () {
            
            var result =  Common.ajaxWrapper.call(undefined, 'GET', '/categories', null);
            
            result.done(function(res) {
                if(res) {
                    $('.event_tab_lst').html(Category.categoryTemplate(res));
                }
            });
        },
    }

    /**
     * 
     * --------------------------------------------------------------------------------------
     * 제품
     * Products
     * --------------------------------------------------------------------------------------
     * 
     */

    var Products = {
        data : {
            categoryId : 0,
            totalCount : 0,
            item : [],
        },

        init : function() {
            this.productTemplate = Handlebars.compile($('#product-template').html());
            this.bindEvents()
            this.initializingProducts()
        },

        bindEvents : function() {
            $('div.more').on('click', '.btn', this.getProductsByOffset.bind(this)); // 더보기 버튼
        },

        initializingProducts : function() {
            // 초기 데이터 받아오기
            var result = Common.ajaxWrapper.call(undefined, 'GET', '/products', null);
            
            result.done(function(res) {
                Products.rendering(res);
            });
        },

        getProductsByCategoryId : function(categoryId) {
            event.preventDefault();

            this.data.item = []; // === Products.data.item Reset data item
            this.data.categoryId = categoryId; // change categoryId

            // Category 에서 탭이 변경 될 때 .call을 통해서 호출
            // 카테고리별 initial products data ajaxWrapper
            return Common.ajaxWrapper.call(undefined, 'GET', '/products?cid=' + categoryId, null);

        },

        rendering : function(res) {

            // caching
            var leftSection = ''
                , rightSection = ''
                , $eventBox = $('.wrap_event_box ul')
                , $listText = $('.event_lst_txt .pink');

            // category Changed then clear inner product contents!
            // category Change method in Products.data.item = []; // reset!
            if(Products.data.item.length === 0) {
                Products.data.totalCount = res.totalCount;
                $eventBox.html('');
                $listText.text(res.totalCount + '개'); // update totalCount
            }

            if(res.products) {
                res.products.forEach(function(p, i) {
                    // data caching
                    Products.data.item.push(p);

                    if(i % 2 === 0) leftSection += Products.productTemplate(p);
                    else rightSection += Products.productTemplate(p);
                    
                });

                // 기존에 있는 데이터들도 있을 수 있기 때문에 append
                $($eventBox[0]).append(leftSection);
                $($eventBox[1]).append(rightSection);

                // 총 갯수와 현재 아이템 갯수를 비교해서 같아지면 모든 데이터를 받아온 것 이기 때문에 '더보기' 버튼 invisible
                // 또, product의 데이터가 홀수인 경우,
                if((res.totalCount === Products.data.item.length))
                    $('div.more .btn').addClass('invisible');
                else
                    $('div.more .btn').removeClass('invisible');
            }

        },

        getProductsByOffset : function() {
            
            var curItemCount = Products.data.item.length;
            var categoryId = Products.data.categoryId;

            // 10개씩 더불러오기. 현재의 아이템의 갯수가 offset이 되고, limit은 서버에 10으로 고정
            var getURL = '/products?cid=' + categoryId + '&offset=' + curItemCount;

            // 모든 데이터를 가지고 왔을 경우 Ajax 요청을 막는다.
            if(Products.data.totalCount > curItemCount) {
                var result = Common.ajaxWrapper.call(undefined, 'GET', getURL, null);

                result.done(function(res) {
                    Products.rendering(res);
                });

                result.fail(function(err) {
                    console.log('load productData failure');
                });

            } else {
                console.log('Already get All Products List');
            }
            
        },

    };


    /**
     * 
     * --------------------------------------------------------------------------------------
     * 공용
     * Common
     * --------------------------------------------------------------------------------------
     * 
     */

    var Common = {
        ajaxWrapper : function(method, url, data) {
            return $.ajax({
				contentType : 'application/json; charset=UTF-8',
				method : method,
				url : url,
				data : data,
				dataType : 'json',
			});
        },

        infiniteScroll : function(flag) {
            if(flag) {
                $(window).scroll(function() {
                    if ($(window).scrollTop() + 50 >= ($(document).height() - $(window).height())) {
                        Products.getProductsByOffset.apply();
                    }
                });
            }
        }
    }
    
    var Main = {
        init : function () {
            Carousel.init({
                autoStart: true,
                carouselName : '.visual_img'
            });
            Category.init();
            Products.init();
            Common.infiniteScroll(true); // true => infinite Scroll active!

            this.bindEvents();
        },
        bindEvents : function () {
            $('.container_visual').on('click', '.prev_e', 
                Carousel.promotionAnimation.bind(Carousel, 500, 'prev'));
            $('.container_visual').on('click', '.nxt_e, .nxt_fix', 
                Carousel.promotionAnimation.bind(Carousel, 500, 'next'));
        }
    }

    Main.init();

})(window);