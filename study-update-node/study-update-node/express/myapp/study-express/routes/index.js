// 引入Express
var express = require("express");
// 引入Express路由对象
var router = express.Router();
//首页路由
router.get("/", function(req, res, next) {
    // 渲染index页面，传入对象
    res.render("index", {
        title: "Hello",
        name: "零度逍遥",
        age: 25,
        happy: true,
    });
});

// 定义一个GET请求“/”的路由
router.get("/for", function(req, res, next) {
    // 渲染index页面，传入渲染对象
    res.render("for", {
        title: "Hello",
        // 定义一个数组，每一项都是一个对象
        list: [{
                id: 1,
                content: "今天天气不错",
            },
            {
                id: 2,
                content: "昨天你吃了什么？",
            },
            {
                id: 3,
                content: "工作好累",
            },
        ],
        targetId: 2, // 定义一个变量，表示当前被选中的id
    });
});

// 学习router中间件函数中的requset对象
router.get("/abcd", function(req, res, next) {
    console.log(req.url); // /abcd
    res.send(req.headers);
});
router.get("/abcd/abc", function(req, res, next) {
    console.log(req.url); // /abcd/abc
    res.send(req.cookies);
});
router.get("/book/:id", function(req, res, next) {
    console.log(req.url); // /book/2
    res.send(req.params); // { id: '2' }
});
router.get("/goods", function(req, res, next) {
    // 浏览器地址栏输入/goods?id=2&name=商品
    console.log(req.query); // { id: '2', name: '商品' }
});
router.post("/postApi", function(req, res, next) {
    console.log(req.body);
    // res.send()方法发送数据到页面显示
    res.send(req.body);
});

// 学习router中间件函数中的response对象
router.get("/res", function(req, res, next) {
    res.render("index.html");
});
router.get("/reshtml", function(req, res, next) {
    res.render("index", function(err, html) {
        // 读取的页面文件文本
        console.log(html);
        // html和css都是文本，渲染到浏览器的时候，浏览器会帮我们解析，js会被浏览器引擎执行
        res.send(
            `<!DOCTYPE html><html lang="en"><head><meta charset="UTF-8"><title>Title</title></head><body><h2>我是一个页面</h2></h2></body></html>`
        );
    });
});
router.get("/resbuffer", function(req, res, next) {
    // 下载2进制文件
    res.send(new Buffer("<p>html</p>"));
});
router.get("/resstring", function(req, res, next) {
    res.send("<h1>html</h1>");
});
router.get("/resobject", function(req, res, next) {
    res.send({ a: 1, b: 2 });
});
router.get('/resjson', function(req, res, next) {
    // 返回JSON格式的数据
    res.json({
        name: 'john',
        age: 28,
        hobby: ['打篮球', '唱歌', '旅游']
    })
});
router.get('/resstatus', function(req, res, next) {
    res.status(202).end();
});
router.get('/resstatus2', function(req, res, next) {
    // 定义一个404状态码，并以JSON格式返回
    res.status(404).json({
        statusCode: 404,
        msg: 'Not Found'
    })
});
router.get('/resredirect1', function(req, res, next) {
    console.log('resredirect1');
    res.redirect('/resredirect11'); // 跳转到“/book2”路由
});
router.get('/resredirect11', function(req, res, next) {
    console.log('resredirect11');
    res.end(); // 直接结束
});
router.get('/resredirect2', function(req, res, next) {
    res.redirect('http://www.baidu.com');
});
router.get('/resredirect3', function(req, res, next) {
    console.log('/resredirect3');
    res.redirect(301, '/resredirect33'); // 301跳转到“/resredirect33”路由
});
router.get('/resredirect33', function(req, res, next) {
    console.log('/resredirect33');
    res.end(); // 直接结束
});
module.exports = router;