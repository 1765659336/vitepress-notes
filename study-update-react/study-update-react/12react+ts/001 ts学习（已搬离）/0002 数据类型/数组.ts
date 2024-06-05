/* 
  TypeScript像JavaScript一样可以操作数组元素。 
  有两种方式可以定义数组。 第一种，可以在元素类型后面接上 []，表示由此类型元素组成的一个数组
  第二种方式是使用数组泛型，Array<元素类型>
*/
let list1: number[] = [1,2,3];
console.log(list1.length,list1[2]);
let list2: Array<string> = ['a','b','c'];
console.log(list2[1]);