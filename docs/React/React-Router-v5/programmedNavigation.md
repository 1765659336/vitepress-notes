## 编程式导航

编程式导航：通过 JS 代码来实现页面跳转

history 是 React 路由提供的，用于获取浏览器历史记录的相关信息

push(path)：跳转到某个页面，参数 path 表示要跳转的路径

go(n)： 前进或后退到某个页面，参数 n 表示前进或后退页面数量（比如：-1 表示后退到上一页）

:::details 点我查看代码
```js
import React from 'react';
import { BrowserRouter as Router , Route , Link } from 'react-router-dom';

class Login extends React.Component {
	handleLogin = () => {
		this.props.history.push('/home')
	}
	
	render(){
		return (
			<diV>
				<p>登录页面</p>
				<button onClick={this.handleLogin}>前往首页</button>
			</diV>
		)
	}
}

const Home = props => {

	const handleHome = () => {
		props.history.go(-1)
	}
	
	return (
		<div>
			<p>首页</p>
			<button onClick={handleHome}>前往登录页面</button>
		</div>
	)
}

const App = () => (
	<Router>
		<Link to="/login">前往登录</Link>
		<Route path="/login" component={Login}></Route>
		<Route path="/home" component={Home}></Route>
	</Router>
)

```
:::