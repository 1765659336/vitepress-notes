# 路由参数

## params参数

1. Route组件path路径中声明占位符
2. params参数直接写在路径中
3. 在props.match.params中接收

:::details 点我查看代码
```js
import { Link, Route, Switch } from "react-router-dom";


const Message = (props) => {
  const { id, title, content } = props.match.params;
  return (
    <>
      {id + "-" + title + "-" + content}
    </>
  )
}

const Index = () => {

  const messages = [
    {
      id: "001",
      title: "title1",
      content: 'content1'
    },
    {
      id: "002",
      title: "title2",
      content: 'content2'
    },
    {
      id: "003",
      title: "title3",
      content: 'content3'
    }
  ]

  return (
    <ul>
      {
        messages.map(item =>
          <li key={item.id}>
            <Link to={`/message/${item.id}/${item.title}/${item.content}`}>{item.title}</Link>
          </li>
        )
      }
    </ul>
  )
}

const App = () => {

  return (
    <>
      <Index></Index>
      <Switch>
        <Route path="/message/:id/:title/:content" component={Message}></Route>
      </Switch>
    </>
  )
}

export default App;
```
:::

## search参数

1. Route组件中不需要占位
2. Link组件中传递参数
3. props.location.search获取参数字符串

:::details 点我查看代码
```js
import { Link, Route, Switch } from "react-router-dom";


const Message = (props) => {
  const qs = props.location.search;
  const searchData = {};
  qs.slice(1).split('&').map(item => {
    const data = item.split("=");
    searchData[data[0]] = data[1]
  })
  const { id, title, content } = searchData;
  return (
    <>
      {id + "-" + title + "-" + content}
    </>
  )
}

const Index = () => {

  const messages = [
    {
      id: "001",
      title: "title1",
      content: 'content1'
    },
    {
      id: "002",
      title: "title2",
      content: 'content2'
    },
    {
      id: "003",
      title: "title3",
      content: 'content3'
    }
  ]

  return (
    <ul>
      {
        messages.map(item =>
          <li key={item.id}>
            <Link to={`/message?id=${item.id}&title=${item.title}&content=${item.content}`}>{item.title}</Link>
          </li>
        )
      }
    </ul>
  )
}

const App = () => {

  return (
    <>
      <Index></Index>
      <Switch>
        <Route path="/message" component={Message}></Route>
      </Switch>
    </>
  )
}

export default App;
```
:::

## state参数

1. Route组件中不需要占位
2. Link组件to属性使用对象的形式
3. 使用props.location.state接收

<span class="span-warning-message">当使用BrowserRouter包裹整个路由组件的时候，直接刷新浏览器，不会丢失state路由参数，因为BrowserRouter是基于浏览器history实现的，会被state路由参数会被缓存起来。但是，当使用HashRouter组件时，刷新浏览器会丢失state路由参数。</span>

:::details 点我查看代码

```js
import { Link, Route, Switch } from "react-router-dom";


const Message = (props) => {

  console.log(props);

  // 当使用HashRouter组件时，直接刷新浏览器会丢失state，避免程序执行错误
  const { id, title, content } = props.location.state || { id: undefined, title: undefined, content: undefined };
  return (
    <>
      {id + "-" + title + "-" + content}
    </>
  )
}

const Index = () => {

  const messages = [
    {
      id: "001",
      title: "title1",
      content: 'content1'
    },
    {
      id: "002",
      title: "title2",
      content: 'content2'
    },
    {
      id: "003",
      title: "title3",
      content: 'content3'
    }
  ]

  return (
    <ul>
      {
        messages.map(item =>
          <li key={item.id}>
            <Link to={{ pathname: "/message", state: item }}>{item.title}</Link>
          </li>
        )
      }
    </ul >
  )
}

const App = () => {

  return (
    <>
      <Index></Index>
      <Switch>
        <Route path="/message" component={Message}></Route>
      </Switch>
    </>
  )
}

export default App;
```
:::