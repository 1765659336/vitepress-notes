# 链表

## 链表的定义
```
链表存储有序的元素集合，但不同于数组，链表中的元素在内存中并不是连续放置的。每个元素由一个存储元素本身的节点和一个指向下一个元素的引用(也称指针或链接)组成。
```

## 数组的缺点
```
数组的创建通常需要申请一段连续的内存空间,并且大小是固定的,所以当前数组不能满足容量需求时,需要扩容.是很浪费性能的
数组开头或中间位置插入数据的成本很高,需要进行大量元素位移
```

## 链表与数组的比较
```
相对于传统的数组，链表的一个好处在于，添加或移除元素的时候不需要移动其他元素。然而，链表需要使用指针，因此实现链表时需要额外注意。数组的另一个细节是可以直接访问/修改任何位置的任何元素，而要想访问/修改链表中的一个元素，需要从起点(表头)开始迭代列表直到找到所需的元素。
```

## 单向列表API
| API                       | API说明                                         | 参数说明                           | 返回体说明                                                   |
| ------------------------- | ----------------------------------------------- | ---------------------------------- | ------------------------------------------------------------ |
| append(element)           | 在链表末尾添加元素                              | element节点的值                    | void空                                                       |
| getHead()                 | 获取链表的头                                    | void空                             | head头节点                                                   |
| size()                    | 得到链表的长度                                  | void空                             | length链表的长度                                             |
| insert(position, element) | 往链表指定位置插入元素(下标位置position从0开始) | position节点的下标,element节点的值 | true/false插入成功或者失败                                   |
| isEmpty()                 | 检查链表是否为空                                | void空                             | true/false是否为空                                           |
| removeAt(position)        | 传入要删除某个位置下标的元素                    | position节点的下标                 | current/false删除的节点/删除失败                             |
| indexOf(element)          | 获取指定element的下标position                   | element节点的值                    | index/-1指定element的下标/没有节点的element等于传入的element |
| remove(element)           | 删除指定元素                                    | element节点的值                    | current/false删除的节点/删除失败                             |
| update(position, element) | 更新指定position下标的节点                      | position节点的下标,element节点的值 | true/false更新成功/失败                                      |
| get(position)             | 获取指定position下标的节点                      | position节点的下标                 | current/false获取的节点/获取失败                             |
| delete()                  | 删除链表最后一个节点                            | void                               | current/false删除的节点/删除失败                             |

## 创建一个单向链表

```JavaScript
const LikedList = function() {
    let head = null;
    let length = 0;

    // 辅助类,创建节点
    const Node = function(element) {
        this.element = element;
        this.next = null; //因为next用来存放对象，null是一个空的对象，因此这里使用空很合适
    };

    //在链表末尾添加元素
    LikedList.prototype.append = function(element) {
        const node = new Node(element);
        if (head === null) {
            head = node;
        } else {
            // 拿一个变量接收找到的最后一个节点,将添加的元素添加到最后一个节点的next属性
            let current = head;
            while (current.next) {
                current = current.next;
            }
            current.next = node;
        }
        length++;
    };

    // 获取链表的头
    LikedList.prototype.getHead = function() {
        return head;
    };

    //得到链表的长度
    LikedList.prototype.size = function() {
        return length;
    };

    // 往链表指定位置插入元素(下标位置position从0开始)
    LikedList.prototype.insert = function(position, element) {
        let node = new Node(element);
        // 插入位置不能越界
        if (position > -1 && position <= length) {
            // 在开头插入元素,相当于交换(插入的node和head两个数)
            if (position == 0) {
                let current = head;
                head = node;
                head.next = current;
            } else if (position == length) {
                //在末尾的位置插入
                this.append(element);
                // 在append方法中新建了一个node,所以将这个作用域中的node赋值为null,释放内存
                node = null;
                // append方法中执行了length++
                length--;
            } else {
                // previous插入坐标前一个节点 current当前插入坐标的节点
                let previous = null;
                let current = head;
                let index = 0;
                while (index < position) {
                    previous = current;
                    current = current.next;
                    index++;
                }
                previous.next = node;
                node.next = current;
            }
            return true;
        } else {
            // return new Error("插入的下标位置越界了，不能这样");
            return false;
        }
        length++;
    };

    //检查链表是否为空
    LikedList.prototype.isEmpty = function() {
        return length === 0;
    };

    //传入要删除某个位置下标的元素
    LikedList.prototype.removeAt = function(position) {
        // 越界问题
        if (position > -1 && position < length) {
            let current = head;
            //删除链表第一个元素
            if (position === 0) {
                head = current.next;
            } else {
                //while循环退出条件是，查找到链表的index下标位置为position时，进行删除操作
                let index = 0;
                let previous = null;
                // 查询
                while (index < position) {
                    previous = current;
                    current = current.next;
                    index++;
                }
                // 当index == position时,删除
                previous.next = current.next;
            }
            length--;
            return current;
        } else {
            return false;
        }
    };

    //获取指定element的下标position
    LikedList.prototype.indexOf = function(element) {
        let index = 0;
        let current = head;
        while (current) {
            if (current.element == element) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    };

    // 删除指定元素
    LikedList.prototype.remove = function(element) {
        return this.removeAt(this.indexOf(element));
    };

    // 更新指定position下标的节点
    LikedList.prototype.update = function(position, element) {
        if (this.get(position)) {
            this.get(position).element = element;
            return true;
        }
        return false;
    };

    // 获取指定position下标的节点
    LikedList.prototype.get = function(position) {
        // 越界判断
        if (position > -1 && position < length) {
            let current = head;
            let index = 0;
            while (index < position) {
                current = current.next;
                index++;
            }
            return current;
        } else {
            return false;
        }
    };

    // 删除链表最后一个节点
    LikedList.prototype.delete = function() {
        this.removeAt(length - 1);
    };
};
```

