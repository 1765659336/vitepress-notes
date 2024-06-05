/* module.exports = {
    api: {
        '/server' (req, res) {
            // req.params 是 url 上的路径参数
            // req.query 是 url 上的查询参数
            // req.body 是请求体中的参数
            res.json({ desc: `你传入的值`, data: req.query })
        },
    },
} */

/* module.exports = {
    db: {
        'blogs': [{
            id: 1,
            content: `mockm 是一款便于使用, 功能灵活的接口工具. 看起来不错~`,
            title: `认识 mockm 的第一天`,
        }, ],
    },
} */

module.exports = util => {
    return {
        remote: true,
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