function addOverloading(a: number, b: number): void
function addOverloading(a: string, b: string): string
function addOverloading(a: any, b: any): any {
  if (typeof (a) === "number") {
    return a + b
  } else if (typeof (a) === "string") {
    return `${a}+${b}`
  }
}

console.log(addOverloading(1, 2)); // 3
console.log(addOverloading("1", "2")); // 1+2