let obj = {};
obj[Symbol("1")] = 1;
obj[Symbol("2")] = 2;
obj.a = 3;
const result = Reflect.ownKeys(obj);
console.log(result); // [ 'a', Symbol(1), Symbol(2) ]
for (const index of result) {
    console.log(obj[index]); // 3 1 2
}