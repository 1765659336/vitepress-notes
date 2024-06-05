1. 创建react项目`npx create-react-app app`
2. 下载axios`npm i axios`
3. 下载mockjs`npm i mockjs`
4. 编写mock文件 src/mock/test.js
```js
import Mock from 'mockjs';
// 请求的响应时间1秒到3秒之间
Mock.setup({
    timeout: '1000-3000'
})

// 请求方式要使用小写
Mock.mock("/test", "get", {
    "string|1-10": "★"
});
```
5. 发送请求src/api/index.js
```js
import request from "../utils/request";

export const test = () => {
    return request({
        method: "GET",
        url: "/test",
    })
};
```
6. 在组件中启用mock, src/App.js
```js
...
import {test} from './api';
import { openMock } from "./utils/env";
if (openMock) {
  require("./mock/test");
}
...
test().then(res => {
    console.log(res);
  }).catch(err => {
    console.log(err);
  })
```
7. 给mock加一个开关 src/utils/env.js
```js
// 是否启动mock
export const openMock = true;
```