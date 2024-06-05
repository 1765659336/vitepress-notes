## useCallback

<span class="span-info-message">保存上一次的函数的引用栈内存，有两个参数，第一个参数是函数体，第二个参数是触发的值</span>

:::details 点我查看代码
```js
import React, { useState, useCallback } from "react";


const App = () => {
  const [count, setCount] = useState(0);

  const [count2, setCount2] = useState(0);


  // 当count2改变时，会去重新执行第一个参数函数，并获取到最新的count
  const fn = useCallback(() => {
    console.log(count);
  }, [count2])
  return (
    <>
      {/* 点击count+1按钮之后，点击fn()按钮，打印的值还是0，当点击count2+1按钮
      触发useCallback重新执行获取最新的count值,此时点击fn()按钮，将会打印最新的值
      */}
      <p>{count}</p>
      <button onClick={() => setCount(count + 1)}>count+1</button>
      <p>{count2}</p>
      <button onClick={() => setCount2(count2 + 1)}>count2+1</button>
      <button onClick={fn}>fn()</button>
    </>
  )
}

export default App;
```
:::

## useCallback的应用场景

<span class="span-info-message">当我们使用React.memo()来减少子组件不必要的重新渲染时，当我们传递一个函数参数给子组件时，
父组件每次重新渲染，函数都会被重新创建，React.memo()从而认为传入的props发生了改变，从而
会重新渲染子组件</span>

:::details 问题代码如下
```js
import React, { useState } from "react";

const Home = React.memo(
  () => {

    console.log("组件挂载或者更新")

    return (
      <div>
        Home
      </div>
    )
  }
)

const App = () => {

  const [count, setCount] = useState(0);

  const fn = () => { }

  return (
    <>
      <Home fn={fn}></Home>
      <p>{count}</p>
      <button onClick={() => setCount(count + 1)}>+1</button>
    </>
  )
}

export default App;
```
:::

:::details 解决方式如下
```js
import React, { useState, useCallback } from "react";

const Home = React.memo(
  () => {

    console.log("组件挂载或者更新")

    return (
      <div>
        Home
      </div>
    )
  }
)

const App = () => {

  const [count, setCount] = useState(0);
  
  const fn = useCallback(() => { }, [])

  return (
    <>
      <Home fn={fn}></Home>
      <p>{count}</p>
      <button onClick={() => setCount(count + 1)}>+1</button>
    </>
  )
}

export default App;
```
:::