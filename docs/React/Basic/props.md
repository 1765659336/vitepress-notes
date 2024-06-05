## props
1. 可以给组件传递任意类型的数据，包括JSX 
2. 不能在组件中<span class="span-warning-message">"直接"</span>修改props的值，props是只读属性，不能修改props对象
3. 如果不将props传递给super，那么就无法在constructor中使用this.props

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

class Hello extends React.Component {

	// 3、特点3,如果不将props传递给super，那么就无法在constructor中使用this.props
	constructor(props) {
	  super(props);
		console.log(this.props);
	}
	
	render(){
		console.log(this.props);
		this.props.fn();
		// Cannot assign to read only property 'name' of object '#<Object>' 特点2不能修改props的值
		// this.props.name = 'liujie';
		return (
			<div>
				<h1>props.name:{this.props.name}</h1>
				<h1>props.age:{this.props.age}</h1>
				<h1>{this.props.arr[0]}</h1>
				{this.props.tag}
			</div>
		)
	}
}

// 特点1，可以传入任意类型的数据
ReactDOM.render(<Hello name="rose" age={19} arr={['red','green','blue']} fn={()=>{console.log('hahaha')}} tag={<h1>Tag</h1>}/>,document.getElementById('root'))
```
:::

## props校验
1. 安装包prop-types (npm install prop-types)
   1. 引入包
   2. 使用组件名.propTypes = {}的对象方式来给组件添加校验规则
   3. 校验规则是通过propTypes对象的属性来约束

2. 常见的约束规则
   1. 常见类型：propTypes.array、propTypes.bool、propTypes.func、propTypes.number、propTypes.object、propTypes.string
   2. React元素类型：.element
   3. 必填项：在指定类型后面再.isRequired
   4. 特定结构的对象propTypes.shape({
	xxx: propTypes.string,
	xx: propTypes.number
})

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';
import propTypes from 'prop-types';

const App = props => {
	return (
		<h1>{props.colors}</h1>
	)
}

App.propTypes = {
	// 约定colors的类型为数组的形式
	colors:propTypes.array
}

ReactDOM.render(<App colors={['red','green','blue']}/>,document.getElementById('root'));
```
:::

## props默认值
通过App.defaultProps给props设置默认值

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
	render(){
		return (
			<h1>props对象的默认值:{this.props.data}</h1>
		)
	}
}

App.defaultProps = {
	data:10
}

ReactDOM.render(<App />,document.getElementById('root'));
```
:::