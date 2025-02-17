## 约束
1. 如果有需要后台接口的地方, 统一假设为 http://192.168.1.18:8080

## 业务场景
### 如何使后端的接口允许跨域(谨慎使用，脱离了我使用mock的初衷，即是只产生假数据而不会因为我要用工具而改变我的代码)
```
不需要配置 webpack, 不需要后端人员更改, 不需要浏览器插件
这个功能 mockm 默认是支持的, 以最简方式启动 mockm 就能拥有此功能, 只要在命令行输入下面这条命令即可。
当设置了proxy时，请求http://127.0.0.1:9000时，会代理跳转到后端地址
```

```
mm proxy=http://192.168.1.18:8080
```

```
你也可以使用配置文件的方式, 创建 mm.config.js 文件并录入以下内容, 然后命令行输入 mm 即可:

module.exports = {
  proxy: `http://192.168.1.18:8080`
}
```

```
然后更换原来的请求地址为自己的即可, 例如自己的 IP 为 127.0.0.1 则做以下更改:

更改前: http://192.168.1.18:8080/api/
更改后: http://127.0.0.1:9000/api/
```

### 如何创建一个自己的接口
```
与后端接口相同时, 会使用自己的
```
```js
module.exports = {
  api: {
    '/my/api': {
      msg: `我的 api`
    },
  },
}
```
```
接口已完成, 访问 http://127.0.0.1:9000/my/api查看效果。
```

### 如何从接口中获取请求信息
```js
module.exports = {
    api: {
        '/server' (req, res) {
            // req.params 是 url 上的路径参数
            // req.query 是 url 上的查询参数
            // req.body 是请求体中的参数
            res.json({ desc: `你传入的值`, data: req.query })
        },
    },
}
```

### 如何快速生成 Restful API
```
假设我要写一个博客文章的列表, 并且要实现添加文章, 查询文章, 分页, 模糊搜索, 删除, 修改等各种功能的接口. 那么只需添加以下内容:
```
```js
module.exports = {
  db: {
    'blogs': [
      {
        id: 1,
        content: `mockm 是一款便于使用, 功能灵活的接口工具. 看起来不错~`,
        title: `认识 mockm 的第一天`,
      },
    ],
  },
}
```

### 如何生成逼真的数据
```
mockjs是一个不错的数据生成工具, mockm 默认集成了它, 下面用它生成一批用户信息.
```
<a href="http://mockjs.com/examples.html">mock官网</a>
```js
module.exports = util => {
  return {
    db: {
      'users': util.libObj.mockjs.mock({
        'data|15-23': [ // 随机生成 15 至 23 条数据
          {
            'id|+1': 1, // id 从 1 开始自增
            name: `@cname`, // 随机生成中文名字
            'sex|1': [`男`, `女`, `保密`], // 性别从这三个选项中随机选择一个
          },
        ]
      }).data,
    },
  }
}
```