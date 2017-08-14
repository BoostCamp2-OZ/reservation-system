var ajaxModule = (function ($) {

    var cachedData = {};

    function cachingAjax(options, callback) {
        var cachingData = cachedData[options.url];

        if (cachingData) {
            callback(cachingData);
        } else {

            $.ajax({

                url: options.url,
                method: options.method || 'GET',
                data: options.data || null,
                contentType: 'application/json'

            }).then(function (json) {

                cachedData[options.url] = json;
                callback(json);
            });
        }
    }

    return {
        ajax: cachingAjax
    }

})($);
