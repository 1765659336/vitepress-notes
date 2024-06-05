
# this是从哪来的
```
this在函数作用域中被自动创建
```
# 为什么使用this

## 不使用 this

```javascript
const sayName = function(people) {
    console.log(people.name);
}
const zhangsan = {
    name: "zhangsan"
}
const lisi = {
    name: "lisi"
}
sayName(zhangsan); // "zhangsan"
sayName(lisi); // "lisi"
```

```
需要显式的传入一个上下文对象people，当显式的上下文对象多起来之后影响代码的阅读。
```
## 使用this
```javascript
const sayName = function() {
    console.log(this.name);
}
const zhangsan = {
    name: "zhangsan"
}
const lisi = {
    name: "lisi"
}
sayName.call(zhangsan); // "zhangsan"
sayName.call(lisi); // "lisi"
```

```
this 提供了一种更优雅的方式来隐式“传递”一个对象引用，因此可以将 API 设计得更加简洁并且易于复用。随着使用模式越来越复杂，显式传递上下文对象会让代码变得越来越混乱，使用this则不会这样。 
```

# this到底是什么
```
this 是在运行时进行绑定的，并不是在编写时绑定，它的上下文取决于函数调用时的各种条件。this 的绑定和函数声明的位置没有任何关系，只取决于函数的调用方式。
当一个函数被调用时，会创建一个活动记录（有时候也称为执行上下文）。这个记录会包含函数在哪里被调用（调用栈）、函数的调用方法、传入的参数等信息。this 就是记录的其中一个属性，会在函数执行的过程中用到。
```