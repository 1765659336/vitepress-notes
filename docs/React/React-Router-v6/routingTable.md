# 路由表

## useRoutes
<span class="span-info-message">生成嵌套式Routes,Route</span>

```js
import { Navigate, useRoutes, Route, Routes } from "react-router-dom";

const About = () => {
    return (
        <div>About</div>
    )
}

const Home = () => {
    return (
        <div>Home</div>
    )
}


const App = () => {

    const routes = useRoutes([
        {
            path: '/',
            element: <Navigate to='/home' />
        },
        {
            path: '/home',
            element: <Home />
        },
        {
            path: '/about',
            element: <About />
        }
    ])

    return (
        <>
            <Routes>
                <Route path="/" element={<Home />}></Route>
                <Route path="/home" element={<Home />}></Route>
                <Route path="/about" element={<About />}></Route>
            </Routes>
            {routes}
        </>
    )
}

export default App;
```

## 嵌套路由
<span class="span-warning-message">二级路由不用带/</span>

:::details 点我查看代码
```js
import { Navigate, useRoutes, Route, Routes, Outlet } from "react-router-dom";

const Home1 = () => {
    return (
        <div>Home1</div>
    )
}

const Home2 = () => {
    return (
        <div>Home2</div>
    )
}

const About = () => {
    return (
        <>
            <div>About</div>
            <Outlet></Outlet>
        </>
    )
}

const Home = () => {
    return (
        <>
            <div>Home</div>
            <Outlet></Outlet>
        </>
    )
}


const App = () => {

    const routes = useRoutes([
        {
            path: '/',
            element: <Navigate to='/home' />
        },
        {
            path: '/home',
            element: <Home />,
            children: [
                {
                    path: 'home1',
                    element: <Home1 />
                },
                {
                    path: 'home2',
                    element: <Home2 />
                }
            ]
        },
        {
            path: '/about',
            element: <About />
        }
    ])

    return (
        <>
            <Routes>
                <Route path="/" element={<Home />}></Route>
                <Route path="/home" element={<Home />}>
                    <Route path="home1" element={<Home1 />}>
                    </Route>
                    <Route path="home2" element={<Home2 />}>
                    </Route>
                </Route>
                <Route path="/about" element={<About />}></Route>
            </Routes>
            {routes}
        </>
    )
}

export default App;
```
:::

## 默认路由

使用index 指定默认路由

:::details 点我查看代码
```js
<Route path='/about' element={<About />}>
    <Route index element={<Address />} />
    <Route path='address' element={<Address />}></Route>
    <Route path='information' element={<Information />}></Route>
    <Route path='joinus' element={<Join />}></Route>
</Route>
``` 
:::

或者设置path为空，来指定默认路由

:::details 点我查看代码
```js
let router  =[{
  path: "/home",
  element :<Home/ >,
  children: [
    {
    path:"",
    element:<News/>
    },
    {
    path: " news " ,
    element:<News/>
    }
  ]
}]
```
:::