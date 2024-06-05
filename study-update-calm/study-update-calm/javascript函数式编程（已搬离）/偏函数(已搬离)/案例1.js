// 以前我们要实现一个函数用来判断变量的类型是不是某某某是这么实现的

const isType = function(type, variable) {
    return Object.prototype.toString.call(variable) === "[object " + type + "]";
};

console.log(isType("Object", {}));

// 此时我们需要设置某一个值为默认值，并且返回一个默认值为我们设置的那个函数

const isTypeCurrying = function(type) {
    return function(variable) {
        return Object.prototype.toString.call(variable) === "[object " + type + "]";
    }
}

const isTypeCurryingFunction = isTypeCurrying("Function");
console.log(isTypeCurryingFunction(function() {}));