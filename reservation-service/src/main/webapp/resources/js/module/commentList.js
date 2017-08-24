var $ = require('jquery');
var ajaxModule = require('./ajaxModule');
var moment = require('moment');
var commentTemplate = require('../../templates/comments/comment-list.hbs');

var CommentList = (function () {

    var $commentSummary = $('div.grade_area');

    function init() {
        getComments();
    }

    function getComments() {
        var productId = $('.group_visual').data('product-id');
        var offset = $('.list_short_review').find('li').length;

        var result = ajaxModule.ajax({
            url: '/api/comments/products/' + productId + '/offset/' + offset,
            method: 'GET'
        });

        result.then(function (data) {
            renderingComments(data);
        }, function (err) {
            alert('error:' + err);
        });

    }

    function renderingComments(data) {

        data.comments.forEach(function (comment) {
            comment.createDate = formattingDate(comment.createDate);
            comment.score = comment.score.toFixed(1);
        });

        $('ul.list_short_review').append(commentTemplate(data));

        renderingCommentsSummary(data.commentsSummary);

    }

    function formattingDate(createDate) {
        return moment(createDate).format('YYYY.MM.DD');
    }

    function renderingCommentsSummary(commentsSummary) {
        var average = commentsSummary.average;
        var rating = average / 5.0 * 100;
        $commentSummary.attr('data-product-id',commentsSummary.productId);
        $commentSummary.find('.text_value span').text(average);
        $commentSummary.find('em.green').text(commentsSummary.totalCount);
        $commentSummary.find('.graph_value').css('width', rating + '%');
    }


    return {
        init: init,
        getComment: getComments
    }

})();

module.exports = CommentList;