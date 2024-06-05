## react简单使用

`npm install react react-dom`

## 引入react react-dom 两个js文件

```html
<script src="./node_modules/react/umd/react.development.js" type="text/javascript" charset="utf-8"></script>
<script src="./node_modules/react-dom/umd/react-dom.development.js" type="text/javascript" charset="utf-8"></script>
```

## 创建React元素

```js
// 创建react元素
// 参数1：元素名称 参数2：元素属性 参数3及后面的参数：元素的子节点
const title = React.createElement('h1',null,'Hello React');
```

## 渲染React元素到页面中
```js
// 渲染React元素
// 参数1：要渲染的React元素 参数2：挂载点
ReactDOM.render(title,document.getElementById('root'));
```

## 页面中的容器

```html
<div id="root"></div>
```

## 脚手架创建项目

`npx create-react-app projectName`

## 启动项目

`cd projectName && npm run start`

## Mustache模板语法

```
// react自动配置了babel,能够将jsx解析成ECMAScript语法，推荐使用()包括起来
// jsx使用驼峰命名法
// react 中的Mustache语法是单{} vue中是{{}} 括号中可以放任意的表达式，jsx自身也是js表达式 因为react是单{}，与对象的写法起冲突了，所以是不能在{}Mustache语法中出现对象的，只在style中出现 不能出现的语句如for循环、if判断
```

```js
import React from 'react';
import ReactDOM from 'react-dom';

const name = 'react';
const title = ( <h1 className = 'title'>hello {name}<span/></h1>);

ReactDOM.render(title, document.getElementById('root'));
```

## 样式处理

```
方式1：外部导入css文件
方式2：行内样式
```

```js
import './css/index.css';

// 驼峰命名法
const title = (
	<h1 className="title" style={{backgroundColor:'red',color:'green'}}>
		JSX行内样式
	</h1>
)
```

## 条件渲染

```
方式1： if-else
方式2：三元表达式
方式3：逻辑判断运算符
```

```js
import React from 'react';
import ReactDOM from 'react-dom';

// if-eles
const data = (isLoading) => {
	if(isLoading){
		return <div>数据</div>
	}
	return <div>加载中</div>
}

// 三元表达式
const data = (isLoading) => {
	return isLoading ? <div>数据</div> : <div>加载中</div>
}

// 逻辑运算符，只能展示一个
const data = (isLoading) => {
	return isLoading && <div>数据</div>
}

const title = (
	<div>
		{data(true)}
		{data(false)}
	</div>
)

ReactDOM.render(title,document.getElementById('root'))
```

## 列表渲染

```
使用map函数，不要遗忘key
```

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

