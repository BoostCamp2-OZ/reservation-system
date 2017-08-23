var $ = require('jquery');
var egComponent = require('@egjs/component');
var MoveComponent = require('./moveComponent');
var extend = require('../common/util');

var RollingComponent = extend(egComponent, {


    init: function ($root, options) {
        this.options = {
            autoStart: true,
            circulation: true,
            intervalTimer: null,
            clickTimer: null
        };

        this.options = Object.assign({}, this.options, options);

        this.$root = $root;
        this.slider = this.$root.find('ul.visual_img')[0];

        this._moveComponentInit();
        this._eventBind();
        if (this.options.autoStart) this._autoStart();

    },


    _updateStatus: function (options) {
        // 여기서 업데이트
    },


    _moveComponentInit: function () {
        this.mcInst = new MoveComponent($(this.slider), {
            circulation: this.options.circulation
        });
        this.mcInst.on({
            'afterMove': this._updateStatus.bind(this),
            'beforeMove': this._updateStatus.bind(this)
        });
    },


    _eventBind: function () {
        this.$root.on('click', '.prev_e', this._movePrev.bind(this));
        this.$root.on('click', '.nxt_e', this._moveNext.bind(this));
    },


    _movePrev: function () {
        this._stopAutoRolling();
        this.mcInst.move('prev', 0);
    },


    _moveNext: function () {
        this._stopAutoRolling();
        this.mcInst.move('next', 0);
    },


    _autoStart: function () {
        var options = this.options;

        options.intervalTimer = setInterval(function () {
            this.mcInst.move('next');
        }.bind(this), 2000);
    },


    _stopAutoRolling: function () {
        var options = this.options;

        options.intervalTimer != null
        && clearInterval(options.intervalTimer);

        clearTimeout(options.clickTimer);

        if (options.autoStart) {
            options.clickTimer = setTimeout(function () {
                this._autoStart();
            }.bind(this), 2000);
        }
    }

});

module.exports = RollingComponent;