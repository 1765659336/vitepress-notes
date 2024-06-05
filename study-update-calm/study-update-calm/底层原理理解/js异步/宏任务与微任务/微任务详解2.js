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