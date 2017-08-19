var TICKET_INFO = [
    {'status': '', 'type': '0', 'statusName': '전체', 'statusClass': ''},
    {'status': '', 'type': '1', 'statusName': '예약 신청중', 'statusClass': 'ico_clock', 'buttonName': '취소'},
    {'status': 'confirmed', 'type': '2', 'statusName': '예약 확정', 'statusClass': 'ico_check2', 'buttonName': '취소'},
    {'status': 'used', 'type': '3', 'statusName': '이용 완료', 'statusClass': 'ico_check2', 'buttonName': '예매자 리뷰 남기기'},
    {'status': 'used', 'type': '4', 'statusName': '취소된 예약', 'statusClass': 'ico_cancel'}
];


var ReservationList = extend(eg.Component, {

    init: function ($base, $popup) {
        this.$base = $base.find('.list_cards');
        this.$errBoard = $base.find('.err');
        this.currentTab = 0;
        this.$popup = $popup;

        this._initMomentKo();
        this._getMyReservations();
        this._bindEvents();
    },

    _initMomentKo: function () {
        moment.locale('ko', {
            weekdays: ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"],
            weekdaysShort: ["일", "월", "화", "수", "목", "금", "토"],
        });
    },

    _bindEvents: function () {
        this.$base.on('click', '.booking_cancel', this._openCancelPopup.bind(this));
        this.$popup.on('click', '.btn_gray, .popup_btn_close', this._closeCancelPopup.bind(this));
        this.$popup.on('click', '.btn_green', this._cancelTicket.bind(this));
    },

    _getMyReservations: function () {

        var result = ajaxModule.ajax({
            url: '/api/reservations/my',
            method: 'GET'
        });

        result.then(function (data) {
            this._renderingReservations(data);
        }.bind(this));

    },

    _renderingReservations: function (data) {
        this.tickets = data;

        this.filteredTickets = TICKET_INFO.map(function (status, i) {
            var workedTicket = TICKET_INFO[i];
            workedTicket.tickets = this._getSimpleTicketsByType.call(this, i);
            workedTicket.tickets.forEach(function (ticket) {

                if (ticket.reservationType === 4) {
                    ticket.isCanceled = true;
                }

                ticket.buttonName = workedTicket.buttonName;
                ticket.salesStart = this._formattingDate(ticket.salesStart);
                ticket.salesEnd = this._formattingDate(ticket.salesEnd);
                ticket.totalPrice = this._convertPriceAddComma(ticket.totalPrice);
                ticket.details = this._convertReservationBreakDown(ticket);

            }.bind(this));

            return workedTicket;

        }.bind(this));

        this.trigger('ready', {
            ticketList: this.filteredTickets
        });

        // 기본 값은 전체로 초기 렌더링
        this.rendering(this.currentTab);
    },

    _formattingDate: function (createDate) {
        return moment(createDate).format('YYYY.MM.DD.(ddd)');
    },

    _convertPriceAddComma: function (price) {
        if ('string' !== typeof price) price += '';
        return price.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },

    _convertReservationBreakDown: function (ticket) {
        var breakdown = '';
        ticket.generalTicketCount && (breakdown += '성인(' + ticket.generalTicketCount + ') ');
        ticket.youthTicketCount && (breakdown += '청소년(' + ticket.youthTicketCount + ') ');
        ticket.childTicketCount && (breakdown += '어린이(' + ticket.childTicketCount + ') ');
        ticket.totalTicketCount && (breakdown += '총(' + ticket.totalTicketCount + ')');
        return breakdown;
    },

    _getSimpleTicketsByType: function (type) {
        ('string' === typeof type) ? type : '' + type;

        // 전체
        if (type === '0') {
            return this.filteredTickets;
        }

        return this.tickets.filter(function (ticket) {
            return ticket.reservationType === type;
        });

    },

    rendering: function (targetType) {
        this.currentTab = targetType;

        var $cardList = this.$base;
        var simpleTicketTempl = Handlebars.compile($('#simpleTicket').html());

        $cardList.html('');

        if (targetType === 0) {
            this.filteredTickets.map(function (ticket) {
                $cardList.append(simpleTicketTempl(ticket));
            });
        } else {
            $cardList.append(simpleTicketTempl(this.filteredTickets[targetType]));
        }

        if($cardList.find('article.card_item').length === 0){
            this.$errBoard.show();
        } else {
            this.$errBoard.hide();
        }
    },

    _openCancelPopup: function (e) {
        e.preventDefault();

        var $wrapper = $(e.target).closest('.card_item');
        var $popupTitle = this.$popup.find('.pop_tit span');
        var $popupScedule = this.$popup.find('.pop_tit small.sm');

        var bookingId = $wrapper.data('booking-id');
        var name = $wrapper.find('h4.tit').text();
        var scedule = $($wrapper.find('.item .item_dsc')[0]).text();

        // 해당 booking id를 받아서 배열의 index 값을 리턴해준다.
        var ticket = this._getTicketOfFilteredList(bookingId);

        if (ticket.item.reservationType === 3) {
            location.href = '/reviewWrite/' + ticket.item.pid;
        } else {
            $popupTitle.text(name);
            $popupScedule.text(scedule);
            this.$popup.data('popup-id', ticket.item.rid);
            this.$popup.fadeIn(350);
        }
    },


    _closeCancelPopup: function (e) {
        e.preventDefault();
        this.$popup.fadeOut(350);
    },

    _getTicketOfFilteredList: function (bookingId) {

        var filertedListLength = this.filteredTickets.length;

        for (var i = 0; i < filertedListLength; i++) {

            var list = this.filteredTickets[i];
            var listLength = list.tickets.length;

            for (var j = 0; j < listLength; j++) {
                var rid = list.tickets[j].rid;
                if (bookingId === rid) {
                    return {
                        index: j,
                        item: list.tickets[j]
                    };
                }
            }
        }
    },

    _cancelTicket: function (e) {
        e.preventDefault();

        var popupId = this.$popup.data('popup-id');
        var ticket = this._getTicketOfFilteredList(popupId);
        var ticketItem = ticket.item;
        var type = ticketItem.reservationType;

        // update reservation type For DB
        var result = ajaxModule.ajax({
            method: 'PUT',
            url: '/api/reservations',
            data: {
                rid: popupId,
                reservationType: type
            }
        });

        result.then(function (res) {
            if (res) {
                this._reservationUpdate(res, type, ticket);
                this.trigger('afterCancel', {
                    ticketList: this.filteredTickets
                });
            } else {
                alert('예매 취소에 실패했습니다.');
            }
        }.bind(this));
    },

    _reservationUpdate: function (res, type, ticket) {
        var ticketItem = ticket.item;

        if (res) {
            if (type === 1 || type === 2) {
                this.filteredTickets[type].tickets.splice(ticket.index, 1);
                ticketItem.reservationType = 4;
                ticketItem.isCanceled = true;
                this.filteredTickets[ticketItem.reservationType].tickets.push(ticketItem);
            }
            this.rendering(this.currentTab);
            this.$popup.hide();
        } else {
            alert('예매 취소에 실패했습니다.');
        }
    },

    getTotalTicketCount: function () {
        return this.filteredTickets.map(function (item) {
            return item.tickets.length;
        }).reduce(function (prev, next) {
            return prev + next;
        })
    },

    getTicketCountByType: function (type) {
        if (type === 2) type = 3;
        else if (type === 3) type = 4;
        return this.filteredTickets[type].tickets.length;
    }


});