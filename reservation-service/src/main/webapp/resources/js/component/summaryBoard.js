var egComponent = require('@egjs/component');
var extend = require('../common/util');
var $ = require('jquery');

var SummaryBoard = extend(egComponent, {

    init: function ($root) {

        this._initInstValues($root);
        this._eventBind();
    },

    _initInstValues: function ($root) {
        this.$root = $root;
        this.$summaryWrapper = this.$root.find('.summary_board');
        this.$list = this.$summaryWrapper.children('li');
    },

    _eventBind: function () {
        this.$summaryWrapper.on('click', '.item', this._changeTabByReservationType.bind(this));
    },

    _changeTabByReservationType: function (e) {
        e.preventDefault();

        var $target = $(e.target);
        var $targetItem = $target.closest('.item');
        var $nowTab = $target.closest('ul').find('.on');
        var $clickTab = $targetItem.find('.link_summary_board');

        var targetType = $targetItem.data('type');

        $nowTab.removeClass('on');
        $clickTab.addClass('on');

        this.currentTab = targetType;

        this.trigger('changeTab', {
            tabId: this.currentTab
        });
    }


});

module.exports = SummaryBoard;