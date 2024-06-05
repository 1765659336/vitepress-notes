var express = require('express');
var router = express.Router();
const db = require('../conf/db');

/* GET home page. */
router.get('/', function(req, res, next) {
    res.send("<h1>123</h1>")
});

router.get('/userList', (req, res, next) => {
    // sql查询user表
    db.query('select * from list', [], function(results, fields) {
        // 以json的形式返回
        res.json({ results })
    })
})
module.exports = router;