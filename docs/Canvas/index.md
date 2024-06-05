# 1、canvas先知先会

## 1、1 概述

长久以来，web上的动画都是Flash。比如动画广告、游戏等等，基本上都是Flash实现的。Flash 是有缺点
的，比如需要安装Adobe Flash Player, 漏洞多，重量比较大、卡顿和不流畅等等。
HTML5提出了一个新的canvas标签，彻底颠覆了Flash的主导地位。无论是广告、游戏都可以使用canvas实
现了。

## 1、2 canvas简介

Canvas 是一个轻量级的画布，是h5的一个标签我们使用Canvas进行JavaScript的编程，不需要增加额外的插件，性能也很好，不卡顿，在手机中也很流畅，现在高版本的浏览器基本上都支持canvas了

# 2、初次使用canvas

## 2、1 使用

```html
<body>
    <!-- 在页面中设置一个canvas标签，也就是画布默认是w300*h150白色的-->
    <canvas>
    当前的浏览器版本不支持，请升级浏览器
    </canvas>    
</body>
```

## 2、2 注意

标签对中的内容是用来替换的，canvas是一个h5标签，浏览器不兼容的话用“当前的浏览器不支持，请升级浏览器”来替换显示（ie浏览器 F12仿真展示）
canvas的标签属性只有两个height width
不要使用css来设置宽高，用css来设置相当于把canvas画布的大小改变会失真，有一个拉伸的效果，变的模糊了 

## 2、3“工具”的获取

```html
<script type="text/javascript">
      // 1、获取元素
      var mycanvas = document.querySelector('#one');
      // 2、获取上下文,获取绘画的工具箱对象
      var ctx = mycanvas.getContext('2d');
      // 3、移动画笔
      ctx.moveTo(100,100);
      // 4、绘制直线，从起点画到画布上一点的路径，现在看不见
      ctx.lineTo(200,100);
      // 5、描边
      ctx.stroke();
    </script>
```

## 2、4“工具”的介绍

### 2、4、1线条的精度问题

线条的默认宽度是1px,黑色
但是实际上显示有2px,灰色
产生的原因是因为对齐的位置是线条中心的位置，上下各占0.5px，浏览器显示的时候会将0.5看作1px这样线条就占了2px的宽度，变宽了，颜色也不饱和了
解决办法，线条移动0.5px 

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      ctx.moveTo(100,100);
      ctx.lineTo(200.5,100.5);
      ctx.moveTo(100,200);
      ctx.lineTo(200,200);
      ctx.stroke();
    </script>
  </body>
</html>
```

### 2、4、2 画笔的样式设置

lineWidth 画笔的宽度
linecap 线末端的样式，butt默认 round椭圆帽子线条变长 square矩形帽子线条变长
linejoin 相交线的拐点，画折线和弧线用 miter默认 round圆的 bevel斜的
fillstyle 填充的颜色
setLineDash([]) 设置虚线
getLineDash() 获取虚线宽度的集合
lineDashOffset() 设置虚线偏移量负值和虚线反方向偏转，正值向虚线方向偏移 

#### linecap三种属性值的区别

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      // 蓝色 10px
      // 开启新路径
      ctx.beginPath();
      ctx.moveTo(100, 100);
      ctx.lineTo(200, 100);
      ctx.strokeStyle = 'blue';
      ctx.lineWidth = 10;
      ctx.lineCap = 'butt';
      ctx.stroke();
      // 红色 20px
      ctx.beginPath();
      ctx.moveTo(100, 200);
      ctx.lineTo(200, 200);
      ctx.strokeStyle = 'red';
      ctx.lineWidth = 20;
      ctx.lineCap = 'square';
      ctx.stroke();
      // 绿色 30px
      ctx.beginPath();
      ctx.moveTo(100, 300);
      ctx.lineTo(200, 300);
      ctx.strokeStyle = 'green';
      ctx.lineWidth = 30;
      ctx.lineCap = 'round';
      ctx.stroke();
    </script>
  </body>
</html>
```

#### linejoin 的三个属性值的区别

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      // 蓝色 10px
      // 开启新路径
      ctx.beginPath();
      ctx.moveTo(100, 100);
      ctx.lineTo(150, 75);
      ctx.lineTo(200, 100);
      ctx.lineJoin = 'miter';
      ctx.strokeStyle = 'blue';
      ctx.lineWidth = 10;
      ctx.stroke();
      // 红色 20px
      ctx.beginPath();
      ctx.moveTo(100, 200);
      ctx.lineTo(150, 175);
      ctx.lineTo(200, 200);
      ctx.lineJoin = 'round';
      ctx.strokeStyle = 'red';
      ctx.lineWidth = 20;
      ctx.stroke();
      // 绿色 30px
      ctx.beginPath();
      ctx.moveTo(100, 300);
      ctx.lineTo(150, 275);
      ctx.lineTo(200, 300);
      ctx.lineJoin = 'bevel';
      ctx.strokeStyle = 'green';
      ctx.lineWidth = 30;
      ctx.stroke();
    </script>
  </body>
