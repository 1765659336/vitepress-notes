const CustomSet = function() {
    this.items = {};

    // 这么写,创建多个集合时,用的都是一个对象
    // let items = {};

    // 判断集合中是否有某个属性,返回布尔值
    CustomSet.prototype.has = function(value) {
        return this.items.hasOwnProperty(value);
    }

    // 向集合中添加属性
    CustomSet.prototype.add = function(value) {
        if (!this.has(value)) {
            this.items[value] = value;
            return true;
        }
        return false;
    }

    // 在集合中删除某个值
    CustomSet.prototype.remove = function(value) {
        if (this.has(value)) {
            delete this.items[value];
            return true;
        }
        return false;
    }

    // 清空集合，删除集合所有的值
    CustomSet.prototype.clear = function() {
        this.items = {};
        return true;
    }

    // 返回集合的长度，不用考虑兼容性的写法
    /*不能简单地使用for- in语句遍历items对象的属性，递增count变量的值。还需要使用has方法(以验证items对象具有该属性)，因为对象的原型包含了额外的属性( 属性既有继承自JavaScript的object类的，也有属于对象自身，未用于数据结构的)。
     */
    CustomSet.prototype.size = function() {
        // 计数器
        let count = 0;
        for (let prop in this.items) {
            if (this.has(prop)) {
                count++;
            }
        }
        return count;
    }

    // 以数组的形式返回集合中所有的元素
    CustomSet.prototype.valuesArr = function() {
        let arr = [];
        for (let prop in this.items) {
            if (this.items.hasOwnProperty(prop)) {
                arr.push(this.items[prop]);
            }
        }
        return arr;
    }

    // 求与另外一个集合的并集
    CustomSet.prototype.union = function(set2) {
        // for(var i in arr)i是数组的下标
        // for(var i in obj)i是对象的属性名
        // 可以通过items[属性名]调用属性值判断是否相同，在这里我们利用之前的valuesArr()方法转数组，通过下标调用数组值也可行
        let arr1 = this.valuesArr();
        let arr2 = set2.valuesArr();
        /* 方式1:返回一个普通的对象
        let obj = {};
        // 深拷贝原始集合， 防止调用方法， 破坏原始集合
        for (let prop in this.items) {
            obj[prop] = this.items[prop];
        }
        // 查询与原集合不同的值
        for (let prop2 in arr2) {
            for (let prop1 in arr1) {
                if (arr2[prop2] !== arr1[prop1]) {
                    obj[arr2[prop2]] = arr2[prop2];
                }
            }
        } */

        /* 方式2:返回一个集合
         */
        let obj = new CustomSet();
        for (let prop in this.items) {
            obj.add(this.items[prop]);
        }
        // 查询与原集合不同的值
        for (let prop2 in arr2) {
            for (let prop1 in arr1) {
                if (arr2[prop2] !== arr1[prop1]) {
                    obj.add(arr2[prop2]);
                }
            }
        }
        return obj;
    }

    // 求与另外一个集合的交集
    CustomSet.prototype.intersection = function(set2) {
        // for(var i in arr)i是数组的下标
        // for(var i in obj)i是对象的属性名
        let arr1 = this.valuesArr();
        let arr2 = set2.valuesArr();
        // 存放交集
        /* 方式1 
        let obj = {}
            // 查询不同的值
        for (let prop2 in arr2) {
            for (let prop1 in arr1) {
                if (arr2[prop2] == arr1[prop1]) {
                    obj[arr1[prop1]] = arr1[prop1];
                    // 匹配上了，后面的必不可能相同，不然set2就不是集合了，因此退出当前循环
                    break;
                }
            }
        } */

        /* 方式2: 返回一个集合 */
        let obj = new CustomSet();
        for (let prop2 in arr2) {
            for (let prop1 in arr1) {
                if (arr2[prop2] == arr1[prop1]) {
                    obj.add(arr1[prop1]);
                    // 匹配上了，后面的必不可能相同，不然set2就不是集合了，因此退出当前循环
                    break;
                }
            }
        }
        return obj;
    }

    // 求与另外一个集合的差集,找到当前集合不同于另外一个集合的属性值，找“我有你没有的”
    CustomSet.prototype.differenceSet = function(set2) {
        let arr1 = this.valuesArr();
        let arr2 = set2.valuesArr();
        /* 方式1
        let obj = {};
        // 去掉相同的值
        for (let prop1 in arr1) {
            for (let prop2 in arr2) {
                if (arr2[prop2] == arr1[prop1]) {
                    // 这个数组是通过集合转换而来的,不会有重复的值
                    arr1.splice(arr1.indexOf(arr1[prop1]), 1);
                    // 将arr2中重复的值也删掉,减少后续for循环执行的次数
                    arr2.splice(arr2.indexOf(arr2[prop2], 1));
                    // 退出当前的循环,只会退出一个for循环
                    break;
                }
            }
        } 
        // 剩下来的独一无二的属性值
        for (let prop in arr1) {
            obj[arr1[prop]] = arr1[prop];
        }*/

        /* 方式2: 返回一个集合 */
        let obj = new CustomSet();
        // 去掉相同的值
        for (let prop1 in arr1) {
            for (let prop2 in arr2) {
                if (arr2[prop2] == arr1[prop1]) {
                    // 这个数组是通过集合转换而来的,不会有重复的值
                    arr1.splice(arr1.indexOf(arr1[prop1]), 1);
                    // 将arr2中重复的值也删掉,减少后续for循环执行的次数
                    arr2.splice(arr2.indexOf(arr2[prop2], 1));
                    // 退出当前的循环,只会退出一个for循环
                    break;
                }
            }
        }

        for (let prop in arr1) {
            obj.add(arr1[prop]);
        }

        return obj;
    }

    // 判断当前集合是不是另外一个集合的子集
    CustomSet.prototype.Subject = function(set2) {
        let arr1 = this.valuesArr();
        let arr2 = set2.valuesArr();
        if (arr1.length <= arr2.length) {
            for (let prop1 in arr1) {
                for (let prop2 in arr2) {
                    // 在当前这次循环次数中,不相等判断prop2是不是arr2的最后一个下标，如果是就说明当前arr1[prop1]在arr2中找不到，所以就不是
                    if (arr1[prop1] !== arr2[prop2]) {
                        if (prop2 == arr2.length - 1) {
                            return false;
                        }
                    } else {
                        break;
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}