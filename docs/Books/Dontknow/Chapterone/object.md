# 创建对象的两种方式
## 文字形式
```js
var obj = {
    name: "zhangsan",
    sex: "male",
};
console.log(obj); // { name: 'zhangsan', sex: 'male' }
```
## 构造函数的形式
```js
var obj = new Object();
obj.name = "zhangsan";
obj.sex = "male";
console.log(obj); // { name: 'zhangsan', sex: 'male' }
```
## 两种方式的区别
```
文字声明和构造函数的形式声明没有什么很大的区别，唯一的区别在于构造函数声明的方式添加属性时，需要逐个的添加，一般使用文字声明的形式比较多。
```
# 类型
```
javascript中的语言类型一共有6种：
	简单基本类型：
		1、string
		2、number
		3、boolean
		4、null （注意：虽然typeof null输出object,但是这是js语言设计的缺陷，null实际上是简单基本类型）
		5、undefined
	复杂类型：
		6、object
			1、复杂基本类型
				1、function子对象
				2、array子对象
			2、内置对象
				1、String构造函数
				2、Number构造函数
				3、Boolean构造函数
				4、Object构造函数
				5、Function构造函数
				6、Array构造函数
				7、Date构造函数
				8、RegExp（正则表达式）构造函数
				9、Error构造函数
```
## 内置对象
### String、Number、Boolean
#### 有字面量形式和对象形式
```
String、Number、Boolean有字面量形式和对象形式。
```
```js
// 字面量形式
var str = "str";
var num = 1;
var bool = false;
// 对象形式
var str2 = new String("str");
var num2 = new Number(1);
var bool2 = new Boolean(false);
console.log(typeof str, typeof num, typeof bool, typeof str2, typeof num2, typeof bool2);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/60bb6004370e4d91ad912c5dd0bfaaeb.png)
#### 装箱
```js
// 字面量形式
var str = "str";
var num = 1;
var bool = false;
// 对象形式
var str2 = new String("str");
var num2 = new Number(1);
var bool2 = new Boolean(false);
console.log(str2, num2, bool2);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/9445787f73f44fc9b1c5fd75f640b47f.png)
```
我们可以通过上面的图发现，对象形式的值原型上有很多方法，毫无疑问，我们可以直接调用这些方法以及对象的属性。
```
```js
// 字面量形式
var str = "str";
var num = 1;
var bool = false;
// 对象形式
var str2 = new String("str");
var num2 = new Number(1);
var bool2 = new Boolean(false);
console.log(str, num, bool, str2, num2, bool2);
console.log(str2.length,num2.toString(), bool2.toString());
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/b88b023a272049ac80b1b3c4b8392e09.png)
```
如果我们用字面量的形式来调用会发生什么呢？会报错吗？
```
```js
// 字面量形式
var str = "str";
var num = 1;
var bool = false;
// 对象形式
var str2 = new String("str");
var num2 = new Number(1);
var bool2 = new Boolean(false);
console.log(str, num, bool, str2, num2, bool2);
console.log(str2.length, num2.toString(), bool2.toString());
console.log(str.length, num2.toString(), bool2.toString());
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/fb64a2dbdb294d20ae4dbecbb32e5624.png)
```
没有报错，并且输出的结果和对象形式的执行结果一致，这是因为js在我们调用字面量形式的方法时，会将字面量的值自动转换为对象类型的值。需要注意的是，只是js内部在解析执行这段代码的时候会将字面量的值转换为对象的形式来执行。执行完毕之后，原来的字面量的值依然还是字面量。
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/d145806f85d64b1d9f47d98a9f5ddc57.png)
#### null和undefined
##### 只有字面量的形式且只能通过字面量的形式创建
```
null和undefined没有对应的对象形式，只有字面量形式。js中并没有什么Null和Undefined构造函数。
```
```js
var _null = new Null();
var _undefined = new Undefined();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/3ef6cb2a959d4c25a2556f1a32e9c10d.png)
##### 解释一个我们常见的bug
```
我们书写的代码中，常常因为各种原因导致一些undefined的值出现，比如后端接口出错或修改，从而导致我们接收到值与之前的值不一样。导致一些对象身上的属性不存在。此时我们调用方法就会出现下面这种报错。
```
```js
var obj = {
    a: 0.999999
};

console.log(obj.a.toFixed(2));

obj.a = undefined;

console.log(obj.a.toFixed(2));
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/6327f089580b439d86fe2067bb473ac8.png)
##### 怎么避免
```js
var obj = {
    a: 0.999999
};

