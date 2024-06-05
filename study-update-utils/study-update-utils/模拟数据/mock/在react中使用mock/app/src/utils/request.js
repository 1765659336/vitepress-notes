import axios from "axios";
// import config from "../config/request.js";
// create an axios instance
const request = axios.create({
    // baseURL: import.meta.env['VITE_APP_BASE_API'] as string, // url = base url + request url
    // withCredentials: true, // send cookies when cross-domain requests
    timeout: 3000, // request timeout
    // baseURL: 
});
// request interceptor
request.interceptors.request.use(
    c => {
        return c;
    },
    error => {
        return Promise.reject(error);
    }
);

// response interceptor
request.interceptors.response.use(
    response => {
        if (response.status === 200) {
            console.log("请求成功", response.data);
        } else {
            console.log("接口失败");
        }
        return response;
    },
    error => {
        return Promise.reject(error);
    }
);

export default request;