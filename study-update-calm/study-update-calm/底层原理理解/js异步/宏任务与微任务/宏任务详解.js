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