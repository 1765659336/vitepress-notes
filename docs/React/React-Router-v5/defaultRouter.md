## 默认路由

浏览器首次渲染应用时，会前往"/"路由地址，因此我们给"/"设置匹配的component就可以实现默认跳转的页面组件

:::details 点我查看代码
```js
import React from 'react';
import {BrowserRouter as Router , Route} from 'react-router-dom';

const App = () => (
	<Router>
		<p>首页</p>
		<Route path="/" component={Login}></Route>
	</Router>
)

class Login extends React.Component {
	render(){
		return (
			<div>
				<p>登录页面</p>
			</div>
		)
	}
}

export default App;
```
:::

<span class="span-warning-message">需要注意的是，因为react使用的是模糊匹配，所以上述案例不管输入什么路径都会跳转到"/login"</span>