var RatingComponent = extend(eg.Component, {

    init: function ($root, options) {
        this.options = {
            mouseover: false
        }

        this.options = Object.assign({}, this.options, options);

        this.$root = $root;
        this.$stars = $root.find('.rating_rdo');
        this.$score = $root.find('.star_rank');

        this._eventBind();


    },

    _eventBind: function () {
        this.$root.on('click', '.rating_rdo', this._changeRate.bind(this));
    },

    _changeRate: function (e) {
        e.preventDefault();
        this.score = $(e.currentTarget).val();

        this._changeStar();
        this._changeScore();
    },

    _changeStar: function () {
        var stars = this.$stars;

        for (var i = 0, l = stars.length; i < l; i++) {
            if (i <= this.score) stars.eq(i).addClass('checked');
            else stars.eq(i).removeClass('checked');
        }

    },

    _changeScore: function () {
        this.$score.text(this.score).removeClass('gray_star');
    },

    getScore: function () {
        return this.score;
    }


});