## useMemo

<span class="span-info-message">实现如vue的计算属性一致的功能，接收两个参数，第一个参数为计算函数，第二参数为监听触发的值</span>

:::details 点我查看代码
```js
import { useState, useMemo } from "react";

const App = () => {

  const [a, setA] = useState(0);
  const [b, setB] = useState(0);
  const [c, setC] = useState(0);

  // 当a和b的值改变时，useMemo才会重新执行，d的值才会改变
  const d = useMemo(() => {
    return a + b
  }, [a, b])

  return (
    <>
      <p>{a}</p>
      <p>{b}</p>
      <p>{c}</p>
      <p>{d}</p>
      <button onClick={() => setA(a + 1)}>a+1</button>
      <button onClick={() => setB(b + 1)}>b+1</button>
      <button onClick={() => setC(c + 1)}>c+1</button>
    </>
  )
}

export default App;
```
:::