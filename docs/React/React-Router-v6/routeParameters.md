# 路由参数

## params参数
路由表中定义的路由路径中需要占位符
```js
{
    path: '/home',
    element: <Home />,
    children: [
        {
            path: 'message/:id/:title/:content',
            element: <Message />
        },
    ]
},
```
使用
```js
<Link to={`message/${m.id}/${m.title}/${m.content}`}>{m.title}</Link>
```
传递参数
使用useParams()或useMatch()接收

:::details 点我查看代码
```js
import { Navigate, useRoutes, Outlet, Link, useParams, useMatch } from "react-router-dom";


const Message = () => {
    const { id, title, content } = useParams();
    const { params: { id: id2, title: title2, content: content2 } } = useMatch('/home/message/:id/:title/:content');

    return (
        <>
            <div>{id}-{title}-{content}</div>
            <div>{id2}-{title2}-{content2}</div>
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

    return (
        <>
            <div>Home</div>
            {
                messages.map(m =>
                    <li key={m.id}>
                        <Link to={`message/${m.id}/${m.title}/${m.content}`}>{m.title}</Link>
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
                    path: 'message/:id/:title/:content',
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

## search参数（query参数）

路由表不需要占位符

使用
```js
<Link to={`message?id=${m.id}&title=${m.title}&content=${m.content}`}>{m.title}</Link>
```
传递参数

使用useSearchParams()或useLocation()接收

:::details 点我查看代码
```js
import { Navigate, useRoutes, Outlet, Link, useSearchParams, useLocation } from "react-router-dom";


const Message = () => {
    const [search, setSearch] = useSearchParams();
    const { search: search2 } = useLocation();
    return (
        <>
            <div>{search.get("id")}-{search.get("title")}-{search.get("content")}</div>
            <div>{search2}</div>
            <button onClick={() => setSearch('id=4&title=titie4&content=content4')}>修改路由</button>
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

    return (
        <>
            <div>Home</div>
            {
                messages.map(m =>
                    <li key={m.id}>
                        <Link to={`message?id=${m.id}&title=${m.title}&content=${m.content}`}>{m.title}</Link>
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

## state参数

路由表不需要占位符

使用 
```js
<Link to='message' state={{id: m.id,title: m.titlecontent: m.content}}>{m.title}</Link>
```
传递参数

使用useLocation()接收

:::details 点我查看代码
```js
import { Navigate, useRoutes, Outlet, Link, useLocation } from "react-router-dom";


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