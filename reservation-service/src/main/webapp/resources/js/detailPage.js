$(function () {

    var mainFlicking = new FlickingComponent($('div.section_visual'));
    var popupFlicking = null;

    function init() {
        eventBind();
    }

    function eventBind() {

        $('.section_btn').on('click', '.bk_btn', clickReservableProduct);
        $('.list_short_review').on('click', '.thumb_area', openPhotoViewer);
        $('#photoviewer').on('click', 'label', closePhotoViewer);
        $('.section_store_details').on('click','.bk_more', contentMoreToggle);
        //1. 오시는길 클릭
        $('.info_tab_lst').on('click', '._path', clickDisplayInfo);

        //2. 상세 정보 클릭
        $('.info_tab_lst').on('click', '._detail', clickDetailInfo);
    }

    function clickDisplayInfo(e){
        event.preventDefault(); // a태그 이벤트 막기..
        $("a[class='anchor active']").removeClass('active');
        $(this).find('.anchor').addClass('active');
        $('.detail_area_wrap').addClass('hide');
        $('.detail_location').removeClass('hide');


    }

    function clickDetailInfo(e){
        event.preventDefault();
        $("a[class='anchor active']").removeClass('active');
        $(this).find('.anchor').addClass('active');
        $('.detail_area_wrap').removeClass('hide');
        $('.detail_location').addClass('hide');
    }

    function contentMoreToggle (e) {
        e.preventDefault();

        var $el = $(e.target);
        var $container = $el.closest('.section_store_details');
        var $content = $container.find('.store_details');
        var $openBtn = $container.find('._open');
        var $closeBtn = $container.find('._close');

        // 닫혀있음
        if($content.hasClass('close3')) {
            $openBtn.hide();
            $closeBtn.show();
        } else {
            $openBtn.show();
            $closeBtn.hide();
        }

        $content.toggleClass('close3');
    }

    function clickReservableProduct(e) {
        var productId = $('.group_visual').data('product-id');

        if (checkReservableProduct(e.currentTarget)) {
            location.href = '/reservations/products/' + productId;
        }
    }

    function checkReservableProduct(target) {
        return $(target).find('span').data('reservable');
    }

    function openPhotoViewer(e) {
        e.preventDefault();

        var commentId = $(e.currentTarget).data('comment-id');

        var result = ajaxModule.ajax({
            url: '/api/comments/' + commentId + '/images',
            method: 'GET'
        });

        result.then(function(data) {
            renderingCommentImages(data);
        }, function(err) {
            alert('error:', err);
        });

    }

    function closePhotoViewer(e) {
        e.preventDefault();

        if(popupFlicking != null) {
            popupFlicking.clear();
        }

        $('#photoviewer').fadeOut(300, function complete() {
            $('.popup_image').css('left' , 0);
            $('.popup_title').off('click');
        });
    }

    function renderingCommentImages(data) {
        var popupTemplate = Handlebars.compile($('#popupImageTempl').html());
        $('.popup_image').html(popupTemplate(data));

        popupFlicking = new FlickingComponent($('div.popup'));

        $('#photoviewer').fadeIn(300);
    }

    init();
    CommentList.init();

});

