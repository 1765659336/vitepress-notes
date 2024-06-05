## useContext

需要读取哪个父级传递的Context，就使用useContext(父级通过createContext()创建的Context对象)
:::details 基本使用示范代码
```js
import { useState, createContext, useContext } from 'react';

const CountContext = createContext();
const CountContext2 = createContext();

const Son = () => {
  return (
    <>
      <p>Home传递的Context--{useContext(CountContext2)}</p>
      <p>App传递的Context--{useContext(CountContext)}</p>
    </>
  )
}

const Home = () => {
  return (
    <>
      <p>App传递的Context--{useContext(CountContext)}</p>

      <CountContext2.Provider value={useContext(CountContext)}>
        <Son></Son>
      </CountContext2.Provider>
    </>
  )
}

const App = () => {

  const [count, setCount] = useState(0)

  return (
    <div>
      <p>you click {count} times</p>
      <button onClick={() => setCount(count + 1)}>click</button>
      <CountContext.Provider value={count}>
        <Home />
      </CountContext.Provider>
    </div>
  )

};

export default App;
```
:::

## 