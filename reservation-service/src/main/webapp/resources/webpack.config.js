var path = require('path');
var UglifyJSPlugin = require('uglifyjs-webpack-plugin');
// var OptimizeCssAssetsPlugin = require('optimize-css-assets-webpack-plugin');
var ExtractTextPlugin = require('extract-text-webpack-plugin');

module.exports = {
    entry: {
        main: ['./js/mainPage.js'],
        detail: ['./js/detailPage.js'],
        my: ['./js/myReservation.js'],
        reserve: ['./js/reservePage.js'],
        review: ['./js/reviewPage.js'],
        reviewWrite: ['./js/reviewWritePage.js']
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
            },
            {
                test: /\.css$/,
                // loader: ExtractTextPlugin.extract("style-loader", "css-loader")
            }
        ]
    },
    plugins: [
        new UglifyJSPlugin(),
        new ExtractTextPlugin("[name].css")
    ]
};