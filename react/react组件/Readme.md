## 组件的三种创建方式
```
方式1：函数组件
方式2：类组件
方式3：外部模块组件
```
`index.js`
```js
import React from 'react';
import ReactDOM from 'react-dom';


// 函数组件
// 格式：函数名大写、必须有返回值、渲染时可以是单标签也可以是双标签
// function Hello() {
// 	return ( 
// 		<h1>函数组件1</h1>
// 	)
// }

// const Hello = () => <h1>函数组件2</h1>



// 类组件
// 格式：类名也必须大写、碧玺有render方法且方法必须有返回值、必须继承React.Component类
// class Hello extends React.Component {
// 	render() {
// 		return <h1>类组件</h1>
// 	}
// }


// 组件模块化
import Hello from './Hello';

ReactDOM.render( < Hello / > , document.getElementById('root'));
```
`Hello.js`
```js
import React from 'react';

// 创建组件
class Hello extends React.Component {
	render() {
		return <h1>组件封装</h1>
	}
}

export default Hello
```

## 受控组件和非受控组件
```
受控组件的状态（组件内部的一些数据）要放在state中，通过setState()去修改
```
```js
import React from 'react';
import ReactDOM from 'react-dom';

// HTML中的表单元素是可输入的，也就是有自己的可变状态，而React中的可变状态通常保存在state中，并且只能通过setState()修改，最终React决定使用state来控制表单元素的值
// 文本框、富文本框、下拉框都是操作的value
// 复选框是操作checked
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

```
非受控组件则与受控组件相反，react组件不使用state去控制元素的状态
```

```js
import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
	constructor() {
	    super();
        // react废弃了this.$refs写法，使用React.createRef()后，通过ref的current属性将能得到dom节点或组件的实例
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

ReactDOM.render(<App/>,document.getElementById('root'))
```

## 有状态组件和无状态组件以及this指向的差别

```
// 函数组件又叫无状态组件，类组件又叫有状态组件
// 状态即为数据
// 函数组件没有自己的状态，只负责静态数据的展示,reacthook解决了这个问题，后面详细讲解
// 类组件有自己的状态，通常用来展示动态数据
```

```
// 1、使用箭头函数的this指向render()，render里面的this指向App组件，通过this.add()调用add，将render传递给add
// 2、通过constructor里面调用bind方法改变this指向
// 3、class实例方法是箭头函数,推荐使用
```

```js
import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
	// constructor() {
	//   super();
	// 	this.state = {
	// 		count: 0
	// 	}
	// }
	
	// 简便写法
	state = {
		count: 1
	}
	
    // 2----------------------------------
	// constructor() {
	// 	super();
	// 	this.add = this.add.bind(this);
	// }
	
	// add(){
	// 	this.setState({
	// 		count: this.state.count + 1,
	// 	})
	// }
    // -----------------------------------
	
    
    // 3----------------------------------
	add = () => {
		this.setState({
			count: this.state.count + 1,
		})
	}
    // -----------------------------------
	
	render(){
		// 状态是可变的，不能直接修改state的值，这样子只会修改值不会更新UI。setState()的作用修改state、更新UI.思想：数据驱动视图
		return (<div>
							<span>数据为:{this.state.count}</span>
							// 1、使用箭头函数的this指向render()，render里面的this指向App组件，通过this点add()调用add，将render传递给add
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

## 组件通信

### props的基本使用

```js
import React from 'react';
import ReactDOM from 'react-dom';

// function App(props) {
// 	return (
// 		<div>{props.name}</div>
// 	)
// }

// ReactDOM.render(<App name="jack" age={18} />,document.getElementById('root'))


class App extends React.Component {
	render(){
		return (
			<h1>{this.props.name}</h1>
		)
	}
}

ReactDOM.render(<App name="jack" age={18} />,document.getElementById('root'))
```

### props的特点

```js
import React from "react";
import ReactDOM from "react-dom";

class Hello extends React.Component {
  // 3、特点3,如果不将props传递给super，那么就无法在constructor中使用this.props
  constructor(props) {
    super(props);
    console.log(this.props);
  }

  render() {
    console.log(this.props);
    this.props.fn();
    // 报错：Cannot assign to read only property 'name' of object '#<Object>' 特点2不能修改props的值
    // this.props.name = 'liujie';
    return (
      <div>
        <h1> props.name: {this.props.name} </h1>{" "}
        <h1> props.age: {this.props.age} </h1> <h1> {this.props.arr[0]} </h1>{" "}
        {this.props.tag}{" "}
      </div>
    );
  }
}

// 特点1，可以传入任意类型的数据
ReactDOM.render(
  <Hello
    name="rose"
    age={19}
    arr={["red", "green", "blue"]}
    fn={() => {
      console.log("hahaha");
    }}
    tag={<h1> Tag </h1>}
  />,
  document.getElementById("root")
);
```

### props校验

```
也可以使用ts来做校验
```

```js
import React from 'react';
import ReactDOM from 'react-dom';
import propTypes from 'prop-types';

/*props校验
使用步骤：1、安装包prop-types (npm install prop-types)
2、引入包
3、使用组件名.propTypes = {}的对象方式来给组件添加校验规则
4、校验规则是通过propTypes对象的属性来约束
*/ 

const App = props => {
	return (
		<h1>{props.colors}</h1>
	)
}

/*常见的约束规则
1、常见类型：propTypes.array、propTypes.bool、propTypes.func、propTypes.number、propTypes.object、propTypes.string
2、React元素类型：.element
3、必填项：在指定类型后面再.isRequired
4、特定结构的对象propTypes.shape({
	xxx: propTypes.string,
	xx: propTypes.number
})
*/
// 添加校验
App.propTypes = {
	// 约定colors的类型为数组的形式
	colors:propTypes.array
}

ReactDOM.render(<App colors={['red','green','blue']}/>,document.getElementById('root'));
```

### props默认值

```js
import React from 'react';
import ReactDOM from 'react-dom';

/*给props对象的一些属性设置默认值*/
 
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

### 父传子props

```js
import React from 'react';
import ReactDOM from 'react-dom';

class Parent extends React.Component {

	state = {
		lastName: '杰'
	}

	render() {
		return (<>
			<Son name={this.state.lastName}></Son>
			<Son2 name={this.state.lastName}></Son2></>)
	}

}

const Son = props => {
	return (<h1>{props.name}</h1>)
}

class Son2 extends React.Component {

	state = {
		name: this.props.name
	}

	render() {
		return (<h1>{this.state.name}</h1>)
	}
}

ReactDOM.render(<Parent />, document.getElementById('root'));
```

### 子传父function

```
父组件给子组件传递一个方法，子组件调用这个方法时，将这个数据作为方法的参数传递给父组件
```

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

### 兄弟之间通信

```
原理：结合父传子和子传父的知识，让其他们共同的父亲作为通讯站，来实现组件之间的通信
实现：传递组件
```

```js
import React from 'react';
import ReactDOM from 'react-dom';

class Parent extends React.Component {

	state = {
		sonCount: 0
	}

	add = (value) => {
		console.log(value);
		this.setState({ sonCount: value });
	}

	render() {
		return (
			<div>
				<Child1 count={this.state.sonCount} />
				<Child2 add={this.add} />
			</div>
		)
	}
}

const Child1 = (props) => {
	return (
		<h1>{props.count}</h1>
	)
}

class Child2 extends React.Component {
	state = {
		count: 1
	}
	render() {
		return (
			<button onClick={() => { this.props.add(this.state.count) }}>传值</button>
		)
	}
}

ReactDOM.render(<Parent />, document.getElementById('root'))
```

### 多代传递

```
使用react的Provider发送数据，Consumer接收数据
！！！注意：Consumer会去匹配最近的祖先（含Provider的）拿数据
```

```js
import React from 'react';
import ReactDOM from 'react-dom';

const { Provider, Consumer } = React.createContext();

class App extends React.Component {
	state = {
		data: { a: 1, b: 2 },
	}

	render() {
		return (
			<Provider value={this.state.data}>
				<First></First>
			</Provider>
		)
	}
}

function First() {
	return (
		<Second></Second>
	)
}

function Second() {
	return (
		<Consumer>
			{data => <h1>{data.a}-{data.b}</h1>}
		</Consumer>
	)
}

ReactDOM.render(<App />, document.getElementById('root'))
```

### props.children属性

```
// children属性：表示组件标签的子节点。当组件标签有子节点时，props对象就会有children属性，children的值可以是任意值（文本、标签、组件、甚至是函数）
```

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