console.log(obj.a.toFixed(2));

obj.a = undefined;
// es5 逻辑判断符（当obj.a为0或者为false或者为null或者为undefined，当我们的值可以是false或者为0并调用方法或属性时，需要使用下面es6的方式）
console.log(obj.a && obj.a.toFixed(2));
// es6 ?.判断值是否为undefined或者为null
console.log(obj.a?.toFixed(2));
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/a86379e69ea0448cbe89da61c1693c00.png)
### Date、Error
#### 只有对象形式且只能通过构造函数的形式创建
[Date--MDN文档](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Date)
[Error-MDN文档](https://developer.mozilla.org/zh-CN/docs/Web/JavaScript/Reference/Global_Objects/Error#properties)
```js
var today = new Date();
console.log(Date.prototype);
console.log(today);
console.log(typeof today);
console.log(today.__proto__);
console.log(today.getDate());
// Error身上没有自己的属性和方法，只从原型链继承了Object原型对象的方法和属性
var err = new Error("出错了");
console.log(typeof err);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/a8a1b6bf19164be9b943de1f7ccf39c1.png)
```
Date的这些属性和方法我找不到。啊~
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/963bb51f62ee4971be2123a6cef39ed9.png)
### Object、Array、Function、RegExp
#### 只有对象的形式，既可以使用字面量形式创建也可以构造函数创建
```js
var obj = {
    a: 1
};

var obj2 = new Object();
obj2.a = 1;

var arr = [1, 2];

var arr2 = new Array(1, 2);

var fn = function(msg) {
    console.log(msg);
}

var fn2 = new Function("msg", "console.log(msg)");

var reg = /^\d+\.\d+$/;
var reg2 = new RegExp("^\d+\.\d+$");

console.log(typeof obj, typeof obj2, typeof arr, typeof arr2, typeof fn, typeof fn2, typeof reg, typeof reg2);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/cd37d83d9b4d4e48b4ed16de3aa1b28e.png)
#### 补充知识点
```
google浏览器的默认页面设置了安全策略，不能执行new Function来创建新的函数。
需要换一个浏览器或者前面别的网页。比如B站。
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/2659b1ad13414e32926417c18cfa096d.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/883df3e2a89c440da5743221536823de.png)
# 属性
## 属性的定义
```
对象由属性组成，属性包括属性名和属性值。属性名存储在对象身上，是属性值内存空间的引用而属性值记录着引用关系。
```

## 访问属性
### 两种访问属性的方式
```
1、.操作符
	属性名必须满足标识符的命名规范
2、[".."]语法
	可以接受任意UTF-8/Unicode字符串作为属性名
两种方式除了上面不同，其它都是一致的，没有什么不同。
```
[js标识符的命名规则](http://c.biancheng.net/view/8068.html)
```js
var obj = {
    "@a_b": 1,
};

// 1、.操作符不能访问不符合js标识符命名规则的属性
// console.log(obj.@a_b);
// 2、[".."]可以
console.log(obj["@a_b"]);
```
### 属性名永远都是字符串。
```
不管你使用什么类型的值作为属性名，都会被转换为一个字符串。
```
```js
var obj = {
    "@a_b": 1,
};
// 数字字面值
obj[1] = 3;

// 对象
obj[{ a: 1 }] = 3;

// 传入一个不同的对象，obj对象身上的[object Object]属性的值变为4
obj[{ a: 2 }] = 4;

/* 
    因为传入对象，js内部会调用toString方法将对象的值转换为[object Object]，从而拿这个值作为属性名。
    当下次传入不同的对象，依然还是转换为[object Object]，因此会重新赋值。
*/
console.log({ a: 1 }.toString());
console.log(obj);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/1badf3a9efd644c1b44b5b278d8cf0a5.png)
### toString方法从哪来？
```
来自Object原型对象。具体后面在第5章会学习原型链。
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/83b788f2112540bfa7c8113fb1c1909e.png)

