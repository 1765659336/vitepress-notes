# 函数中的作用域

```
1、函数作用域的含义是指，属于这个函数的全部变量都可以在整个函数的范围内使用及复用（事实上在嵌套的下一级作用域中也可以使用）
2、不能从上一级（外部）访问内部的变量和函数
```

代码验证第1点：

```js
(function() {
    var a = 1;
    (function() {
        var b = 2;
        console.log(a, b); //1 2
    })();
})();
```

代码验证第2点：

```js
(function() {
    let a = 1;
    (function() {
        let b = 2;
        console.log(a, b); //1 2
    })();
    console.log(b); //ReferenceError：b is not defined
})();
```

# 隐藏内部实现

```
什么是隐藏内部实现：将一段代码中的任何声明（变量或函数）都将绑定在这个新创建的包装函数的作用域中，而不是先前所在的作用域中；换句话说，可以把变量和函数包裹在一个函数的作用域中，然后用这个作用域来“隐藏”它们。
隐藏内部实现的作用（好处）：遵循软件开发的最小暴露（最小授权、最小特权）原则，将一些变量和函数藏起来，成为私有的
具体实现：遵循一个原则在代码编写时，将要隐藏的内容放在需要调用它的最高一级别的块级作用域中。
```

`不恰当示范`

```javascript
function fn1() {
  console.log(fn2(2) + 2);
}

function fn2(a) {
  return a * 2;
}

// 虽然这样运行起来没有错误，但是fn2()函数暴露在全局作用域中，实际上只被fn1()函数调用，不符合最小暴露原则
fn1();//6
```

`隐藏内部实现写法`

```js
function fn1() {
  console.log(fn2(2) + 2);

  function fn2(a) {
    return a * 2;
  }
}
fn1(); //6
```

## 规避冲突

```
“隐藏”作用域中的变量和函数所带来的另一个好处，是可以避免同名标识符之间的冲突，两个标识符可能具有相同的名字但用途却不一样，无意间可能造成命名冲突。冲突会导致变量的值被意外覆盖。
```

`错误示范：`

```js
function foo() {
  function bar(a) {
    i = 3; // 未写var变量提升至全局变量可以被for循环LHS查询到，从而修改for循环中i的值
    console.log(a + i);
  }
  for (var i = 0; i < 10; i++) {
    bar(i * 2); // 糟糕，无限循环了！
  }
}
foo();
```

`解决办法：`

```javascript
function foo() {
    function bar(a) {
        var i = 3;
        console.log(a + i);
    }
    for (var i = 0; i < 10; i++) {
        bar(i * 2);
    }
}
foo();
```

### 方法1全局命名空间(外部js文件避免冲突的办法)

```
变量冲突的一个典型例子存在于全局作用域中。当程序中加载了多个第三方库时，如果它们没有妥善地将内部私有的函数或变量隐藏起来，就会很容易引发冲突。
这些库通常会在全局作用域中声明一个名字足够独特的变量，通常是一个对象。这个对象被用作库的命名空间，所有需要暴露给外界的功能都会成为这个对象（命名空间）的属性，而不是将自己的标识符暴漏在顶级的词法作用域中。
```

`比如：一个MyReallyCoolLibrary第三方库`

```javascript
var MyReallyCoolLibrary = {
      awesome: "stuff",
      doSomething: function() {
        // ...
      },
      doAnotherThing: function() {}
 }       
```

### 方法2模块化
```
AMD,es6模块化,CMD等
```
# 函数作用域

```
在任意代码片段外部添加包装函数，可以将内部的变量和函数定义“隐藏”起来,虽然这种技术可以解决一些问题，但是它并不理想，因为会导致一些额外的问题。首先，必须声明一个具名函数 foo()，意味着 foo 这个名称本身“污染”了所在作用域。其次，必须显式地通过函数名（foo()）调用这个函数才能运行其中的代码。
```

```javascript
function fn() {
   console.log('hahaha');
 }
 console.log(fn); //fn(){}
 fn = 1;
 console.log(fn); //1
```

```
如果函数不需要函数名（或者至少函数名可以不污染所在作用域），并且能够自动运行，这将会更加理想。javascript为我们提供了函数表达式的形式来解决，用一对小括号把函数包裹起来
```

```javascript
(function fn() {console.log('hahaha');});
```

```
(function foo(){ .. }) 作为函数表达式意味着 foo 只能在 .. 所代表的位置中被访问，外部作用域则不行。foo 变量名被隐藏在自身中意味着不会非必要地污染外部作用域。
```

## 匿名和具名函数表达式

```
对于函数表达式你最熟悉的场景可能就是回调参数了,比如定时器中的匿名函数表达式
```

```javascript
      setInterval(function(){
        console.log('1秒过去了');
      },1000)
```

```
匿名函数表达式的缺点：
1、匿名函数在栈追踪中不会显示出有意义的函数名，使得调试很困难。
2、如果没有函数名，当函数需要引用自身时只能使用已经过期的 arguments.callee 引用，比如在递归中。另一个函数需要引用身的例子，是在事件触发后事件监听器需要解绑自身。
3、匿名函数省略了对于代码可读性 / 可理解性很重要的函数名。一个描述性的名称可以让代码不言自明。
```
```
然而具名函数表达式就没有这些烦恼，因此无论何时我们都应该有给匿名函数表达式赋予一个标识符的习惯
```

