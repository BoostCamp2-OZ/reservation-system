var RollingComponent = extend(eg.Component, {
    // setinterval 관리,
    // clickinterval 관리
    // autostart 관리

    init: function ($root, options) {
        this.options = {
            autoStart: true,
            circulation: true,
            intervalTimer: null,
            clickTimer: null
        };

        this.$root = $root;
        this.slider = this.$root.find('ul.visual_img')[0];

        this.moveComponentInit();
        this.eventBind();
        this.autoMoving();

    },

    updateStatus: function (options) {
        // 여기서 업데이트
        this.status = options;
        console.log('updateStatus', this.status);
    },

    moveComponentInit: function () {
        this.mcInst = new MoveComponent($(this.slider), {
            circulation : this.options.circulation
        });
        this.mcInst.on({
            'afterMove': this.updateStatus.bind(this),
            'beforeMove': this.updateStatus.bind(this)
        });
    },

    eventBind: function () {
        this.$root.on('click', '.prev_e', this.movePrev.bind(this));
        this.$root.on('click', '.nxt_e', this.moveNext.bind(this));
    },


    movePrev: function () {
        this.stopMoving();

        this.mcInst.move('prev', 0);

    },

    moveNext: function () {
        this.stopMoving();

        this.mcInst.move('next', 0);
    },

    moveSlider: function () {
        $(this.slider).animate({'left': -this.moveRange * this.currentIndex});
    },

    autoMoving: function () {
        this.interval = setInterval(this.moveNext.bind(this), 2000);
    },

    stopMoving: function () {
        if (this.interval != null) {
            clearInterval(this.interval);
        }
        if (this.timeout != null) {
            clearTimeout(this.timeout);
        }
        this.timeout = setTimeout(this.autoMoving.bind(this), 2000);
    }
});
