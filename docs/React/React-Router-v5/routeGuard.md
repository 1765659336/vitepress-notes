## 路由守卫

:::details 点我查看示例代码
```js
import React from "react";

import { BrowserRouter, Route, Switch, Redirect } from 'react-router-dom';

const RenderComponet = (Content) => {
  class Component extends React.Component {

    render() {
      return (
        <div>{Content}</div>
      )
    }
  }

  Component.displayName = Content;

  return Component;
}

const Login = RenderComponet("Login");
const Error = RenderComponet("Error");
const Home = RenderComponet("Home");
const User = RenderComponet("User");
const Role = RenderComponet("Role");
const Page = RenderComponet("Page");

const NewsSandBox = props => {
  return (
    <Switch>
      {/* 精确匹配/，初次来到页面显示home组件 */}
      <Redirect from="/" to="/home" exact></Redirect>
      <Route path="/home" component={Home}></Route>
      <Route path="/manage/user" component={User}></Route>
      <Route path="/manage/role" component={Role}></Route>
      <Route path="/manage/page" component={Page}></Route>
      {/* 自定义未声明路径 */}
      <Route path="*" component={Error}></Route>
    </Switch>
  );
}

const App = () => {
  return (
    <BrowserRouter>
      {/* Switch路由精准匹配,路由守卫 */}
      <Switch>
        <Route path="/login" component={Login}></Route>
        <Route path="/" render={() => {
          // 可以在其中添加业务，比如动态渲染组件
          if (localStorage.getItem("token")) {
            return (
              <NewsSandBox></NewsSandBox>)
          } else {
            return (
              <Redirect to="/login"></Redirect>
            )
          }
        }}></Route>
      </Switch >
    </BrowserRouter >
  );
}

export default App;
```
:::