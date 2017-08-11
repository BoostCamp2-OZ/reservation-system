$(function () {


    mainProductList.init();

    var rolling = new RollingComponent($('div.group_visual'));

    rolling.on('')

    function infinityScroll(isActive) {
        var $document = $(document);
        var $window = $(window);

        if (!isActive) {
            return false;
        } else {
            $document.scroll(function () {
                if ($document.height() <= $window.scrollTop + $window.height()) {
                    mainProductList.getMoreProducts();
                }
            });
        }
    }


    infinityScroll(true);
});

