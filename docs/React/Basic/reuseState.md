## render-props模式

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

class App extends React.Component {
	render(){
		return (
			<div>
				<h1>render-props模式</h1>
				<Mouse render={(mouse) => {
					return (
							<p>
								鼠标位置:{mouse.x},{mouse.y}
							</p>
						)
				}}></Mouse>
			</div>
		)
	}
}

class Mouse extends React.Component {
	state = {
		x: 0,
		y: 0
	}
	
	render(){
		return this.props.render(this.state)
	}
	
	handleMousemove = e => {
		this.setState({
			x:e.clientX,
			y:e.clientY
		})
	}
	
	componentDidMount() {
		window.addEventListener('mousemove',this.handleMousemove)
        
	componentWillUnmount(){
		window.removeEventListener('mousemove',this.handleMousemove)
	}
}

Mouse.propTypes = {
	children: propTypes.func.isRequired
}
	
}

ReactDOM.render(<App></App>,document.getElementById('root'));
```
:::

## render-children模式

:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';
import propTypes from 'prop-types';

class App extends React.Component {
	render(){
		return (
			<div>
				<h1>children模式</h1>
				<Mouse>
					{(mouse) => {
						return (
								<p>
									鼠标位置:{mouse.x},{mouse.y}
								</p>
							)
					}}
				</Mouse>
			</div>
		)
	}
}

class Mouse extends React.Component {
	state = {
		x: 0,
		y: 0
	}
	
	render(){
		return this.props.children(this.state)
	}
	
	handleMousemove = e => {
		this.setState({
			x:e.clientX,
			y:e.clientY
		})
	}
	
	componentDidMount() {
		window.addEventListener('mousemove',this.handleMousemove)
	}
	
	componentWillUnmount(){
		window.removeEventListener('mousemove',this.handleMousemove)
	}
}

Mouse.propTypes = {
	children: propTypes.func.isRequired
}

ReactDOM.render(<App></App>,document.getElementById('root'));
```
:::

## 高阶组件
:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

// 高阶组件函数
function withMouse(WrappedComponent){
	// 创建提供复用属性的组件
	class Mouse extends React.Component {
		state = {
			x: 0,
			y: 0
		}
		
		render(){
			return (
				<WrappedComponent {...this.state} {...this.props}></WrappedComponent>
			)
		}
		
		handleMousemove = e => {
			this.setState({
				x: e.clientX,	
				y: e.clientY
			})
		}
		
		componentDidMount(){
			window.addEventListener('mousemove',this.handleMousemove)
		}
		
		componentWillUnmount(){
			window.removeEventListener('mousemove',this.handleMousemove)
		}
	}
	
	// 设置displayName，解决组件重名的问题
	Mouse.displayName = `WithMouse${getDisplayName(WrappedComponent)}`
	
	return Mouse
}

// 给被增强的组件命名函数
function getDisplayName(WrappedComponent) {
	return WrappedComponent.displayName || WrappedComponent.name || 'Component';
}

// 被增强的组件
class Position extends React.Component {
	render(){
		return (
			<p>鼠标的x坐标:{this.props.x}鼠标的y坐标:{this.props.y}</p>
		)
	}
}

const WrappedPositon = withMouse(Position);

class App extends React.Component {
	render(){
		return(
			<div>
				<h1>高阶组件</h1>
				<WrappedPositon></WrappedPositon>
			</div>
		)
	}
}

ReactDOM.render(<App></App>,document.getElementById('root'))
```
:::