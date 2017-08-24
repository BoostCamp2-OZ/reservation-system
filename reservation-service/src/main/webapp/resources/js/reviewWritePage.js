var $ = require('jquery');
var RatingComponent = require('./component/ratingComponent');
var ImageUploadComponent = require('./component/imageUploadComponent');
var ResultFormComponent = require('./component/resultFormComponent');
var Comment = require('./module/reviewWrite');

$(function () {

    var ratingComponent = new RatingComponent($('div.rating'));

    Comment.init();

    var imageUploadComponent = new ImageUploadComponent($('.review_write_footer_wrap'));

    $('.box_bk_btn').on('click', '.bk_btn', function () {

        var score = ratingComponent.getScore() || 0;
        var comment = Comment.getComment() || '';
        var images = imageUploadComponent.getImage() || [];

        var resultForm = new ResultFormComponent($('.box_bk_btn'), {
            score: score,
            comment: comment,
            images: images
        });

    });

});