var $ = require('jquery');

var ajaxModule = (function () {

    var cachedData = {};

    function cachingAjax(options) {
        var cachingData = cachedData[options.url];

        if (cachingData) {
            return Promise.resolve(cachingData);
        } else {
            return $.ajax({
                url: options.url,
                method: options.method || 'GET',
                data: JSON.stringify(options.data) || null,
                contentType: options.contentType || 'application/json',

            }).then(function (json) {
                return cachedData[options.url] = json;
            });
        }
    }

    function formDataAjax(options) {
        return $.ajax({
            url: options.url,
            method: options.method || 'POST',
            data : this.formData,
            contentType: options.contentType || 'application/json',
            processData : options.processData || true
        });
    }

    return {
        ajax: cachingAjax,
        formData: formDataAjax
    }
})();

module.exports = ajaxModule;
