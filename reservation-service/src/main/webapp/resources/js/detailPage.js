$(function () {

    var mainFlicking = new FlickingComponent($('div.section_visual'));


    function init(){
        eventBind();
    }
    function eventBind(){
        $('.section_btn').on('click','.bk_btn',clickReservableProduct);

    }

    function clickReservableProduct(e){
        var productId = $('.group_visual').data('product-id');
        console.log(productId);

        if(checkReservableProduct(e.currentTarget)){
            location.href='/reservations/products/'+productId;
        }
    }
    function checkReservableProduct(target){
        var isReservable = $(target).find('span').data('reservable');
        return isReservable;
    }


    init();

});

