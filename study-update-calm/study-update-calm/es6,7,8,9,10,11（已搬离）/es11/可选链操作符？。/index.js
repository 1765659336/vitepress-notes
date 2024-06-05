const obj = {
    a: {
        b: {
            c: 1,
            d: 2
        }
    }
}

delete obj ? .a ? .b ? .c;
console.log(obj);