### 数组（对象）的下标属性是数字,是冲突了吗?
```js
/* 
    我们一般通过下标访问数组时，下标的值为数字类型，但是实际上我们使用字符串类型也可以访问得到，
    且数组也是一个对象，我们之前说的对象的属性名永远为字符串，因此按照规范我们其实应该通过字符串类型
    数值来访问数组的各项。我们使用数字类型，js帮我们调用了toString()方法转换了数据类型。
*/
var arr = [1, 2, 3];
var num = 1;
var str = "1";
console.log(arr[num], arr[str], arr[num.toString()]);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/d85d3afeed464fdabeac71fa7e9b21fb.png)
## 可计算属性名
```
es6新增了可计算属性名，可以执行一段表达式，用表达式的返回值来作为属性名。
```
```js
var num1 = 1,
    num2 = 2,
    isLock = false;
var obj = {
    // 基本运算表达式
    [num1 + num2]: 1,
    // 三元运算表达式
    [isLock ? "正确" : "错误"]: 2,
    // Symbol
    [Symbol.for('a')]: 3,
    [Symbol.for('b')]: 4
};
console.log(obj);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/33b8b599d1194b78978fca2428033c7e.png)
[Symbol的使用](http://t.csdn.cn/4lgXI)
## 函数类型属性该不该叫方法
```
我们通过前面学习知道，如果对象的一个属性的属性值是函数类型的数据，那么其实属性值只是保存了引用关系（指针），并不是真正的将函数存储在对象内部。因此我们将函数叫做对象身上的方法不妥，这个函数都不属于对象。但是实际上程序员之间交流的时候，会有相当一部分人会叫对象的方法，也包括我，对于这个问题，不需要深究，我认为没有意义，如果非要深究的话，是不应该叫做方法的。
```
## 给数组添加属性对length的影响
```
1、length变化
	给数组添加的属性名为1或者“1”这种数字或者类似于数字的，length会变化。
2、length不变
	相反不变。
```
```js
var arr = [1, 2, 3];
console.log(arr.length); // 3
// 下标不变
arr.a = "a";
console.log(arr.length); // 3
// 下标变化
arr[9] = 4;
console.log(arr.length); // 10
/* 
    为什么为10呢？因为js中的数组与java等一些语言不同，它的下标溢出时，
    会自动扩容，在指定下标的位置赋值。多余的下标在google调试工具中显示一个empty，
    我们去访问的话，返回undefined。
*/
console.log(arr); // [1, 2, 3, empty × 6, 4, a: 'a']
console.log(arr[3]) // undefined
```
## 浅拷贝与深拷贝
[参考资料来源](https://www.zhihu.com/question/453889983/answer/2100978041)
作者：华为云开发者社区
链接：https://www.zhihu.com/question/453889983/answer/2100978041
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
### 为什么需要浅拷贝和深拷贝
```
这还是扯到js中的引用数据类型
```
```js
var zhangsan = {
    life: "Alive",
    Characteristic: {
        height: "180cm",
        wealth: "世界首富",
        Face_value: "高"
    }
};

// 此时我们需要一个和zhangsan一模一样的人
var clone_people = zhangsan;
console.log(clone_people);
// 有一天clone_people出了意外死了
clone_people.life = "Dead";
console.log(clone_people, "克隆人");
console.log(zhangsan, "zhangsan");
// 怎么回事，怎么zhangsan也死啦？这不对吧？
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/8b48d259ed7d46b68dbc504662d4c5a1.png)
```
为什么会这样呢？因为js中复杂引用类型在进行赋值操作时，只是添加了一条引用关系，这条引用关系指向了赋值的值。而不是像我们想象的那样真的在内存地址中开辟了一块空间，里面存的值和被赋值的值一模一样。
```
`我们以为的`
![在这里插入图片描述](https://img-blog.csdnimg.cn/ce338cc33c29460c8819efe0254eedc5.png)
`实际情况`
![在这里插入图片描述](https://img-blog.csdnimg.cn/1a9d1946834942b68fe2c8a007841d25.png)
### 我们需要做到我们想象的那样怎么弄呢？
#### 什么是浅拷贝？
```
浅拷贝只拷贝一层。
```
```js
var zhangsan = {
    life: "Alive",
    Characteristic: {
        height: "180cm",
        wealth: "世界首富",
        Face_value: "高"
    }
};

function cloneObj(obj) {
    let clone = {};
    for (let i in obj) {
        clone[i] = obj[i];
    }
    return clone;
}

// 此时我们需要一个和zhangsan一模一样的人
var clone_people = cloneObj(zhangsan);
console.log(clone_people);
clone_people.life = "Dead";
console.log(clone_people, "克隆人");
console.log(zhangsan, "zhangsan");
// 我们实现了我们想象的那种情况？那么浅拷贝只拷贝一层是什么意思呢？
// 当我们修改Characteristic属性值里面的属性时
clone_people.Characteristic.wealth = "穷光蛋";
console.log(zhangsan);
// 我们发现明明是克隆人变穷了，但是zhangsan也变穷了。也就是浅拷贝只有最外层的不是共享的一块儿内存了，里面的值依然是共享一块儿内存
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/d2bf53dba3be47c3b5ea4447d564f19d.png)
#### 浅拷贝的常用实现方式
1. for in 遍历对象的所有属性
```js
// 封装一个函数，实现传入一个对象返回一个拷贝后的新对象
 function cloneObj(obj) {
    let clone = {};
    // 用 for  in 遍历obj的属性
    for (let i in obj) {
      clone[i] = obj[i];
    }
    return clone;
  }
```
2. Object.keys会将对象的所有属性通过一个数组返回
```js
function cloneObj(obj) {
    let clone = {};
    for (let i of Object.keys(obj)) {
      clone[i] = obj[i];
    }
    return clone;
  }
```
3. Object.entries()方法返回一个给定对象自身可枚举属性的键值对数组
```js
function cloneObj(obj) {
    let clone = {};
    for (let [key, value] of Object.entries(obj)) {
      clone[key] = value;
    }
    return clone;
  }
```
4. Object.getOwnPropertyNames（）返回一个由它的属性构成的数组。
```js
function cloneObj(obj) {
    let clone = {};
    for (const item of Object.getOwnPropertyNames(obj)) {
        clone[item] = obj[item];
    }
    return clone;
}
```
5. Object.getOwnPropertyNames()方法返回一个由指定对象的所有自身属性的属性名（包括不可枚举属性但不包括 Symbol 值作为名称的属性）组成的数组。
```js
function cloneObj(obj) {
    let clone = {};
    for (const item of Object.getOwnPropertyNames(obj)) {
        clone[item] = obj[item];
    }
    return clone;
}
```
### 深拷贝
```
深拷贝可以将对象的所有属性都进行一次拷贝，额外开辟一块空间存储起来，与原有的内存空间不共享。
```
```js
var zhangsan = {
    life: "Alive",
    Characteristic: {
        height: "180cm",
        wealth: "世界首富",
        Face_value: "高"
    }
};

function cloneObj(obj) {
    // 判断 obj 是否为数组
    if (Array.isArray(obj)) {
        var clone = [];
    } else {
        var clone = {};
    }
    for (let i in obj) {
        // 如果为对象则递归更进一层去拷贝
        if (typeof obj[i] == "object" && obj[i] != null) {
            clone[i] = cloneObj(obj[i]);
        } else {
            clone[i] = obj[i];
        }
    }
    return clone;
}

var clone_people = cloneObj(zhangsan);
clone_people.Characteristic.wealth = "穷光蛋";
console.log(zhangsan);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/13584b88f7cc4e839b513daec54bd369.png)

#### 深拷贝的常用实现方式
1. typeof obj[i] == "object"判断是否为对象,obj instanceof Array判断是否为数组
```js
function cloneObj(obj) {
// 先判断 obj 是否为数组
 if (obj instanceof Array) {
   var clone = [];
 } else {
   var clone = {};
 }
 for (let i in obj) {
   // 如果为对象则递归更进一层去拷贝
   if (typeof obj[i] == "object" && obj[i] != null) {
     clone[i] = cloneObj(obj[i]);
   } else {
     clone[i] = obj[i];
   }
 }
 return clone;
}
```
2. typeof obj[i] == "object"判断是否为对象,Array.isArray(obj)判断 obj 是否为数组
```js
function cloneObj(obj) {
	// 判断 obj 是否为数组
	if (Array.isArray(obj)) {
	  var clone = [];
	} else {
	  var clone = {};
	}
	for (let i in obj) {
	  // 如果为对象则递归更进一层去拷贝
	  if (typeof obj[i] == "object" && obj[i] != null) {
	    clone[i] = cloneObj(obj[i]);
	  } else {
	    clone[i] = obj[i];
	  }
	}
	return clone;
}
```
##  属性描述符与访问描述符
[原文地址](http://t.csdn.cn/lsqDK)
## 不变性
### 常量属性
```js
// 属性不可修改，不能重定义，不能删除
var obj = {
    a: 1
};

Object.defineProperty(obj, "a", {
    configurable: false,
    writable: false,
})

console.log(Object.getOwnPropertyDescriptor(obj, "a"));
console.log(obj);

// 不可修改
obj.a = 2;
console.log(obj);

// 不可删除
delete obj.a;
console.log(obj);

// 不可重新配置,报错
Object.defineProperty(obj, "a", {
    enumerable: false,
});
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/dcbbb30a5218499dbdef36ad3c69c627.png)
### 禁止对象拓展新属性
```js
// 保留对象原有的属性并且禁止后续添加新属性
var obj = {
    a: 1,
};
console.log(obj);

Object.preventExtensions(obj);

// 非严格模式下，添加新属性不起效果
obj.b = 2;
console.log(obj);

// 严格模式下，添加新属性报错
(function() {
    "use strict";
    obj.c = 3;
    console.log(obj);
})();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/a7f19d691c46459c8719f7586a6ff1d6.png)
### 密封对象
```js
/* 
不能再添加新属性，且现有的属性也不能重新配置属性描述符，
但是可以通过set修改现有属性的值，不能用Object.defineProperties(obj, "a", { value: xxx });
*/
var obj = {
    a: 1
};

