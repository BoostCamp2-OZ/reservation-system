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

        ajaxModule.ajax({
            url: '/api/comments/' + commentId + '/images',
            method: 'GET'
        }, renderingCommentImages);

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

