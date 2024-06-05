/* 
    方法1，分离链接
    分离链接法包括为散列表的每一个位置创建一个链表并将元索存储在里面。它是解决冲突的
最简单的方法，但是它在HashTable实例之外还需要额外的存储空间。
*/
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

// 使用链表加数组来解决哈希冲突
const HashTable = function() {
    this.table = [];

    //散列函数,计算传进来的值的ASCLL码的之和
    const hashFunction = function(key) {
        let hash = 0;
        for (let i = 0; i < key.length; i++) {
            hash += key.charCodeAt(i);
        }
        return hash % 37;
    };

    // 向散列表中添加元素
    HashTable.prototype.put = function(key, value) {
        const hash = hashFunction(key);
        if (this.table[hash] === undefined) {
            this.table[hash] = new LikedList();
        }
        this.table[hash].append(value);
    };

    // 从散列表中查找一个值(根据键名)
    HashTable.prototype.get = function(key) {
        const hash = hashFunction(key);
        if (this.table[hash] === undefined) {
            return false;
        } else {
            // 应该得到整个链表，后续在链表中加入返回所有值的方法
            return this.table[hash];
        }
    };

    // 清空散列表
    HashTable.prototype.clear = function() {
        this.table = [];
    };

    // 移除散列表中的一个元素(根据键名)
    HashTable.prototype.remove = function(key) {
        this.table[hashFunction(key)] = undefined;
    };

    // 输出散列表中所有的元素
    HashTable.prototype.print = function() {
        for (let i = 0; i < this.table.length; i++) {
            /*在创建稀疏数组时，会存在一些空白单元JavaScript会将这些空白单元隐式的赋值为undefined（但这与将其显式赋值为 undefined是有所区别的）这个过程并且会影响length的值*/
            if (this.table[i] !== undefined) {
                console.log(i + ":  " + this.table[i].getHead());
            }
        }
    };
};

let hashtable = new HashTable();
hashtable.put("a", 1);
hashtable.put("c", 2);
hashtable.put("b", 3);
hashtable.print();
console.log(hashtable.get("a"));
console.log(hashtable.get("b"));
console.log(hashtable.get("c"));
hashtable.remove("a");
hashtable.print();
hashtable.clear();
hashtable.print();