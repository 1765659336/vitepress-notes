let s1 = Symbol('zhangsan');
let s2 = Symbol('zhangsan');
let s3 = Symbol.for('zhangsan');
let s4 = Symbol.for('zhangsan');
console.log(s1 === s2); // false
console.log(s3 === s4); // true