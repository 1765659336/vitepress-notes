/* 
    后一个then会监听前一个then的执行
*/
new Promise((resolve) => {
        resolve();
        console.log("a");
    })
    .then(() => {
        new Promise((resolve) => {
                resolve();
                console.log("c");
            })
            .then(() => {
                console.log(1);
                // return new Promise("undefined");
            })
            .then(() => {
                console.log(2);
            });
        console.log("d");
        // return new Promise("undefined");
    })
    .then(() => {
        new Promise((resolve) => {
                resolve();
                console.log("e");
            })
            .then(() => {
                new Promise((resolve) => {
                        console.log("g");
                        resolve();
                    })
                    .then(() => {
                        console.log(4);
                        // return new Promise("undefined");
                    })
                    .then(() => {
                        console.log(6);
                    });
                console.log("h");
                // return new Promise("undefined");
            })
            .then(() => {
                console.log(5);
            });
        console.log("f");
        // return new Promise("undefined");
    })
    .then(() => {
        console.log(3);
    });
console.log("b");