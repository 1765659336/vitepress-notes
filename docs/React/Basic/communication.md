## 组件通信

## 父传子
函数组件通过props接收，类组件通过this.props接收

:::details 点我查看代码
```js
import React from 'react';

const GrandFather = () => {
    return (
        <Parent name="杰"/>
    )
}

class Parent extends React.Component {

    render() {
        return (<Son name={this.props.name}></Son>)
    }

}

const Son = props => {
    return (<h1>{props.name}</h1>)
}

export default GrandFather;
```
:::

## 子传父
父组件传递一个函数给子组件，子组件通过函数形参接收实参的方式传递给父组件数据
:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

class Parent extends React.Component {
	
	fn = data => {
		console.log('子组件的数据：',data)
	}
	
	render(){
		return (
			<Son func={this.fn} />
		)
	}
}

class Son extends React.Component {
	state = {
		name:'爸爸'
	}
	render(){
		return (
			<h1>{this.props.func(this.state.name)}</h1>
		)
	}
}

ReactDOM.render(<Parent/>,document.getElementById('root'))
```
:::

## 兄弟通信
兄弟组件通过他们的共同父亲中定义一个函数来接收子组件传递的数据，然后通过props传递给另外一个子组件,实际上就是父传子和子传父的结合

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

class Parent extends React.Component {
	state = {
		count: 1
	}
	
	add = () => {
		this.setState({
			count:this.state.count + 1
		})
	}
	
	render(){
		return (
			<div>
				<Child1 count={this.state.count}/>
				<Child2 add={this.add}/>
			</div>
		)
	}
}

const Child1 = (props) => {
	return (
		<h1>{props.count}</h1>
	)
}

function Child2(props) {
	return (
		<button onClick={() => {props.add()}}>+1</button>
	)
}

ReactDOM.render(<Parent/>,document.getElementById('root'))
```
:::

## 多级组件通信Context
Consumer会根据组件的嵌套层级逐级的往上查找，去匹配查找到的第一个Provider

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

const {Provider,Consumer} = React.createContext();

class App extends React.Component {
	state = {
		data: '爸爸'
	}
	
	render(){
		return (
			<Provider value={this.state.data}>
				<First></First>
			</Provider>
		)
	}
}

function First(){
	return (
		<Second></Second>
	)
}

function Second(){
	return (
		<Consumer>
			{data => <h1>{data}</h1>}
		</Consumer>
	)
}

ReactDOM.render(<App />,document.getElementById('root'))
```

## props.children通信
children属性：表示组件标签的子节点。当组件标签有子节点时，props对象就会有吃了children属性，children的值可以是任意值（文本、标签、组件、甚至是函数）

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
	render(){
		return (<h1>{this.props.children}</h1>)
	}
}

ReactDOM.render(<App>我是App标签的子节点</App>,document.getElementById('root'));
```
:::