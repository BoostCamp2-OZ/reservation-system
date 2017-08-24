var $ = require('jquery');
var egComponent = require('@egjs/component');
var extend = require('../common/util');
var reviewTumbnailTempl = require('../../templates/review/thumb-image.hbs');

var ImageUploadComponent = extend(egComponent, {

    init: function ($root, options) {
        this.options = Object.assign({}, this.options, options);

        this.$root = $root;
        this.$imageContainer = $root.find('.lst_thumb');
        this.images = [];

        this._eventBind();

    },

    _eventBind: function () {
        this.$root.on('change', '#reviewImageFileOpenInput', this._loadImage.bind(this));
        this.$imageContainer.on('click', 'li.item', this._deleteImage.bind(this));
    },

    _loadImage : function(evt) {
        var files = evt.target.files;

        for (var i = 0, len = files.length; i < len; i++) {
            var file = files[i];
            var reader = new FileReader();

            reader.onload = (function(e) {
                var test = {};
                test.data = e.target.result;
                this.$imageContainer.append(reviewTumbnailTempl(test));
            }.bind(this));
            reader.readAsDataURL(file);
            this.images.push(file);
        }
    },

    _deleteImage : function(event){
        var $target = $(event.currentTarget);
        var $ul = this.$imageContainer;
        var index = $ul.index($target);

        $target.remove();
        this.images.splice(index,1);
    },


    getImage: function (){
        return this.images;
    }

});

module.exports = ImageUploadComponent;

