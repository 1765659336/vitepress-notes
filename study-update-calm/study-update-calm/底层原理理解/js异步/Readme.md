## 参考资料
「第十六章 JS中的宏任务与...程，ES6必学知识」https://www.aliyundrive.com/s/WTu5EMa5JEL
点击链接保存，或者复制本段内容，打开「阿里云盘」APP ，无需下载极速在线查看，视频原画倍速播放。
B站链接
https://www.bilibili.com/video/BV1eJ41177Rg?p=8

## 笔记
### 宏任务与微任务队列
```
1、js执行的主任务队列，然后还有一个宏任务队列和微任务队列
2、每当主任务队列清空时，js的事件循环机制就会去微任务队列中拿一个微任务到主任务队列中执行，如果没有微任务，再去看宏任务队列中有没有任务。（因为微任务的优先级高于宏任务）
3、promise在js中是微任务，每次执行解析时都会添加到微任务队列末尾
4、定时器、延时器在js中是宏任务，每次执行解析时都会添加到宏任务队列末尾
5、promise的then调用链有一个监听机制，当前一个then调用完成，会在前一个then调用完成时返回的函数中闭包调用后一个then回调
函数，此时后一个then回调函数为被当成一个微任务添加到微任务队列中
```
```js
const timer1 = setTimeout(() => {
    console.log("延时器1");
}, 0);

new Promise((resolve, reject) => {
    resolve();
}).then(() => {
    console.log("promise1");
});

new Promise((resolve, reject) => {
    resolve();
    console.log("主任务1");
}).then(() => {
    console.log("promise2");
});

const timer2 = setTimeout(() => {
    console.log("延时器2");
}, 0);

console.log("主任务2");
/* 
主任务1
主任务2
promise1
promise2
延时器1
延时器2
*/
```
### 宏任务详解
```
定时器和延时器设置的时间，浏览器不能完全精确，(不推荐用定时器的时间来决定代码的执行顺序)当解析到这个定时器时，会开始计时。当时间到的时候，定时器的回调函数会被当成宏任务添加到宏任务队列中。一旦时间到了之后会被添加到主任务中执行
```
```js
/* 
思考：
    1、解析的时候时间很短，可以忽略不计，timer1,timer2,timer3几乎同时开始计算时间 "同步"输出
    2、timer2(1s),timer1(3s),timer4(5s)按照顺序添加到宏任务队列中
    3、timer2到达时间被执行,"定时器2"输出
    4、timer1执行，timer3(1s)被添加到宏任务中，开始计时,此时宏任务中有timer3(1s),timer4(2s),"定时器1"输出
    5、timer3执行，"定时器3"输出
    6、timer4执行, "定时器4"输出
*/
const timer1 = setTimeout(() => {
    console.log("定时器1");
    const timer3 = setTimeout(() => {
        console.log("定时器3");
    }, 1000);
}, 3000);
console.log("同步");
const timer2 = setTimeout(() => {
    console.log("定时器2");
}, 1000);
const timer4 = setTimeout(() => {
    console.log("定时器4");
}, 5000);
/* 
同步
定时器2
定时器1
定时器3
定时器4
*/
```
### 微任务详解
```
1、promise作为微任务代表，promise构造函数中的代码为同步代码，then为微任务链式调用，当调用的时候才会被添加到微任务队列
2、微任务队列优先级比宏任务队列优先级高，只有当微任务队列中的任务为空，才会去执行宏任务队列中的任务
3、await后面是一个promise对象，可以获取promise对象的值，await要等待它所修饰的代码执行完，才会开始“解析”当前异步函数中的后续代码
    使用了await的函数要变为异步函数 async function(){}
```
```js
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
```
```js
/* 
    在await后面加一段需要长时间执行的代码，发现xxx在await的promise对象代码执行完成才会输出
    await要等待它所修饰的代码执行完，才会开始“解析”当前异步函数中的后续代码
*/
async function fn1() {
    const a = await new Promise((resolve, reject) => {
        console.log("promise1");
        resolve();
    }).then(() => {
        console.log("then1");
    }).then(() => {
        new Promise((resolve, reject) => {
            console.log("promise2");
            resolve();
        })
    });
    let str = "";
    for (let i = 0; i < 9999999; i++) {
        // js字符串拼接很耗时间
        str += i;
    }
    console.log("xxx");
    return new Promise((resolve, reject) => {
        console.log("promise3");
        resolve();
    }).then(() => {
        console.log("then2")
    });
}

function fn2() {
    new Promise((resolve, reject) => {
        console.log("2promise1");
        resolve();
    }).then(() => {
        console.log("2then1");
    }).then(() => {
        new Promise((resolve, reject) => {
            console.log("2promise2");
            resolve();
        })
    });
    console.log("2xxx");
    return new Promise((resolve, reject) => {
        console.log("2promise3");
        resolve();
    }).then(() => {
        console.log("2then2")
    });
}
fn1();
fn2();
console.log("主任务");
/* 
    执行结果
        promise1
        2promise1
        2xxx
        2promise3
        主任务
        then1
        2then1
        2then2
        promise2
        2promise2
        xxx
        promise3
        then2
*/
```
### DOM渲染任务与script标签任务是同步的
```
当<script></script>中的js代码书写在DOM渲染之前，且这段js代码执行时间很长，DOM渲染任务迟迟不执行，页面会成为一个空白页，影响用户体验
```
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<script>
    let str = "";
    for (let i = 0; i < 9999999; i++) {
        // js字符串拼接很耗时间
        str += i;
    }
</script>

<body>
    <h1>HI</h1>
</body>

</html>
```
## 任务共享内存
```
js是单线程的，不管是微任务还是宏任务，只有被调到主任务中执行的时候，才去读取内存中的值
多任务队列，只是为了让线程有一定的优先级与多线程执行。他们共用的是一块儿内存
```
```js
let i = 0;
setTimeout(() => {
    // 不能使用i++，不然会将当前i的值输出，再进行+1操作，此时代码执行完时，输出的值与内存的值不一致
    console.log(++i);
}, 1000);
setTimeout(() => {
    console.log(++i);
}, 1000);
```
## 进度条案例
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        #father {
            width: 500px;
            border: 1px solid #ccc;
            height: 20px;
        }
        
        #son {
            background-color: yellow;
        }
    </style>
</head>

<body>
    <div id="father">
        <div id="son"></div>
    </div>
</body>
<script>
    const handle = function(i) {
        if (i <= 100) {
            setTimeout(() => {
                const son = document.getElementById("son");
                son.innerHTML = i;
                son.style.width = i + "%";
                handle(++i);
            }, 10);
        }
    }
    handle(0);
</script>

</html>
```