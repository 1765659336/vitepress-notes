## React.memo()
React提供了一个高价组件，可以让子组件不会永远随着父组件的更新而更新重新渲染，而是会去匹配父组件传递的props是否发生改变，从而来决定是否要重新渲染。

:::details 点我查看代码
```js
import React, { useState } from "react";

const Son = () => {
  console.log("因为没有被React.meno高价函数修饰，所有父组件重新渲染，会打印")

  return (
    <div>Son</div>
  )
}

const Son2 = React.memo(() => {

  console.log("因为被React.meno高价函数修饰过，且props没有改变，因此只会打印一次")
  return <div>Son2</div>
}
)

const Son3 = React.memo((props) => {

  console.log("因为被React.meno高价函数修饰过，但是props改变了，因此会打印多次", props)
  return <div>Son2</div>
}
)


const App = () => {
  const [count, setCount] = useState(0);
  return (
    <>
      <p>{count}</p>
      <button onClick={() => setCount(count + 1)}>+1</button>
      <Son></Son>
      <Son2></Son2>
      <Son3 count={count}></Son3>
    </>
  )
}

export default App;
```
:::