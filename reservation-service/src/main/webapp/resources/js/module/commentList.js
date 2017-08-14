var CommentList = (function () {

    function init() {

        var source = $('#commentTemplate').html();
        var commentTemplate = Handlebars.compile(source);

        var productId = $('.group_visual').data('product-id');
        var offset = 0;

        var $commentSummary = $('div.grade_area');


        options = {
            url: '/api/comments/products/' + productId + '/offset/' + offset,
            method: 'GET'
        }

        function rederingComments(data) {
            for (var i = 0, l = data.comments.length; i < l; i++) {
                data.comments[i].createDate = moment(data.comments[i].createDate).format('YYYY.MM.DD. 방문');
                data.comments[i].score = data.comments[i].score.toFixed(1);
            }

            $('ul.list_short_review').append(commentTemplate(data));
            rederingCommentsSummary(data.commentsSummary);

        }

        function rederingCommentsSummary(commentsSummary) {
            var average = commentsSummary.average;
            var rating = average / 5.0 * 100;
            $commentSummary.find('.text_value span').text(average);
            $commentSummary.find('em.green').text(commentsSummary.totalCount);
            $commentSummary.find('.graph_value').css('width', rating + '%');
        }

        ajaxModule.ajax(options, rederingComments);


    }


    return {
        init: init
    }
})();


$(function () {
    CommentList.init();
})