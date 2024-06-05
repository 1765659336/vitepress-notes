## 精准匹配

react路由匹配机制是模糊匹配，也就是Route组件中配置的path字符串是以Link中to的字符串开头，就可以匹配的上。
会导致，react路由从上往下解析时，如果模糊匹配上了会渲染出来

:::details 点我查看演示
```js
import React from 'react';
import {BrowserRouter as Router , Route , Link} from 'react-router-dom';

class Default extends React.Component {
	render(){
		return (
			<p>默认路由</p>
		)
	}
}

class Second extends React.Component {
	render(){
		return (
			<p>第二个页面</p>
		)
	}
}


const App = () => (
	<Router>
		<Link to = "second">前往第二个页面</Link>
		<Route path = '/' component = {Default}></Route>
		<Route path = '/second' component = {Second}></Route>
	</Router>
)

export default App;
```
:::

<span class="span-warning-message">如果我们在浏览器中输入/second路径，默认路由还是会被渲染出来</span>

<span class="span-info-message">给 Route 组件添加 exact 属性，让其变为精确匹配模式。精确匹配：只有当 path 和 pathname 完全匹配时才会展示该路由</span>

:::details 点我查看代码
```js
import React from 'react';
import {BrowserRouter as Router , Route , Link} from 'react-router-dom';

class Default extends React.Component {
	render(){
		return (
			<p>默认路由</p>
		)
	}
}

class Second extends React.Component {
	render(){
		return (
			<p>第二个页面</p>
		)
	}
}


const App = () => (
	<Router>
		<Link to = "second">前往第二个页面</Link>
		<Route exact path = '/' component = {Default}></Route>
		<Route path = '/second' component = {Second}></Route>
	</Router>
)

export default App;
```
:::