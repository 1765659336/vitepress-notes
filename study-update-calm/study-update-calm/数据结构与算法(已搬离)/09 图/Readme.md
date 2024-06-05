## 图的相关概念
```
图是一组由边连接的节点的集合
任何二元关系都可以用图表示
相邻顶点：由一条边连接在一起的顶点
顶点的度：该顶点的相邻顶点数量
路径：顶点的连续序列，如A B C 
简单路径：不包含重复的顶点
如果图中不存在环，则称该图是无环的
如果图中的每两个顶点间都存在路径，则该图是连通的
无向图，图的边没有方向，图的边有方向有向图
如果图中的每两个顶点在双向上都有路径，则该图是强连通的,反之就是稀疏图
加权图与未加权图，也就是路径是否有大小
```
## 图的表示方式

图的表示方式有很多种，不存在绝对正确的方式，各有好坏，根据实际情况考虑

## 最常见的邻接矩阵表示图

用一个二维数组展示，两个索引分别代表两个顶点，如果两个顶点有边，则array[i][j] = 1  否则array[i][j] = 0

### 该表示方法的缺点

1、如果是稀疏图，会有很多个0，浪费计算机的存储空间来表示不存在的边

2、找给定顶点的相邻顶点，就算只有一个，也不得遍历整个数组

3、图中的顶点可能会发生改变，而二维数组不太灵活

## 在大多数问题上更好的方式邻接表

我们也可以使用一种叫作邻接表的动态数据结构来表示图。邻接表由图中每个顶点的相邻顶点列表所组成。存在好几种方式来表示这种数据结构。我们可以用列表(数组)链表，甚至是散列表或是字典来表示相邻顶点列表。

邻接字典实现图

```JavaScript
var Dictionary = function() {
  let items = {};

  // 判断字典中是否有该值
  this.has = function(key) {
    return items.hasOwnProperty(key);
  }

  // 向字典中添加新的值
  this.set = function(key, value) {
    items[key] = value;
  }

  // 从字典中移除某个值
  this.remove = function(key) {
    if (this.has(key)) {
      delete items[key]
      return true;
    } else {
      return false;
    }
  }

  // 通过键查询字典中的值
  this.get = function(key) {
    return this.has(key) ? items[key] : undefined;
  }

  // 以数组的形式输出字典的所有值
  this.values = function() {
    let arr = [];
    for (let key in items) {
      if (this.has(key)) {
        arr.push(items[key]);
      }
    }
    return arr;
  }

  // 清空字典中所有的值
  this.clear = function() {
    items = {};
    return true;
  }

  // 返回字典值的数量
  this.size = function() {
    let count = 0;
    for (let key in items) {
      count++;
    }
    return count;
  }

  // 以数组的形式返回字典所有的键
  this.keys = function() {
    let arr = [];
    for (let key in items) {
      if (this.has(key)) {
        arr.push(key);
      }
    }
    return arr;
  }

  // 返回字典
  this.getItems = function() {
    return items;
  }
}

function Graph() {
  // 存储顶点的数组
  let arr = [];
  // 字典存储边，边的入射点是键，边的终点是值
  let dic = new Dictionary();

  // 添加入射点
  this.addInputPoint = function(point) {
    arr.push(point);
    dic.set(point, []);
  }

  // 添加所有边的终点(添加的时候要先添加所有的顶点，再添加边)
  this.addOuputPoint = function(point, endPoint) {
    dic.get(point).push(endPoint);
    // 下面写了就是无向图
    dic.get(endPoint).push(point);
  }

  // 输出顶点以及顶点的边
  this.toString = function() {
    let s = '';
    for (let i in arr) {
      s += arr[i] + '-->';
      for (let j in dic.get(arr[i])) {
        s += dic.get(arr[i])[j] + '  ';
      }
      s += '\n';
    }
    return s;
  }
}
// 测试用
var g = new Graph();
var arr = ['A', 'B', 'C', 'D'];
for (let i in arr) {
  console.log(arr[i]);
  g.addInputPoint(arr[i]);
}

g.addOuputPoint('A', 'B');
g.addOuputPoint('A', 'C');
g.addOuputPoint('B', 'C');
g.addOuputPoint('C', 'D');
g.addOuputPoint('D', 'A');

console.log(g.toString());

```


尽管邻接表可能对大多数问题来说都是更好的选择，但以上两种表示法都很有用，且它们有着不同的性质(例如，要找出顶点v和w是否相邻，使用邻接矩阵会比较快，直接通过索引找到array[v][w]等于1还是0

## 关联矩阵

也是用二维数组实现，矩阵的行表示顶点，列表示边。如果顶点i是边e的入射点，则array[i][e] = 1

### 优点：

当使用邻接表时，边的数量很多时，邻接的数组、链表、甚至是散列表或是字典中的数据将会更多，占用更多的计算机存储空间，使用关联矩阵可以节省空间和内存