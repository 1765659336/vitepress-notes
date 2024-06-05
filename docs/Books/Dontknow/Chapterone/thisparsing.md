# 调用位置与调用栈
```
调用位置：函数在代码中被调用执行的位置。
调用栈：当前函数被执行时，之前调用的所有函数的调用顺序。
```
```js
const fn1 = function() {
    console.log("fn1");
    // fn2的调用位置在这，它的调用栈是fn1-->fn2
    fn2();
}

const fn2 = function() {
    console.log("fn2");
    // fn3的调用位置在这，它的调用栈是fn1-->fn2-->fn3
    fn3();
}

const fn3 = function() {
    console.log("fn3");
}

// fn1的调用位置在这，它的调用栈是fn1
fn1();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/dbe00aa3424b4274a1964602e48bd4e6.png)
# 如何确定this是什么？
```
先找到调用位置，然后再判断使用下面哪种绑定规则来绑定this。
```
# this绑定规则
## 默认绑定
```
无法应用其它规则时的就使用该绑定方式。没有任何的修饰的函数执行。
```
`比如`
```js
function fn() {
    // 在非严格模式中，this指向全局对象
    console.log(this);
}

fn();

function fn2() {
    "use strict";
    // 在严格模式下，this指向undefined
    console.log(this);
}

fn2();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/43d97cb83d5f47b5bc292ca20ef30817.png)
## 隐式绑定
### 定义与使用
```
主要判断调用位置是否有上下文对象。
```
`比如`
```js
const a = 1;
const fn = function() {
    console.log(this.a); // 2
}

const obj = {
    a: 2,
    fn: fn
}

obj.fn();
```
```
当函数引用处有上下文对象时，隐式绑定规则会把函数调用中的this绑定到这个上下文对象上。
```
### 多级引用上下文
```
当上下文引用关系有多层时，this会隐式绑定到哪个上下文呢？
```
```js
const fn = function() {
    console.log(this.a); // 1
}
const obj = {
    a: 1,
    fn,
}

const obj2 = {
    a: 2,
    fn,
    obj
}

obj2.obj.fn();
```
```
通过输出结果为1发现函数fn中的this绑定了obj上下文对象了，所以也就是说明this会隐式绑定引用关系最后一层或者是函数的上一层。
```
### 隐式绑定丢失this（特别注意）
#### 常见情况1赋值
```
下面的代码控制台输出什么？
```
```js
var a = 1;

function fn() {
    console.log(this.a);
}

var obj = {
    a: 2,
    fn: fn
}

var fnCopy = obj.fn;

fnCopy();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/6695ee5caaba42d1af74ab22d1e8c47f.png)
```
为什么输出1呢？为什么this指向是全局this呢？虽然fnCopy是对obj.fn的一个引用，但是当fnCopy被调用时，并没有上下文修饰，所以使用默认绑定规则，此时在非严格模式下，因此this绑定到全局对象身上。
```
#### 意外明白的一个知识点
```
上述代码我在node环境中运行发现输出的值为undefined，不对啊！按照分析应该是输出1才对。
后续我试着改变代码为这样
```
```js
var a = 1;

console.log(globalThis);

function fn() {
    console.log(this.a);
}

var obj = {
    a: 2,
    fn: fn
}

var fnCopy = obj.fn;

fnCopy();
```
```
我发现global全局对象身上并没有a属性。
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/bccac91d148f4d7ba6c873da0cd08c99.png)
```
然后我再将代码改成这样，结果正确输出为1
```
```js
globalThis.a = 1;

console.log(globalThis);

function fn() {
    console.log(this.a);
}

var obj = {
    a: 2,
    fn: fn
}

var fnCopy = obj.fn;

fnCopy();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/4f2ded44174945338dee6d58fabd3bb7.png)
`好的，后续我在阅读js书籍调试代码时，将不会选择在node环境中运行代码了。`
#### 常见情况2函数参数隐式赋值
```
把函数当成参数传递成为回调函数时，也会导致隐式丢失。函数中的参数传递实际上是js在当前函数作用域中声明一个变量，然后把传入的值赋值给声明的这个变量。
```
```js
var a = 1;


