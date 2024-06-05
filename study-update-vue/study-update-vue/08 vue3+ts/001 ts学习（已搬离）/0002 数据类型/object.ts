/* 
  object表示非原始类型，也就是除number，string，boolean，symbol，null或undefined之外的类型。
*/
// declare就是告诉TS编译器你担保这些变量和模块存在，并声明了相应类型，编译的时候不需要提示错误
declare function create(o: object | null): void;

create({ prop: 0 }); // OK
create(null); // OK

/* create(42); // Error
create("string"); // Error
create(false); // Error
create(undefined); // Error */