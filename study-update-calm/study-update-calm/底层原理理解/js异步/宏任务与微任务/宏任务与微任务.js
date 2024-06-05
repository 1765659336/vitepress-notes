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