## 立即执行函数表达式
```
两种方式
(function(){})();
(function(){}())
效果一样全凭个人喜好
```

```
立即执行函数表达式的非常普遍的进阶用法是把它们当作函数调用并传递参数进去。
```
```javascript
var a = 1;
(function fn(object){
  console.log(object.a);//1
})(window)
```
# 块作用域

```
块作用域的作用：我们在 for 循环的头部直接定义了变量 i，通常是因为只想在 for 循环内部的上下文中使用 i，而忽略了 i 会被绑定在外部作用域（函数或全局）中的事实。这就是块作用域的用处。变量的声明应该距离使用的地方越近越好，并最大限度地本地化。
```

## 一个问题
```javascript
//i定义在浏览器主对象window上，也就是定义在全局作用域上
for(var i = 0; i < 2; i++){
  console.log(i);
}
console.log(window.i);//2
```

```
定义块级作用域的方法：
1、with
2、try/catch
3、let
4、const
```

## with

```
用 with 从对象中创建出的作用域仅在 with 声明中而非外
部作用域中有效。
```

```javascript
with(a){
  a = 1
}
console.log(a);//a is not defined
```

## try/catch

```
try/catch 的 catch 分句会创建一个块级作用域，其中声明的变量仅在 catch 内部有效。当同一个作用域中的两个或多个 catch 分句用同样的标识符名称声明错误变量时，很多静态检查工具还是会发出警告。
实际上这并不是重复定义，因为所有变量都被安全地限制在块作用域内部，但是静态检查工具还是会很烦人地发出警告。为了避免这个不必要的警告，很多开发者会将 catch 的参数命名为 err1、err2 等。也有开发者干脆关闭了静态检查工具对重复变量名的检查。
```

```javascript
try {
    throw new Error("err");
} catch (err) {
    console.log(err); // 错误信息
}
console.log(e); // err is not defined
```

## let

```
let关键字可以将变量绑定到所在的任意作用域中（通常是 { .. } 内部）。换句话说，let为其声明的变量隐式地了所在的块作用域。
```

```javascript
{
    let a = 1;
}
console.log(a); //a is not defined
```

```
用 let 将变量附加在一个已经存在的块作用域上的行为是隐式的。在开发和修改代码的过程中，如果没有密切关注哪些块作用域中有绑定的变量，并且习惯性地移动这些块或者将其包含在其他的块中，就会导致代码变得混乱。为块作用域显式地创建块可以部分解决这个问题，使变量的附属关系变得更加清晰。通常来讲，显式的代码优于隐式或一些精巧但不清晰的代码。显式的块作用域风格非常容易书写,推荐使用显示的方式编写代码,只要声明是有效的，在声明中的任意位置都可以使用 { .. } 括号来为 let 创建一个用于绑定的块
```

```javascript
if(true){
  {
    let a = 1;
    console.log(a);//1
  }
} 
```

### let声明不会被提升
```
提升是指声明会被视为存在于其所出现的作用域的整个范围内。
但是使用 let 进行的声明不会在块作用域中进行提升。声明的代码被运行之前，声明并不“存在”。
```

### let的作用，let声明的变量不使用后会被垃圾回收

```javascript
function process(data) {
  // 在这里做点有趣的事情
}
var someReallyBigData = { .. };
process( someReallyBigData );
var btn = document.getElementById( "my_button" );
btn.addEventListener( "click", function click(evt) {
  console.log("button clicked");
}, /*capturingPhase=*/false );
```

```
click 函数的点击回调并不需要 someReallyBigData 变量。理论上这意味着当 process(..) 执行后，在内存中占用大量空间的数据结构就可以被垃圾回收了。但是，由于 click 函数形成了一个覆盖整个作用域的闭包，JavaScript 引擎极有可能依然保存着这个结构（取决于具体
实现）。块作用域可以打消这种顾虑，可以让引擎清楚地知道没有必要继续保存 someReallyBigData了,为变量显式声明块作用域，并对变量进行本地绑定是非常有用的工具
```

```javascript
function process(data) {
  // 在这里做点有趣的事情
}
{
  let someReallyBigData = { .. };
  process( someReallyBigData );
}

var btn = document.getElementById( "my_button" );
btn.addEventListener( "click", function click(evt) {
  console.log("button clicked");
}, /*capturingPhase=*/false );
```



### let的作用，let循环

```
替换之前for循环中的var，避免for循环时i被声明到for循环所在的作用域。
```

```javascript
for(let i = 0; i < 2; i++){
  console.log(i);
}
//进行LHS查询，查询不到浏览器会隐式声明并赋值undefined
console.log(window.i);//undefined
```

## const

```
除了 let 以外，ES6 还引入了 const，同样可以用来创建块作用域变量，但其值是固定的（常量）。之后任何试图修改值的操作都会引起错误。
```

```javascript
function fn() {
  const a = 1;
}
const b = 2;
b = 3;//Assignment to constant variable.
console.log(a); //a is not defined
```