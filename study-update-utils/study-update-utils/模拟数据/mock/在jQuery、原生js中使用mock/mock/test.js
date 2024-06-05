// 请求的响应时间1秒到3秒之间
Mock.setup({
    timeout: "1000-3000",
});

// 请求方式要使用小写
Mock.mock("/test", "get", {
    "string|1-10": "★",
});