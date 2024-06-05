# Redux中的actions
完善之前的求和案例，将之前dispatch中的参数抽离成一个个的action,并使用redux-thunk处理异步的action

## action

新增一个文件，专门用来存放action函数，做到action统一管理
新增一个文件，专门用来存放所有的action函数名，做到多处使用action时，修改名称，只需要改一处即可

## async_action 异步action
延迟的动作不想交给组件自身，想交给action，比如想要对状态进行操作，但是具体的数据靠异步任务返回。
此时，可以使用redux-thunk
`npm i redux-thunk`
并配置在store中
1. 从redux中引入applyMiddleware执行中间件，引入redux-thunk（默认暴露方式）将applyMiddleware()作为createStore()的第二个参数，并将redux-thunk默认暴露的对象作为applyMiddleware()的参数
2. 创建action的函数不再返回一般对象，而是一个函数，该函数中写异步任务。
3. 异步任务有结果后，分发一个同步的action去真正操作数据。

:::details 点我查看代码
```js
import React from "react";
import { createStore, applyMiddleware } from 'redux'
import thunk from 'redux-thunk'

/* 
    该模块是用于定义action对象中type类型的常量值，目的只有一个：便于管理的同时防止程序员单词写错
*/
const INCREMENT = 'increment'
const DECREMENT = 'decrement'

/* 
    专门为Count组件生成action对象
*/

//同步action，就是指action的值为Object类型的一般对象
const createIncrementAction = data => ({ type: INCREMENT, data })
const createDecrementAction = data => ({ type: DECREMENT, data })

//异步action，就是指action的值为函数,异步action中一般都会调用同步action，异步action不是必须要用的。
const createIncrementAsyncAction = (data, time) => {
    return (dispatch) => {
        setTimeout(() => {
            dispatch(createIncrementAction(data))
        }, time)
    }
}

/* 
    1.用于创建一个为Count组件服务的reducer，reducer的本质就是一个函数
    2.reducer函数会接到两个参数，分别为：之前的状态(preState)，动作对象(action)
*/

const initState = 0 //初始化状态
function countReducer(preState = initState, action) {
    // console.log(preState);
    //从action对象中获取：type、data
    console.log(action);
    const { type, data } = action
    //根据type决定如何加工数据
    switch (type) {
        case INCREMENT: //如果是加
            return preState + data
        case DECREMENT: //若果是减
            return preState - data
        default:
            return preState
    }
}

export const store = createStore(countReducer, applyMiddleware(thunk));

class Count extends React.Component {

    state = { carName: '奔驰c63' }

    //加法
    increment = () => {
        const { value } = this.selectNumber;
        store.dispatch(createIncrementAction(value * 1))
    }
    //减法
    decrement = () => {
        const { value } = this.selectNumber
        store.dispatch(createDecrementAction(value * 1))
    }
    //奇数再加
    incrementIfOdd = () => {
        const { value } = this.selectNumber
        const count = store.getState()
        if (count % 2 !== 0) {
            store.dispatch(createIncrementAction(value * 1))
        }
    }
    //异步加
    incrementAsync = () => {
        const { value } = this.selectNumber
        // setTimeout(()=>{
        store.dispatch(createIncrementAsyncAction(value * 1, 500))
        // },500)
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
}

export const App = () => {
    return (
        <Count></Count>
    )
}
```
:::