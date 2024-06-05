//双向链表
const DoubleLikedList = function() {
    this.head = null;
    this.length = 0;
    this.tail = null; //链表尾部，下面的方法实现就可以从尾部开始查找(也就是用tail替换head)，也就是反向操作链表大致类似。

    // 辅助类,创建节点
    const Node = function(element) {
        this.prev = null;
        this.element = element;
        this.next = null; //因为next用来存放对象，null是一个空的对象，因此这里使用空很合适
    }

    //添加元素
    DoubleLikedList.prototype.append = function(element) {
        let node = new Node(element);
        if (this.head === null) {
            this.head = node;
            this.tail = node;
        } else {
            let current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = node;
            node.prev = current;
            this.tail = node;
        }
        this.length++;
    }

    // 获取链表的头
    DoubleLikedList.prototype.getHead = function() {
        return this.head;
    }

    // 获取链表的尾
    DoubleLikedList.prototype.getTail = function() {
        return this.tail;
    }

    //得到链表的长度
    DoubleLikedList.prototype.size = function() {
        return this.length;
    }

    // 往链表中插入元素(下标位置position从0开始)
    DoubleLikedList.prototype.insert = function(position, element) {
        let node = new Node(element);
        // 插入位置不能越界
        if (position > -1 && position <= this.length) {
            // 在开头插入元素,相当于交换(插入的node和head两个数)
            if (position === 0) {
                let current = this.head;
                this.head = node;
                this.head.next = current;
                current.prev = this.head;
            } else if (position === this.length) { //在末尾的位置插入
                this.append(element);
                node = null;
                // append方法中执行了length++
                this.length--;
            } else {
                let previous = null;
                let current = this.head;
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
            this.length++;
            return true;
        } else {
            return false;
        }
    }

    //检查链表是否为空
    DoubleLikedList.prototype.isEmpty = function() {
        return this.length === 0;
    }

    //传入要删除某个元素的下标
    DoubleLikedList.prototype.removeAt = function(position) {
        // 越界问题
        if (position > -1 && position < this.length) {
            let current = this.head;
            //删除链表第一个元素
            if (position == 0) {
                this.head = current.next;
                this.head.prev = null;
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
                if (position !== this.length - 1) {
                    current.next.prev = previous;
                } else {
                    this.tail = previous;
                }
            }
            this.length--;
            return current;
        } else {
            return false;
        }
    }

    //获取指定element的下标position
    DoubleLikedList.prototype.indexOf = function(element) {
        let index = 0;
        let current = this.head;
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
        if (position > -1 && position < this.length) {
            let current = this.head;
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
        this.removeAt(this.length - 1);
    };
}