## 双向列表API
| API                       | API说明                                         | 参数说明                           | 返回体说明                                                   |
| ------------------------- | ----------------------------------------------- | ---------------------------------- | ------------------------------------------------------------ |
| append(element)           | 在链表末尾添加元素                              | element节点的值                    | void空                                                       |
| getHead()                 | 获取链表的头                                    | void空                             | head头节点                                                   |
| getTail()                 | 获取链表的尾                                    | void空                             | tail尾节点                                                   |
| size()                    | 得到链表的长度                                  | void空                             | length链表的长度                                             |
| insert(position, element) | 往链表指定位置插入元素(下标位置position从0开始) | position节点的下标,element节点的值 | true/false插入成功或者失败                                   |
| isEmpty()                 | 检查链表是否为空                                | void空                             | true/false是否为空                                           |
| removeAt(position)        | 传入要删除某个位置下标的元素                    | position节点的下标                 | current/false删除的节点/删除失败                             |
| indexOf(element)          | 获取指定element的下标position                   | element节点的值                    | index/-1指定element的下标/没有节点的element等于传入的element |
| remove(element)           | 删除指定元素                                    | element节点的值                    | current/false删除的节点/删除失败                             |
| update(position, element) | 更新指定position下标的节点                      | position节点的下标,element节点的值 | true/false更新成功/失败                                      |
| get(position)             | 获取指定position下标的节点                      | position节点的下标                 | current/false获取的节点/获取失败                             |
| delete()                  | 删除链表最后一个节点                            | void                               | current/false删除的节点/删除失败                             |

## 创建一个双向链表

```JavaScript
//双向链表
var DoubleLikedList = function() {
    let head = null;
    let length = 0;
    let tail = null; //链表尾部，下面的方法实现就可以从尾部开始查找(也就是用tail替换head)，也就是反向操作链表大致类似。

    // 辅助类,创建节点
    const Node = function(element) {
        this.prev = null;
        this.element = element;
        this.next = null; //因为next用来存放对象，null是一个空的对象，因此这里使用空很合适
    }

    //添加元素
    DoubleLikedList.prototype.append = function(element) {
        let node = new Node(element);
        if (head === null) {
            head = node;
            tail = node;
        } else {
            let current = head;
            while (current.next) {
                current = current.next;
            }
            current.next = node;
            node.prev = current;
            tail = node;
        }
        length++;
    }

    // 获取链表的头
    DoubleLikedList.prototype.getHead = function() {
        return head;
    }

    // 获取链表的尾
    DoubleLikedList.prototype.getTail = function() {
        return tail;
    }

    //得到链表的长度
    DoubleLikedList.prototype.size = function() {
        return length;
    }

    // 往链表中插入元素(下标位置position从0开始)
    DoubleLikedList.prototype.insert = function(position, element) {
        let node = new Node(element);
        // 插入位置不能越界
        if (position > -1 && position <= length) {
            // 在开头插入元素,相当于交换(插入的node和head两个数)
            if (position === 0) {
                let current = head;
                head = node;
                head.next = current;
                current.prev = head;
            } else if (position === length) { //在末尾的位置插入
                this.append(element);
                node = null;
                // append方法中执行了length++
                length--;
            } else {
                let previous = null;
                let current = head;
                let index = 0;
                while (index < position) {
                    previous = current;
                    current = current.next;
                    index++;
                }
                previous.next = node;
                node.prev = previous;
                node.next = current;
            }
            return true;
        } else {
            return false;
        }
        length++;
    }

    //检查链表是否为空
    DoubleLikedList.prototype.isEmpty = function() {
        return length === 0;
    }

    //传入要删除某个元素的下标
    DoubleLikedList.prototype.removeAt = function(position) {
        // 越界问题
        if (position > -1 && position < length) {
            let current = head;
            //删除链表第一个元素
            if (position == 0) {
                head = current.next;
                head.prev = null;
            } else {
                //while循环退出条件是，查找到链表的index下标位置为position时，进行删除操作
                let index = 0;
                //待删除元素的前一个节点
                let previous = null;
                // 查询
                while (index < position) {
                    previous = current;
                    current = current.next;
                    index++;
                }
                // 当index == position时,删除
                previous.next = current.next;
                //如果删除的元素不是最后一个元素
                if (position !== length - 1) {
                    current.next.prev = previous;
                } else {
                    tail = previous;
                }
            }
            length--;
            return current;
        } else {
            return false;
        }
    }

    //获取指定element的下标position
    DoubleLikedList.prototype.indexOf = function(element) {
        let index = 0;
        let current = head;
        while (current) {
            if (current.element == element) {
                // return直接退出函数后面的代码不会执行
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // 删除指定元素
    DoubleLikedList.prototype.remove = function(element) {
        return this.removeAt(this.indexOf(element));
    }

    // 更新指定position下标的节点
    DoubleLikedList.prototype.update = function(position, element) {
        if (this.get(position)) {
            this.get(position).element = element;
            return true;
        }
        return false;
    };

    // 获取指定position下标的节点
    DoubleLikedList.prototype.get = function(position) {
        // 越界判断
        if (position > -1 && position < length) {
            let current = head;
            let index = 0;
            while (index < position) {
                current = current.next;
                index++;
            }
            return current;
        } else {
            return false;
        }
    };

    // 删除链表最后一个节点
    DoubleLikedList.prototype.delete = function() {
        this.removeAt(length - 1);
    };
}
```


# 循环链表

循环链表就是将head.prev指向tail尾部节点，将tail.next指向head节点。

