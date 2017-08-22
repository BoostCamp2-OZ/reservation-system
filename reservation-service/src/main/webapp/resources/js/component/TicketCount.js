var egComponent = require('@egjs/component');
var extend = require('../common/util');

var TicketCount = extend(egComponent, {

    init: function ($root) {
        this._initInstanceValue($root);
        this._eventBind();
    },

    _initInstanceValue: function ($root) {
        this.$root = $root;
        this.$countControl = $root.find('.count_control');
        this.$ticketCount = this.$countControl.find('.count_control_input ');
        this.$minus = this.$countControl.find('.btn_plus_minus._minus');
        this.$individualPrice = $root.find('.individual_price');
        this.$totalPrice = this.$individualPrice.find('.total_price');

        this.count = parseInt(this.$ticketCount.val());
        this.price = parseInt(this.$individualPrice.data('price'));
        this.totalPrice = parseInt(this.$totalPrice.text());
        this.ticektType = $root.find('.product_amount span').data('type');
    },

    getTicketType: function () {
        return this.ticektType;
    },

    getTicketCount: function () {
        return this.count;
    },

    _eventBind: function () {
        this.$countControl.on('click', '.btn_plus_minus._plus', this._plus.bind(this));
        this.$countControl.on('click', '.btn_plus_minus._minus', this._minus.bind(this));
    },

    _plus: function (e) {
        e.preventDefault();
        this.$ticketCount.val(++this.count);

        this._activeNumber();
        this._activeButton();
        this._changeTotalCount();

        this.trigger('plus');

    },

    _minus: function (e) {
        e.preventDefault();

        if (this.count !== 0) {
            this.$ticketCount.val(--this.count);

            this._activeNumber();
            this._activeButton();
            this._changeTotalCount();

            this.trigger('minus');
        }
    },

    _activeButton: function () {

        if (this.count === 0) {
            this.$minus.addClass('disabled');
        }
        if (this.count === 1) {
            this.$minus.removeClass('disabled');
        }

    },

    _activeNumber: function () {

        if (this.count === 0) {
            this.$ticketCount.addClass('disabled');
        }
        if (this.count === 1) {
            this.$ticketCount.removeClass('disabled');
        }

    },

    _changeTotalCount: function () {

        this.totalPrice = this.price * this.count;

        if (this.totalPrice > 0) {
            this.$individualPrice.addClass('on_color');
        } else {
            this.$individualPrice.removeClass('on_color');
        }

        this.$totalPrice.text(this.totalPrice);

    }

});

module.exports = TicketCount;