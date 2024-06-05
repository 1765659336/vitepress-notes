## 路由守卫

```js

// ./views/About
// const About = () => {
//     return (
//         <div>About</div>
//     )
// }
// export default About;

// ./views/NotFound
// const NotFound = () => {
//     return (
//         <div>NotFound</div>
//     )
// }
// export default NotFound;

// ./views/Home
// import { Outlet } from "react-router-dom";
// const Home = () => {
//     return (
//         <>
//             <div>Home</div>
//             <Outlet></Outlet>
//         </>
//     )
// }
// export default Home;

// ./views/Role
// const Role = () => {
//     return (
//         <div>Role</div>
//     )
// }
// export default Role;

// ./views/User
// const User = () => {
//     return (
//         <div>User</div>
//     )
// }
// export default User;

import React, { useEffect, lazy } from "react";

// Navigate重定向组件
import { useRoutes, useLocation, useNavigate, Navigate, BrowserRouter } from "react-router-dom";

// 直接引入
import Home from "./views/Home";
// 懒加载
const About = lazy(() => import("./views/About"));
const NotFound = lazy(() => import("./views/NotFound"));
const Role = lazy(() => import("./views/Role"));
const User = lazy(() => import("./views/User"));

// 懒加载时的占位组件
const withLoadingComponent = (comp) => {
    return (
        <React.Suspense fallback={<div>loading...</div>}>{comp}</React.Suspense>
    );
};

const Login = () => {
    const navigate = useNavigate();

    return (
        <div>
            <div>LoginPage</div>
            <button onClick={() => { navigate("/"); localStorage.setItem("token", "token") }}>Login</button>
        </div>
    );
};

const Logged = () => {
    const navigate = useNavigate();

    useEffect(() => {
        console.warn("你已登录");
        navigate("/");
    });

    return <></>;
};

// 路由文件
const routes = [
    {
        path: "/",
        element: <Navigate to="/home" />,
    },
    {
        path: "/home",
        element: <Home />,
        children: [
            {
                path: "/home/users",
                element: withLoadingComponent(<User />),
            },
            {
                path: "/home/roles",
                element: withLoadingComponent(<Role />),
            },
        ],
    },
    {
        path: "/about",
        element: withLoadingComponent(<About />),
    },
    {
        path: "/login",
        element: <Login />,
    },
    {
        path: "*",
        element: withLoadingComponent(<NotFound />),
    },
];

// 前置路由守卫
const BeforeRouterEnter = () => {
    const outlet = useRoutes(routes);
    const location = useLocation();
    const token = localStorage.getItem("token");
    if (location.pathname === "/login" && token) {
        return <Logged />;
    }
    if (location.pathname !== "/login" && !token) {
        return <Login />;
    }
    return <>{outlet}</>;
};

const App = () => {
    return (
        <BrowserRouter>
            <BeforeRouterEnter />
        </BrowserRouter>
    );
};

export default App;
```