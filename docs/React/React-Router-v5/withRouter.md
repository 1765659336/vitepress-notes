# withRouter

<span class="span-info-message">将一般组件也能拿到路由组件的props</span>

## 路由组件

  - 被BrowserRouter/HashRouter包裹的组件，并且被路由规则匹配上的路由组件，props中能拿到路由信息
  - 被BrowserRouter/HashRouter包裹的组件，而没有被路由规则匹配上的组件不能从props中拿到路由信息，但是当我们用withRouter将一般组件包裹一下，则可以拿到

:::details 点我查看代码
```js
import React from 'react';
import { BrowserRouter, Route, Switch, withRouter } from 'react-router-dom';

const Out = (props) => {
  const { go, push } = props.history;
  return (
    <>
      Out
      <button onClick={() => go(-1)}>go(-1)</button>
      <button onClick={() => push("/son1")}>push("/son1")</button>
    </>
  )
}

const WOut = withRouter(Out);

const Son1 = (props) => {

  const { go, push } = props.history;

  return (
    <>
      Son1
      <button onClick={() => go(-1)}>go(-1)</button>
      <button onClick={() => push("/son2")}>push("/son2")</button>
    </>
  )
}

const Son2 = (props) => {

  const { go, push } = props.history;

  return (
    <>
      Son2
      <button onClick={() => go(-1)}>go(-1)</button>
      <button onClick={() => push("/son1")}>push("/son1")</button>
    </>
  )
}

const App = () => {

  return (
    <>
      <BrowserRouter>
        <WOut></WOut>
        <Switch>
          <Route exact path="/" component={Son1} ></Route>
          <Route path="/son1" component={Son1} ></Route>
          <Route path="/son2" component={Son2} ></Route>
        </Switch>
      </BrowserRouter>
    </>
  )
}

export default App;
```
:::