// 相当于调用了Object.preventExtensisons;以及所有现有属性的configurable都设置为false
Object.seal(obj);

// 不能新增属性
obj.b = 2;
console.log(obj);

// 不能删除
delete obj.a;
console.log(obj);

// 可以修改现有属性的属性值
obj.a = 3;
console.log(obj);

// 不能重新配置
Object.defineProperties(obj, "a", { enumerable: true });
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/0893d0aab9134eabbc87e4f8b7dc86a0.png)
### 冰冻对象
#### 浅冰冻对象
```js
/* 
    在密封对象的基础上，将属性设置为writable:false,不能修改属性的值
*/

// 浅冰冻对象，类比浅拷贝，也就是只有第一层被冰冻的意思。

var obj = {
    a: 1,
    children: {
        b: 2
    }
};

Object.freeze(obj);

// 拥有密封的特点之外，还不可修改
obj.a = 2;
// 子对象属性可以修改
obj.children.b = 3;
console.log(obj);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/abde12b737814f0aaaf13e2b071465cf.png)
#### 深冰冻对象
```js
// 深冰冻
var obj = {
    a: 1,
    children: {
        b: 2,
        children: {
            e: 5
        }
    },
    childrenArr: [{ c: 3 }, { d: 4 }]
};

function deepFreeze(obj) {

    function assistFunction(obj) {
        for (let i in obj) {
            // 如果为对象则递归更进一层去拷贝
            Object.freeze(obj[i]);
            if ((typeof obj[i] == "object" || obj instanceof Array) && obj[i] != null) {
                assistFunction(obj[i]);
            }

        }
    }
    Object.freeze(obj);
    assistFunction(obj);
}
// 之前可以修改
obj.children.children.e = 25;
obj.childrenArr[0].c = 15;
console.log(obj);

