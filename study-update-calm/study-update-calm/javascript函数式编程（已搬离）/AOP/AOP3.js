/* 
    确保函数的执行顺序正确
        通过函数里面的this指向调用者来决定执行顺序
*/
Function.prototype.before = function(fnBe) {
    const _this = this; // this 指向test对象
    // 返回一个函数，为了链式调用
    return function() {
        fnBe();
        _this();
    }
}

Function.prototype.after = function(fnAf) {
    const _this = this; // this 指向before返回的那个函数
    return function() {
        _this();
        fnAf();
    }
}

function test() {
    console.log("test");
}

test.before(function() { console.log("before"); }).after(function() { console.log("after"); })();