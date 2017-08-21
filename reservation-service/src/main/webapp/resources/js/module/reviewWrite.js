var Comment = (function () {

    var $root = $('div.review_contents');
    var $reviewWriteInfo = $('a.review_write_info');
    var $commentCount = $('.guide_review').find('span').eq(0);
    var comment;

    function init() {
        _eventBind();
    }

    function _eventBind() {
        $root.on('focus', 'a.review_write_info', _focusTextarea);
        $root.on('focusout', '.review_textarea', _focusoutTextarea);
        $root.on('keyup paste', '.review_textarea', _changeTextarea);
    }

    function _focusTextarea(e) {
        e.preventDefault();
        $reviewWriteInfo.hide();
        $root.find('.review_textarea').focus();
    }

    function _focusoutTextarea(e) {
        if ($(e.currentTarget).val().length === 0) $reviewWriteInfo.show();
    }

    function _changeTextarea(e) {
        comment = $(e.currentTarget).val();
        $commentCount.text(comment.length);
    }

    function getComment() {
        return comment;
    }

    return {
        init: init,
        getComment : getComment
    }
})();