// 深度冰冻
deepFreeze(obj);

// 深度不可修改
obj.children.children.e = 50;
obj.childrenArr[0].c = 30;
console.log(obj);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/5850bbf32a634a0b97bb0c8857839f8b.png)
##### 深冰冻的危害
```js
// 深冰冻
var objChildrenChildren = {
    e: 5
};

var obj = {
    a: 1,
    children: {
        b: 2,
        children: objChildrenChildren
    },
    childrenArr: [{ c: 3 }, { d: 4 }]
};

var obj2 = {
    children: objChildrenChildren
}

function deepFreeze(obj) {

    function assistFunction(obj) {
        for (let i in obj) {
            // 如果为对象则递归更进一层去拷贝
            Object.freeze(obj[i]);
            if ((typeof obj[i] == "object" || obj instanceof Array) && obj[i] != null) {
                assistFunction(obj[i]);
            }

        }
    }
    Object.freeze(obj);
    assistFunction(obj);
}
// 之前可以修改
obj.children.children.e = 25;
obj.childrenArr[0].c = 15;
console.log(obj);

// 深度冰冻
deepFreeze(obj);

// 深度不可修改
obj.children.children.e = 50;
obj.childrenArr[0].c = 30;
console.log(obj);

// 深度冰冻之后，如果有其它对象与被深度冰冻对象共享属性值，那么其它对象共享的值也会被冰冻。
obj2.children.e = 100;
console.log(obj2);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/d5ceacbcca344483beebeb48849f86a3.png)
## 存在性
### 通过.属性读取属性来判断属性是否存在的不合理
```js
/* 
    当访问对象中不存在的属性时，返回undefined
    但是对象属性的属性值也是可以为undefined的
    因此使用这种方式来判断某个属性是不是对象的属性不合理
*/
var obj = {
    a: 1,
    b: undefined
};

