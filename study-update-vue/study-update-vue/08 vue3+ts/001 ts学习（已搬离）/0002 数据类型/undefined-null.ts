/* 
  1.默认情况下null和undefined是所有类型的子类型。 就是说你可以把null和undefined赋值给number类型的变量。
  2.当你编译的时候`tsc [filename] --strictNullChecks`标记，null和undefined只能赋值给void和它们各自(严格校验)
*/
let un: number = undefined;
let un2: number = null;