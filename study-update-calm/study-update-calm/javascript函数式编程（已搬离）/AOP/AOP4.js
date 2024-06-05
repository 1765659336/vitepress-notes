/* 
    确保链式函数的参数函数this指向调用者
*/
Function.prototype.before = function(fnBe) {
    const _this = this; // this 指向test对象
    // 返回一个函数，为了链式调用
    return function() {
        // console.log(this, "before");
        fnBe.call(this);
        _this.call(this);
    };
};

Function.prototype.after = function(fnAf) {
    const _this = this; // this 指向before返回的那个函数
    return function() {
        // console.log(this, "after");
        _this.call(this);
        fnAf.call(this);
    };
};

function test() {
    console.log("test");
    // console.log(this);
}

test
    .before(function() {
        console.log("before");
        console.log(this); // this指向test调用者
    })
    .after(function() {
        console.log("after");
        console.log(this); // this指向test调用者
    })
    .call(test);