console.log(obj.b); // undefined
console.log(obj.c); // undefined
```
### 不访问属性值来判断属性是不是对象的属性
#### 1、in操作符
```js
/* 
    in操作符会检查属性是否是对象自身的属性，也会判断是否是原型上的属性
*/

Object.prototype.b = 2;

var obj = {
    a: 1,
};

obj.__proto__.c = 3;
console.log("a" in obj); // true
console.log("b" in obj); // true
console.log("c" in obj); // true
```
##### in搭配数组时的注意事项
```js
/* 
    in操作符判断的是对象中是否有这个属性名，而不是属性值
*/
// 目标数组中的属性名有0，1, 2, 3 而没有4。
console.log(4 in [1, 2, 3, 4]); // false
```
#### 2、hasOwnProperty()
```js
/* 
    hasOwnProperty()只会检查属性是否在对象中，不会检查原型链
*/

var obj = {
    a: 1,
}

obj.__proto__.b = 2;

console.log(obj.hasOwnProperty("a")); // true
console.log(obj.hasOwnProperty("b")); // false
```
##### 不是所有的对象都能访问到hasOwnProperty
```js
/* 
    使用Object.create(null)创建的对象原型链不指向Object原型对象
    因此无法通过obj.hasOwnProperty()
*/
var obj2 = Object.create(null);
obj2.a = 1;
console.log(obj2);
console.log(obj2.__proto__);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/4abc0fc9c1b847c3b718c9950db43feb.png)
##### 解决办法
```js
var obj2 = Object.create(null);
obj2.a = 1;
/* 
    此时需要直接通过Object显式绑定this来解决
*/
console.log(Object.prototype.hasOwnProperty.call(obj2, "a")); // true
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/384d3299c64646e9b5074972f11e33b7.png)
#### 3、propertyIsEnumerable()
```js

