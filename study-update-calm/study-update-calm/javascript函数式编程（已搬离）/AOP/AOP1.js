// 单独为一个函数对象添加方法
test.__proto__.before = function(fn) {
    fn();
    // 返回一个它自己，实现链式调用
    return this;
}

test.__proto__.after = function(fn) {
    fn();
    return this;
}

function test() {
    console.log("test");
}

test.before(function() { console.log("before"); }).after(function() { console.log("after"); });

test();