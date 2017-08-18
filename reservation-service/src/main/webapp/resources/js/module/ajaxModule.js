var ajaxModule = (function ($) {

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
                contentType: 'application/json'

            }).then(function (json) {
                return cachedData[options.url] = json;
            });
        }
    }

    return {
        ajax: cachingAjax
    }

})($);
