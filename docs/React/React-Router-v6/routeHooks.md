# 路由hooks

## useInRouterContext

判断当前组件是否被路由组件包裹
:::details 点我查看代码
```js
import { BrowserRouter, useInRouterContext, Routes, Route } from "react-router-dom";
const OutCop = () => {
    // 不被路由组件包裹，为false
    const isTrue = useInRouterContext();

    return (
        <div>
            OutCop-{isTrue ? "true" : "false"}
        </div>
    )
}

const Index = () => {
    // 被路由组件包裹，为true
    const isTrue = useInRouterContext();
    return (
        <>
            Index-{isTrue ? "true" : "false"}
        </>
    )
}

const App = () => {

    return (
        <>
            <OutCop />
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Index />}></Route>
                </Routes>
            </BrowserRouter>
        </>

    )
}

export default App;
```
:::

## useNavigationType

返回当前的导航类型，用户是如何来到当前页面的

返回值 POP/PUSH/REPLACE POP表示是否直接进入的当前路由（如刷新浏览器）、PUSH表示是否是push模式进入的当前路由，REPLACE同理是否是replace模式进入的当前路由

:::details 点我查看代码
```js
import { BrowserRouter, useNavigationType, Routes, Route, Link, Outlet } from "react-router-dom";

const Home = () => {
    const Type = useNavigationType();

    return (
        <>
            {Type}
        </>
    )
}

const Index = () => {
    return (
        <>
            <Link to="/home" replace>replace</Link>
            <Link to="/home">push</Link>
        </>
    )
}

const App = () => {

    return (
        <>
            <BrowserRouter>

                <Routes>
                    <Route path="/" element={<Index />}></Route>
                    <Route path="/home" element={<Home />}></Route>

                </Routes>
            </BrowserRouter>
        </>

    )
}

export default App;
```
:::

## useOutlet

用来呈现当前组件中已经渲染的嵌套子路由对象
如果子路由都没有渲染返回null，哪个子路由渲染了就返回哪个子路由对象
```js
{
    $$typeof: Symbol(react.element),
    key: null,
    props: {value: undefined, children: {…}},
    ref: null,
    type: {$$typeof: Symbol(react.provider), _context: {…}},
    _owner: FiberNode {tag: 0, key: null, stateNode: null, elementType: ƒ, type: ƒ, …},
    _store: {validated: false},
    _self: null,
    _source: null,
    [[Prototype]]: Object
}
```

:::details 点我查看代码
```js
import { BrowserRouter, useOutlet, Routes, Route, Outlet } from "react-router-dom";

const Home1 = () => {

    return (
        <>
            Home1
        </>
    )
}

const Home2 = () => {

    return (
        <>
            Home2
        </>
    )
}

const Home = () => {

    const obj = useOutlet();
    console.log(obj);

    return (
        <>
            Home
            <Outlet></Outlet>
        </>
    )
}

const App = () => {

    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Home />}>
                        <Route path="/home1" element={<Home1 />}></Route>
                        <Route path="/home2" element={<Home2 />}></Route>
                    </Route>
                </Routes>
            </BrowserRouter>
        </>

    )
}

export default App;
```
:::

## useResolvePath

给定一个URL值，解析其中的path,search,hash值

:::details 点我查看代码
```js
import { useResolvedPath } from "react-router-dom";

const App = () => {

    const { pathname, search, hash } = useResolvedPath('/message?id=001#qwe')
    return (
        <>
            {pathname} - {search} - {hash}
        </>
    )
}

export default App;
```
:::