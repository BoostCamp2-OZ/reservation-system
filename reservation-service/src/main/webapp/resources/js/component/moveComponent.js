var egComponent = require('@egjs/component');
var extend = require('../common/util');
var $ = require('jquery');

var MoveComponent = extend(egComponent, {


    init: function ($root, options) {
        this.$root = $root; // slider

        this._config = {
            circulation: false,
            index: 1,
            size: 0,
            viewTime: 500
        };

        this._config = Object.assign({}, this._config, options);
        this._config.size = $(this.$root).children('li').length;

        if (this._config.circulation) {
            this.rollingInit();
        }
    },

    rollingInit: function () {
        var $slider = $(this.$root);
        var $items = $slider.find('li');

        if ($items.length < 3) {
            var cloneLast = $items.last().clone(true);
            var cloneFirst = $items.first().clone(true);

            $items.first().before(cloneLast);
            $items.last().after(cloneFirst);
        } else {
            $items.first().before($items.last());
        }

        $slider.css({'left': -$items.width()}); // css 초기화

    },

    move: function (direction, swipe) {

        var options = this._config;
        var duration = options.viewTime;

        var $slider = $(this.$root);
        var $item = $slider.find('li');
        var itemWidth = $item.width();
        var leftIndent = parseInt($slider.css('left'));
        var movePosition = parseInt(swipe) || 0;

        this.trigger('beforeMove', {
            index: options.index,
            size: options.size,
            circulation: options.circulation,
            direction: direction
        });

        if (direction === 'prev') {

            if (this._isReachedToEnd(direction, options)) return false;

            $slider.filter(':not(:animated)').animate({"left": leftIndent + (itemWidth - movePosition)}, duration,
                function complete() {
                    if (options.circulation) {
                        $item.first().before($item.last());
                        $slider.css({'left': -itemWidth});
                    } else {
                        $slider.css({'left': -itemWidth * (options.index - 1)});
                    }
                });

            --options.index;

            if (options.index <= 0) {
                options.index = options.size;
            }

        } else {

            if (this._isReachedToEnd(direction, options)) return false;

            $slider.filter(':not(:animated)').animate({"left": leftIndent - (itemWidth + movePosition)}, duration,
                function complete() {
                    if (options.circulation) {
                        $item.last().after($item.first());
                        $slider.css({'left': -itemWidth});
                    } else {
                        $slider.css({'left': -itemWidth * (options.index - 1)});
                    }
                });

            ++options.index;

            if (options.index > options.size) {
                options.index = 1;
            }
        }

        this.trigger('afterMove', {index: options.index, size: options.size});
    },


    _isReachedToEnd: function (direction, options) {
        var isReached = false;

        if (direction === 'prev') {
            if ((options.index === 1) && !options.circulation) isReached = true;
        } else {
            if ((options.index === options.size) && !options.circulation) isReached = true;
        }

        return isReached;
    }

});

module.exports = MoveComponent;