```
## 查询返回对象中所有的属性。
### 1、keys()
```js
/* 
    Object.keys会返回一个数组，包含所有的可枚举属性，不包含原型链上的属性。
*/

var obj = {
    a: 1,
    c: 3,
    d: 4
};
// 没法拿到原型链上的属性名
obj.__proto__.b = 2;
console.log(Object.keys(obj));

// 没法拿到不可枚举的属性名
Object.defineProperty(obj, "d", {
    enumerable: false
});
console.log(Object.keys(obj));
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/b2cc20a0da6042328b599a864a3c6b4c.png)
### 2、getOwnPropertyNames()
```js
/* 
    拿到对象所有的属性，通过数组的形式返回，
    不管是否可枚举都可以读取到，但是不能读取到原型链上的属性
*/
var obj = {
    a: 1,
    c: 3,
    d: 4
};
// 没法拿到原型链上的属性名
obj.__proto__.b = 2;
console.log(Object.getOwnPropertyNames(obj));

// 可以拿到不可枚举的属性名
Object.defineProperty(obj, "d", {
    enumerable: false
});
console.log(Object.getOwnPropertyNames(obj));
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/f17f9d885f994698aaef681a0d9074da.png)
### 3、自己封装查询对象所有属性（包含原型链的属性）
```js
// 包含所有原型身上的属性和不管是否可以枚举的属性
var getOwnPropertyNamesRecursive = function(obj) {
    if (obj.__proto__) {
        return [...Object.getOwnPropertyNames(obj), ...getOwnPropertyNamesRecursive(obj.__proto__)];
    }
    return Object.getOwnPropertyNames(obj);
};
// 包含所有原型身上的属性和可枚举的属性
var keysRecursive = function(obj) {
    if (obj.__proto__) {
        return [...Object.keys(obj), ...keysRecursive(obj.__proto__)];
    }
    return Object.keys(obj);
};

var obj = {
    a: 1,
    c: 3,
    d: 4
};

obj.__proto__.b = 2;

Object.defineProperty(obj, "d", {
    enumerable: false
});

console.log(getOwnPropertyNamesRecursive(obj));
console.log(keysRecursive(obj));
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/64233797041f451c885a9db71bd41e4c.png)
## 遍历
### 遍历属性名
#### for in 遍历对象所有的可枚举的属性名（包括原型链）
`注意事项：for in遍历对象时，遍历的属性名顺序是不固定的，不同的js引擎可能遍历的顺序不一致`
```js
var obj = {
    a: 1,
};

Object.defineProperty(obj.__proto__, "b", {
    value: 2,
    writable: true,
    enumerable: true,
    configurable: true
});

console.log(Object.getOwnPropertyDescriptor(obj.__proto__, "b"));
for (const key in obj) {
    console.log(key);
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/49c20b463f6e470aa1ff4d037ff72b7b.png)
#### for in 遍历不适合用来遍历数组
```js
/* var obj = {
    a: 1,
};

Object.defineProperty(obj.__proto__, "b", {
    value: 2,
    writable: true,
    enumerable: true,
    configurable: true
});

console.log(Object.getOwnPropertyDescriptor(obj.__proto__, "b"));
for (const key in obj) {
    console.log(key);
} */

var arr = [1, 2, 3];

// 数组原型上有可枚举的属性
arr.__proto__.a = 2;

// 数组身上有可枚举的属性
Object.defineProperty(arr, "b", {
    value: 3,
    writable: true,
    enumerable: true,
    configurable: true
});

