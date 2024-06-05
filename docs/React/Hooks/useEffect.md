## useEffect
<span class="span-info-message">React在完成DOM的更新后会执行useEffect，默认在组件首次渲染的时候也会执行一次</span>

:::details 点我查看代码
```js
import { useState, useEffect } from 'react';

const App = () => {

  const [count, setCount] = useState(0);

  useEffect(() => {
    console.log("useEffect", count)
  });

  console.log("组件渲染", count);

  return (
    <div>
      <p>you click {count} times</p>
      <button onClick={() => setCount(count + 1)}>click</button>
    </div>
  )

};

export default App;
```

## useEffect接收两个参数
:::

<span class="span-info-message">第一个参数是副作用函数，第二个参数是监听的数据，只有当监听的数据改变时，对应的副作用函数才会执行，类似于vue中的watch。</span>

<div class="div-info-Line"></div>

<span class="span-info-message">不传第二个参数那么就是组件重新渲染就会执行副作用函数</span>

<div class="div-info-Line"></div>

<span class="span-info-message">传入一个[]空数组，那么只会在组件初次渲染的时候执行一次</span>

:::details 点我查看代码
```js
import { useState, useEffect } from 'react';

const App = () => {

  const [count, setCount] = useState(0);

  const [count2, setCount2] = useState(0);


  useEffect(() => {
    console.log("useEffect-count", count)
  });

  useEffect(() => {
    console.log("useEffect-count2", count2)
  }, [count2]);

  useEffect(() => {
    console.log("只会执行一次", count, count2);
  }, []);

  console.log("组件渲染", count, count2);

  return (
    <div>
      <p>you click {count} times</p>
      <button onClick={() => setCount(count + 1)}>click</button>
      <p>you click {count2} times</p>
      <button onClick={() => setCount2(count2 + 1)}>click</button>
    </div>
  )

};

export default App;
```
:::

## useEffect被销毁的回调
<span class="span-info-message">useEffect可以返回一个函数，会在下一次useEffect执行之前，上一个被销毁时调用，可以用来销毁一些如定时器、事件监听</span>

:::details 点我查看代码
```js
import { useState, useEffect } from 'react';

const App = () => {
  const [count, setCount] = useState(0);

  useEffect(() => {
    const Timer = setInterval(() => {
      console.log(count);
    }, 1000)
    return () => {
      // 如果不清除的话，点击button之后，运行的定时器会越来越多，分别打印对应的count栈内存值
      clearInterval(Timer);
    }
  })
  return (
    <div>
      <p>you click {count} times</p>
      <button onClick={() => setCount(count + 1)}>click</button>
    </div>
  )
}

export default App;
```
:::

## useEffect模拟生命周期函数

<span class="span-info-message">模拟componentDidMount首次加载</span>

:::details 点我查看代码
```js
import { useState, useEffect } from 'react';

const App = () => {

  const [count, setCount] = useState(0);

  // 模拟componentDidMount
  useEffect(() => {
    console.log("App组件挂载完成");
  }, [])

  return (
    <div>
      <p>you click {count} times</p>
      <button onClick={() => setCount(count + 1)}>click</button>
    </div>
  )
}
export default App;
```
:::

<span class="span-info-message">模拟componentDidUpdate更新完毕</span>

:::details 点我查看代码
```js
import { useState, useEffect } from 'react';

const Home = (() => {

  // 判断组件更新与否
  let isUpdate = false;

  return () => {

    const [count, setCount] = useState(0);

    useEffect(() => {
      return () => {
        isUpdate = false;
      }
    }, [])

    // 模拟componentDidUpdate
    useEffect(() => {
      if (isUpdate) {
        console.log("组件更新了");
      } else {
        isUpdate = true;
      }
    });

    return (
      <div>
        <p>you click {count} times</p>
        <button onClick={() => setCount(count + 1)}>click</button>
      </div>
    )
  }
})()

const App = () => {
  const [isShow, setIsShow] = useState(true);
  return (
    <>
      {isShow ? <Home></Home> : null}
      <button onClick={() => setIsShow(!isShow)}>isShow?</button>
    </>
  )
}

export default App;
```
:::

<span class="span-info-message">模拟componentWillUnmout将要卸载</span>

:::details 点我查看代码
```js
import { useState, useEffect } from 'react';

const Home = () => {

  const [count, setCount] = useState(0);

  // 模拟componentWillUnmout
  useEffect(() => {
    return () => {
      console.log('Home组件销毁了');
    }
  }, []);

  return (
    <div>
      <p>you click {count} times</p>
      <button onClick={() => setCount(count + 1)}>click</button>
    </div>
  )
}

const App = () => {
  const [isShow, setIsShow] = useState(true);

  return (
    <>
      {isShow ? (<Home></Home>) : null}
      <button onClick={() => setIsShow(!isShow)}>显示/隐藏Home</button>
    </>
  )
}
export default App;
```
:::