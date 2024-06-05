## useState

```js
const [state, setState] = useState(initialState);
```
在初始渲染期间，返回的状态 (state) 与传入的第一个参数 (initialState) 值相同。

<span class="span-info-message">setState修改数据支持两种方式</span>
```js
// 对于简单的，直接传入一个state更新
setState(state + 1);
// 对于复杂逻辑数据更新可以传入一个函数，函数返回值作为更新的state
setState(()=> state + 1);
```

:::details 点我查看代码
```js
import { useState } from 'react';

const App = () => {
  const [ state, setState ] = useState(0);
  
  return (
    <div>
      <p>You Click { state } times</p>
      <button onClick={() => setState( state + 1)}>click</button>
      <button onClick={() => setState(() => state + 1)}>click</button>
    </div>
  )
}

export default App;
```
:::

<span class="span-info-message">setState修改引用数据类型方式</span>
可以使用es6+的解构赋值语法来改变值

:::details 点我查看代码
```js
import { useState } from 'react';

const App = () => {
  const [state, setState] = useState([1, 2, 3]);

  return (
    <div>
      <p>{state.join('-')}</p>
      <button onClick={() => setState([...state, (state[state.length - 1] + 1)])}>addItem</button>
    </div>
  )
}

export default App;
```
:::

## useState惰性
1. initialState 参数只会在组件的初始渲染中起作用，后续渲染时会被忽略。如果初始 state 需要通过复杂计算获得，则可以传入一个函数，在函数中计算并返回初始的 state，此函数只在初始渲染时被调用。
:::details 点我查看代码
```js
import { useState } from 'react';

const App = () => {
  const [state, setState] = useState(() => {
    return [1, 2, 3].map(item => item * 10)
  });

  return (
    <div>
      <p>{state.join('-')}</p>
      <button onClick={() => setState([...state, (state[state.length - 1] + 10)])}>addItem</button>
    </div>
  )
}

export default App;
```
:::

2. 如果state修改的值和现有的值一致，则不会触发组件的更新
:::details 点我查看代码

```js
import { useState } from 'react';

const App = () => {
  const [state, setState] = useState(() => {
    return [1, 2, 3].map(item => item * 10)
  });

  // 点击button不会触发组件更新，组件不会重新渲染，因此clg不会打印
  console.log("组件更新了");

  return (
    <div>
      <p>{state.join('-')}</p>
      <button onClick={() => setState(state)}>addItem</button>
    </div>
  )
}

export default App;
```
:::