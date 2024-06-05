const express = require('express');
const Mock = require('mockjs');

const app = express();

app.get('/server', (req, res) => {
    // 设置响应头,允许跨域
    res.setHeader('Access-Control-Allow-Origin', '*');
    // 设置响应体
    res.send('Hello Ajax GET ');
});

app.post('/server', (req, res) => {
    // 设置响应头,允许跨域
    res.setHeader('Access-Control-Allow-Origin', '*');
    // 设置响应体
    res.send('Hello Ajax POST ');
})

// 不管是什么请求都可以响应
app.all('/server-json', (req, res) => {
    // 设置响应头,允许跨域
    res.setHeader('Access-Control-Allow-Origin', '*');
    let person = {
        name: 'liujie',
        age: 18
    }

    person = JSON.stringify(person);
    // 设置响应体
    res.send(person);
})

// CORS
app.all('/cors', (req, res) => {
    // 在进行这个测试时，将80端口改成了8000端口了，因为80端口和8848端口好像没有跨域问题
    //设置响应头,允许跨域*代表全部页面
    res.setHeader('Access-Control-Allow-Origin', '*');
    // 设置某一个端口
    // res.setHeader('Access-Control-Allow-Origin', 'http://localhost:8080');
    // 设置限定的请求方式*全部请求方式
    // res.setHeader('Access-Control-Allow-Method', '*');
    const data = Mock.mock({
        "string|1-10": "★"
    })
    res.json(data);
})

app.listen(8000, () => {
    console.log('服务器启动成功');
});