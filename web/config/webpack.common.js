var webpack = require("webpack");

module.exports = {
    entry: {
        'polyfills': './app/polyfills.ts',
        'vendor': './app/vendor.ts',
        'application': './app/main.ts'
    },
    output: {
        path: __dirname,
        filename: './dist/[name].js',
        chunkFilename: './dist/[id].js'
    },
    resolve: {
        extensions: ['', '.ts', '.js']
    },
    module: {
        loaders: [{
            test: /\.ts$/,
            loaders: ['ts-loader']
        }]
    },
    plugins: [
        new webpack.optimize.CommonsChunkPlugin({
            name: ['application', 'vendor', 'polyfills']
        })
    ]
};