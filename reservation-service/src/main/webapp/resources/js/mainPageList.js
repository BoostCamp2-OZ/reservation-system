var mainPageList = (function(){

    var Templates = {};
    var $productContainer = $('.wrap_event_box');
    var activeIndex = 0;


    function init() {
        _eventBinding();
        _handlebarInit();
        _getCategories();
        _getProducts();
    }


    function _eventBinding() {

        $('ul.event_tab_lst').on('click', 'a.anchor', _changeCategory);
        $('.more').on('click', '.btn', _moreProducts);
    }


    function _handlebarInit() {
        Templates.category = Handlebars.compile($('#categoryTemplate').html());
        Templates.product = Handlebars.compile($('#productTemplate').html());
    }


    function _getProducts(offset) {
        if (offset === undefined) offset = 0;

        var categoryId = $('.active').closest('.item').data('category');

        ajaxModule.ajax({
            url: '/api/products/categories/' + categoryId + '/offset/' + offset,
            method: 'GET'
        }, function (data) {
            _productRendering('html', data);
        });

    }

    function _moreProducts() {
        var offset = $productContainer.find('.item').length;
        var categoryId = $('.active').closest('.item').data('category');

        ajaxModule.ajax({
            url: '/api/products/categories/' + categoryId + '/offset/' + offset,
            method: 'GET'
        }, function (data) {
            _productRendering('append', data);
        });
    }


    function _productRendering(type, data) {
        var leftSection = '';
        var rightSection = '';
        var totalCount = data.totalCount;
        var products = data.products;

        var $leftSection = $productContainer.find('.left');
        var $rightSection = $productContainer.find('.right');


        for (var i = 0, l = products.length; i < l; i++) {
            if (i % 2) {
                rightSection += Templates.product(products[i]);
            } else {
                leftSection += Templates.product(products[i]);
            }
        }

        $leftSection[type](leftSection);
        $rightSection[type](rightSection);

        _changeProductsCount(totalCount);
    }


    function _categoryRendering(data) {
        $('ul.event_tab_lst').append(Templates.category(data));
    }


    function _changeCategory(e) {
        var $currentTarget = $(e.currentTarget);
        var $currentActive = $('.event_tab_lst li[data-category="' + activeIndex + '"] a');

        $currentActive.removeClass('active');
        $currentTarget.addClass('active');

        activeIndex = $currentTarget.closest('li').data('category');

        _getProducts();
    }


    function _changeProductsCount(totalCount) {
        $countText = $('.event_lst_txt span.pink');
        $countText.text(totalCount + '개');
    }


    function _getCategories() {

        ajaxModule.ajax({
            url: '/api/categories',
            method: 'GET'
        }, _categoryRendering);

    }


    function infinityScroll(isActive) {
        if(!isActive) {
            return false;
        }
    }


    return {
        init: init,
        infinityScroll: infinityScroll
    }

})();
