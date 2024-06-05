// 队列
const Queue = function() {
    this.item = [];

    // 入列
    Queue.prototype.queueIn = function(element) {
        this.item.push(element);
    }

    // 出列
    Queue.prototype.queueOut = function() {
        return this.item.shift();
    }

    // 查看队列头
    Queue.prototype.peek = function() {
        return this.item[0];
    }

    // 检查队列是否为空
    Queue.prototype.isEmpty = function() {
        return this.item.length === 0;
    }

    // 返回队列大小
    Queue.prototype.size = function() {
        return this.item.length;
    }

    // 查看整个队列
    Queue.prototype.getQueue = function() {
        return this.item
    }
}