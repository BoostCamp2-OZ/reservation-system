$(function () {
    var $document = $(document);
    var $window = $(window);
    $document.scroll(function () {
        console.log("불러오기");
        if ($document.height() <= $window.scrollTop() + $window.height()) {
            CommentList.getComment();
        }
    });
});