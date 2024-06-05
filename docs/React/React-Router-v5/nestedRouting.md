## 嵌套路由

多级路由的实现

:::details 点我查看代码
```js
import React from 'react';
import { BrowserRouter as Router , Route , Link } from 'react-router-dom';

/* 
	使用 Router 组件包裹整个应用
*/

class App extends React.Component {
	render(){
		return (
			<Router>
				<div>
					<h1>路由的基本使用</h1>
					<Link to="/first">页面一</Link>
					<Route path="/first" component={First}></Route>
				</div>
			</Router>
		)
	}
}

const First = () => (<div>
	<Link to="/first/second">页面二</Link>
	<Route path="/first/second" component={Second}></Route>
	<p>页面一的内容</p>
</div>)

const Second = () => <p>页面二的内容</p>

export default App;
```
:::