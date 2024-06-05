/* 
  Object类型的变量只是允许你给它赋任意值 - 但是却不能够在它上面调用任意的方法，即便它真的有这些方法：
*/
let ObjectNum: Object = 4;
// ObjectNum.toFixed(2);
// 类型Object上不存在toFixed方法

// [propName: string] : any 表示对象的其它属性为字符串类型的属性，属性值的类型为any
let obj: {name: string, [propName: string] : any} = {name: "zhangsan",age:18}