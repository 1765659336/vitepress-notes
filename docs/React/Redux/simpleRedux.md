# Redux中的store和reducer

## 不使用redux
我们通过一个求和案例来学习redux

:::details 点我查看不使用redux的求和案例
```js
import React, { Component } from 'react'

class Count extends Component {

	state = {count:0}

	//加法
	increment = ()=>{
		const {value} = this.selectNumber
		const {count} = this.state
		this.setState({count:count+value*1})
	}
	//减法
	decrement = ()=>{
		const {value} = this.selectNumber
		const {count} = this.state
		this.setState({count:count-value*1})
	}
	//奇数再加
	incrementIfOdd = ()=>{
		const {value} = this.selectNumber
		const {count} = this.state
		if(count % 2 !== 0){
			this.setState({count:count+value*1})
		}
	}
	//异步加
	incrementAsync = ()=>{
		const {value} = this.selectNumber
		const {count} = this.state
		setTimeout(()=>{
			this.setState({count:count+value*1})
		},500)
	}

	render() {
		return (
			<div>
				<h1>当前求和为：{this.state.count}</h1>
				<select ref={c => this.selectNumber = c}>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>&nbsp;
				<button onClick={this.increment}>+</button>&nbsp;
				<button onClick={this.decrement}>-</button>&nbsp;
				<button onClick={this.incrementIfOdd}>当前求和为奇数再加</button>&nbsp;
				<button onClick={this.incrementAsync}>异步加</button>&nbsp;
			</div>
		)
	}
}

export default class App extends Component {
	render() {
		return (
			<div>
				<Count/>
			</div>
		)
	}
}
```
:::

## 使用redux
先介绍一下需要用到的redux知识点

## reducer

reducer本质上就是一个普通的函数，第一个参数为上一次store中的值，第二个参数为store.dispatch()中的参数。reducer被第一次调用时，是store自动触发的，传递的preState是undefined,传递的action是:{type:'@@REDUX/INIT_a.2.b.4}将return的值作为新的store值。

```js

const initState = 0;

const countReducer = (preState = initState, action) => {
    // console.log(preState,action.data,action.type);
    const { type, data } = action

    switch (type) {
        case 'increment':
            return preState + data;
        case 'decrement':
            return preState - data;
        default:
            return preState
    }

}
```

## store
1. 通过createStore(reducer)创建仓库
2. 通过store.getState()获取仓库的数据
3. 通过store.subscribe()监测store中状态的改变
   
```js

import { createStore } from "redux";

// 接收一个reducer来创建仓库
const store = createStore(countReducer);

```

## 基本使用

使用store,reducer实现一个简易版的redux。
:::details 点我查看代码
```js
import React from "react";
import { createStore } from "redux";

// 第一次调用Reducer的时候，没有传值，不设置默认值那么就会是underfined
const initState = 0;

const countReducer = (preState = initState, action) => {
    // console.log(preState,action.data,action.type);
    const { type, data } = action

    switch (type) {
        case 'increment':
            return preState + data;
        case 'decrement':
            return preState - data;
        default:
            return preState
    }

}

const store = createStore(countReducer);

class Count extends React.Component {

    //加法
    increment = () => {
        const { value } = this.selectNumber
        store.dispatch({ type: 'increment', data: value * 1 })
    }
    //减法
    decrement = () => {
        const { value } = this.selectNumber
        store.dispatch({ type: 'decrement', data: value * 1 })
    }
    //奇数再加
    incrementIfOdd = () => {
        const { value } = this.selectNumber
        const count = store.getState()
        if (count % 2 !== 0) {
            store.dispatch({ type: 'increment', data: value * 1 })
        }
    }
    //异步加
    incrementAsync = () => {
        const { value } = this.selectNumber
        setTimeout(() => {
            store.dispatch({ type: 'increment', data: value * 1 })
        }, 500)
    }

    render() {
        return (
            <div>
                <h1>当前求和为：{store.getState()}</h1>
                <select ref={c => this.selectNumber = c}>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                </select>&nbsp;
                <button onClick={this.increment}>+</button>&nbsp;
                <button onClick={this.decrement}>-</button>&nbsp;
                <button onClick={this.incrementIfOdd}>当前求和为奇数再加</button>&nbsp;
                <button onClick={this.incrementAsync}>异步加</button>&nbsp;
            </div>
        )
    }

    // redux只会帮我们管理状态，并不会帮我们重新渲染组件，需要监听store中状态的改变，手动调用setState来重新渲染组件
    componentDidMount() {
        store.subscribe(() => {
            this.setState({})
        })
    }
}

const App = () => {
    return (
        <Count></Count>
    )
}

export default App;
```
:::

## 全局监听redux中状态的改变来重新渲染组件

我们在每个使用了redux的组件中都需要手动监听redux来重新渲染组件，代码量很大。我们可以在index.js中监测store中状态的改变，一旦发生改变重新渲染App组件，做到一劳永逸，并且因为react中有diff算法，带来的额外性能开销并不多。

```js
import React from 'react'
import ReactDOM from 'react-dom'
import App from './App'
import store from './redux/store'

ReactDOM.render(<App/>,document.getElementById('root'))

store.subscribe(()=>{
	ReactDOM.render(<App/>,document.getElementById('root'))
});
```