# 变量提升

```
作用域同其中的变量声明出现的位置有某种微妙的联系，这种联系就是提升，两种常见的特殊情况引出提升
```

```javascript
a = 2;
var a;
console.log(a);//2
```

```
很多人会认为是 undefined，因为 var a 声明在 a = 2 之后。但是却是正常的。
```

```javascript
console.log(a);
var a = 2;//undefined
```

```
因为JavaScript引擎编译的特殊机制，代码执行的过程应该是：
1、包括变量和函数在内的所有声明都会在任何代码被执行前首先被处理                                             
2、当你看到 var a = 2; 时，可能会认为这是一个声明。但 JavaScript 实际上会将其看成两个声明：var a; 和 a = 2;。第一个定义声明是在编译阶段进行的。第二个赋值声明会被留在原地等待执行阶段。因此上方两个代码的执行顺序是
```

```javascript
var a;//提升
a = 2;
console.log(a);//2
```

```javascript
var a;//提升
 console.log(a);//undefined
 a = 2;
```

```
每个作用域都会进行提升操作。尽管前面大部分的代码片段已经简化了（因为它们只包含全局作用域）
```

```javascript
console.log(b);//undefined
var b = 1;

function fn() {
  console.log(a);//undefined
  var a = 1;
}
fn();
```

# 函数提升

```
函数也可以被提升，可以先调用再声明 
```

```javascript
      fn();

      function fn() {
        console.log('函数');//函数
      }
```

```
但是函数里面的代码是另外一个作用域，不能在当前作用域中被提升
```

```
函数可以被提升，但是函数表达式不能被提升
```

```javascript
fn();//浏览器报错TypeError：fn is not a function
var fn = (function() {
  console.log('函数');//函数
})//一般书写的时候我们会省略()
```

即使是具名函数表达式，名称标识符在赋值之前也无法在所在作用域中使用

```javascript
foo();//RHS 右查询，查询到了undefined，但是进行不正确的操作，浏览器报错TypeError: foo is not a function 
bar();//RHS 右查询，没查询到，浏览器报ReferenceError: bar is not defined
// function 不是在第一位，因此是函数表达式，函数表达式的变量名存储在函数表达式中
var foo = function bar() {
  console.log(1);
}
```

实际执行的顺序,把具名函数变量名提升了

```javascript
var foo;
foo();
bar();

foo = function() {
  var bar = ...self...
}
```

# 函数优先

```
函数声明和变量声明都会被提升。但是一个值得注意的细节（这个细节可以出现在有多个“重复”声明的代码中）是“函数会首先被提升，然后才是变量”。
```

```javascript
fn();//1
var fn;//函数声明提升在变量声明提升前面，会被浏览器认为是重复声明，忽略
function fn(){
  console.log(1);
}

fn = function(){
  console.log(2);
}
```
```
浏览器编译后实际代码执行过程
```
```javascript
// 函数声明提升
fn = function(){
	console.log(1);
}
fn();//1

fn = function(){
  console.log(2);
}
```

```
尽管重复的 var 声明会被忽略掉，但出现在后面的函数声明还是可以覆盖前面的。
```

```javascript
fn();//3
 
function fn(){
  console.log(1);
}

fn = function(){
  console.log(2);
}

fn();//2
```

```javascript
fn();//3

function fn(){
  console.log(1);
}

fn = function(){
  console.log(2);
}

function fn(){
  console.log(3);
}
```

```js
fn(); //3

function fn() {
    console.log(1);
}

fn = function() {
    console.log(2);
}

function fn() {
    console.log(3);
}

fn(); //2
```

`面代码实际编译执行的顺序`
```js
// -------------
// 函数声明提升
function fn() {
    console.log(1);
}

function fn() {
    console.log(3);
}

// -------------
fn(); //3


fn = function() {
    console.log(2);
}


fn(); //2
```

# 已过时内容
```
一个普通块内部的函数声明通常会被提升到这个块所在作用域的顶部，这个过程不会像下面的代码暗示的那样可以被条件判断所控制,而是按照声明先后覆盖********（现在的JavaScript版本已经不会这样了，会直接报错，因为不会被提升了，可以放心在普通块内部声明函数了）,了解即可，已过时的知识。
```
`书中的内容`
```js
foo(); // b
if (true) {
    function foo() {
        console.log("a");
    }
} else {
    function foo() {
        console.log("b");
    }
}
```

`现在的情况`
```javascript
fn();//fn is not a function
if(true){
  function fn(){
    console.log(1);
  }
}else {
  function fn(){
    console.log(2);
  }
}
```

# 额外补充
```
为了我们编写的代码的可控性，我们应该尽可能不使用提升
es6新增的let和const都不具备提升
因此我们声明函数时，也尽可能的选择函数表达式的形式(var fn = function(){})
而不是(function fn(){})
```