for (const key in arr) {
    console.log(key);
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/b0e182cb51c8424598305080607d01fa.png)
#### 使用传统的方式来遍历数组
```js
/*
	为什么传统的方式遍历不到原型链和自己身上其它的可枚举属性呢？
	因为数组有一个length属性，传统的for循环是按照数字0~lenght-1的
	数字顺序作为属性名去读取数组中的属性的。而我们前面说过，只有当我们
	操作的属性名是1或者是“1”这种时，才可能会对length的值产生影响。详细见
	前面“给数组添加属性对length的影响”一节。
	
*/
var arr = [1, 2, 3];

// 数组原型上有可枚举的属性
arr.__proto__.a = 2;

// 数组身上有可枚举的属性
Object.defineProperty(arr, "b", {
    value: 3,
    writable: true,
    enumerable: true,
    configurable: true
});
for (let i = 0; i < arr.length; i++) {
    console.log(i);
}
```
### 遍历属性值
#### for in遍历对象的属性值与传统的for遍历数组的属性值
```
首先，for in肯定是可以的，通过属性名来访问属性值，以及原始方法遍历数组同理
```
```js
var obj = {
    a: 1,
};

Object.defineProperty(obj.__proto__, "b", {
    value: 2,
    writable: true,
    enumerable: true,
    configurable: true
});

console.log(Object.getOwnPropertyDescriptor(obj.__proto__, "b"));
for (const key in obj) {
    console.log(key,obj[key]);
}

var arr = [1, 2, 3];

// 数组原型上有可枚举的属性
arr.__proto__.a = 2;

// 数组身上有可枚举的属性
Object.defineProperty(arr, "b", {
    value: 3,
    writable: true,
    enumerable: true,
    configurable: true
});

for (const key in arr) {
    console.log(key,arr[key]);
}

for (let i = 0; i < arr.length; i++) {
    console.log(i,arr[i]);
}
```
####  forEach、every、some遍历数组的属性值
```js
/* 
    forEach:遍历数组中的所有值并忽略回调函数中的返回值
    every:一直遍历下去，直到return false,返回值(中途停止值为false，遍历完毕值为true)会被接收
    some:一直遍历下去，直到return true,返回值(中途停止值为true，遍历完毕值为false)会被接收
*/
var arr = ["a", "b", "c"];

console.log(arr.forEach(function(item) {
    console.log(item); // a b c
    return "xxx";
})); // undefined return的xxx被忽略

console.log("----------------------");
console.log(arr.every(function(item) {
    // 遍历到b时停止遍历
    console.log(item);
    return item !== "b"
}));
console.log("----------------------");

console.log(arr.every(function(item) {
    // 遍历到e时停止遍历
    console.log(item);
    return item !== "e"
}));
console.log("----------------------");

console.log(arr.some(function(item) {
    // 遍历到b时停止遍历
    console.log(item);
    return item === "b"
}));
console.log("----------------------");

console.log(arr.some(function(item) {
    // 遍历到e时停止遍历
    console.log(item);
    return item === "e"
}));
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/9e3ecba994564820a6cfc6de29a3233d.png)
#### for of 遍历数组和内部有迭代器iterator属性的对象
##### 遍历数组
```js
/* 
    遍历数组的值
*/

var arr = ["a", "b", "c"];

for (const iterator of arr) {
    console.log(iterator); // a b c
}
```
##### 遍历一般对象（没有迭代器）报错
```js
/* 
    遍历一般对象的值（没有迭代器iterator）
*/
var obj = {
    a: 1,
    b: 2,
    c: 3
};

for (const iterator of obj) {
    console.log(iterator);
};
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/ec519e18ad914a72b7c2125d37d6ccfc.png)
##### 遍历有迭代器属性的对象的所有属性值
[symbol参考资料](https://blog.csdn.net/weixin_44242181/article/details/124373034)
[iterator迭代器参考资料](https://blog.csdn.net/weixin_44242181/article/details/124373006)
```js
/* 
    遍历有迭代器属性的对象的所有属性值
*/
var obj = {
    a: 1,
    b: 2,
    c: 3
};

Object.defineProperty(obj, Symbol.iterator, {
    enumerable: false,
    configurable: true,
    writable: false,
    value: function() {
        var _this = this;
        var index = 0;
        // 可枚举但不包括原型链的属性组成的数组
        var attributeArr = Object.keys(_this);
        return {
            next: function() {
                return {
                    // index++ 先运算后+1
                    value: _this[attributeArr[index++]],
                    done: (index > attributeArr.length)
                }
            }
        }
    }
});

for (const iterator of obj) {
    console.log(iterator);
}
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/f99f56158d754eeb82c603697b5161a7.png)
