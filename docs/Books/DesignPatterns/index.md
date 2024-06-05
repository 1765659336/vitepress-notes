
## 参考资料
 [JavaScript设计模式es6（23种)](https://juejin.cn/post/6844904032826294286#heading-0)
 [JavaScript的23种设计模式](https://juejin.cn/post/7072175210874535967#comment)
 [百度百科-设计模式](https://baike.baidu.com/item/%E8%BD%AF%E4%BB%B6%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F/2117635?fromtitle=%E8%AE%BE%E8%AE%A1%E6%A8%A1%E5%BC%8F&fromid=1212549)
## 设计模式简介
设计模式代表了最佳的实践，通常被有经验的面向对象的软件开发人员所采用。设计模式是软件开发人员在软件开发过程中面临的一般问题的解决方案。这些解决方案是众多软件开发人员经过相当长的一段时间的试验和错误总结出来的。
设计模式是一套被反复使用的、多数人知晓的、经过分类编目的、代码设计经验的总结。使用设计模式是为了重用代码、让代码更容易被他人理解、保证代码可靠性。 毫无疑问，设计模式于己于他人于系统都是多赢的，设计模式使代码编制真正工程化，设计模式是软件工程的基石，如同大厦的一块块砖石一样。
## 模式原则
## 开闭原则
模块应对扩展开放，而对修改关闭。模块应尽量在不修改原(是"原"，指原来的代码)代码的情况下进行扩展
`举例`
一群人需要出行，现在摆在他们面前有两种方式选择，如果我们将代码写成下面这样，当多了一种出行的方式如"plane"，那么我们就需要修改下面的代码。
```js
const travel = function(type, peoples) {
    switch (type) {
        case "bus":
            console.log("花费", peoples.length * 80);
            break;
        case "train":
            console.log("花费", peoples.length * 120);
    }
};

travel("bus", [{ name: "zhangsan" }, { name: "lisi" }]); // 花费160
```
```js
const travel = function(type, peoples) {
    switch (type) {
        case "bus":
            console.log("花费", peoples.length * 80);
            break;
        case "train":
            console.log("花费", peoples.length * 120);
            break;
        case "plane":
            console.log("花费", peoples.length * 240);
            break;
    }
};

travel("bus", [{ name: "zhangsan" }, { name: "lisi" }]); // 花费160
travel("plane", [{ name: "zhangsan" }, { name: "lisi" }]); // 花费 480
```
显然，当有新的需求添加时，我们修改了原有的代码，不符合开闭原则。那么应该怎么编写符合开闭原则的代码呢？
```js
const travel = function() {
    const typeObject = {
        ["bus"]: function(peoples) {
            console.log("花费", peoples.length * 80);
        },
        ["train"]: function(peoples) {
            console.log("花费", peoples.length * 120);
        },
    };

    return {
        addType: (type, callback) => {
            typeObject[type] = callback;
        },
        run: (type, peoples) => {
            typeObject[type](peoples);
        },
    };
};

const Trevel = travel();
Trevel.run("bus", [{ name: "zhangsan" }, { name: "lisi" }]); // 花费160
Trevel.addType("plane", function plane(peoples) { console.log("花费", peoples.length * 240); })
Trevel.run("plane", [{ name: "zhangsan" }, { name: "lisi" }]); // 花费 480
```
```js
const travel = function() {
    const typeObject = {
        ["bus"]: function(peoples) {
            console.log("花费", peoples.length * 80);
        },
        ["train"]: function(peoples) {
            console.log("花费", peoples.length * 120);
        },
    };

    return {
        addType: (type, callback) => {
            typeObject[type] = callback;
        },
        run: (type, peoples) => {
            typeObject[type](peoples);
        },
    };
};

const Trevel = travel();
Trevel.run("bus", [{ name: "zhangsan" }, { name: "lisi" }]); // 花费160
```
## 里氏代换原则
如果调用的是父类的话，那么换成子类也完全可以运行
```js
class Father {
    say() {
        console.log("hi")
    }
}

class Son extends Father {

}

const father = new Father();
father.say();
// 里氏代换原则
// const father = new Son();
// father.say();
```
## 单一职责原则
一个程序只做好一件事，如果功能过于复杂就拆分开，每个部分保持独立
```js
// 只用来创建学生
class Student {
    constructor(name) {
        this.name = name;
    }
}

// 只用来创建一个班级并实现班级具有的功能
class Classroom {
    constructor(name) {
        this.name = name;
        this.studentArr = [];
    }

    addStudent(student) {
        this.studentArr.push(student);
    }

    getStudent() {
        return this.studentArr;
    }
}

const zhangsan = new Student("zhangsan");
const lisi = new Student("lisi");
const classroom = new Classroom("六年一班");
classroom.addStudent(zhangsan);
classroom.addStudent(lisi);
console.log(classroom.getStudent());
```
## 接口隔离原则
保持接口的单一独立,一种角色，不多不少，不干不该干的事，该干的事都要干 抽象类抽象类不会有实例
## 依赖倒转原则
要针对接口编程，而不是针对实现编程。使用方只关注接口而不关注具体类的实现
## 设计模式分类（23种设计模式）
## 创建型
## 单例模式
## 优点
划分命名空间，减少全局变量。增强模块性，把自己的代码组织在一个全局变量名下，放在单一位置，便于维护。且只会实例化一次，简化了代码的调试和维护。
## 缺点
由于单例模式提供的是一种单点访问，所以它有可能导致模块间的强耦合 从而不利于单元测试。无法单独测试一个调用了来自单例的方法的类，而只能把它与那个单例作为一个单元一起测试。
## 使用场景
一般系统只会有一个登录框实例。
```js
class LoginForm {
    constructor() {
        this.state = "hide";
    }
    show() {
        if (this.state === "show") {
            console.log("已经显示");
            return;
        }
        this.state = "show";
        console.log("登录框显示成功");
    }
    hide() {
        if (this.state === "hide") {
            console.log("已经隐藏");
            return;
        }
        this.state = "hide";
        console.log("登录框隐藏成功");
    }
}
LoginForm.getInstance = (function() {
    let instance;
    return function() {
        if (!instance) {
            instance = new LoginForm();
        }
        return instance;
    };
})();

let obj1 = LoginForm.getInstance();
let obj2 = LoginForm.getInstance();
console.log(obj1 === obj2); // true
obj1.show(); // 登录框显示成功
obj2.show(); // 已经显示
obj1.hide(); // 登录框隐藏成功
obj2.hide(); // 已经隐藏
```
## 原型模式
## 优点
不再依赖构造函数或者类创建对象，可以将这个对象作为一个模板生成更多的新对象
## 缺点
对于包含复杂引用类型值的属性来说，所有实例在默认的情况下都会取得相同的属性值，操作同一块内存空间
## 使用场景
需要一份和之前被实例化出来的对象一模一样的新对象，这个新对象不是通过类的形式创建出来的，如果需要解决复杂数据类型共用内存地址的问题，可以使用浅拷贝/深拷贝
```js
class Student {
    constructor(name, age, hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    say() {
        console.log("my name is", this.name);
        console.log("I'm", this.age);
        console.log('my hobby is', this.hobby);
    }
}

const zhangsan = new Student("zhangsan", 18, ["吃饭", "睡觉", "打豆豆"]);
zhangsan.say();
/* 
my name is zhangsan
I'm 18
my hobby is [ '吃饭', '睡觉', '打豆豆' ]
*/
// 原型模式克隆产生新的对象
const lisi = Object.create(zhangsan);
lisi.say();
/* 
my name is zhangsan
I'm 18
my hobby is [ '吃饭', '睡觉', '打豆豆' ]
*/
lisi.name = 'lisi';
lisi.age = 20;
// 对于复杂引用类型，我修改的是lisi，但是zhangsan也会被修改，因为它们共用一块内存地址
lisi.hobby.push("看妞");
lisi.say();
/* 
my name is lisi
I'm 20
my hobby is [ '吃饭', '睡觉', '打豆豆', '看妞' ]
*/
zhangsan.say();
/* 
my name is zhangsan
I'm 18
my hobby is [ '吃饭', '睡觉', '打豆豆', '看妞' ]
*/
```
## 工厂模式/静态工厂模式
## 优点
调用者创建对象时只要知道其名称即可。
扩展性高，如果要新增一个产品，直接扩展一个工厂类即可。
隐藏产品的具体实现，只关心产品的接口。
## 缺点
每次增加一个产品时，都需要增加一个具体类，这无形增加了系统内存的压力和系统的复杂度，也增加了具体类的依赖。
## 使用场景
将同类型的一些类，归类为一个工厂类，将它们的创建交给这个工厂来统一路径创建。
```js
class Shirt {
    constructor(size, color, style) {
        this.name = "衬衫";
        this.size = size;
        this.color = color;
        this.style = style;
    }
}

class Skirt {
    constructor(size, color, style) {
        this.name = "裙子";
        this.size = size;
        this.color = color;
        this.style = style;
    }
}

class Trousers {
    constructor(size, color, style) {
        this.name = "裤子";
        this.size = size;
        this.color = color;
        this.style = style;
    }
}

class ClothingFactory {
    constructor(name) {
        this.name = name;
        this.productArr = ["Shirt", "Skirt", "Trousers"];
        this.Shirt = Shirt;
        this.Skirt = Skirt;
        this.Trousers = Trousers;
    }

    produce(name, size, color, style) {
        if (this.productArr.indexOf(name) !== -1) {
            return new this[name](size, color, style);
        }
        return false;
    }
}

const clothingFactory = new ClothingFactory("优衣库");
console.log(clothingFactory.produce("Skirt", "XXL", "blue", "male"));

class Leather {
    constructor(size, color, style) {
        this.name = "皮衣";
        this.size = size;
        this.color = color;
        this.style = style;
    }
}

// 拓展方式1 继承
class NewFactory extends ClothingFactory {
    constructor(name) {
        super(name);
        this.name = name;
        this.Leather = Leather;
        this.productArr = ["Leather"];
    }

    produce(name, size, color, style) {
        if (this.productArr.indexOf(name) !== -1) {
            return new this[name](size, color, style);
        } else if (new ClothingFactory().produce(name, size, color, style)) {
            return new ClothingFactory().produce(name, size, color, style)
        }
        return false;
    }
}

const newFactory = new NewFactory("新工厂");
console.log(newFactory.produce("Leather", "XXL", "blue", "male"));
console.log(newFactory.produce("Skirt", "XXL", "blue", "male"));

// 拓展方式2
class NewFactory2 {
    constructor(name) {
        this.name = name;
        this.Leather = Leather;
        this.productArr = ["Leather"];
    }
    produce(name, size, color, style) {
        if (this.productArr.indexOf(name) !== -1) {
            return new this[name](size, color, style);
        }
        return false;
    }
}

const newFactory2 = new NewFactory2("新工厂");
console.log(newFactory2.produce("Leather", "XS", "red", "famale"));
```
## 抽象工厂模式
## 优点
生成产品族，可以创建多个对象
## 缺点
产品族扩展非常困难，要增加一个系列的某一产品，需要修改抽象工厂类，又需要修改具体实现
## 使用场景
```js
/* 抽象类
js中abstract是个保留字，实现抽象类只能通过new.target进行验证，
防止抽象类被直接实例，另外如果子类没有覆盖指定方法，则抛出错误
*/
class ProductionFlow {
    constructor() {
        if (new.target === ProductionFlow) {
            throw new Error('抽象类不能被实例')
        }
    }
    production() {
        throw new Error('production要被重写')
    }
    materials() {
        throw new Error('materials要被重写')
    }
}

class DownJacket extends ProductionFlow {
    production() {
        console.log(`材料:${this.materials()},生产羽绒服`)
    }
    materials() {
        return '鸭毛'
    }
}
class Underwear extends ProductionFlow {
    production() {
        console.log(`材料:${this.materials()},生产内衣`)
    }
    materials() {
        return '丝光棉'
    }
}
class TShirt extends ProductionFlow {
    production() {
        console.log(`材料:${this.materials()},生产t恤`)
    }
    materials() {
        return '纯棉'
    }
}

class AbstractProductionFactory {
    constructor() {
        this.clothingObj = {
            downJacket: DownJacket,
            underwear: Underwear,
            t_shirt: TShirt,
        }
    }

    product(clothingType) {
        if (this.clothingObj[clothingType]) {
            return this.clothingObj[clothingType]
        }
        throw new Error(`工厂暂时不支持生产这个${clothingType}类型的服装`)
    }
}

const abstractProductionFactory = new AbstractProductionFactory();
const downJacketClass = abstractProductionFactory.product('downJacket');
const underwearClass = abstractProductionFactory.product('underwear');
const downJacket = new downJacketClass();
const underwear = new underwearClass();
downJacket.production() // 材料:鸭毛,生产羽绒服
underwear.production() // 材料:丝光棉,生产内衣
```
## 建造者模式
## 优点
建造者模式的封装性很好，对象本身与构建过程解耦。建造者模式很容易进行扩展。如果有新的需求，通过实现一个新的建造者类就可以完成。
## 缺点
产品必须有共同点，范围有限制，当内部有变化复杂时，会有很多建造类。
## 使用场景
建造者模式（builder pattern）比较简单，它属于创建型模式的一种，将一个复杂的对象分解成多个简单的对象来进行构建，将复杂的构建层与表示层分离，使得相同的构建过程可以创建不同的表示的模式便是建造者模式。需要生成的对象具有复杂得内部结构；且内部属性本身相互依赖
```js
/**
 * 产品类：car 目前需要构建一辆车。
 */

class Car {
    constructor() {
        this.name = '',
            this.number = '',
            this.wheel = '',
            this.engine = ''
    }
}


/* 
 *    建造者类，里面有专门负责各个部分的工人
 */
class CarBuilder {
    nameBuilder() {
        this.name = '很厉害的车'
    }
    numberBuilder() {
        this.number = '88888888'
    }
    wheelBuilder() {
        this.wheel = '高级橡胶做的轮子'
    }
    engineBuilder() {
        this.engine = '很厉害的引擎'
    }
    getCar() {
        const car = new Car()
        car.name = this.name;
        car.number = this.number;
        car.wheel = this.wheel;
        car.engine = this.engine;
        return car;
    }
}


/**
 *   指挥者类，指挥各个部分的工人工作
 */
class Director {
    action(builder) {
        builder.nameBuilder();
        builder.numberBuilder();
        builder.wheelBuilder();
        builder.engineBuilder();
    }
}

/**
 *    使用方法
 */

const builder = new CarBuilder();
const director = new Director();
director.action(builder);
const car = builder.getCar();
console.log(car);
/* 
Car {
  name: '很厉害的车',
  number: '88888888',
  wheel: '高级橡胶做的轮子',
  engine: '很厉害的引擎'
}
*/
```
## 结构型
## 适配器模式
适配器模式的目的是为了解决对象之间的接口不兼容的问题，通过适配器模式可以不更改源代码的情况下，让两个原本不兼容的对象在调用时正常工作。
## 优点
让任何两个没有关联的类可以同时有效运行，并且提高了复用性、透明度、以及灵活性。
## 缺点
过多的使用适配器模式，会让系统变得零乱，不易整体把控。建议在无法重构的情况下使用适配器。
## 使用场景
```js
class ChargingTreasure {
    constructor(electricity) {
        this.electricity = electricity;
    }
    discharge() {
        this.electricity--;
        return 1
    }
}

class Phone {
    constructor(electricity) {
        this.electricity = electricity;
    }

    charging(electricity) {
        this.electricity = this.electricity + electricity;
    }
}

class PAD {
    constructor(electricity) {
        this.electricity = electricity;
    }

    fillUp(electricity) {
        this.electricity = this.electricity + electricity;
    }
}

// 适配器
class Tieline {
    connectionPhone(phone, chargingTreasure) {
        phone.charging(chargingTreasure.discharge());
    }

    connectionPAD(pad, chargingTreasure) {
        pad.fillUp(chargingTreasure.discharge());
    }
}

const chargingTreasure = new ChargingTreasure(100);
const phone = new Phone(50);
const pad = new PAD(50);
const tieline = new Tieline();
tieline.connectionPhone(phone, chargingTreasure);
tieline.connectionPAD(pad, chargingTreasure);
console.log(chargingTreasure.electricity);
console.log(phone.electricity);
console.log(pad.electricity);
```
## 装饰器模式
装饰者模式能够在不更改源代码自身的情况下，对其进行职责添加。相比于继承装饰器的做法更轻巧。通俗的讲我们给心爱的手机上贴膜，带手机壳，贴纸，这些就是对手机的装饰。
## 优点
装饰类和被装饰类它们之间可以相互独立发展，不会相互耦合，装饰器模式是继承的一个替代模式，它可以动态的扩展一个实现类的功能。
缺点
## 缺点
多层的装饰会增加复杂度
## 使用场景
```js
class Aircraft {
    ordinary(){
        console.log('发射普通子弹')
    }
}
class AircraftDecorator {
    constructor(aircraft){
        this.aircraft = aircraft
    }
    laser(){
        console.log('发射激光')
    }
    guidedMissile(){
        console.log('发射导弹')
    }
    ordinary(){
        this.aircraft.ordinary()
    }
}
const aircraft = new Aircraft()
const aircraftDecorator = new AircraftDecorator(aircraft)
aircraftDecorator.ordinary() // 发射普通子弹
aircraftDecorator.laser() // 发射激光
aircraftDecorator.guidedMissile() // 发射导弹
// 可以看到在不更改源代码的情况下对它进行了装饰扩展
```
## 代理模式
代理模式的关键是，当客户不方便直接访问一个对象或者不满足需要的时候，提供一个替身对象来控制对这个对象的访问，客户实际上访问的是替身对象。替身对象对请求做出一些处理之后，再把请求转交给本体对象。
代理和本体接口需要一致性，代理和本体之间可以说是鸭子类型的关系，不在乎他怎么实现的，只要它们之间暴露的方法一致既可。
## 优点
职责清晰，高扩展性，智能化
缺点
## 缺点
当对象和对象之间增加了代理可能会影响到处理的速度。
实现代理需要额外的工作，有些代理会非常的复杂。
## 使用场景
我们都知道，领导拥有公司的最高权限，假设公司有员工100个，如果每个人都去找领导去处理事务，那领导肯定会崩溃，因此领导招聘了一个秘书帮他收集整理事务，秘书会在合适时间一次性将需要处理的业务交给老板处理，在这里秘书就是领导的一个代理角色。
```js
// 员工
class Staff {
  constructor(affairType){
    this.affairType = affairType
  }
  applyFor(target){
    target.receiveApplyFor(this.affairType)
  }
}
// 秘书
class Secretary {
  constructor(){
    this.leader = new Leader()
  }
  receiveApplyFor(affair){
    this.leader.receiveApplyFor(affair)
  }
}
//领导
class Leader {
  receiveApplyFor(affair){
    console.log(`批准:${affair}`)
  }
}

const staff = new Staff('升职加薪')
staff.applyFor(new Secretary()) // 批准:升职加薪

```
## 外观模式
外观模式本质就是封装交互，隐藏系统的复杂性，提供一个可以访问的接口。由一个将子系统一组的接口集成在一起的高层接口，以提供一个一致的外观，减少外界与多个子系统之间的直接交互，从而更方便的使用子系统。
## 优点
减少系统的相互依赖，以及安全性和灵活性
## 缺点
违反开放封闭原则，有变动的时候更改会非常麻烦，即使继承重构都不可行。
## 使用场景
```js
// 外观模式经常被用于处理高级游览器的和低版本游览器的一些接口的兼容处理
function addEvent(el,type,fn){
    if(el.addEventlistener){// 高级游览器添加事件DOM API
        el.addEventlistener(type,fn,false)
    }else if(el.attachEvent){// 低版本游览器的添加事件API
        el.attachEvent(`on${type}`,fn)
    }else {//其他
        el[type] = fn
    }
}
```
## 桥接模式
桥接模式（Bridge）将抽象部分与它的实现部分分离，使它们都可以独立地变化。
## 优点
有助于独立地管理各组成部分， 把抽象化与实现化解耦
提高可扩充性
## 缺点
大量的类将导致开发成本的增加，同时在性能方面可能也会有所减少。
## 使用场景
```js
class Color {
    constructor(name){
        this.name = name
    }
}
class Shape {
    constructor(name,color){
        this.name = name
        this.color = color 
    }
    draw(){
        console.log(`${this.color.name} ${this.name}`)
    }
}

//测试
let red = new Color('red')
let yellow = new Color('yellow')
let circle = new Shape('circle', red)
circle.draw()
let triangle = new Shape('triangle', yellow)
triangle.draw()

```
## 组合模式
组合模式就是由一些小的子对象构建出的更大的对象，而这些小的子对象本身可能也是由多个孙对象组合而成的。
组合模式将对象组合成树状结构，以表示“部分-整体”的层次结构。除了用来表示树状结构之外，组合模式的另一个好处就是通过对象的多态性表现，使得用户对单个对象和组合对象的使用具有一致性。
## 优点
高层模块调用简单，节点可以自由添加
## 缺点
其叶对象和子对象声明都是实现类，而不是接口，这违反了依赖倒置原则
## 使用场景
以我们最常见的文件夹和文件的关系，非常适合用组合模式来描述，文件夹可以包括子文件夹和文件，文件不能包括任何文件，这种关系让最终会形成一棵树。下面来实现文件的添加，扫描该文件里的文件，并且可以删除文件。
```js
// 文件夹类
class Folder {
  constructor(name) {
    this.name = name
    this.parent = null;
    this.files = []
  }
  // 添加文件
  add(file) {
    file.parent = this
    this.files.push(file)
    return this
  }
  // 扫描文件
  scan() {
    console.log(`开始扫描文件夹：${this.name}`)
    this.files.forEach(file => {
      file.scan()
    });
  }
  // 删除指定文件
  remove() {
    if (!this.parent) {
      return
    }
    for (let files = this.parent.files, i = files.length - 1; i >= 0; i--) {
      const file = files[i]
      if (file === this) {
        files.splice(i, 1)
        break
      }
    }
  }
}
// 文件类
class File {
  constructor(name) {
    this.name = name
    this.parent = null
  }
  add() {
    throw new Error('文件下面不能添加任何文件')
  }
  scan() {
    console.log(`开始扫描文件：${this.name}`)
  }
  remove() {
    if (!this.parent) {
      return
    }
    for (let files = this.parent.files, i = files.length - 1; i >= 0; i++) {
      const file = files[i]
      if (file === this) {
        files.splice(i, 1)
      }
    }
  }
}

const book = new Folder('电子书')
const js = new Folder('js')
const node = new Folder('node')
const vue = new Folder('vue')
const js_file1 = new File('javascript高级程序设计')
const js_file2 = new File('javascript忍者秘籍')
const node_file1 = new File('nodejs深入浅出')
const vue_file1 = new File('vue深入浅出')

const designMode = new File('javascript设计模式实战')

js.add(js_file1).add(js_file2)
node.add(node_file1)
vue.add(vue_file1)

book.add(js).add(node).add(vue).add(designMode)
book.remove()
book.scan()
```
## 享元模式
享元模式是一种用于性能优化的模式，核心是运用共享技术来有效支持大量的细粒度对象。如果系统中创建了大量的类似对象，会导致内存消耗过高，通过享用模式处理重用类似对象，减少内存消耗的问题，达到性能优化方案。
享元模式的关键是如何区分内部状态和外部状态

内部状态：可以被对象共享，通常不会改变的称为内部状态
外部状态：取决于具体的场景，根据具体的场景变化，并且不能被共享的称为外部状态
## 优点
减少了大批量对象的创建，降低了系统了内存。
## 缺点
提高了系统的复杂度，需要分离出外部状态和内部状态，而且外部状态具有固有化的性质，不应该随着内部状态的变化而变化，否则会造成系统的混乱。
## 使用场景
```js
let id = 0
// 定义内部状态
class Upload {
  constructor(uploadType) {
    this.uploadType = uploadType
  }
  // 点击删除时 小于3000直接删除，大于3000通过confirm提示弹窗删除。
  delFile(id) {
    uploadManager.setExternalState(id,this)
    if(this.fileSize < 3000){
      return this.dom.parentNode.removeChild(this.dom)
    }
    if(window.confirm(`确定要删除该文件吗？${this.fileName}`)){
      return this.dom.parentNode.removeChild(this.dom)
    }
  }
}
// 外部状态
class uploadManager {
  static uploadDatabase = {}
  static add(id, uploadType, fileName, fileSize) {
    const filWeightObj = UploadFactory.create(uploadType)
    const dom = this.createDom(fileName, fileSize, () => {
      filWeightObj.delFile(id)
    })
    this.uploadDatabase[id] = {
      fileName,
      fileSize,
      dom
    }
  }
  // 创建DOM 并且为button绑定删除事件。
  static createDom(fileName, fileSize, fn) {
    const dom = document.createElement('div')
    dom.innerHTML = `
      <span>文件名称：${fileName}，文件大小：${fileSize}</span>
      <button class="delFile">删除</button>
    `
    dom.querySelector('.delFile').onclick = fn
    document.body.append(dom)
    return dom
  }
  static setExternalState(id, flyWeightObj) {
    const uploadData = this.uploadDatabase[id]
    for (const key in uploadData) {
      if (Object.hasOwnProperty.call(uploadData, key)) {
        flyWeightObj[key] = uploadData[key]
      }
    }
  }

}
// 定义一个工厂创建upload对象，如果其内部状态实例对象存在直接返回，反之创建保存并返回。
class UploadFactory {
  static createFlyWeightObjs = {}
  static create(uploadType) {
    if (this.createFlyWeightObjs[uploadType]) {
      return this.createFlyWeightObjs[uploadType]
    }
    return this.createFlyWeightObjs[uploadType] = new Upload(uploadType)
  }
}
// 开始加载
const startUpload = (uploadType, files)=>{
    for (let i = 0, file; file = files[i++];) {
      uploadManager.add(++id, uploadType, file.fileName, file.fileSize)
    }
}

startUpload('plugin', [
  {fileName: '1.txt',fileSize: 1000},
  {fileName: '2.html',fileSize: 3000},
  {fileName: '3.txt',fileSize: 5000}
]);
startUpload('flash', [
  {fileName: '4.txt',fileSize: 1000},
  {fileName: '5.html',fileSize: 3000},
  {fileName: '6.txt',fileSize: 5000}
]);
```
## 行为型
## 观察者模式/发布订阅模式
## 优点
支持简单的广播通信，自动通知所有已经订阅过的对象
目标对象与观察者之间的抽象耦合关系能单独扩展以及重用
增加了灵活性
观察者模式所做的工作就是在解耦，让耦合的双方都依赖于抽象，而不是依赖于具体。从而使得各自的变化都不会影响到另一边的变化
## 缺点
过度使用会导致对象与对象之间的联系弱化，会导致程序难以跟踪维护和理解
在订阅者和订阅目标之间如果循环引用执行，会导致崩溃
发布订阅模式没有办法提供给订阅者所订阅的目标它是怎么变化的，仅仅只知道它变化了
发布订阅模式没有办法提供给订阅者所订阅的目标它是怎么变化的，仅仅只知道它变化了
## 使用场景
定义了一种一对多的关系，让多个观察者对象同时监听某一个主题对象，这个主题对象的状态发生变化时就会通知所有的观察者对象，使它们能够自动更新自己，当一个对象的改变需要同时改变其它对象，并且它不知道具体有多少对象需要改变的时候，就应该考虑使用观察者模式。
```js
class Bus {
    constructor() {
        // 消息队列
        this.messageQueue = {};
    }
    $on(name, fn) {
        /* 判断标识是否存在，存在就操作对应标识已经存在的函数数组，否则就新建一个空数组 */
        this.messageQueue[name] = this.messageQueue[name] || [];
        this.messageQueue[name].push(fn);
    }
    $emit(name, args) {
        if (this.messageQueue[name]) {
            /* 循环对应标识的函数数组，并将所有的参数传递给数组中每一项函数执行 */
            this.messageQueue[name].forEach((cb) => cb(args));
        }
    }
    $off(name) {
        if (name) {
            // 删除消息队列中对应的标识属性
            delete this.messageQueue[name];
        } else {
            /* 如果直接调用$bus.$off()不传入name，此时name为undefined，消息队列清空 */
            this.messageQueue = {};
        }
    }
}

Bus.getInstance = (function() {
    let instance;
    return function() {
        if (!instance) {
            instance = new Bus();
        }
        return instance;
    };
})();

class People {
    constructor(name) {
        this.name = name;
    }

    eat() {
        console.log(this.name, "吃个饭");
    }

    sleep() {
        console.log(this.name, "睡觉");
    }
}
const bus = Bus.getInstance();
const zhangsan = new People("zhangsan");
const lisi = new People("lisi");
bus.$on("eight o 'clock", lisi.eat.bind(lisi));
bus.$on("Ten o 'clock", zhangsan.eat.bind(zhangsan));
bus.$on("Ten o 'clock", lisi.sleep.bind(lisi));
bus.$on("eleven o 'clock", lisi.eat.bind(lisi));
console.log("8点了");
bus.$emit("eight o 'clock");
console.log("10点了");
bus.$emit("Ten o 'clock");
console.log("11点了");
bus.$emit("eleven o 'clock");
/* 
8点了
lisi 吃个饭
10点了
zhangsan 吃个饭
lisi 睡觉
11点了
lisi 吃个饭
*/
```
## 迭代器模式
## 优点
它支持以不同的方式遍历一个聚合对象。
迭代器简化了聚合类。在同一个聚合上可以有多个遍历。
在迭代器模式中，增加新的聚合类和迭代器类都很方便，无须修改原有代码。
## 缺点
由于迭代器模式将存储数据和遍历数据的职责分离，增加新的聚合类需要对应增加新的迭代器类，类的个数成对增加，这在一定程度上增加了系统的复杂性。
但是在es6中新增了Iterator,Array Arguments Set Map String TypeArray NodeList 都支持从而不需要我们自己重新自己书写迭代器类
## 使用场景
```js
/* 
    内部迭代器
*/
Array.prototype.forEach = function(callback, thisArg) {
    for (let i = 0; i < this.length; i++) {
        callback.call(thisArg, this[i], i, this);
    }
};

Array.prototype.map = function(callback, thisArg) {
    let arr = [];
    for (let i = 0; i < this.length; i++) {
        arr.push(callback.call(thisArg, this[i], i, this));
    }
    return arr;
};
const arr = ["a", "b", "c"];
const obj = { name: "zhangsan" };
arr.forEach(function(item, index, array) {
    console.log(item);
    console.log(index);
    console.log(array);
    console.log(this);
}, obj);
const result = arr.map(function(item, index, array) {
    console.log(item);
    console.log(index);
    console.log(array);
    console.log(this);
    return item + item;
}, obj);
console.log(result);

/* 
    外部迭代器
*/

// 外部迭代器必须显示的迭代下一个元素。它增加了调用的复杂度，但也增加了迭代器的灵活性，可以手动控制迭代的过程。

/* 
    es6——迭代器iterator
*/
const arr3 = ["o", "r", "e", "a"];

// 不同于for in 的是 for in i 是下标、键 for of 是值
for (let i of arr3) {
    console.log(i); // o r e a
}

// 对象的Symbol.iterator属性是一个函数，返回值是一个对象，该对象中有一个next方法
// arr也是一个对象
let iterator = arr3[Symbol.iterator]();
console.log(iterator); // Object [Array Iterator] {}
// iterator中有一个next方法，每调用一次，next指针的返回值是数据结构的下一位节点对象，第一次调用就是节点对象
console.log(iterator.next()); // { value: 'o', done: false }
console.log(iterator.next()); // { value: 'r', done: false }
console.log(iterator.next()); // { value: 'e', done: false }
console.log(iterator.next()); // { value: 'a', done: false }

/* 
    自定义迭代器
*/
class ArrIterator extends Array {
    constructor(arr) {
            super(arr);
            this.current = 0;
            this.length = arr.length;
            this.arr = arr;
        }
        // 自定义迭代器
        [Symbol.iterator]() {
            let index = 0;
            let lock = false;
            return {
                next: () => {
                    if (index < this.length && !lock) {
                        index++;
                        return { value: `自定义${this.arr[index - 1]}`, done: lock };
                    } else {
                        lock = true;
                        // done为true时，for of停止遍历
                        return { value: undefined, done: lock };
                    }
                },
            };
        }
    next() {
        return {
            done: this.current >= this.length,
            value: this.arr[this.current++],
        };
    }
}
let arrIterator = new ArrIterator([1, 2, 3]);
while (!(item = arrIterator.next()).done) {
    console.log(item);
}
for (const item of arrIterator) {
    console.log(item);
}
```
## 策略模式
## 优点
策略模式指的是定义一系列算法，把他们一个个封装起来，目的就是将算法的使用和算法的实现分离开来。同时它还可以用来封装一系列的规则，比如常见的表单验证规则，只要这些规则指向的目标一致，并且可以被替换使用，那么就可以用策略模式来封装它们。
算法可以自由切换，避免了使用多层条件判断，增加了扩展性
## 缺点
## 使用场景
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="" id="registerForm" method="post">
        请输入用户名：<input type="text" name="userName" /> 请输入密码：
        <input type="text" name="password" /> 请输入手机号码：
        <input type="text" name="phoneNumber" />
        <button>提交</button>
    </form>
    <script>
        class Check {
            constructor(formObject, varifyCollection) {
                this.formData = formObject;
                this.verifyCollection = varifyCollection ? varifyCollection : {};
            }

            add(verifyRecord, verifyFunc) {
                if (!this.verifyCollection[verifyRecord]) {
                    this.verifyCollection[verifyRecord] = [];
                }
                this.verifyCollection[verifyRecord].push(verifyFunc);
            }

            callback(message) {
                alert(message);
            }

            submit() {
                function auxiliary() {
                    for (const record of Object.keys(this.verifyCollection)) {
                        for (const verifyFunc of this.verifyCollection[record]) {
                            if (!verifyFunc(this.formData[record].value, this.callback, this.formData)) {
                                return false;
                            }
                        }
                    }
                };
                if (auxiliary.call(this) !== false) {
                    return true;
                }

                return false;
            }
        }

        const registerForm = document.getElementById('registerForm');
        const check = new Check(registerForm, {
            "userName": [function(value, callback) {
                if (value === undefined || value === null || value === "") {
                    callback("账号是必填项");
                    return false;
                }
                return true;
            }],
            "password": [
                function(value, callback) {
                    if (value === undefined || value === null || value === "") {
                        callback("密码是必填项");
                        return false;
                    }
                    return true;
                },
                function(value, callback) {
                    if (!/^\S*(?=\S{6,})(?=\S*\d)(?=\S*[A-Z])(?=\S*[a-z])(?=\S*[!@#$%^&*? ])\S*$/.test(value)) {
                        callback("密码强度校验,最少6位,包括至少1个大写字母,1个小写字母,1个数字,1个特殊亨符");
                        return false;
                    }
                    return true;
                }
            ]

        });
        check.add("userName",
            function(value, callback) {
                if (value.length < 6) {
                    callback("账号长度必须6位");
                    return false;
                }
                return true;
            }
        );
        check.add("phoneNumber",
            function(value, callback) {
                if (/^(?:(?:\+|00)86)?1[3-9]\d{9}$/.test(value)) {
                    return true;
                }
                callback("电话号码格式不正确");
                return false;
            });
        registerForm.onsubmit = function() {
            console.log("提交");
            if (check.submit()) {
                console.log("校验成功");
            } else {
                console.log("校验失败");
            }
            return false;
        }
    </script>
</body>
</html>
```
`以下代码来自iview官方文档表单校验演示代码`
```vue
<template>
    <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
        <FormItem label="Name" prop="name">
            <Input v-model="formValidate.name" placeholder="Enter your name"></Input>
        </FormItem>
        <FormItem label="E-mail" prop="mail">
            <Input v-model="formValidate.mail" placeholder="Enter your e-mail"></Input>
        </FormItem>
        <FormItem label="City" prop="city">
            <Select v-model="formValidate.city" placeholder="Select your city">
                <Option value="beijing">New York</Option>
                <Option value="shanghai">London</Option>
                <Option value="shenzhen">Sydney</Option>
            </Select>
        </FormItem>
        <FormItem label="Date">
            <Row>
                <Col span="11">
                    <FormItem prop="date">
                        <DatePicker type="date" placeholder="Select date" v-model="formValidate.date"></DatePicker>
                    </FormItem>
                </Col>
                <Col span="2" style="text-align: center">-</Col>
                <Col span="11">
                    <FormItem prop="time">
                        <TimePicker type="time" placeholder="Select time" v-model="formValidate.time"></TimePicker>
                    </FormItem>
                </Col>
            </Row>
        </FormItem>
        <FormItem label="Gender" prop="gender">
            <RadioGroup v-model="formValidate.gender">
                <Radio label="male">Male</Radio>
                <Radio label="female">Female</Radio>
            </RadioGroup>
        </FormItem>
        <FormItem label="Hobby" prop="interest">
            <CheckboxGroup v-model="formValidate.interest">
                <Checkbox label="Eat"></Checkbox>
                <Checkbox label="Sleep"></Checkbox>
                <Checkbox label="Run"></Checkbox>
                <Checkbox label="Movie"></Checkbox>
            </CheckboxGroup>
        </FormItem>
        <FormItem label="Desc" prop="desc">
            <Input v-model="formValidate.desc" type="textarea" :autosize="{minRows: 2,maxRows: 5}" placeholder="Enter something..."></Input>
        </FormItem>
        <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
        </FormItem>
    </Form>
</template>
<script>
    export default {
        data () {
            return {
                formValidate: {
                    name: '',
                    mail: '',
                    city: '',
                    gender: '',
                    interest: [],
                    date: '',
                    time: '',
                    desc: ''
                },
                ruleValidate: {
                    name: [
                        { required: true, message: 'The name cannot be empty', trigger: 'blur' }
                    ],
                    mail: [
                        { required: true, message: 'Mailbox cannot be empty', trigger: 'blur' },
                        { type: 'email', message: 'Incorrect email format', trigger: 'blur' }
                    ],
                    city: [
                        { required: true, message: 'Please select the city', trigger: 'change' }
                    ],
                    gender: [
                        { required: true, message: 'Please select gender', trigger: 'change' }
                    ],
                    interest: [
                        { required: true, type: 'array', min: 1, message: 'Choose at least one hobby', trigger: 'change' },
                        { type: 'array', max: 2, message: 'Choose two hobbies at best', trigger: 'change' }
                    ],
                    date: [
                        { required: true, type: 'date', message: 'Please select the date', trigger: 'change' }
                    ],
                    time: [
                        { required: true, type: 'string', message: 'Please select time', trigger: 'change' }
                    ],
                    desc: [
                        { required: true, message: 'Please enter a personal introduction', trigger: 'blur' },
                        { type: 'string', min: 20, message: 'Introduce no less than 20 words', trigger: 'blur' }
                    ]
                }
            }
        },
        methods: {
            handleSubmit (name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('Success!');
                    } else {
                        this.$Message.error('Fail!');
                    }
                })
            },
            handleReset (name) {
                this.$refs[name].resetFields();
            }
        }
    }
</script>
```
## 模板方法模式
模块方法模式是一种基于继承的设计模式，在javascript中没有真正意义上的继承，所有继承都来自原型(prototype)上的继承，随着ES6的class到来，实现了继承的“概念”，让我们可以以一种很方便简洁的方式继承，但其本质上还是原型继承。
模板方法模式由两部分组成，第一部分是抽象父类，第二部分是具体的实现子类。抽象父类主要封装了子类的算法框架，以及实现了一些公共的方法和其他方法的执行顺序。子类通过继承父类，继承了父类的算法框架，并进行重写。
## 优点
提供公共的代码便于维护。行为由父类控制，具体由子类来实现。
## 缺点
其每一个具体实现都需要继承的子类来实现，这无疑导致类的个数增加，使得系统庞大。
## 使用场景
```js
/* 
    模板方法模式规定了子类需要有哪些父类中的方法，有哪些属性
    “模板”顾名思义就是制定了一些规则
*/
class People {
    constructor(name, age, professional) {
        this.name = name;
        this.age = age;
        this.professional = professional;
    }

    sleep() {
        console.log(this.name + "睡觉了");
    }

    work() {
        throw new Error("字类必须重写work方法");
    }
}

/* 子类必须要重写父类的work工作方法，也就是子类必须要有work方法 */
class Doctor extends People {
    constructor(name, age) {
        super(name, age, "医生");
    }

    work() {
        console.log("我的工作是给病人治病");
    }
}

class Police extends People {
    constructor(name, age) {
        super(name, age, "警察");
    }

    work() {
        console.log("我的工作是抓坏人");
    }
}

const zhangsan = new Doctor("zhangsan", 22);
const lisi = new Police("lisi", 24);
zhangsan.work();
lisi.work();
```
## 职责链模式
职责链模式的定义是：使用多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系，将这些对象链成一条链，并沿着这条链传递该请求，知道有一个对象处理它为止。
## 优点
降低耦合度，它将请求的发送者和接收者解耦。
简化了对象，使得对象不需要知道链的结构。
增强给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，允许动态地新增或者删除责任。
## 缺点
不能保证每一条请求都一定被接收。
系统性能将受到一定影响，而且在进行代码调试时不太方便，可能会造成循环调用。
可能不容易观察运行时的特征，有碍于排除问题。
## 使用场景
```js
// 财务
class Financial {
    constructor(name, minimumMoney, maximumMoney) {
        this.name = name;
        this.minimumMoney = minimumMoney;
        this.maximumMoney = maximumMoney;
    }

    Approve(money) {
        if (money > this.minimumMoney && money < this.maximumMoney) {
            console.log("财务审批成功");
            return true
        }
        return false;
    }
}
// 领导
class Leader {
    constructor(name, minimumMoney, maximumMoney) {
        this.name = name;
        this.minimumMoney = minimumMoney;
        this.maximumMoney = maximumMoney;
    }

    Approve(money) {
        if (money >= this.minimumMoney && money < this.maximumMoney) {
            console.log("领导审批成功");
            return true
        }
        return false;
    }
}
// 老板
class Boss {
    constructor(name, minimumMoney, maximumMoney) {
        this.name = name;
        this.minimumMoney = minimumMoney;
        this.maximumMoney = maximumMoney;
    }

    Approve(money) {
        if (money >= this.minimumMoney && money < this.maximumMoney) {
            console.log("老板审批成功");
            return true
        }
        return false;
    }
}

// 审批职责链
class ApprovalDuty {
    constructor(currentApprover) {
        // 设置当前审批人
        this.currentApprover = currentApprover;
    }

    // 设置下一个审批职责
    setNextApprovalDuty(approvalDuty) {
        this.approvalDuty = approvalDuty;
    }

    // 开始审批
    beginApprove(approvalDocument) {
        if (this.currentApprover.Approve(approvalDocument.money)) {
            approvalDocument.state = "已审批";
        } else {
            this.approvalDuty.beginApprove(approvalDocument);
        }
    }
}

// 审批单
class ApprovalDocument {
    constructor(name, id, money, state) {
        this.name = name;
        this.id = id;
        this.money = money;
        this.state = state;
    }
}

const approvalDocument = new ApprovalDocument("为公司买一台宝马", "AD0001", 500000, "待审批");
const financial = new ApprovalDuty(new Financial("刘财务", 0, 10000));
const leader = new ApprovalDuty(new Leader("刘总", 10000, 100000));
const boss = new ApprovalDuty(new Boss("老板", 100000, 1000000));
financial.setNextApprovalDuty(leader);
leader.setNextApprovalDuty(boss);
financial.beginApprove(approvalDocument);
console.log(approvalDocument);
```
## 命令模式
命令模式中的命令指的是一个执行某些特定的事情的指令。
命令模式最常见的应用场景如：有时候需要向某些对象发送请求，但是并不知道请求的接收者是谁，也不知道被请求的操作是什么。此时可以通过一种松耦合的方式来设计程序，使得请求发送者和请求接收者消除彼此之间的耦合关系。
## 优点
降低了代码的耦合度，易扩展，出现新的命令可以很容易的添加进去
## 缺点
命令模式使用过度会导致代码中存在过多的具体命令。
## 使用场景
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <button id="add">新增</button>
    <button id="remove">删除</button>
    <button id="update">修改</button>
    <button id="query">查询</button>
    <script>
        const add = document.getElementById("add");
        const remove = document.getElementById("remove");
        const update = document.getElementById("update");
        const query = document.getElementById("query");
        // 命令集合
        class ButtonAction {
            add() {
                console.log("新增");
            }
            remove() {
                console.log("删除");
            }
            update() {
                console.log("修改");
            }
            query() {
                console.log("查询");

            }
        }
        // 命令绑定类
        class Command {
            constructor(buttonAction) {
                this.buttonAction = buttonAction;
            }
            bind(el, commandName) {
                el.onclick = this.buttonAction[commandName];
            }
        }

        const buttonAction = new ButtonAction();
        const command = new Command(buttonAction);
        command.bind(add, "add");
        command.bind(remove, "remove");
        command.bind(update, "update");
        command.bind(query, "query");
    </script>
</body>

</html>
```
## 备忘录模式
备忘录模式就是在不破坏封装的前提下，捕获一个对象内部状态，并在该对象之外保存这个状态，以保证以后可以将对象恢复到原先的状态。
## 优点
给用户提供了一种可以恢复状态的机制，可以使用户能够比较方便地回到某个历史的状态。
实现了信息的封装，使得用户不需要关心状态的保存细节。
## 缺点
如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存。
## 使用场景
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <script>
        // 棋子
        class Piece {
            constructor(name) {
                this.name = name;
            }
        }

        // 棋手
        class ChessPlayer {
            constructor(name) {
                this.name = name;
            }

            playChess(board, i, j, name) {
                board.addPiece(i, j, new Piece(name));
            }

            repentantChess(board, pace) {
                board.repentantChess(pace);
            }
        }

        // 棋盘
        class Board {
            constructor(name, i, j) {
                this.name = name;
                // 创建一个二维数组"棋盘"
                this.board = Array.from(Array(i), () => new Array(j));
                // 用来对下棋做记录
                this.record = [];
                this.xMax = i - 1;
                this.yMax = j - 1;
            }

            addPiece(i, j, piece) {
                // 判断是否连子
                const check = function(x, y, piece) {
                    // 计算要判断的区域范围
                    let xMin = x - 4 <= 0 ? 0 : x - 4;
                    let xMax = x + 4 >= this.xMax ? this.xMax : x + 4;
                    let yMin = y - 4 <= 0 ? 0 : y - 4;
                    let yMax = y + 4 >= this.yMax ? this.yMax : y + 4;

                    // 判断连子数是否达到5
                    function isWin(number) {
                        if (number === 5) {
                            alert(`${piece.name}胜利了`);
                        }
                    }
                    // 连子数
                    let connectedNumber = 0;
                    // 判断横着是否连子
                    for (let i = yMin; i <= yMax; i++) {
                        if (this.board[i][y] && piece.name === this.board[i][y].name) {
                            connectedNumber = connectedNumber + 1;
                            isWin(connectedNumber);
                        } else {
                            connectedNumber = 0;
                        }
                    }
                    connectedNumber = 0;
                    // 判断竖着是否连子
                    for (let i = xMin; i <= xMax; i++) {
                        if (this.board[x][i] && piece.name === this.board[x][i].name) {
                            connectedNumber = connectedNumber + 1;
                            isWin(connectedNumber);
                        } else {
                            connectedNumber = 0;
                        }
                    }
                    connectedNumber = 0;
                    let x1 = 0;
                    let x2 = 0;
                    let beginIndex = -4;
                    // 判断斜着是否连子
                    for (let i = 0; i <= 8; i++) {
                        if (
                            x + beginIndex >= 0 &&
                            x + beginIndex <= xMax &&
                            y + beginIndex >= 0 &&
                            y + beginIndex <= yMax
                        ) {
                            if (
                                this.board[x + beginIndex][y + beginIndex] &&
                                piece.name === this.board[x + beginIndex][y + beginIndex].name
                            ) {
                                x1 = x1 + 1;
                                isWin(x1);
                            } else {
                                x1 = 0;
                            }
                        }
                        if (
                            x - beginIndex >= 0 &&
                            x - beginIndex <= xMax &&
                            y + beginIndex >= 0 &&
                            y + beginIndex <= yMax
                        ) {
                            if (
                                this.board[x - beginIndex][y + beginIndex] &&
                                piece.name === this.board[x - beginIndex][y + beginIndex].name
                            ) {
                                x2 = x2 + 1;
                                isWin(x2);
                            } else {
                                x2 = 0;
                            }
                        }
                        beginIndex++;
                    }
                };
                if (i < 0 || i > this.xMax || j < 0 || j > this.yMax) {
                    alert("你下的位置不在棋盘上");
                } else {
                    if (this.board[i][j]) {
                        alert("该位置已经有一颗棋子了");
                    } else {
                        this.board[i][j] = piece;
                        this.record.push({
                            x: i,
                            y: j,
                            piece: piece
                        });
                        check.call(this, i, j, piece);
                    }
                }
            }

            repentantChess(pace) {
                for (let i = 0; i < pace; i++) {
                    const result = this.record.pop();
                    this.board[result.x][result.y] = undefined;
                }
            }
        }

        const board = new Board("五子棋", 10, 10);
        const black = new ChessPlayer("黑色方");
        const white = new ChessPlayer("白色方");
        black.playChess(board, 1, 1, "黑子");
        white.playChess(board, 2, 3, "白子");
        black.playChess(board, 2, 2, "黑子");
        white.playChess(board, 3, 4, "白子");
        black.playChess(board, 3, 3, "黑子");
        white.playChess(board, 4, 5, "白子");
        black.playChess(board, 4, 4, "黑子");
        black.repentantChess(board, 1);
        black.playChess(board, 5, 5, "黑子");
        white.playChess(board, 5, 6, "白子");
        black.playChess(board, 5, 9, "黑子");
        white.playChess(board, 6, 7, "白子");
        console.log(board);
    </script>
</body>

</html>
```
## 状态模式
允许一个对象在其内部状态改变的时候改变其行为，对象看起来似乎修改了它的类，通俗一点的将就是记录一组状态，每个状态对应一个实现，实现的时候根据状态去运行实现。
## 优点
将所有与某个状态有关的行为放到一个类中，并且可以方便地增加新的状态，只需要改变对象状态即可改变对象的行为。
允许状态转换逻辑与状态对象合成一体，而不是某一个巨大的条件语句块。
可以让多个环境对象共享一个状态对象，从而减少系统中对象的个数。
## 缺点
状态模式的使用必然会增加系统类和对象的个数。
状态模式的结构与实现都较为复杂，如果使用不当将导致程序结构和代码的混乱。
状态模式对"开闭原则"的支持并不太好，对切换状态的状态模式增加新的状态类需要修改那些负责状态转换的源代码，否则无法切换到新增状态，而且修改某个状态类的行为也需修改对应类的源代码。
## 使用场景
```js
// 状态与行为对应的类
class State {
    constructor(attack) {
        this.attack = attack;
    }
    handle(context) {
        // clg模拟不同状态的不同行为
        console.log(this.attack);
        context.setState(this);
    }
}

class Context {
    constructor() {
        this.state = null;
    }
    getState() {
        return this.state;
    }
    setState(state) {
        this.state = state;
    }
}

/* 
    随着状态增多，程序中的状态实例增多
*/
const s1 = new State("未开始"),
    s2 = new State("进行中"),
    s3 = new State("已停止"),
    s4 = new State("已结束");
context = new Context();
const run = () => {
    s1.handle(context);
    console.log(context.getState());

    s2.handle(context);
    console.log(context.getState());

    s3.handle(context);
    console.log(context.getState());

    s4.handle(context);
    console.log(context.getState());
};
run();
```
## 访问者模式
访问者模式是将数据的操作和数据的结构进行分离，对数据中各元素的操作封装独立的类，使其在不改变数据结构情况下扩展新的数据。
## 优点
符合单一职责原则。具有优秀的扩展性和灵活性。
## 缺点

## 使用场景
```js
let id = 0;

class Store {
    constructor() {
        this.store = [];
    }

    add(storeItem) {
        this.store.push(storeItem);
    }

    delete(storeItem) {
        this.store.filter(item => item.id !== storeItem.id);
    }

    update(storeItem) {
        this.store.forEach((item, index) => {
            if (item.id === storeItem.id) {
                this.store[index] = storeItem;
            }
        })
    }

    query(storeItem) {
        if (storeItem) {
            return this.store.find(item => item.id === storeItem.id);
        } else {
            return this.store;
        }
    }
}

// 访问者
class Visitor {
    constructor(name) {
        this.name = name;
    }
}

// 访问者————新增一条新的log日志数据并清除一条最早的
class CallLog extends Visitor {
    visit(store) {
        const result = store.query();
        if (result.length > 0) store.delete(result[0]);
        store.add({
            id: ++id,
            number: id
        });
    }
}

// 访问者————如果当前数据量为单数，就再将当前需要添加进去的数据再添加一次
class AddDouble extends Visitor {
    visit(store) {
        store.add({
            id: ++id,
            number: id
        });
        const result = store.query();
        if (result.length % 2) {
            store.add({
                id: id,
                number: id
            });
        }

    }
}

const store = new Store();
const callLog = new CallLog("访问者1");
const addDouble = new AddDouble("访问者2");
addDouble.visit(store);
console.log(store.store);
callLog.visit(store);
console.log(store.store);
```
## 中介者模式
中介者模式的作用就是解除对象与对象之间的紧密耦合关系。增加一个中介者对象之后，所有相关对象都通过中介者对象来通信，而不是相互引用，所以当一个对象发生改变时，只需要通过中介者对象即可。中介者使各对象之间耦合松散，而且可以独立改变他们之间的交互。中介者模式使网状的多对多关系变成了相对简单的一对多关系。
## 优点
降低了类的复杂度，将一对多转化成了一对一。各个类之间的解耦。
## 缺点
当中介者变得庞大复杂，导致难以维护。
## 使用场景
```html
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    选择颜色：<select name="" id="colorSelect">
		<option value="">请选择</option>
		<option value="red">红色</option>
		<option value="blue">蓝色</option>
	</select>
    <span id="colorPrompt" style="display: none;">请选择颜色</span>
    <br /> 选择内存：
    <select name="" id="memorySelect">
		<option value="">请选择</option>
		<option value="32G">32G</option>
		<option value="63G">64G</option>
	</select>
    <span id="memoryPrompt" style="display: none;">请选择内存</span>
    <br /> 输入购买数量：
    <input type="number" id="numberInput" />
    <span id="numberPrompt" style="display: none;">请输入正确的购买数量</span>
    <br />
    <div>你选择了颜色：<span id="colorInfo"></span></div>
    <div>你选择了内存：<span id="memoryInfo"></span></div>
    <div>你选择了数量：<span id="numberInfo"></span></div>
    <button id="nextBtn" disabled="true">请选择手机颜色、内存和购买数量</button>
    <script>
        // 中介者类
        class Mediator {
            constructor() {
                this.colorSelect = document.getElementById("colorSelect");
                this.memorySelect = document.getElementById("memorySelect");
                this.numberInput = document.getElementById("numberInput");
                this.colorPrompt = document.getElementById("colorPrompt");
                this.memoryPrompt = document.getElementById("memoryPrompt");
                this.numberPrompt = document.getElementById("numberPrompt");
                this.colorInfo = document.getElementById("colorInfo");
                this.memoryInfo = document.getElementById("memoryInfo");
                this.numberInfo = document.getElementById("numberInfo");
                this.nextBtn = document.getElementById("nextBtn");
            }
            changed(valueObj) {
                switch (valueObj.id) {
                    case "colorSelect":
                        this.colorInfo.innerText = valueObj.value;
                        if (!this.colorSelect.value) {
                            this.colorPrompt.style.color = 'red';
                            this.colorPrompt.style.display = 'block';
                        } else {
                            this.colorPrompt.style.color = 'green';
                            setTimeout(() => {
                                this.colorPrompt.style.display = 'none';
                            }, 1500);
                        }
                        break;
                    case "memorySelect":
                        this.memoryInfo.innerText = valueObj.value;
                        if (!this.memorySelect.value) {
                            this.memoryPrompt.style.color = 'red';
                            this.memoryPrompt.style.display = 'block';
                        } else {
                            this.memoryPrompt.style.color = 'green';
                            setTimeout(() => {
                                this.memoryPrompt.style.display = 'none';
                            }, 1500);
                        }
                        break;
                    case "numberInput":
                        this.numberInfo.innerText = valueObj.value;
                        if ((!this.numberInput.value && new Number(this.numberInput.value) !== 0) || new Number(this
                                .numberInput.value) < 0) {
                            this.numberPrompt.style.color = 'red';
                            this.numberPrompt.style.display = 'block';
                        } else {
                            this.numberPrompt.style.color = 'green';
                            setTimeout(() => {
                                this.numberPrompt.style.display = 'none';
                            }, 1500);
                        }
                        break;
                }
                if ((this.numberInput.value && this.numberInput.value >= 0) && this.memorySelect.value && this
                    .colorSelect.value) {
                    this.nextBtn.disabled = false;
                    this.nextBtn.innerHTML = '放入购物车'
                } else {
                    this.nextBtn.disabled = true;
                    this.nextBtn.innerHTML = '请选择手机颜色、内存和购买数量'
                }
            }
        }
        const mediator = new Mediator();
        colorSelect.onchange = function() {
            mediator.changed(this)
        }
        memorySelect.onchange = function() {
            mediator.changed(this)
        }
        numberInput.oninput = function() {
            mediator.changed(this)
        }
    </script>
</body>

</html>
```
## 解释器模式
解释器模式提供了评估语言的语法或表达式的方式，它属于行为型模式。这种模式实现了一个表达式接口该接口，该接口解释一个特定的上下文。
## 优点
可扩展性比较好，灵活。增加了新的解释表达式的方式。
## 缺点
可利用场景比较少，在web开发中几乎不可见。对于复杂的环境比较难维护。
解释器模式会引起类膨胀。它还采用递归调用方法，没控制好可能会导致崩溃。
## 使用场景
```js
class TerminalExpression {
  constructor(data) {
    this.data = data
  }
  interpret(context) {
    if (context.indexOf(this.data) > -1) {
      return true;
    }
    return false;
  }
}

class OrExpression {
  constructor(expr1, expr2) {
    this.expr1 = expr1;
    this.expr2 = expr2;
  }
  interpret(context) {
    return this.expr1.interpret(context) || this.expr2.interpret(context);
  }
}

class AndExpression {
  constructor(expr1, expr2) {
    this.expr1 = expr1;
    this.expr2 = expr2;
  }
  interpret(context) {
    return this.expr1.interpret(context) && this.expr2.interpret(context);
  }
}

class InterpreterPatternDemo {
  static getMaleExpression() {
    const robert = new TerminalExpression("小明");
    const john = new TerminalExpression("小龙");
    return new OrExpression(robert, john);
  }

  static getMarriedWomanExpression() {
    const julie = new TerminalExpression("张三");
    const married = new TerminalExpression("小红");
    return new AndExpression(julie, married);
  }

  static init(args) {
    const isMale = this.getMaleExpression();
    const isMarriedWoman = this.getMarriedWomanExpression();
    console.log(`小龙是男性?${isMale.interpret("小龙")}`)
    console.log(`小红是一个已婚妇女?${isMarriedWoman.interpret("小红 张三")}`)
  }
}
InterpreterPatternDemo.init();
```