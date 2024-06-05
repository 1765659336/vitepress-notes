/* 
    方法2，线性探查
    当想向表中某个位置加入一个新元素的时候，如果索引
为index的位置已经被占据了，就尝试index+1的位置。如果index+1的位置也被 占据了，就尝试index+2的位置，以此类推。
    在js中，我们不需要像其它语言一样担心数组的长度超出可用范围，需要手动扩容。因为js的数组会自动扩容，但是会影响性能，所以需要好好
设计一下，数组的初始长度给多大，一次扩容多少，这些问题较为复杂，目前还没有水平去深入-__-
*/
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
        let hash = hashFunction(key);
        while (this.table[hash] !== undefined) {
            hash++;
        }
        this.table[hash] = value;
    };

    // 从散列表中查找一个值(根据键名)
    HashTable.prototype.get = function(key) {
        const hash = hashFunction(key);
        if (this.table[hash] === undefined) {
            return false;
        } else {
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
                console.log(i + ":  " + this.table[i]);
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