</html>

```

### 2、4、3 自动闭合

```
自动闭合是闭合到该路径的起始位置，从绘制的终点位置和路径的起始位置连接起来一条直线
```

# 3、绘制图形案例

## 3、1绘制平行线（两条直线）

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      ctx.moveTo(100,100);
      ctx.lineTo(200,100);
      ctx.moveTo(100,200);
      ctx.lineTo(200,200);
      ctx.stroke();
    </script>
  </body>
</html>

```

## 3、2绘制三条颜色和宽度不同的平行线

存在的问题：工具的属性覆盖，和描边覆盖
解决方法：开启多条路径，类似于多线程，互不干扰 

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      // 蓝色 10px
      // 开启新路径
      ctx.beginPath();
      ctx.moveTo(100, 100);
      ctx.lineTo(200, 100);
      ctx.strokeStyle = 'blue';
      ctx.lineWidth = 10;
      ctx.stroke();
      // 红色 20px
      ctx.beginPath();
      ctx.moveTo(100, 200);
      ctx.lineTo(200, 200);
      ctx.strokeStyle = 'red';
      ctx.lineWidth = 20;
      ctx.stroke();
      // 绿色 30px
      ctx.beginPath();
      ctx.moveTo(100, 300);
      ctx.lineTo(200, 300);
      ctx.strokeStyle = 'green';
      ctx.lineWidth = 30;
      ctx.stroke();
    </script>
  </body>
</html>

```

## 3、3绘制填充的三角线

存在的问题：当线条的宽度很宽时，三角线的角的位置会缺失，起始点和lineTo的结束点无法闭合
解决办法：这条线不自己手动闭合，使用canvas的自动闭合，也就是使用canvas的结束路径closePath()来解决 

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      ctx.moveTo(100,100)
      ctx.lineTo(150,150);
      ctx.lineTo(100,200);
      ctx.lineTo(100,100);
      ctx.lineWidth = 10;
      // 关闭这条路径，和beginPath不是对生关系，beginPath是开启一条新路径
      ctx.closePath();
      ctx.stroke();
      // 填充
      // ctx.fill();
    </script>
  </body>
</html>

```

## 3、4绘制镂空的正方形

画两个正方形，进行填充
存在的问题：非零环绕填充规则的使用
非零环绕填充：判断某个区域是否填充的步骤
1、从区域向外面画一条线
2、判断与这条线相交的路径线的方向是顺时针还是逆时针
3、判断所有相交的线的顺逆时针方向的数量是否相同，相同则不填充
4、不相同也就是顺逆相减结果为非零，就填充。这就是非零填充，又叫奇偶规则 

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
  </head>
  <body><!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      // 逆时针绘制
      ctx.moveTo(100,100);
      ctx.lineTo(100,300);
      ctx.lineTo(300,300);
      ctx.lineTo(300,100);
      ctx.closePath();
      ctx.stroke();
      // 顺时针绘制
      ctx.moveTo(150,150);
      ctx.lineTo(250,150);
      ctx.lineTo(250,250);
      ctx.lineTo(150,250);
      ctx.closePath();
      ctx.fillstyle = 'red';
      ctx.fill();
    </script>
  </body>
</html>

  </body>
</html>

```

简洁版，画四条粗的线条

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      ctx.lineWidth = 30;
      ctx.moveTo(100,100);
      ctx.lineTo(200,100);
      ctx.lineTo(200,200);
      ctx.lineTo(100,200);
      ctx.closePath();
      ctx.stroke();
    </script>
  </body>
</html>

```

## 3、5 绘制虚线

问题：setlineDash([])的使用
解决：以一组数组为单位，重复这组数组比如[5,10,5],就是5实10虚5实重复数组5虚10实5虚    

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      ctx.moveTo(100,100.5);
      ctx.lineTo(200,100.5);
      
      ctx.setLineDash([5,10,5]);
      
      ctx.stroke();
    </script>
  </body>
</html>

