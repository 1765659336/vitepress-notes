## {}Mustache模板语法
1. react自动配置了babel,能够将jsx解析成ECMAScript语法，推荐使用()包括起来
2. react 中的Mustache语法是单{} vue中是{{}} 括号中可以放任意的表达式，jsx自身也是js表达式 
3. 因为react是单{}，与对象的写法起冲突了，所以是不能在{}Mustache语法中出现对象的，只在style中出现 不能出现的语句如for循环、if判断
:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';
const name = 'react';
const title = ( <h1 className = 'title'>hello {name}<span/></h1>);
ReactDOM.render(title, document.getElementById('root'));
```
:::
## 条件渲染
1. if-eles
2. 三元表达式
3. 逻辑运算符
:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

// if-eles
const data1 = (isLoading) => {
	if(isLoading){
		return <div>数据</div>
	}
	
	return <div>加载中</div>
}

// 三元表达式
const data2 = (isLoading) => {
	return isLoading ? <div>数据</div> : <div>加载中</div>
}

// 逻辑运算符，只能展示一个
const data3 = (isLoading) => {
	return isLoading && <div>数据</div>
}

const title = (
	<div>
		{data1(true)}
		{data2(false)}
		{data3(false)}
	</div>
)

ReactDOM.render(title,document.getElementById('root'))
```
## 列表渲染
:::details 点我查看代码
```js
import React from 'react';
import ReactDOM from 'react-dom';

const data = [
	{id:1,value:111},
	{id:2,value:222},
	{id:3,value:333}
]

// key必须要加，且必须是唯一的，尽量不用用item作为key
const title = (
		<ul>
			{data.map(item => <li key={item.id}>{item.value}</li>)}
		</ul>
)

ReactDOM.render(title,document.getElementById('root'))
```
:::
## 样式处理
1. 行内样式`style={{}}`
2. 类名`className=""`
:::details 点我查看代码
```css
.title {
	text-align: center;
}
```
```js
import React from 'react';
import ReactDOM from 'react-dom';

import './css/index.css';

const title = (
		<h1 className="title" style={{backgroundColor:'red',color:'green'}}>
			JSX行内样式
		</h1>
)

ReactDOM.render(title,document.getElementById('root'))
```
:::

## 事件绑定

:::details 点我查看代码
```js
const Test = () => {
  const clickCallback = () => {
    console.log("click");
  }
  return (
    <button onClick={clickCallback}>Test</button>
  )
}
class App extends React.Component {
  clickCallback() {
    console.log("click")
  }
  render() {
    return (
      <>
        <Test />
        <button onClick={this.clickCallback.bind(this)}>App</button>
      </>
    )
  }
}

export default App;
```
:::