# 组件说明
## BrowserRouter

## HashRouter
使用hash路由模式
## Routes
类似于react-router-dom@5Switch
| 不同点   | Switch                        | Routes                        |
| -------- | ----------------------------- | ----------------------------- |
| 是否必需 | Route不一定要用Switch包裹     | Route必须要用Routes包裹       |
| 包裹效果 | 包裹之后只会模糊匹配一个Route | 包裹之后只会精准匹配一个Route,要想开启模糊匹配，可以使用path="/*" |

当URL改变时，Routes都会查看其所有的子Route组件，找到最佳匹配并呈现组件
## Route
1. path属性 匹配的路径
2. element属性 匹配的组件
3. caseSensitive属性 用于指定匹配时是否区分大小写，默认为false

Route支持嵌套使用，也就是多级路由

## Navigate
重定向组件
1. to属性 跳转的路径
2. replace属性 默认为false,使用push模式，为true时，使用replace模式，浏览器不会留下跳转痕迹，不能回退

## Link 
路由跳转组件
1. to属性 字符串形式跳转的路径 对象形式<span>{pathname:跳转的路径,state:传递state路由参数}</span>
2. replace 使用replace还是push模式
## NavLink
高亮效果路由跳转
1. to属性 字符串形式跳转的路径 对象形式<span>{pathname:跳转的路径,state:传递state路由参数}</span>
2. replace 使用replace还是push模式
3. `className={({isActive}) => {return isActive?"active":"noactive"} }`