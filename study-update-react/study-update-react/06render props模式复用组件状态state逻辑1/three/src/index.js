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
	
	// 优化2：在组件卸载时，删除监听事件
	componentWillUnmount(){
		window.removeEventListener('mousemove',this.handleMousemove)
	}
}

// 优化1：给Mount组件添加校验
Mouse.propTypes = {
	children: propTypes.func.isRequired
}

ReactDOM.render(<App></App>,document.getElementById('root'));