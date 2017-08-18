$(function () {

    var $summaryBoardWrapper;
    var reservationList;
    var summaryBoard;

    function init() {
        $summaryBoardWrapper = $('.my_summary');
        reservationList = new ReservationList($('.section_my'), $('.popup_booking_wrapper'));
        summaryBoard = new SummaryBoard($summaryBoardWrapper);

        bindEventEmitter();
    }


    function updateSummaryText() {
        var $item = $summaryBoardWrapper.find('li');
        var $figures = $item.find('.figure');

        $figures.map(function (i, figure) {
            var totalCount = 0;

            if(i === 0){
                totalCount = reservationList.getTotalTicketCount();
            } else {
                totalCount = reservationList.getTicketCountByType(i);
            }

            $(figure).text(totalCount);
        });
    };

    function bindEventEmitter() {
        summaryBoard.on('changeTab', function (options) {
            reservationList.rendering(options.tabId);
        });

        reservationList.on({
            'ready' : updateSummaryText,
            'afterCancel' : updateSummaryText
        });
    };


    init();

});