/* 
  元祖：其实就是一个限制了长度和每一个元素的类型的数组，
  元祖编译成js，就会发现元祖被编译成了一个数组，因此元祖也可以通过下标和length拿到元素和下标，并且可以使用操作数组的方法
  当元祖长度超出时，会使用联合类型（也就是元祖中使用到的数据类型的集合）
*/  
let tuples: [number,string,boolean] = [1,'a',true];
console.log(tuples[1],tuples.length);
console.log(tuples.reverse());
// tuples.push([1,2,3]); // 报错类型“number[]”的参数不能赋给类型“string | number | boolean”的参数。ts(2345)
console.log(tuples);