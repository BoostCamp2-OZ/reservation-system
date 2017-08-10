var ajaxModule = (function ($) {

    var categoryId;
    var offset;
    var cachedData = {};

    function cachingAjax(options, callback) {
        var cachingData = cachedData[options.url];

        if (cachingData) {
            callback(cachingData);
        } else {

            var result = $.ajax({

                url: options.url,
                method: options.method || 'GET',
                data: options.data || null,
                contentType: 'application/json'

            }).then(function (json) {

                cachedData[options.url] = json; // data caching
                callback(json);         // callback function
            });
        }

    }

    return {
        ajax: cachingAjax
    }

})($);
