let proxyObj = {};
proxyObj['/']={
    ws: false,
    target: 'http://localhost:8081',
    // 发送请求头，host被设置为target
    changeOrigin: true,
    // 不重写请求地址
    pathRewrite: {
        '^/': '/'
    }
};


module.exports={
    devServer: {
        host: 'localhost',
        port: 8080,
        proxy: proxyObj
    }
};