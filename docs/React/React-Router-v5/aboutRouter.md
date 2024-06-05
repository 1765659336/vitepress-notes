## 路由概述

<span class="span-info-message">现代的前端应用大多都是SPA (单页应用程序) ,也就是只有一个HTML页面的应用程序。因为它的用户体
验更好、对服务器的压力更小,所以更受欢迎。为了有效的使用单个页面来管理原来多页面的功能,前端路由
应运而生。</span>
<div class="div-info-Line"></div>
<span class="span-info-message">前端路由的功能:让用户从一个视图(页面)导航到另一个视图(页面)</span>
<div class="div-info-Line"></div>
<span class="span-info-message">前端路由是一套映射关系，配置组件和路径的对应关系</span>

## 安装
`npm i react-router-dom@5`

## 路由的执行过程

1. 点击 Link 组件（a标签），修改了浏览器地址栏中的 url 。

2. React 路由监听到地址栏 url 的变化。

3. React 路由内部遍历所有 Route 组件，使用路由规则（ path ）与 pathname 进行匹配。
 
4. 当路由规则（path）能够匹配地址栏中的 pathname 时，就展示该 Route 组件的内容。

## 路由跳转模式push/replace

push是每次跳转都会入栈，而replace是替换栈顶的记录