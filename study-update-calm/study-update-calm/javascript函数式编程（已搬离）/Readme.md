# 函数式编程

## 参考资料
<a href="https://www.bilibili.com/video/BV1Gy4y1W7eV?spm_id_from=333.999.0.0">B站javascript函数式编程视频链接</a>

## AOP 面向切面编程

<a href="https://baike.baidu.com/item/AOP/1332219?fr=aladdin">AOP百度百科</a>

```
单独为一个函数对象添加方法 AOP1.js
确保函数可以进行链式调用 AOP2.js
确保函数的执行顺序正确 AOP3.js
确保链式函数的参数函数this指向调用者 AOP4.js
确保链式函数的参数函数可以拿到调用者传递的参数 AOP5.js
什么时候可以用AOP example.js
```

## currying 函数柯里化
```
解决函数部分参数求值的问题，函数多次接收参数，但是实际上我们不需要每次接收参数的时候都执行整个函数内部业务代码，或者只需要对部门参数进行操作
```

### currying场景之一偏函数
```
偏函数的作用：固化一部分参数，将其设置为默认值，然后返回一个新的函数
```