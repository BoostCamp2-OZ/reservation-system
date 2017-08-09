var mainPage = (function () {

    var source = $('#categoryTemplate').html();
    var categoryTemplate = Handlebars.compile(source);
    var $categoryList = $('ul.event_tab_lst');

    var productSource = $('#productTemplate').html();
    var productTemplate = Handlebars.compile(productSource);

    function init() {
        getProducts();
        $categoryList.on('click', 'a.anchor', changeCategory);
    }

    function getProducts() {
        var categoryId = $categoryList.find('.active').closest('.item').data('category');
        var offset = $('.wrap_event_box').find('.item').length;
        $.ajax({
            url: '/api/products/categories/' + categoryId + '/offset/' + offset,
            method: "GET",
            success: function (data) {
                console.log(data);
                var leftProductContainer = "";
                var rightProductContainer = "";
                for(var i = 0, l = data.products.length; i < l; i++){
                    if(i%2){
                        //left
                        leftProductContainer += productTemplate(data.products[i]);
                    }else{
                        //right
                        rightProductContainer += productTemplate(data.products[i]);
                    }
                }
                $('.lst_event_box.left').append(leftProductContainer);
                $('.lst_event_box.right').append(rightProductContainer);
            }
        })
    }

    function changeCategory(e) {
        var $currentTarget = $(e.currentTarget);
        $currentTarget.closest('.event_tab_lst').find('.active').removeClass('active');
        $currentTarget.addClass('active');
        getProducts();
    }

    function left() {

    }

    function right() {

    }

    function getCategory() {
        var categoryContanier = "";
        $.ajax({
            url: '/api/categories',
            method: 'GET',
            success: function (data) {
                console.log(data);
                $categoryList.append(categoryTemplate(data));
            }
        });
    }

    return {
        init: init,
        getCategory: getCategory
    }

})();
$(function () {
    mainPage.init();
    mainPage.getCategory();
});

