// 不知道类型
let a:unknown;
a = 1;
a= "a";
console.log(a);
// 与any的区别，any类型的变量可以赋值给其它变量
// 但是unknown变量不能赋值给其它的变量，会提示报错
let b:any;
b = "b";
let c:string = "c";
c = b;
// c = a; // 报错不能将类型“unknown”分配给类型“string”。