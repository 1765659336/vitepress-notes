// 单向链表
const LikedList = function() {
    this.head = null;
    this.length = 0;

    // 辅助类,创建节点
    const Node = function(element) {
        this.element = element;
        this.next = null; //因为next用来存放对象，null是一个空的对象，因此这里使用空很合适
    };

    //在链表末尾添加元素
    LikedList.prototype.append = function(element) {
        const node = new Node(element);
        if (this.head === null) {
            this.head = node;
        } else {
            // 拿一个变量接收找到的最后一个节点,将添加的元素添加到最后一个节点的next属性
            let current = this.head;
            while (current.next) {
                current = current.next;
            }
            current.next = node;
        }
        this.length++;
    };

    // 获取链表的头
    LikedList.prototype.getHead = function() {
        return this.head;
    };

    //得到链表的长度
    LikedList.prototype.size = function() {
        return this.length;
    };

    // 往链表指定位置插入元素(下标位置position从0开始)
    LikedList.prototype.insert = function(position, element) {
        let node = new Node(element);
        // 插入位置不能越界
        if (position > -1 && position <= this.length) {
            // 在开头插入元素,相当于交换(插入的node和head两个数)
            if (position == 0) {
                let current = this.head;
                this.head = node;
                this.head.next = current;
            } else if (position == this.length) {
                //在末尾的位置插入
                this.append(element);
                // 在append方法中新建了一个node,所以将这个作用域中的node赋值为null,释放内存
                node = null;
                // append方法中执行了this.length++
                this.length--;
            } else {
                // previous插入坐标前一个节点 current当前插入坐标的节点
                let previous = null;
                let current = this.head;
                let index = 0;
                while (index < position) {
                    previous = current;
                    current = current.next;
                    index++;
                }
                previous.next = node;
                node.next = current;
            }
            this.length++;
            return true;
        } else {
            // return new Error("插入的下标位置越界了，不能这样");
            return false;
        }
    };

    //检查链表是否为空
    LikedList.prototype.isEmpty = function() {
        return this.length === 0;
    };

    //传入要删除某个位置下标的元素
    LikedList.prototype.removeAt = function(position) {
        // 越界问题
        if (position > -1 && position < this.length) {
            let current = this.head;
            //删除链表第一个元素
            if (position === 0) {
                this.head = current.next;
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
            this.length--;
            return current;
        } else {
            return false;
        }
    };

    //获取指定element的下标position
    LikedList.prototype.indexOf = function(element) {
        let index = 0;
        let current = this.head;
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
    LikedList.prototype.delete = function() {
        this.removeAt(this.length - 1);
    };
};