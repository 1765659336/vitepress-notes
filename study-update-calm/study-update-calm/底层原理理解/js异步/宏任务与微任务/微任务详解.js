/* 
思考：
    1、开始解析，定时器添加到宏任务中，Promise构造函数中的代码为同步代码直接执行输出“promise2”，resolve()执行调用then回调，then添加到微任务中
    console.log("同步");执行
    2、微任务优先级比宏任务优先级高，先执行then微任务then2输出
    3、微任务队列为空，执行宏任务“定时器1”输出，Promise构造函数中的代码为同步代码直接执行输出“promise1”，then1添加到微任务队列
    4、then1微任务执行，then1输出
*/
setTimeout(() => {
    console.log("定时器1");
    new Promise((resolve, reject) => {
        console.log("promise1");
        resolve();
    }).then(() => {
        console.log("then1");
    });
}, 1000);

new Promise((resolve, reject) => {
    console.log("promise2");
    resolve();
}).then(() => {
    console.log("then2");
});

console.log("同步");

/* 
执行结果：
    promise2
    同步
    then2
    定时器1
    promise1
    then1
*/