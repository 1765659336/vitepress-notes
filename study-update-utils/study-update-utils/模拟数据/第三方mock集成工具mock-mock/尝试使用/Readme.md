## 使用
+ 安装：`npm i -g mockm` 或者 `npm i mockm`
+ 配置：创建文件 mm.config.js并录入
```
module.exports = {
    api: { // 编写自己的接口
        '/my/api': {
        msg: `我的 api`
    },
}
 
```
+ 启动：命令行执行`mm`
+ 查看接口：浏览器访问 http://127.0.0.1:9000/my/api查看效果.
浏览器访问 http://127.0.0.1:9005/#/get/my/api查看请求详情.
+ 问题：[端口被占用]关闭占用端口的程序, 再重新运行命令。或者告诉 mockm 使用其他端口 `mm port=8800 replayPort=8801  replayPort=8802`,默认情况下 mockm 的几个服务分别占用以下端口:
port=9000
replayPort=9001
testPort=9002