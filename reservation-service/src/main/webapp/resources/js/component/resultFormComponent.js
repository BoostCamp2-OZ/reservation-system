var ResultFormComponent = extend(eg.Component,{


    init : function ($root, options){
        this.$root = $root;
        this.options = {
            score : 0,
            comment : '',
            images : []
        }

        this.productId = $root.data("id");

        this.formData ={};

        this.options = Object.assign({}, this.options, options);

        this._registerReview();
    },

    _registerReview : function(){
        var options = this.options;

        if(!this._checkInputValue(options.comment)){
            alert('5글자 이상 작성해 주세요');
            return false;
        }

        this.formData = new FormData();
        this.formData.append('score', options.score);
        this.formData.append('comment', options.comment);
        this.formData.append('productId', this.productId);

        for(var i = 0; i < options.images.length; i++){
            this.formData.append('file', options.images[i]);
        }

        var afterRegister = $.ajax({
            url : '/api/comments',
            processData : false,
            contentType : false,
            data : this.formData,
            method : 'POST'
        });

        afterRegister.done(function(res) {
            if(res > 0) location.href = '/my';
        });

        afterRegister.fail(function(err) {
            console.error('fail! new review', err);
        })
    },

    _checkInputValue : function(comment) {
        return comment.length >= 5;
    }

});