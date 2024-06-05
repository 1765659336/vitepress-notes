interface IPerson {
    name:string,
    age:number
}

interface IStudent {
    classroom:string
}

const xiaoming : IPerson & IStudent = {
    name: "xiaoming",
    age: 12,
    classroom: "六年一班"
}
console.log(xiaoming);