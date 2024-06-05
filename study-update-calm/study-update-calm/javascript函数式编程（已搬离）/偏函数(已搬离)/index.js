function select(type, num) {


    if (type == 'a') {
        // 模拟一段业务
        console.log(num + 1);
    } else if (type == 'b') {
        // 模拟一段业务
        console.log(num * 1);
    } else if (type == 'c') {
        // 模拟一段业务
        console.log(num ** 2);
    } else if (type == 'd') {
        // 模拟一段业务
        console.log(num / 2);
    } else if (type == 'e') {
        console.log("新加的功能" + num % 2);
    }
}

// 现有实现的一些功能
select("a", 10); // 11
select("b", 10); // 10
select("c", 10); // 100
select("d", 10); // 5
select("e", 10); // 新加的0