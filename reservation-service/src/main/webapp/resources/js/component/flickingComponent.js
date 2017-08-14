var FlickingComponent = extend(eg.Component, {

        init: function ($root, options) {
            this.$root = $root;
            this.$slider = this.$root.find('ul.visual_img').eq(0);

            var $item = this.$slider.find('li');
            this.itemWidth = $item.width();


            this.options = {
                circulation: false,
                maxMoveRange: 20
            };

            this.status = {
                index: 1,
                size: $item.length,
                startX: 0,
                saveX: 0,
                movePosition: 0
            };

            this.options = Object.assign({}, this.options, options);

            this._moveComponentInit();
            this._eventBind();

        },


        _moveComponentInit: function () {
            this.mcInst = new MoveComponent(this.$slider, {
                circulation: this.options.circulation
            });
            this.mcInst.on({
                'afterMove': this._updateStatus.bind(this)
            });
        },


        _eventBind: function () {
            var $root = this.$root;
            var $slider = this.$slider;

            $root.on('click', '.prev', this._move.bind(this, 'prev'));
            $root.on('click', '.nxt', this._move.bind(this, 'next'));

            $slider.on('touchstart', this._touchStart.bind(this));
            $slider.on('touchmove', this._touchMove.bind(this));
            $slider.on('touchend', this._touchEnd.bind(this));
        },


        _updateStatus: function (options) {
            this.status = Object.assign({}, this.status, options);
            var $paginationWrapper = this.$root.find('.figure_pagination');
            var $pageNum = $paginationWrapper.find('.num')[0];
            $($pageNum).text(options.index);
        },


        _move: function (direction) {
            this.mcInst.move(direction, this.status.movePosition);
        },


        _touchStart: function (e) {
            this.status.startX = e.changedTouches[0].pageX;
            this.status.saveX = parseInt(this.$slider.css('left'));
        },


        _touchMove: function (e) {
            e.preventDefault();

            var startX = this.status.startX;
            var saveX = this.status.saveX;
            var drag = e.changedTouches[0].pageX - startX;

            this.status.movePosition = ( drag / this.itemWidth ) * 100;

            if (Math.abs(drag) > 0) {

                if (this._isReachedToEnd()) {
                    if (this._isPossibleMove()) {
                        this._moveSlider();
                    }
                } else {
                    this._moveSlider();
                }

                this.status.saveX = saveX;
            }
        },


        _touchEnd: function (e) {
            if (this._isReachedToEnd()) {
                this._resetPosition();
            } else {
                if (this.status.movePosition < 0) {
                    this._move('next');
                } else {
                    this._move('prev');
                }
            }

            this.status.startX = 0;
            this.status.movePosition = 0;

            e.preventDefault();
        },


        _resetPosition: function () {
            this.$slider.animate({'left': this.status.saveX}, 100); // 초기화
        },


        _moveSlider: function () {
            this.$slider.css({'left': this.status.saveX + this.status.movePosition});
        },


        _isPossibleMove: function () {
            return Math.abs(this.status.movePosition) <= this.options.maxMoveRange;
        },


        _isReachedToEnd: function () {
            var isReached = false;
            var options = this.options;
            var status = this.status;

            if ((status.index === 1)
                && !options.circulation
                && status.movePosition > 0) {
                isReached = true;
            }

            if ((status.index === status.size)
                && !options.circulation
                && status.movePosition < 0) {
                isReached = true;
            }

            return isReached;
        }

    });