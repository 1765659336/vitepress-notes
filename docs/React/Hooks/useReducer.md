## useReducer
useReducer可以理解成用来解决一些useState难以处理的场景，基本上useState可以做的事情，useReducer也可以做。

```js
useReducer(reducer,state,initStateFun)
```

<span class="span-info-message">useReducer接收三个参数,reducer是一个reducer函数,state是初始值,initStateFun是初始值的拦截函数，决定真正的state</span>

:::details 点我查看代码
```js
import React, { useReducer } from 'react';

const App = () => {

  const [count, dispatch] = useReducer((state, action) => {
    switch (action) {
      case 'add':
        return state + 1
      case 'dec':
        return state - 1
      default:
        return state
    }
  }, 0, (state) => {
    return state + 10
  })

  return (
    <div>
      <h1>Count:{count}</h1>
      <button onClick={() => dispatch('add')}>+</button>
      <button onClick={() => dispatch('dec')}>-</button>
    </div>
  )
}
export default App;
```
:::

## useReducer结合useContext案例

<span class="span-info-message">通过点击按钮来改变字体的颜色</span>

:::details 点我查看代码
```js
import React, { createContext, useReducer, useContext } from 'react';

const ColorContext = createContext({});

const reducer = (state, action) => {
  switch (action.type) {
    case "UPDATE_COLOR":
      return action.color
    default:
      return state
  }
}

const Color = props => {
  const [color, dispatch] = useReducer(reducer, 'blue')
  return (
    <ColorContext.Provider value={{ color, dispatch }}>
      {props.children}
    </ColorContext.Provider>
  )
}

const Show = () => {
  const { color } = useContext(ColorContext)
  return (
    <div style={{ color: color }}>字体的颜色为：{color}</div>
  )
}

const Button = () => {
  const { dispatch } = useContext(ColorContext)
  return (
      <div>
          <button onClick={()=>{dispatch({type:"UPDATE_COLOR",color:"red"})}}>红色</button>
          <button onClick={()=>{dispatch({type:"UPDATE_COLOR",color:"yellow"})}}>黄色</button>
      </div>
  )
}

const App = () => {
  return (
    <div>
      <Color>
        <Show />
        <Button />
      </Color>
    </div>
  )
}

export default App;
```
:::