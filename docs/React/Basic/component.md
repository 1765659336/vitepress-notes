## 函数式组件
<div class="div-warning-message animate__animated animate__zoomInDown">
    函数名大写、必须有返回值、因为如果是小写开头的标签，react解析会将组价识别成html标签，从而找不到。
</div>

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

// 函数组件
// function Hello() {
// 	return ( 
// 		<h1>函数组件1</h1>
// 	)
// }

const Hello = () => <h1>函数组件2</h1>

ReactDOM.render(<Hello/>,document.getElementById('root'));
```
:::

## 类组件

:::details 点我查看代码
```js
class Hello extends React.Component {
	render() {
		return <h1>组件封装</h1>
	}
}
```
:::

## 有状态组件
+ 类组件又叫有状态组件,状态即为数据。
+ 状态是可变的，不能直接修改state的值，这样子只会修改值不会更新UI。
+ setState()的作用修改state、更新UI。<span class="span-warning-message">有三种方式绑定this</span>
+ 思想：数据驱动视图。
:::details 点我查看到代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
	// constructor(props) {
	//   super(props);
	// 	this.state = {
	// 		count: 0
	// 	}
	// }
	
	// 简便写法
	state = {
		count: 1
	}
	
    // 绑定this方法1
	// constructor(props) {
	// 	super(props);
	// 	this.add = this.add.bind(this);
	// }

    // 绑定this方法2
	// add(){
	// 	this.setState({
	// 		count: this.state.count + 1,
	// 	})
	// }
	
    // 绑定this方法3
	add = () => {
		this.setState({
			count: this.state.count + 1,
		})
	}
	
	render(){
		return (<div>
                    <span>数据为:{this.state.count}</span>
                    // 1、使用箭头函数的this指向render()，render里面的this指向App组件，通过this.add()调用add
                    // <button onClick={()=>this.add()}>+1</button>
                    
                    
                    // 2、通过constructor里面调用bind方法改变this指向
                    // <button onClick={this.add}>+1</button>
                    
                    
                    // 3、class实例方法是箭头函数,推荐使用
                    <button onClick={this.add}>+1</button>
                </div>)
	}
}

ReactDOM.render(<App/>,document.getElementById('root'))
```
:::

## 无状态组件
+ 函数组件又叫无状态组件
+ 函数组件中的this指向undefined,因为react会使用babel来解析函数式组件，babel会开启严格模式，严格模式下的箭头函数this指向undefined
:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

const Hello = () => {
    console.log(this); // undefined
    return (<h1>函数组件2</h1>)
}

ReactDOM.render(<Hello/>,document.getElementById('root'));
```
:::

## 表单处理(受控组件)
+ HTML中的表单元素是可输入的，也就是有自己的可变状态，而React中的可变状态通常保存在state中，并且只能通过setState()修改，最终React决定使用state来控制表单元素的值
+ 文本框、富文本框、下拉框都是操作的value
+ 复选框是操作checked

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
	
	state = {
		txt: '',
		city: 'bj',
		isChecked: false
	}
	
	bandleChange = e => {
		const target = e.target;
		const value = target.type === 'checkbox' ? target.checked : target.value
		const name = target.name
		this.setState({
			[name]: value
		})
	}
	
	render() {
		return (
			<div>
			<input name="txt" type="text" value={this.state.txt} onChange={this.bandleChange} />
			<select name="city" value={this.state.city} onChange={this.bandleChange}> <option value="bj">北京</option> <option value="sh">上海</option> <option value="sz">深圳</option> </select>
			<input type="checkbox" name="isChecked" value={this.state.isChecked} onChange={this.bandleChange}/>
			</div>
		)
	}
}

ReactDOM.render(<App/>,document.getElementById('root'))
```
:::

## 非受控组件

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
	constructor(props) {
	    super(props);
			this.Reftxt = React.createRef();
	}
	
	getTxt = () => {
		console.log('文本内容为：',this.Reftxt.current.value);
	}
	
	render(){
		return (
			<div>
				<input type="text" ref={this.Reftxt} />
				<button type="button" onClick={this.getTxt}>获取文本框的值</button>
			</div>
		)
	}
}

ReactDOM.render(<App/>,document.getElementById('root'));
```
:::