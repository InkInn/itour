var webpackMerge = require('webpack-merge');
var commonConfig = require('./webpack.common.js');

module.exports = webpackMerge(commonConfig, {
    devServer: {
        historyApiFallback: true,
        stats: 'minimal',
        proxy: {
            '/api': {
                target: 'http://localhost:8912/teaResearch',
                secure: false
            }
        }
    },
    devtool: '#source-map'
});