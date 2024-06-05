# 树

## 树的概念

```
根节点：位于树顶部的节点

内部节点：至少有一个子节点的节点

外部节点（叶节点）：没有子节点的节点

节点→父节点→祖父节点→曾祖父节点

节点→子节点→孙子节点→曾孙节点

子树：树的子集，由树的节点和该节点的后代组成

节点的深度：取决于它的祖先节点的数量

树的高度：最大的深度

二叉树：节点最多只能有两个子节点，一个左侧子节点，另一个是右侧子节点

完全二叉树：除了外部节点，所有的其它节点都有两个子节点

二叉搜索树：是二叉树的一种，只允许左侧节点存储比父节点小的值，在右侧节点存储比父节点大或者相等的值
```



## 二叉树代码实现
```js
// 二叉搜索树
export default function() {
    // 封装一个树节点内部类
    const Node = function(key) {
        this.key = key;
        this.left = null;
        this.right = null;
    };

    // 根节点
    this.root = null;

    // 保存封装的内部方法中的this指向
    // const that = this;

    /*中序遍历是一种以上行顺序访问BST所有节点的遍历方式，也就是以从最小到最大的顺序访问所有节点。中序遍历的一种应用就是对树进行排序操作。
     */
    // 中序遍历辅助函数
    const inOrderTraverse = function(callback) {
        inOrderTraverseNode(this.root, callback);

        function inOrderTraverseNode(node, callback) {
            if (node !== null) {
                // 先走左节点输出的就是从小到大，先走右节点输出的就是从大到小
                inOrderTraverseNode(node.left, callback);
                callback(node.key);
                inOrderTraverseNode(node.right, callback);
            }
        }
    };

    // 先序遍历辅助函数，1、先序遍历就是先将最左一条路线输出，然后从下往上依次输出这些节点的右节点，2、若右节点有后代则回到1
    const preOrderTraverse = function(callback) {
        preOrderTraverseNode(this.root, callback);

        function preOrderTraverseNode(node, callback) {
            if (node !== null) {
                callback(node.key);
                preOrderTraverseNode(node.left, callback);
                preOrderTraverseNode(node.right, callback);
            }
        }
    };

    // 后序遍历辅助函数，（先找最底层的左树根节点然后右树根节点，再往上推一级的左树根节点，右树根节点...）一直找到整个树的最大右树根节点，然后再在整个树的最大右树中执行（）内的步骤,最后输出整个树的根节点，应用场景计算一个目录和所有的子目录的所有文件所占大小
    const postOrderTraverse = function(callback) {
        postOrderTraverseNode(this.root, callback);

        function postOrderTraverseNode(node, callback) {
            if (node !== null) {
                postOrderTraverseNode(node.left, callback);
                postOrderTraverseNode(node.right, callback);
                callback(node.key);
            }
        }
    };

    // 向树中添加一个节点
    this.__proto__.insert = function(key) {
        const newNode = new Node(key);

        // 封装一个比较如果节点大小的方法，用来查找新节点应该添加到树的哪个位置
        const insertNode = function(currentNode, newNode) {
            if (currentNode.key < newNode.key) {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                } else {
                    insertNode(currentNode.right, newNode);
                }
            } else {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                } else {
                    insertNode(currentNode.left, newNode);
                }
            }
        };

        // 判断树的根节点是否存在
        if (this.root == null) {
            this.root = newNode;
        } else {
            insertNode(this.root, newNode);
        }
    };

    // 以数组的形式输出树中节点值
    this.__proto__.values = function() {
        const arr = [];
        const pushArr = function(arrItem) {
            arr.push(arrItem);
        };
        inOrderTraverse.call(this, pushArr);
        return arr;
    };

    // 直接控制台打印
    this.__proto__.print = function() {
        const printVal = function(val) {
            console.log(val);
        };

        inOrderTraverse.call(this, printVal);
    };

    // 找到树中最小的值
    this.__proto__.min = function() {
        return minNode(this.root);
    };

    // 辅助函数可以设置从哪个节点开始查询最小值
    const minNode = function(current) {
        if (current) {
            while (current && current.left !== null) {
                current = current.left;
            }
            return current.key;
        }
        return null;
    };

    // 找到树中最大的值
    this.__proto__.max = function() {
        return maxNode(this.root);
    };

    // 辅助函数可以设置从哪个节点开始查询最大值
    const maxNode = function(current) {
        // 判断传入的节点是不是一个正确的值
        if (current) {
            while (current && current.right !== null) {
                current = current.right;
            }
            return current.key;
        } else {
            return null;
        }
    };

    // 判断这个值是不是树中的节点
    this.__proto__.search = function(key) {
        return searchNode(this.root, key);
    };

    // 搜索值辅助函数
    const searchNode = function(node, key) {
        if (node === null) {
            return false;
        }

        if (key < node.key) {
            serachNode(node.left, key);
        } else if (key > node.key) {
            serachNode(node.right, key);
        } else {
            return true;
        }
    };

    // 移除一个节点,重新构造树
    this.__proto__.remove = function(key) {
        // 判断是否有这个值
        if (this.search(key) == true) {
            // 重新构造树的最后一步
            this.root = removeNode(this.root, key);
            return true;
        } else {
            return false;
        }
    };

    // 删除节点，重新构造树
    const removeNode = function(node, key) {
        // 查询当前节点右侧子树最小的子节点
        const findMinNode = function(node) {
            if (node === null) {
                return null;
            }
            while (node && node.left) {
                node = node.left;
            }
            return node;
        };

        if (node === null) {
            return null;
        }

        if (key < node.key) {
            // 继续向左查找
            // 因为removeNode会有返回值node,这个node的值传给本次递归的node.left,相当于重新构建树
            node.left = removeNode(node.left, key);
            // 这个node是上一次removeNode里的node.left
            return node;
        } else if (key > node.key) {
            // 继续向右查找
            node.right = removeNode(node.right, key);
            return node;
        } else {
            // 相等，找到了，执行删除过程
            // 1、该节点是叶节点
            if (node.left === null && node.right === null) {
                // 删除这个node
                node = null;
                return node;
            }
            // 2、有一个子节点
            if (node.left === null && node.right) {
                node = node.right;
                return node;
            }

            if (node.right === null && node.left) {
                node = node.left;
                return node;
            }

            // 3、有两个子节点，就去寻找右侧子树的最小节点替换我们要删除的node
            // aux查找到的最小子节点
            const aux = findMinNode(node.right);
            // 用查找到的这个最小节点来替换这个被删除的节点，因为右树的最小节点都比左树的节点都要大，比右树的其它节点都要小，刚好符合树节点的条件
            node.key = aux.key;
            node.right = removeNode(node.right, aux.key);
            return node;
        }
    };
};
```