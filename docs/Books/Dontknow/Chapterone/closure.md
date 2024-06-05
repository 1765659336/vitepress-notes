# 闭包
## 闭包的案例

```javascript
function fn1(){
  var a = 1;
  function fn2(){
    console.log(a);
  }
  return fn2;
}

var fn = fn1();
// 按理来说fn1()执行完之后引擎会垃圾回收掉fn1()函数，但是fn();也就是fn2()执行的时候依然可以访问到a的值，fn2依然有对fn1函数内部作用域的引用，这个引用就是闭包。
fn();//1
```

## 闭包的作用

```
在 foo() 执行后，通常会期待 foo() 的整个内部作用域都被销毁，因为我们知道引擎有垃圾回收器用来释放不再使用的内存空间。由于看上去 foo() 的内容不会再被使用，所以很自然地会考虑对其进行回收。而闭包的“神奇”之处正是可以阻止这件事情的发生。事实上内部作用域依然存在，因此没有被回收（var a = 2还在）。谁在使用这个内部作用域？原来是 bar() 本身在使用。拜 bar() 所声明的位置所赐，它拥有涵盖 foo() 内部作用域的闭包，使得该作用域能够一直存活，以供 bar() 在之后任何时间进行引用。bar() 依然持有对该作用域的引用，而这个引用就叫作闭包。
总结：在其它作用域保留了对函数原有作用域的调用，阻止了垃圾回收机制，这就是闭包的作用 
```

```
无论使用何种方式对函数类型的值进行传递，当函数在别处被调用时都可以观察到闭包。
三种方式：
 1、return fn(); 在外部用变量接受，调用变量调用这个函数所在的作用域（详情见闭包的案例） 
 2、在原有的作用域，将函数作为参数传递给外部的函数并调用（详情见下方代码片段1） 
 3、两种方式的结合体，传递函数当然也可以是间接的。用外部变量接收函数，再将外部变量作为参数传递给函数（详情见下方代码片段2） 
```

```javascript
// 将fn2函数作为参数传递给fn3，fn3调用传递进来的函数，所以就是在fn3作用域中调用了fn1作用域中的函数，在当前作用域中调用了其它作用域中的函数
function fn1(){
  var a = 1;
  function fn2(){
    console.log(a);
  }
  fn3(fn2);
}

function fn3(fn){
  fn();//1
}

fn1();
```

```javascript
var fn;
function fn1(){
  var a = 1;
  function fn2(){
    console.log(a);
  }
  fn = fn2;
}

function fn3(fn){
  fn();//1
}

fn1();

fn3(fn);
```

```
无论通过何种手段将内部函数传递到所在的词法作用域以外，它都会持有对原始定义作用域的引用，无论在何处执行这个函数都会使用闭包。
```
## 闭包的应用场景
### Vue响应式原理Object.defineProprty

### 防抖

### 函数柯里化

# 模块
## 模块与模式
```
jQuery内部模块实现的原理
```
```js
function fn() {
    var arr = [];

    function add(variable) {
        arr.push(variable);
    }

    function string() {
        console.log(arr.toString());
    }
    return {
        add,
        string
    }
}

var obj = fn();
obj.add(1);
obj.add(2);
obj.string(); // 1,2
```
## 现代模块化机制
```
AMD
CMD
es6模块化
```