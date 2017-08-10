var Slider = extend(eg.Component, {

    init: function ($root) {
        this.interval = null;
        this.timeout = null;

        this.$root = $root;
        this.slider = this.$root.find('ul.visual_img')[0];

        this.currentIndex = 0;

        this.silderItems = $(this.slider).find('li');
        this.silderItemCount = this.silderItems.length;
        this.moveRange = $(this.silderItems).innerWidth();

        this.eventBind();
        this.autoMoving();

    },

    eventBind : function(){
        this.$root.on('click', '.prev_e', this.movePrev.bind(this));
        this.$root.on('click', '.nxt_e', this.moveNext.bind(this));
    },


    movePrev: function () {
        this.stopMoving();
        if (this.currentIndex > 0) {
            this.currentIndex--;
        }else{
            this.currentIndex = this.silderItemCount - 1 ;
        }
        this.moveSlider();
    },

    moveNext: function () {
        this.stopMoving();
        if (this.currentIndex < this.silderItemCount - 1) {
            this.currentIndex++;
        }else{
            this.currentIndex = 0;
        }
        this.moveSlider();
    },

    moveSlider : function(){
        $(this.slider).animate({'left': -this.moveRange * this.currentIndex});
    },

    autoMoving: function () {
        this.interval = setInterval(this.moveNext.bind(this),2000);
    },

    stopMoving: function () {
        if(this.interval != null){
            clearInterval(this.interval);
        }
        if(this.timeout != null){
            clearTimeout(this.timeout);
        }
        this.timeout = setTimeout(this.autoMoving.bind(this), 2000);
    }
});
