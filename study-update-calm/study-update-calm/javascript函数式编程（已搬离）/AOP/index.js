// 作为链式调用函数的一个桥梁
function People(name) {
    this.name = name;
}
People.prototype.getOffWork = function(value) {
    console.log("下班回家");

    function fn() {}
    fn.lock = false;
    return fn;
};
People.prototype.eat = function() {
    const _this = this;
    if (_this.lock) {
        console.log("warning,sleep没有写在最后");

        function fn() {
            console.log("吃饭");
            _this();
        }
        fn.lock = true;
        return fn;
    } else {
        function fn() {
            _this();
            console.log("吃饭");
        }
        fn.lock = false;
        return fn;
    }
};
People.prototype.lave = function() {
    const _this = this;
    if (_this.lock) {
        console.log("warning,sleep没有写在最后");

        function fn() {
            console.log("洗澡");
            _this();
        }
        fn.lock = true;
        return fn;
    } else {
        function fn() {
            _this();
            console.log("洗澡");
        }
        fn.lock = false;
        return fn;
    }
};
People.prototype.sleep = function() {
    const _this = this;

    function fn() {
        _this();
        console.log("睡觉到天亮");
    }

    /* 走到sleep将lock改为true，告诉后面的调用者
      前面的函数中包含sleep函数，你们要执行在我之前 */
    fn.lock = true;
    return fn;
};

Function.prototype.getOffWork = People.prototype.getOffWork;
Function.prototype.eat = People.prototype.eat;
Function.prototype.lave = People.prototype.lave;
Function.prototype.sleep = People.prototype.sleep;

const company = {
    name: "madouchuanmei",
    employees: [new People("zhangsan"), new People("lisi"), new People("wangwu")],
    // 打卡
    clock: function(name) {
        for (const iterator of this.employees) {
            if ((iterator.name = name)) {
                console.log(iterator.name);
                return iterator.getOffWork(iterator.name);
            }
        }
    },
};

// 张三打卡下班 吃饭洗澡睡觉
company.clock("zhangsan").sleep().eat().lave()();
company.clock("zhangsan").eat().sleep().lave()();
company.clock("zhangsan").eat().lave().sleep()();
company.clock("zhangsan").lave().eat().sleep()();
// --------------------------------