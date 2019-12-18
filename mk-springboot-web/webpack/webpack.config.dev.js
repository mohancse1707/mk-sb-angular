'use strict';

const webpackMerge = require('webpack-merge');

const commonConfig = require('./webpack.config.common');
const helpers      = require('./helpers');

module.exports = webpackMerge(commonConfig, {
    mode: 'development',

    devtool: 'cheap-module-eval-source-map',

    output: {
        path: helpers.root('dist'),
        filename: 'app/[name].[hash].bundle.js',
        chunkFilename: 'app/[id].[hash].chunk.js'
    },

    devServer: {
        contentBase: helpers.root('dist'),
        proxy: [{
            context: [
                '/app',
                '/api',
                '/management',
                '/swagger-resources',
                '/v2/api-docs',
                '/h2-console',
                '/auth'
            ],
            target: 'http://127.0.0.1:8080',
            secure: false,
            headers: { host: 'localhost:9060' }
        }],
        watchOptions: {
            ignored: /node_modules/
        }
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
            },
            {
                test: /.js/,
                use: [
                  {
                    loader: `expose-loader`,
                    options: '$'
                  }
                ]
              }
        ]
    }
});