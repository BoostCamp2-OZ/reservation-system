// webpack.config.js
var path = require('path');
var UglifyJSPlugin = require('uglifyjs-webpack-plugin');
// var HtmlWebpackPlugin = require('html-webpack-plugin');


module.exports = {
    entry: {
        main : ['./js/mainPage.js'],
        detail : ['./js/detailPage.js'],
        my : ['./js/myReservation.js'],
        reserve : ['./js/reservePage.js']
    },
    output: {
        path: path.join(__dirname, 'dist'),
        filename: "[name].bundle.js"
    },
    module: {
        rules: [
            {
                test: /\.hbs$/,
                loader: "handlebars-template-loader"
            }
        ]
    },
    plugins: [
        new UglifyJSPlugin()
    ]
}