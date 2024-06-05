## 条件查询的基本格式

select

​	字段名1,字段名2,...

from

​	表名

where

​	条件;

## 条件有哪些?

### =等于

例如:

```mysql
select empno,ename from emp where sal = 3000;
```

![image-20210605210737797](02MySQL的条件查询命令.assets/image-20210605210737797.png)

### <>或者!=不等于

例如：

```mysql
select empno,ename from emp where sal != 800;
```

![image-20210605210924439](02MySQL的条件查询命令.assets/image-20210605210924439.png)

### < 小于

例如：

```mysql
select empno,ename,sal from emp where sal < 2000;
```

![image-20210605211120611](02MySQL的条件查询命令.assets/image-20210605211120611-1622898681962.png)

### <= 小于等于

例如：

```mysql
select empno,ename,sal from emp where sal <= 3000;
```

![image-20210605211207799](02MySQL的条件查询命令.assets/image-20210605211207799.png)

### > 大于

例如：

```mysql
select empno,ename,sal from emp where sal > 3000;
```

![image-20210605211256742](02MySQL的条件查询命令.assets/image-20210605211256742.png)

### >= 大于等于

例如：

```mysql
select empno,ename,sal from emp where sal >= 3000;
```

![image-20210605211331223](02MySQL的条件查询命令.assets/image-20210605211331223-1622898811886.png)

### between...and... 或者...>=... and ...<=... 两者之间

注意：包括两端的值

例如：

```mysql
select empno,ename,sal from emp where sal between 2450 and 3000;
```

![image-20210605211750078](02MySQL的条件查询命令.assets/image-20210605211750078.png)

例如： 

```mysql
select empno,ename,sal from emp where sal >= 2450 and sal<= 3000;
```

![image-20210605211954598](02MySQL的条件查询命令.assets/image-20210605211954598.png)

### is null 为空

例如： 

```mysql
select empno,ename,sal,comm from emp where comm is null;
```

![image-20210605212321550](02MySQL的条件查询命令.assets/image-20210605212321550.png)

### is not null 不为null

例如：

```mysql
select empno,ename,sal,comm from emp where comm is not null;
```

![image-20210605212506501](02MySQL的条件查询命令.assets/image-20210605212506501.png)

### and 并且

### or 或者

注意：and 和 or 同时出现的时候，and的优先级比or高，先执行and再执行or，要想or先执行可以使用小括号（）

例如：

```mysql
select empno,ename,job from emp where job= 'manager'or job = 'salesman';
```

![image-20210605212843389](02MySQL的条件查询命令.assets/image-20210605212843389.png)

### in 包含

例如：

```mysql
select empno,ename,job from emp where job in('manager','salesman');
```

![image-20210605213556047](02MySQL的条件查询命令.assets/image-20210605213556047.png)

### not in 不包含



### not 取反 用在 in 和 is null 中



### 模糊查询

%匹配多个字符

_（下划线）匹配一个字符

例如：

```mysql
select ename from emp where ename like '%O%';
```

![image-20210605214132149](02MySQL的条件查询命令.assets/image-20210605214132149.png)

注意：如果要匹配含有_的应该使用转义符 '\ _'  （中间没有空格，Typora编辑器的原因会显示一个空格）

### distinct 去重

命令：

```mysql
select distinct job from emp;
```

![image-20210606214841821](02MySQL的条件查询命令.assets/image-20210606214841821-1622987322928.png)

联合起来去重，多个字段都相同才去重命令：

```mysql
select distinct job,deptno from emp;
```

![image-20210606214953080](02MySQL的条件查询命令.assets/image-20210606214953080.png)

