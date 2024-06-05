const Stack = function() {

    // 不使用this.item是因为使用者可以直接外部通过“实例.item”操作数组，破坏栈的结构 xxx
    // const item = [];

    // 目前只能是使用this.item,因为const item = [];当使用Stack创建多个栈时,使用的都是这个[]
    this.item = [];
    // 不使用this.push的原因是因为这样做,每一个new出来的对象都会去开辟一块空间用来保存这个方法,因为this会指向对象
    // 入栈
    Stack.prototype.push = function(Element) {
        this.item.push(Element);
    }

    // 出栈
    Stack.prototype.pop = function() {
        return this.item.pop();
    }

    // 获取整个栈
    Stack.prototype.getStack = function() {
        return this.item;
    }

    // 检查栈顶元素
    Stack.prototype.peek = function() {
        return this.item[this.item.length - 1];
    }

    // 检查栈是否为空
    Stack.prototype.isEmpty = function() {
        return this.item.length == 0;
    }

    // 清除栈
    Stack.prototype.clear = function() {
        this.item = [];
    }

    // 获取栈的长度
    Stack.prototype.size = function() {
        return this.item.length;
    }
}