```

## 3、5 绘制一个渐变的矩形

线是由点构成的，填充矩形可以看做是一条宽度够大的线，渐变色的原理

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      // 绘制矩形
      // 线是由点构成的
      // 填充白到黑的渐变颜色
      ctx.lineWidth = 30;
      for(let i = 0; i < 255; i++){
        ctx.beginPath();
        ctx.moveTo(100+i-1,100);
        ctx.lineTo(100+i,100);
        ctx.strokeStyle = 'rgb('+i+',0,0)';
        ctx.stroke();
      }
    </script>
  </body>
</html>
```

## 3、6 绘制折线图所需的小功能

### 3、6 、1绘制一个网格

获取canvas画布的宽高

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      // 绘制网格
      // 1、网格的大小
      let gridSize = 10;
      // 2、获取画布的大小
      // // 方式1mycanvas对象的属性
      // let canvasHeight = mycanvas.height;
      // let canvasWidth = mycanvas.width;
      // 方式2 ctx对象的属性
      let canvasHeight = ctx.canvas.height;
      let canvasWidth = ctx.canvas.width;
      // 3、多少条x方向的线
      let xNumber = Math.floor(canvasHeight / gridSize);
      // 遍历的方式来画
      for(let i = 0 ; i < xNumber ; i++){
        ctx.beginPath();
        ctx.moveTo(0,i * gridSize - 0.5);
        ctx.lineTo(canvasWidth,i * gridSize - 0.5);
        ctx.strokeStyle = '#999999'
        ctx.stroke();
      }
      // 4、多少条y方向的线
      let yNumber = Math.floor(canvasWidth / gridSize);
      // 遍历的方式来画
      for(let i = 0 ; i < yNumber ; i++){
        ctx.beginPath();
        ctx.moveTo(i * gridSize - 0.5,0);
        ctx.lineTo(i * gridSize - 0.5,canvasHeight);
        ctx.strokeStyle = '#999999'
        ctx.stroke();
      }
    </script>
  </body>
</html>

```

### 3、6、2 绘制坐标系

明白坐标轴的三角形怎么绘制

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      // 设置坐标轴距离画布边缘的空白距离
      const space = 40;
      // 获取画布的大小
      const canvasHeight = ctx.canvas.height;
      const canvasWidth = ctx.canvas.width;
      // 确定原点的位置
      const x0 = space;
      const y0 = canvasHeight - space;
      // 确定箭头等腰直角三角形的底边长
      const length = 20;
      // 绘制x轴
      ctx.moveTo(x0, y0);
      ctx.lineTo(canvasWidth - space, y0);
      ctx.lineTo(canvasWidth - space - length / 2, y0 - length / 2);
      ctx.lineTo(canvasWidth - space - length / 2, y0 + length / 2);
      ctx.lineTo(canvasWidth - space, y0);
      ctx.fill();
      ctx.stroke();
      // 绘制y轴
      ctx.moveTo(x0, y0);
      ctx.lineTo(x0, space);
      ctx.lineTo(x0 - length / 2, space + length / 2);
      ctx.lineTo(x0 + length / 2, space + length / 2);
      ctx.lineTo(x0, space);
      ctx.fill();
      ctx.stroke();
    </script>
  </body>
</html>

```

### 3、6、3 绘制矩形像素点

点的中心为矩形像素点的中心

方式1

绘制一个矩形

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      // 确定像素点的中心
      const dotCentre = {
        x: 240,
        y: 350
      }
      
      // 确定点的大小，矩形边长的一半
      const length = 5;
      
      // 开始绘制
      ctx.moveTo(dotCentre.x - length, dotCentre.y - length);
      ctx.lineTo(dotCentre.x + length, dotCentre.y - length);
      ctx.lineTo(dotCentre.x + length, dotCentre.y + length);
      ctx.lineTo(dotCentre.x - length, dotCentre.y + length);
      ctx.closePath();
      ctx.fill();
    </script>
  </body>
</html>

```

方式2

绘制一个宽为像素点的矩形边长的线段

```html
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
      canvas {
        border: 1px solid #000000;
      }
    </style>
  </head>
  <body>
    <canvas id="one" width="600" height="400"></canvas>
    <script type="text/javascript">
      var mycanvas = document.querySelector('#one');
      var ctx = mycanvas.getContext('2d');
      // 确定像素点的中心
      const dotCentre = {
        x: 240,
        y: 350
      }
      
      // 确定点的大小，矩形边长的一半
      const length = 5;
      
      // 开始绘制
      ctx.lineWidth = length * 2;
      ctx.moveTo(dotCentre.x - length,dotCentre.y);
      ctx.lineTo(dotCentre.x + length,dotCentre.y);
      ctx.stroke();
    </script>
  </body>
</html>

```
