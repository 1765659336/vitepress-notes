/* 
    确保函数可以进行链式调用
    在函数的构造函数的原型上面添加这两个方法
    高阶函数，参数是一个函数，返回值也是一个函数
*/
Function.prototype.before = function(fn) {
    fn();
    // 返回一个函数，为了链式调用
    return function() {}
}

Function.prototype.after = function(fn) {
    fn();
    return function() {}
}

function test() {
    console.log("test");
}

test.before(function() { console.log("before"); }).after(function() { console.log("after"); });

test();