# 字典

## 字典的定义
```
字典和集合很相似，集合以[值，值]的形式存储元素，字典则是以[键，值]的形式来存储元素。字典也称作映射。
```

## 字典的实现
```js
const Dictionary = function() {
    this.items = {};

    // 判断字典中是否有该值
    Dictionary.prototype.has = function(key) {
        return this.items.hasOwnProperty(key);
    }

    // 向字典中添加新的值
    Dictionary.prototype.set = function(key, value) {
        this.items[key] = value;
    }

    // 从字典中移除某个值
    Dictionary.prototype.remove = function(key) {
        if (this.has(key)) {
            delete this.items[key]
            return true;
        } else {
            return false;
        }
    }

    // 通过键查询字典中的值
    Dictionary.prototype.get = function(key) {
        return this.has(key) ? this.items[key] : undefined;
    }

    // 以数组的形式输出字典的所有值
    Dictionary.prototype.values = function() {
        let arr = [];
        for (let key in this.items) {
            if (this.has(key)) {
                arr.push(this.items[key]);
            }
        }
        return arr;
    }

    // 清空字典中所有的值
    Dictionary.prototype.clear = function() {
        this.items = {};
        return true;
    }

    // 返回字典值的数量
    Dictionary.prototype.size = function() {
        let count = 0;
        for (let key in this.items) {
            count++;
        }
        return count;
    }

    // 以数组的形式返回字典所有的键
    Dictionary.prototype.keys = function() {
        let arr = [];
        for (let key in this.items) {
            if (this.has(key)) {
                arr.push(key);
            }
        }
        return arr;
    }

    // 返回字典
    Dictionary.prototype.getItems = function() {
        return this.items;
    }
}
```