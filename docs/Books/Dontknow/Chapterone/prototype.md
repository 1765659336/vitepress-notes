# 构造函数
## 什么是构造函数
构造函数是一种特殊的函数，主要用来初始化对象，即为对象成员对象初始化值，它总与new搭配使用。把对象的一些共有的属性和方法放在这个构造函数里面。
## 构造函数的注意事项
构造函数应该：
1. 首字母要大写
2. 和new搭配使用
# 创建对象的三种方式
1. 对象字面量
```js
const obj = {}
```
2. new Object
```js
const obj = new Object();
```
3. 自定义构造函数
```js
const Star = function(uname,age){
	this.uname = uname;
	this.age = age;
	this.sing = function(){
		console.log('唱歌');
	}
}
const ldh = new Star('刘德华',18);
```
# new关键字的作用
在实例化对象的时候，会按顺序执行下面的步骤：
1. 在内存中开辟一个新的空对象
2. 让this指向这个新的对象
3. 执行构造函数里面的代码，将属性和方法添加给新的对象
4. 返回这个对象
# 静态成员和实例成员
静态成员：在构造函数本身上添加的就是静态成员，能够通过构造函数本身才能访问
实例成员：在构造函数中，使用this添加的就是实例成员，能够通过实例对象才能访问
```js
function Star(uname,age){
	//uname,age,sing都是实例成员
	this.uname = uname;
	this.age = age;
	this.sing = function(){
		console.log('唱歌');
	}
}


var ldh = new Star('刘德华',18);
// xb就是静态成员
Star.xb = 'na';
console.log(Star.xb);//na
console.log(ldh.xb);//undefined
console.log(ldh.uname);//刘德华
console.log(Star.uname);//undefined
```
# 为什么使用原型
构造函数存在浪费内存的问题：构造函数中的方法是通过函数来实现的，函数再声明使用的时候会开辟一块内存空间，因此，我们每使用构造函数实例化一个对象，对象都会为方法函数开辟一块内存空间并指向它，但是其实这些内存空间存放的东西是一样的，这就造成了内存空间的浪费。
```js
const Star = function(uname,age){
	this.uname = uname;
	this.age = age;
	this.sing = function(){
		console.log('唱歌');
	}
}
const ldh = new Star('刘德华',18);
const zxy = new Star('张学友',18);
console.log(ldh.sing === zxy.sing);//false
//ldh和zxy两个实例对象的方法是不相等的false
```
# 原型与遍历查找
使用 for..in 遍历对象时原理和查找 [[Prototype]] 链类似，任何可以通过原型链访问到（并且是 enumerable，参见第 3 章）的属性都会被枚举。使用 in 操作符来检查属性在对象中是否存在时，同样会查找对象的整条原型链（无论属性是否可枚举）
```js
var anotherObject = {
a:2
};
// 创建一个关联到 anotherObject 的对象 Object.create(..) 会创建一个新对象（bar）并把它关联到我们指定的对象（foo）
var myObject = Object.create( anotherObject );
for (var k in myObject) {
console.log("found: " + k);
}
// found: a
("a" in myObject); // true
```
# 构造函数的原型对象prototype
JavaScript规定，每一个构造函数中都有一个prototype属性，它的属性值是一个对象，并且这个对象里面的属性和方法都会被构造函数所拥有，这个对象就是原型对象。通常我们把共有的属性直接定义在构造函数上面，把方法定义在构造函数的prototype属性对应的原型对象上面，可以节省内存空间，如果方法放在构造函数中，每次实例化一个对象都要开辟一块空间存储方法，这些方法都是一样的，浪费空间。因此，我们知道构造函数中的原型对象的作用就是共享方法
```js
const Star = function(uname,age){
	this.uname = uname;
	this.age = age;
}
	
Star.prototype.sing = function(){
	console.log('唱歌');
}

const ldh = new Star('刘德华',18);
ldh.sing(); // 唱歌
const zxy = new Star('张学友',19);
zxy.sing(); // 唱歌
console.log(ldh.sing === zxy.sing); // true
```
# 对象身上的原型对象__proto__
每个对象中都会有一个属性__proto__，它的属性值就是构造函数的prototype属性的属性值(也是一个对象 )，之所以实例化的对象可以使用构造函数prototype的属性和方法，就是因为__prpto__的存在，__proto__对象原型和原型对象prototype是等价的。

