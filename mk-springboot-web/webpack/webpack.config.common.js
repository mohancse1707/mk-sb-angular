'use strict';
const webpack = require('webpack');
const CleanWebpackPlugin   = require('clean-webpack-plugin');
const HtmlWebpackPlugin    = require('html-webpack-plugin');
const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const helpers              = require('./helpers');

module.exports = {
    entry: {
        vendor: './src/vendor.ts',
        polyfills: './src/polyfills.ts',
        main: './src/main.ts',
        style: './src/app/content/css/style.css',
        global: './src/app/content/css/navbar.min.css',
        navbarmin: './src/app/content/js/navbar.min.js'
    },

    resolve: {
        extensions: ['.ts', '.js', '.json', '.css', '.scss', '.html']
    },

    module: {
        rules: [
            {
                test: /\.html$/,
                loader: 'html-loader'
            },
            {
                test:/\.(s*)css$/,
                use:['to-string-loader', 'style-loader','css-loader', 'postcss-loader', 'sass-loader']
            }
        ]
    },

    plugins: [
        new webpack.DefinePlugin({
            'process.env': {
                BUILD_TIMESTAMP: `'${new Date().getTime()}'`,
                // The root URL for API calls, ending with a '/' - for example: `"https://www.jhipster.tech:8081/myservice/"`.
                // If this URL is left empty (""), then it will be relative to the current context.
                // If you use an API server, in `prod` mode, you will need to enable CORS
                // (see the `jhipster.cors` common JHipster property in the `application-*.yml` configurations)
                SERVER_API_URL: `''`
            }
        }),
        new CleanWebpackPlugin(
            helpers.root('dist'), { root: helpers.root(), verbose: true }),

        new HtmlWebpackPlugin({
            template: './src/index.html',
            chunksSortMode: 'dependency',
            inject: 'body'
        }),
        new MiniCssExtractPlugin({
            filename: '[name].css'
          })
    ]
    
};