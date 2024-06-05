/* 
  抽象类和抽象方法，不需要具体的实现细节
  定义的抽象方法需要具体实现，但继承的子类必须去实现
*/
abstract class Animal {
  abstract makeSound(): void;
  move(): void {
    console.log("Fast running");
  }
}

class Cat extends Animal {
  name: string;
  constructor(name: string) {
    super();
    this.name = name;
  }
  makeSound(): void {
    console.log("喵喵喵");
  }
}

const xiaohua = new Cat("小花");
console.log(xiaohua.name); // 小花
xiaohua.makeSound(); // 喵喵喵
xiaohua.move(); // Fast running