__proto__的意义在于系统查找对象，它是一个非标准的属性，因此实际开发中我们不可以使用这个属性。
```js
const Star = function(uname,age){
	this.uname = uname;
	this.age = age;
}

Star.prototype.sing = function(){
	console.log('唱歌');
}

const ldh = new Star('刘德华',18);
console.log(ldh.__proto__ === Star.prototype);//true
```
# javascript访问对象的属性和方法的顺序规则
1. 首先查找对象本身上有没有

2. 查找它的原型__proto__上有没有，同理也是构造函数的prototype的原型对象

3. 再查找第2步查找到的原型对象身上有没有，一直找到Object原型对象身上的__proto__

4. 如果前3步都没有找到，那就是null

整个过程靠的是__proto__这个属性，提供了查找的“路线”，我们称为“原型链”。
```js
const Star = function(){};
Object.prototype.sing = function(){
	console.log("Obj唱歌");
};
const ldh = new Star();
ldh.sing(); // Obj唱歌
```
```js
const Star = function(){};
Object.prototype.sing = function(){
	console.log("Obj唱歌");
};
Star.prototype.sing = function(){
	console.log("唱歌");
};
const ldh = new Star();
ldh.sing(); // 唱歌
```
```js
const Star = function(){
	this.sing = function(){
		console.log("ldh唱歌");
	}
};
Object.prototype.sing = function(){
	console.log("Obj唱歌");
};
Star.prototype.sing = function(){
	console.log("唱歌");
};
const ldh = new Star();
ldh.sing(); // ldh唱歌
```
# 原型对象身上的constructor属性
```js
const Star = function(uname,age){
	this.uname = uname;
	this.age = age;
}

Star.prototype.sing = function(){
	console.log('唱歌');
}

//这种形式就是将原型对象重新赋值，Star.prorotype.constructor 就不是Star构造函数了
Star.prototype = {
	constructor: Star,
	eat: function(){
		console.log('吃饭');
	},
	sleep: function(){
		consolo.log('睡觉');
	}
}

//constructor这个属性的值就是用来记录该原型对象引用于哪个构造函数，它可以让原型对象重新指向原来的构造函数
const ldh = new Star('刘德华',18);
ldh.eat();//吃饭
ldh.sing();//Uncaught TypeError: ldh.sing is not a function
//ldh的原型对象被修改了
```
# 构造函数、原型对象、实例对象之间的关系图示
![在这里插入图片描述](https://img-blog.csdnimg.cn/2cceb71068ce4e0f82775d0d0032e1ae.png)
# 原型链图示
![在这里插入图片描述](https://img-blog.csdnimg.cn/28815b264bf4436dbf61631edad6eb15.png)
# 原型this的指向问题
构造函数中this指向的是实例对象
原型对象函数中this指向的也是实例对象
```js
var that1;
var that2;
function Star(uname,age){		
		this.uname = uname;
		this.age = age;
		that1 = this;
}

Star.prototype.sing = function(){
	console.log('唱歌');
	that2 = this;
}
console.log(that1 == that2);//true
```
# 原型链的应用--继承
```js
// 继承属性：
// 就是用call()把父类的this指向改为子类的this指向
// 具体操作示范：
function Father(uname,age){
	this.uname = uname;
	this.age = age;
}
Father.prototype.money = function(){
	console.log('我现在可以挣钱');
}

function Son(uname,age,score){
	//通过调用call这个方法就可以继承父类构造函数中所有的属性，简洁了代码
	Father.call(this,uname,age);
	this.score = score;
}

var son = new Son('刘德华',18,100);
console.log(son); 
// {
//    "uname": "刘德华",
//    "age": 18,
//    "score": 100
// }
```
```js
// 继承方法：
/* 修改子类的原型对象prototype为new Father()这个实例，通过原型链__proto__就继承了父类的原型对象以及其中的方法；但是不要忘记用Son.prototype.constructor = Son;指回原来的构造函数，这是这个实例对象的“身份证”，说明它是哪个构造函数实例化出来的 */
function Father(uname,age){
	this.uname = uname;
	this.age = age;
}
Father.prototype.money = function(){
	console.log('我现在可以挣钱');
}
function Son(uname,age,score){
	//通过调用call这个方法就可以继承父类构造函数中所有的属性，简洁了代码
	Father.call(this,uname,age);
	this.score = score;
}
Son.prototype = new Father();
Son.prototype.constructor = Son;
Son.prototype.kaoshi = function(){
	console.log('考试');
}
var son = new Son('刘德华',18,100);
console.log(son);
// {
//    "uname": "刘德华",
//    "age": 18,
//    "score": 100
// }
son.money(); // 我现在可以挣钱
son.kaoshi(); // 考试
```