var Slider = extend(eg.Component, {


    init: function () {

        this.interval = null;
        this.$root = $('div.group_visual');
        this.$slider = this.$root.find('ul.visual_img');

        this.$root.on('click', '.prev_inn', this.moveLeft);
        this.$root.on('click', '.nxt_inn', this.moveRight);

        this.autoMoving();

    },

    moveLeft: function () {
        $(this.$slider).css('left', -338);
    },

    moveRight: function () {
        $(this.$slider).css('left', 338);
    },

    autoMoving: function () {
        this.interval = setInterval(this.moveRight, 4000);
    },

    stopMoving: function () {
        clearInterval(this.interval);
    }


});

$(function () {
    var slider = new Slider();
    console.log(slider);
})