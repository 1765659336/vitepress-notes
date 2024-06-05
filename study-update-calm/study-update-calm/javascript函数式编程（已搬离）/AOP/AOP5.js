/* 
    确保链式函数的参数函数可以拿到调用者传递的参数
*/
Function.prototype.before = function(fnBe) {
    const _this = this; // this 指向test对象
    // 返回一个函数，为了链式调用
    return function() {
        // console.log(this, "before");
        fnBe.call(this, ...arguments);
        _this.call(this, ...arguments);
    };
};

Function.prototype.after = function(fnAf) {
    const _this = this; // this 指向before返回的那个函数
    return function() {
        // console.log(this, "after");
        // console.log(arguments);
        _this.call(this, ...arguments);
        fnAf.call(this, ...arguments);
    };
};

function test() {
    console.log("test");
    // console.log(this);
    console.log(...arguments);
}

test
    .before(function() {
        console.log("before");
        console.log(this); // this指向test调用者
        console.log(...arguments);
    })
    .after(function() {
        console.log("after");
        console.log(this); // this指向test调用者
        console.log(...arguments);
    })
    .call(test, "a", "b", "c");