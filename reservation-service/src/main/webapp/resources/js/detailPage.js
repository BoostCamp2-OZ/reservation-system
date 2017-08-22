var $ = require('jquery');
var FlickingComponent = require('./component/flickingComponent');
var ajaxModule = require('./module/ajaxModule');
var CommentList = require('./module/commentList');

var popupTemplate = require('../templates/comments/popup-photo-list.hbs');

(function () {

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
        $('.popup_image').html(popupTemplate(data));

        popupFlicking = new FlickingComponent($('div.popup'));

        $('#photoviewer').fadeIn(300);
    }

    init();
    CommentList.init();

})();

