// 函数柯里化，返回一个函数，使用闭包将所有的参数保存起来，解决函数部分参数求值的问题

/* 
    比如：计算每个月的开销，传入每天的花销，得出每个月的开销
*/

let monthlyCost = 0;

// const cost = function(money) {
//     monthlyCost = monthlyCost + money;
// };

/* 
    但是其实我们并不关心每天的花销，我们不需要每天传入开销时，函数都会去做运算，占用性能
    因此可以使用闭包进行优化
*/

const cost = (function() {
    // 使用闭包
    let arr = [];
    return function() {
        if (arguments.length !== 0) {
            [].push.apply(arg, arguments);
        } else {
            // 非主要业务代码进行柯里化处理
            for (let value of arr) {
                monthlyCost += value;
            }
        }
    }
})()

// 将闭包中的非业务部分代码，柯里化出去
let cost = function() {
    for (let value of arguments) {
        monthlyCost += value;
    }
}

// 将函数柯里化
const currying = function(fn) {
    let arr = [];
    return function() {
        if (arguments.length !== 0) {
            [].push.apply(arr, arguments);
        } else {
            fn.apply(this, arr);
        }
    }
}
cost = currying(cost);
cost(100);
cost(200);
cost();
// ...
console.log(monthlyCost);