let i = 0;
setTimeout(() => {
    // 不能使用i++，不然会将当前i的值输出，再进行+1操作，此时代码执行完时，输出的值与内存的值不一致
    console.log(++i);
}, 1000);
setTimeout(() => {
    console.log(++i);
}, 1000);