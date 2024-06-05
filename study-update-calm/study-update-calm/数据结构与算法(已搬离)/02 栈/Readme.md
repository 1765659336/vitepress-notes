# 栈

## 栈的定义

```纯文本
栈是一种先进后出的有序集合。新添加的或待删除的元素都保存在站的末尾，称为栈顶，另一端就叫栈底。在栈里，新元素都靠近栈顶，旧元素都接近栈底
```


## 栈的API

```纯文本
出栈push()
进栈pop()
获取这个栈getStack()
检查栈顶元素peek()
检查栈是否为空isEmpty()
清除栈clear()
获取栈的大小size()
```


## 栈的作用

```纯文本
在编程语言的编译器和内存中保存变量、和调用方法。
例如:函数调用栈，递归调用...
```


## Stack.js文件基于数组的封装

```JavaScript
const Stack = function() {

    //不使用this.item是因为使用者可以直接外部通过“实例.item”操作数组，破坏栈的结构
    const item = [];

    // 不使用this.push的原因是因为这样做,每一个new出来的对象都会去开辟一块空间用来保存这个方法,因为this会指向对象
    // 入栈
    Stack.prototype.push = function(Element) {
        item.push(Element);
    }

    // 出栈
    Stack.prototype.pop = function() {
        return item.pop();
    }

    // 获取整个栈
    Stack.prototype.getStack = function() {
        return item;
    }

    // 检查栈顶元素
    Stack.prototype.peek = function() {
        return item[item.length - 1];
    }

    // 检查栈是否为空
    Stack.prototype.isEmpty = function() {
        return item.length == 0;
    }

    // 清除栈
    Stack.prototype.clear = function() {
        item = [];
    }

    // 获取栈的长度
    Stack.prototype.size = function() {
        return item.length;
    }
}
```