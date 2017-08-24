var $ = require('jquery');
var ajaxModule = require('./module/ajaxModule');
var checkReservable = require('./module/checkReservable');
var TicketCount = require('./component/TicketCount');

$(function () {

    var ticketCounts = [];
    var totalCount = 0;

    function init() {
        initTicketCounts();
        eventBind();
    }

    function eventBind() {

        var $agreement = $('.agreement');
        $agreement.on('click', '.btn_agreement', toggleAgreement);
        $agreement.on('click', '.chk_agree', checkReservable.checkAll);
        $('.inline_control').on('keyup', 'input', checkReservable.checkAll);
        $('.box_bk_btn').on('click', '.bk_btn_wrap', completeReservation);

    }

    function initTicketCounts() {

        var $qty = $('.ticket_body .qty');
        for (var i = 0, l = $qty.length; i < l; i++) {
            ticketCounts[i] = new TicketCount($qty.eq(i));

            ticketCounts[i].on('plus', function(e){
                plusTicketCount();
                checkReservable.checkAll();
            });
            ticketCounts[i].on('minus', function(e) {
                minusTicketCount();
                checkReservable.checkAll();
            });
        }

    }

    function plusTicketCount() {
        $('._totalTicketCount').text(++totalCount);
    }

    function minusTicketCount() {
        $('._totalTicketCount').text(--totalCount);
    }

    function toggleAgreement(e) {

        e.preventDefault();
        $(this).closest('.agreement').addClass('open');

    }

    function completeReservation(e) {

        var data = makeReservationData(e);
        console.log(data);

        var result = ajaxModule.ajax({
            url: '/api/reservations',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json'
        });

        result.done(function() {
            location.href = 'reservations/my';
        });

        result.catch(function(err) {
            console.error('err : ' + err);
        });

    }


    function makeReservationData(e){

        var data = {};
        var queryString = $("form.form_horizontal").serializeArray();
        var productId = $(e.currentTarget).data('productid');

        for(var i = 0, length = queryString.length ; i < length ; i++){
            var name = queryString[i].name;
            data[name]=queryString[i].value;
        }

        for(var i = 0, length = ticketCounts.length ; i < length ; i++){
            var name = ticketCounts[i].getTicketType();
            data[name] = ticketCounts[i].getTicketCount();
        }

        data["productId"] = productId;

        return data;
        
    }

    init();

});