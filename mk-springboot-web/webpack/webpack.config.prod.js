'use strict';

const webpackMerge = require('webpack-merge');
const commonConfig = require('./webpack.config.common');
const helpers      = require('./helpers');

 module.exports = webpackMerge(commonConfig, {
   mode: 'production',
   output: {
        path: helpers.root('dist'),
        filename: 'app/[name].[hash].bundle.js',
        chunkFilename: 'app/[id].[hash].chunk.js'
    },
    
    optimization: {
        noEmitOnErrors: true
    },

    module: {
        rules: [
            {
                test: /\.ts$/,
                loaders: [
                    'babel-loader',
                    {
                        loader: 'awesome-typescript-loader',
                        options: {
                            configFileName: helpers.root('tsconfig.json')
                        }
                    },
                    'angular2-template-loader',
                    'angular-router-loader'
                ],
                exclude: [/node_modules/]
            }
        ]
    }
 });