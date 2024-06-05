# 编程式导航
使用 useNavigate(pathName,{replace:boolean,state:{}) hooks函数来跳转
pathName 跳转的路径（如果要传递params和search参数，直接拼在路径中）
replace 是否开启replace模式
state 传递state路由参数

:::details 点我查看代码
```js
import { Navigate, useRoutes, Outlet, Link, useNavigate, useLocation } from "react-router-dom";

const Message = () => {
    const { state: { id, title, content } } = useLocation();
    return (
        <>
            <div>{id}-{title}-{content}</div>
        </>
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

    const messages = [{
        id: "1",
        title: "title1",
        content: 'message1'
    }, {
        id: "2",
        title: "title2",
        content: 'message2'
    }, {
        id: "3",
        title: "title3",
        content: 'message3'
    }];

    const navigate = useNavigate();

    return (
        <>
            <div>Home</div>
            {
                messages.map(m =>
                    <li key={m.id}>
                        <Link to='message' state={{
                            id: m.id,
                            title: m.title,
                            content: m.content
                        }}>{m.title}</Link>
                        <button onClick={() => navigate("message", { replace: true, state: m })}>{m.title}</button>
                    </li>)
            }
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
                    path: 'message',
                    element: <Message />
                },
            ]
        },
        {
            path: '/about',
            element: <About />
        }
    ])

    return (
        <>
            {routes}
        </>
    )
}

export default App;
```
:::