# 队列

## 队列的定义
```
队列是遵循先进先出原则的一组有序的项。队列在尾部添加新元素，并从头部移除元素。最新添加的元素必须排在队列的末尾
```

## Queue.js文件的基于数组的封装

```JavaScript
const Queue = function(){
  const item = [];
  
  // 入列
  Queue.prototype.queueIn = function(element){
    item.push(element);
  }
  
  // 出列
  Queue.prototype.queueOut = function(){
    return item.shift();
  }
  
  // 查看队列头
  Queue.prototype.peek = function(){
    return item[0];
  }
  
  // 检查队列是否为空
  Queue.prototype.isEmpty = function(){
    return item.length === 0;
  }
  
  // 返回队列大小
  Queue.prototype.size = function(){
    return item.length;
  }

  // 查看整个队列
  Queue.prototype.getQueue = function(){
    return item
  }
}
```

# 优先级队列PriorityQueue.js基于数组封装
## 优先级队列的定义
```
根据每一项的优先级，来判断轻重缓急，有需求的就可以进行“插队”
```

## 优先级队列的实现
```JavaScript
function PriorityQueue() {
    // 封装一个包含元素值和优先级的内部类
    function QueueElement(element, priority) {
        this.element = element;
        this.priority = priority;
    }

    const item = [];

    // 入列
    PriorityQueue.prototype.PriorityQueueIn = function(element, priority) {
        // 创建queueElement对象
        const queueElement = new QueueElement(element, priority);

        if (item.length === 0) {
            item.push(queueElement);
        } else {
            for (let i = 0; i < item.length; i++) {
                if (queueElement.priority > item[i].priority) {
                    item.splice(i, 0, queueElement);
                    // 当查到最后一位之前已经满足条件进行插入了,代码就不再继续执行
                    return
                }
            }
            // 可以进行到这一步,说明之前的return没有执行,也就是说这个元素优先级是队列中最低的,应该添加到末尾
            item.push(queueElement);
        }
    };

    // 出列
    PriorityQueue.prototype.PriorityQueueOut = function() {
        return item.shift();
    }

    // 查看队列头
    PriorityQueue.prototype.peek = function() {
        return item[0];
    }

    // 检查队列是否为空
    PriorityQueue.prototype.isEmpty = function() {
        return item.length === 0;
    }

    // 返回队列大小
    PriorityQueue.prototype.size = function() {
        return item.length;
    }

    // 查看整个队列
    PriorityQueue.prototype.getPriorityQueue = function() {
        return item
    }
}
```