## HashRouter/BrowserRouter 组件

路由模式，路由匹配规则组件，包裹整个应用，一个 React 应用只需要使用一次

HashRouter：使用 URL 的哈希值实现（localhost:3000/#/first）
 
BrowserRouter<span class="span-info-message">（推荐使用）</span>：使用 H5 的 history API 实现（localhost:3000/first）

## Link 组件

用于指定导航链接（a 标签）
1. to属性 字符串形式跳转的路径，对象形式{pathname,state}pathname跳转的路径，state传递的state路由参数
2. replace属性 使用replace还是push模式

```js
	<Link to="/first">页面一</Link>
	<Link to="/first" replace>页面一</Link>
```
## NavLink

1. to属性 字符串形式跳转的路径，对象形式{pathname,state}pathname跳转的路径，state传递的state路由参数
2. replace属性 使用replace还是push模式
3. activeClassName 高亮类名，默认为active

:::details 点我查看代码
```js
import { Link, NavLink, Route } from "react-router-dom";

const Home = () => {
  return (
    <>
      Home
    </>
  )
}

const About = () => {
  return (
    <>
      About
    </>
  )
}

const Index = () => {
  return (
    <div>
      Index
      <Link to="/home" replace>home</Link>
      <NavLink to="about" activeClassName="App-link">about</NavLink>
    </div>
  )
}

const App = () => {

  return (
    <>
      <Index></Index>
      <Route path="/home" component={Home}></Route>
      <Route path="/about" component={About}></Route>
    </>
  )
}

export default App;
```
:::

## Route 组件

指定路由展示组件相关信息
path属性：路由规则
component属性：展示的组件
exact：开启精准匹配
Route组件写在哪，渲染出来的组件就展示在哪
```js
	<Route path="/first" component={First}></Route>
```

## Switch

渲染第一个被location匹配到的并且作为子元素的Route组件或者Redirect组件

:::details 点我查看代码
```js
import { Link, Route, Switch } from "react-router-dom";

const Home = () => {
  return (
    <>
      Home
    </>
  )
}

const About = () => {
  return (
    <>
      About
    </>
  )
}

const Index = () => {
  return (
    <div>
      Index
      <Link to="/about">about</Link>
    </div>
  )
}

const App = () => {

  return (
    <>
      <Index></Index>
      <Switch>
		{/* 当路径是/about时，渲染的组件是Home，因为Switch只会匹配一个，然后Route匹配规则默认是模糊匹配，/也是/about的开头 */}
        <Route path="/" component={Home}></Route>
        <Route path="/about" component={About}></Route>
      </Switch>
    </>
  )
}

export default App;
```

## Redirect
路由重定向

1. from属性匹配到的路径
2. to属性跳转的路径

:::details 点我查看代码
```js
import { Link, Route, Switch, Redirect } from "react-router-dom";

const Home = () => {
  return (
    <>
      Home
    </>
  )
}

const About = () => {
  return (
    <>
      About
    </>
  )
}

const Index = () => {
  return (
    <div>
      Index
      <Link to="/about">about</Link>
    </div>
  )
}

const App = () => {

  return (
    <>
      <Index></Index>
      <Switch>
        <Redirect from="/" to="/home" exact></Redirect>
        <Route path="/home" component={Home}></Route>
        <Route path="/about" component={About}></Route>
      </Switch>
    </>
  )
}

export default App;
```
:::