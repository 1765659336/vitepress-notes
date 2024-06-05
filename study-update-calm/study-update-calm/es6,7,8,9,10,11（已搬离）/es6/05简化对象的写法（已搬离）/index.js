let name = 'zhangsan';
let clog = function() {
    console.log('shuchu')
}

// 属性名和变量名相同
let obj = {
    name,
    clog,
    add(num1, num2) {
        return num1 + num2;
    }
}

// 效果相同的写法
let obj2 = {
    name: name,
    clog: clog,
    add: function(num1, num2) {
        return num1 + num2;
    }
}

obj.clog(); // shuchu
console.log(obj.name, obj.add(1, 2)); // zhangsan 3
obj2.clog(); // shuchu
console.log(obj2.name, obj2.add(1, 2)); // zhangsan 3