function fn() {
    console.log(this.a);
}

var obj = {
    a: 2,
    fn: fn
}

var main = function(callback) {
    callback();
}

main(obj.fn);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/1b8f83e202454c50b7c66cc55565d17b.png)
```
在定时器与延时器中也是如此
```
```js
var a = 1;


function fn() {
    console.log(this.a);
}

var obj = {
    a: 2,
    fn: fn
}

setTimeout(obj.fn, 1000);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/d409e44e58714d5db389c2d8120d6e59.png)
### 显式绑定
#### 定义与使用
```
使用call,apply,bind来显式的绑定this
```
```js
var a = 1;
var obj = {
    a: 2
};

var fn = function() {
    console.log(this.a);
}

fn.call(obj); // 2
```
#### 装箱
```
给call或者apply方法传入一个原始值(字符串类型，布尔类型或者数字类型)来当做this的上下文对象，这个原始值会被转换成它的对象类型。
```
```js
var str = "str";
console.log(str);
var fn = function() {
    console.log(this);
}

fn.call(str);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/b785dbf2adb242ae959c27a98892bc7b.png)

#### 显式绑定解决隐式绑定丢失this的问题
##### 硬绑定
```js
var a = 1;
var obj = {
    a: 2
};

var fn = function() {
    console.log(this.a);
}

var main = function() {
    fn.call(obj);
}
setTimeout(main, 1000); // 2
```
```
使用硬绑定，将无法再次改变this的指向，因为main函数中的this与fn.call(obj)没有关系，obj被写死了。this永远指向obj。如下图所示，是无法再次修改的。
```
```js
var a = 1;
var obj = {
    a: 2
};

var fn = function() {
    console.log(this.a);
}

var main = function() {
    fn.call(obj);
}
setTimeout(main, 1000); // 2

var obj2 = {
	a:3
}

main = main.bind(obj2);
main();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/f7f2ae7c8c7f4ff5bf9475e5c26e8080.png)

##### 优化硬绑定
```
我们可以实现一个硬绑定函数，实现后续可以更改this的需求
```
```js
var _bind = function(fn, obj) {
    return function() {
        return fn.apply(obj, arguments);
    }
}
var a = 1;
var obj = {
    a: 2
};

var fn = function() {
    console.log(this.a);
}

main = function() {
    fn.call(obj);
}
setTimeout(main, 1000);

var obj2 = {
    a: 3
}

var main = _bind(fn, obj2);
main();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/b8d796d036ea49eaa9e3ea16a977417c.png)
##### 内置bind方法
`使用`
```
es5内置了Function.prototype.bind函数，用来实现硬绑定this。
```
```js
var a = 1;
var obj = {
    a: 2
};

var fn = function() {
    console.log(this.a); // 2
}

var main = fn.bind(obj);
setTimeout(main, 1000);
```
`重新绑定this`
```js
var a = 1;
var obj = {
    a: 2
};

var fn = function() {
    console.log(this.a); // 3
}

var main = fn.bind(obj);

var obj2 = {
    a: 3
}

main = fn.bind(obj2);
setTimeout(main, 1000);
```
##### 原生js中应用bind的一个列子
```
Array.prototype.forEach(callback,context);其中第二个参数context，传入之后，callback中的this指向这个context上下文对象。其实在forEach的内部就是实现了bind的功能，内部调用了call或者apply。
```
```js
var obj = {
    a: 1
};
[1, 2, 3].forEach(function(item) {
    console.log(this.a + item);
}, obj)
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/1f363457cc6347aeb2380e5483b53ca6.png)
### new绑定
#### 定义与使用
```
使用new来调用函数，会将函数的this绑定到new返回的上下文对象身上。（前提是函数没有返回其他对象，否则new调用返回的将会是函数返回的值。）
```
```js
var fn = function(a) {
    this.a = a;
}
var obj = new fn(2);
console.log(obj);
console.log(obj.a);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/19bdcae3ebe94772964f6546c7d98472.png)
#### new为我们做了什么
```
1、创建一个对象
2、将这个函数的prototype赋值给这个对象的__proto__
3、将新对象的this绑定到函数中的this
4、如果函数没有返回值，那么就会将这个对象返回出去。否则返回的就是函数自己return的值。
```
## 优先级
### 显式绑定大于隐式绑定
```js
var fn = function() {
    console.log(this.a);
}
var obj = {
    a: 1,
    fn
}

var obj2 = {
    a: 2
}
obj.fn.call(obj2);
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/68dbae45317546b9ae798b0cba590183.png)```
输出2而不是1，说明显式绑定优先级比隐式绑定优先级高。
```

### new绑定大于隐式绑定
```js
var fn = function() {
    console.log(this.a);
}
var obj = {
    a: 1,
    fn
}

