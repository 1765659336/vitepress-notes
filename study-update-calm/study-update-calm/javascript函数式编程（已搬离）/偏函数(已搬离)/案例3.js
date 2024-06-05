function select(type, num) {
    if (type == 'a') {
        // 模拟一段业务
        return function() {
            console.log(num + 1);
        }
    } else if (type == 'b') {
        // 模拟一段业务
        return function() {
            console.log(num * 1);
        }
    } else if (type == 'c') {
        // 模拟一段业务
        return function() {
            console.log(num ** 2);
        }
    } else if (type == 'd') {
        // 模拟一段业务
        return function() {
            console.log(num / 2);
        }
    } else if (type == 'e') {
        console.log("走循环了");
        return function() {
            console.log("新加的功能" + num % 2);
        }
    }
}

// 现有实现的一些功能
const selectA = select("a", 10);
const selectB = select("b", 10);
const selectC = select("c", 10);
const selectD = select("d", 10);
const selectE = select("e", 10);
selectB(); // 1210
selectC(); // 100
selectD(); // 5
selectE(); // 新加的0
selectE(); // 新加的0
selectE(); // 新加的0
selectE(); // 新加的0
selectE(); // 新加的0