$(function () {

    var ratingComponent = new RatingComponent($('div.rating'));

    Comment.init();

    var imageUploadComponent = new ImageUploadComponent($('.review_write_footer_wrap'));

    $('.box_bk_btn').on('click', '.bk_btn', function (e) {
        var score = ratingComponent.getScore() || 0;
        console.log(score);
        var comment = Comment.getComment() || '';
        console.log(comment);
        var images = imageUploadComponent.getImage() || [];
        console.log(images);

        var resultForm = new ResultFormComponent($('.box_bk_btn'), {
            score : score,
            comment : comment,
            images : images,

        });
    });

});