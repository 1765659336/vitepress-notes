// 交叉替换辅助函数
const swap = function(array, index1, index2) {
    let arrCopy = array[index2];
    array[index2] = array[index1];
    array[index1] = arrCopy;
};
/* 
        冒泡排序从小到大
        查询一次就找到当前这次查询最大的一个值或者最小的一个值放在数组最后，再次查询就找到大小次之的最大或最小值一直查询到只剩一个值
    */
Array.prototype.bubbleSort = function() {
    for (let i = 0; i < this.length - 1; i++) {
        // 每排好的i个值，再次遍历的时候就不用再遍历了
        for (let j = 0; j < this.length - 1 - i; j++) {
            if (this[j] > this[j + 1]) {
                swap(this, j, j + 1);
            }
        }
    }
    return this;
};

/*
    选择排序从小到大
    选择排序算法是一种原址比较排序算法。选择排序大致的思路是找到数据结构中的最小值并将其放置在第一位， 
    接着找到第二小的值并将其放在第二位，以此类推。最后一位不用找
 */
Array.prototype.selectionSort = function() {
    for (let i = 0; i < this.length - 1; i++) {
        let minIndex = i;
        for (let j = i + 1; j < this.length; j++) {
            if (this[minIndex] > this[j]) {
                minIndex = j;
            }
        }
        swap(this, i, minIndex);
    }
    return this;
};

/* 
    插入排序从小到大
    插人排序每次排一个数组项,以此方式构建最后的排序数组。假定第一项已经排序了，接着,它和第二项进行比较，第二项是应该待在原位还是捕到第一项之前呢?
    这样，头两项就已正确排序，接着和第三项比较( 它是该插人到第一、 第二还是第三的位置呢?也就是找到一个比前一项大，比后一项小的位置，因为之前已经是排好顺序的，因此比前一项大就意味着比之前的都要大，比后一项小，意味着比后面所有的项都小 ), 以此类推。
*/
Array.prototype.insertSort = function() {
    // 保留当前项的值
    let current = null;
    // 已经排序好项的个数/假设当前虚排序的项所在的位置也就是加到已经排好的数组的最后
    let count;
    for (let i = 1; i < this.length; i++) {
        count = i;
        current = this[count];
        while (count > 0 && current < this[count - 1]) {
            // 说明当前项的值比已经排好的当前while循环最后一位小,因此当前while循环最后一位下标加1，往后移一位，为当前项留出位置
            this[count] = this[count - 1];
            count--;
        }
        // 影响原数组也没事，因为不会影响到数组的长度与后面未排序的值大小
        this[count] = current;
    }
    return this;
};

/* 
    归并排序
    归并排序是-种分治算法。其思想是将原始数组切分成较小的数组，直到每个小数组只有一个位置，
    接着将小数组归并成较大的数组，直到最后只有一个排序完毕的大数组。
*/
// 每当要实现一个递归函数，我们都会实现一个实际被执行的辅助函数
Array.prototype.mergeSort = function() {
    // 拆分数组辅助函数
    const mergeSortRec = function(array) {
        if (array.length === 1) {
            return array;
        }
        // 返回小于或等于一个给定数字的最大整数
        const mid = Math.floor(array.length / 2);
        // 前闭后开截取值
        const left = array.slice(0, mid);
        const right = array.slice(mid, array.length);
        return merge(mergeSortRec(left), mergeSortRec(right));
    };

    // 按照大小顺序合并数组
    const merge = function(left, right) {
        let initLeft = 0;
        let initRight = 0;
        const result = [];
        while (initLeft < left.length && initRight < right.length) {
            if (left[initLeft] < right[initRight]) {
                result.push(left[initLeft]);
                initLeft++;
            } else if (left[initLeft] > right[initRight]) {
                result.push(right[initRight]);
                initRight++;
            } else {
                result.push(left[initLeft]);
                result.push(right[initRight]);
                initLeft++;
                initRight++;
            }
        }
        // 将其中一个未被遍历完的剩余项全部添加到result中
        if (initLeft !== left.length) {
            for (let i = initLeft; i < left.length; i++) {
                result.push(left[initLeft]);
                initLeft++;
            }
        } else {
            for (let i = initRight; i < right.length; i++) {
                result.push(right[initRight]);
                initRight++;
            }
        }
        return result;
    };
    return mergeSortRec(this);
};

/* 
    快速排序 从小到大
    快速排序的思路是，从中间找到一个主元，然后设置一个左元和右元，分别是两端的值，然后进行查找，左元找比主元小的，右元找比主元大的，找到之后进行交换
    直到左元比右元下标大,然后再重复该过程
*/
Array.prototype.quickSort = function() {
    // 递归辅助函数
    function quickSortRec(array) {
        if (array.length === 1) {
            return array;
        }
        // 经过考虑，选择中间值作为中元,因为在排序过程中，原数组会变化，我们需要备份中元值
        const mid = array[Math.floor(array.length / 2)];
        let leftIndex = 0;
        let rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            while (array[leftIndex] < mid && leftIndex < rightIndex) {
                leftIndex++;
            }
            while (array[rightIndex] > mid && leftIndex < rightIndex) {
                rightIndex--;
            }
            swap(array, leftIndex, rightIndex);
            // 值交换的时候，需要改变左元和右元的值，不让会陷入死循环
            leftIndex++;
            rightIndex--;
        }
        return quickSortRec(array.slice(0, Math.floor(array.length / 2))).concat(
            quickSortRec(array.slice(Math.floor(array.length / 2), array.length))
        );
    }

    return quickSortRec(this);
};

const arr = [1, 2, 6, 5, 3, 8, 2, 3];
console.log(arr.quickSort());