var obj2 = {
    a: 2
}
new obj.fn();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/91854f5ab70a478d95f4d137277146e3.png)
```
输出undefined，而不是输出1，说明隐式绑定没有起效果，优先级没有new绑定高。
```
### new绑定大于显式
```js
var fn = function() {
    console.log(this.a);
}
var obj = {
    a: 1,
    fn
}

var obj2 = {
    a: 2
}

var newObj = obj.fn.bind(obj2);
newObj();
new newObj();
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/db56e6cc0ce54b33bc680030a24858dd.png)
```
显式绑定之后输出2，但是当new绑定之后就输出undefined了。说明new绑定的优先级比显式绑定优先级高。
```
### 总结
```
优先级：new绑定>显式绑定>隐式绑定>默认绑定
```
# 不适用绑定规则的特殊情况
## 忽略的this
```
把null和undefined作为this的绑定对象传入call，apply，bind中时，在调用时会被忽略，实际应用的是默认绑定规则。
```
```js
var a = 1;
var obj = {
    a: 2
};

var fn = function() {
    console.log(this.a);
}

fn.call(undefined); // 1
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/27a9a3a643374930865dbb73de00c7f7.png)
## 间接引用
```
js进行赋值操作时，是会返回被进行赋值的值的。比如
```
```js
var a = 1;
var b;
console.log(b = a); // 1
```
```js
var a = 1;
var fn = function() {
    console.log(this.a);
}
var obj = {
    a: 2,
    fn
};

var obj2 = {
    a: 3
}

console.log(obj2.fn = obj.fn); // ƒ () {console.log(this.a);}
```
```
因此在下面情况进行赋值操作时，会导致this指向出现问题。
```
```js
var a = 1;
var fn = function() {
    console.log(this.a);
}
var obj = {
    a: 2,
    fn: fn
};

var obj2 = {
    a: 3,
};
(obj2.fn = obj.fn)();
```
```
答案既不是输出2也不是输出3，因为这个赋值操作返回值是函数，是引用数据类型，返回的是引用，因此调用的时候，根据引用关系查找最终调用位置还是在fn声明的位置，应用默认绑定。
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/64158d800c124c5eb166cde711c09a11.png)
### 一个沉思点
```
使用立即执行函数时，一定要给前面一段代码添加;分号结尾，不然代码会报错。编辑器是通过;来识别一段代码，编译执行的，不使用;又使用立即执行函数，会将()()前面的代码判断成一个函数来编译。
```
![在这里插入图片描述](https://img-blog.csdnimg.cn/a6b2fc565c834781bf8c2acdfded280b.png)
## 箭头函数
```
箭头函数的this继承它的父作用域this，且不能修改
```
```js
var fn = function() {
    (() => {
    	// 继承fn的this
        console.log(this.a);
    })();
}

var obj = {
    a: 1
}

var obj2 = {
    a: 2
}

fn.call(obj); // 1
fn.call(obj2); // 2
```
# 判断this上下文对象圣经
```
1、判断是否有特殊情况，否进入下一步
2、确认是否是new调用，否进入下一步
3、是否通过call,apply,bind调用，否进入下一步
4、是否有链式上下文。是，判断是否有进行赋值操作，否进入下一步
5、使用默认绑定
```