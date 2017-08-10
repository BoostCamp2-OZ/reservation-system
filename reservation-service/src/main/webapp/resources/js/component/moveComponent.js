var MoveComponent = extend(eg.Component, {


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

        if(this._config.circulation) {
            this.rollingInit();
        }
    },

    rollingInit : function() {
        var $slider = $(this.$root);
        var $items = $slider.find('li');

        // 아이템의개수가 3이상이면, 마지막 슬라이드를 첫번째 앞에 붙이고 마지막 슬라이드를 삭제
        // 아이템 개수가 3개 미만일 경우에는 앞뒤에 붙여준다.
        if($items.length < 3) {
            var cloneLast = $items.last().clone(true);
            var cloneFirst = $items.first().clone(true);

            $items.first().before(cloneLast);
            $items.last().after(cloneFirst);
        } else {
            var cloneLast = $items.last().clone(true);
            $items.first().before(cloneLast);
            $items.last().remove();
        }

        $slider.css({'left' : -$items.width()}); // css 초기화

    },

    move: function (direction, swipe) {

        var options = this._config;
        var duration = options.viewTime;

        var $slider = $(this.$root);
        var $item = $slider.find('li');
        var itemWidth = $item.width();
        var leftIndent = parseInt($slider.css('left'));
        var movePosition = parseInt(swipe) || 0;

        this.trigger('beforeMove', {index: options.index, size: options.size, circulation: options.circulation, direction: direction});

        if (direction === 'prev') {

            if (this._isReachedToEnd(direction, options)) return false;

            $slider.filter(':not(:animated)').animate({"left": leftIndent + (itemWidth - movePosition)}, duration,
                function complete() {
                    if (options.circulation) {
                        $item.first().before($item.last());
                        $slider.css({'left': -itemWidth}); // 초기화
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