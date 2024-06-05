## css盒模型
```
盒模型 = content + padding + margin + border
```
<div style="color: #fd3f31;font-weight:1000">使用盒模型的注意事项：</div>
```
1. padding不能为负值，margin可以
2. 背景颜色可以平铺到padding区域
3. 子盒子的margin-top会传递给父盒子，从而带动父盒子一起往下偏移
    解决办法：1. 给父盒子加一个空白的上边框
             1. 不使用margin-top而使用padding-top
4. 上下两个盒子，上面的盒子设置margin-bottom,下面的盒子设置margin-top。
实际两个盒子的上下间距去两个margin的最大值，而不是将两个margin叠加
```

## 块级盒子和内联盒子
<div style="color:#507b66">(display:block/inline/inline-block;)</div>
```
块级盒子：div,p,h1
    ~~特点：1. 独占一行
            1. 可以设置宽高，支持所有样式
            2. 不写宽度会和父容器的宽度相同
            3. 块占据的区域是一个矩形
内联盒子：span,a,strong
    ~~特点：1. 不会换行
            2. 不支持宽高,margin,padding等样式
            3. 不写宽度时，宽度由内容决定
            4. 所占局域不一定是矩形（当内容宽度换行之后就不是矩形了）
            5. 内联盒子之间会有小间隙
                解决办法: 1. 书写代码时，不要换行
                          2. 给内联盒子的套一个父盒子，设置font-size为0，然后再给内联盒子设置合适的字体大小
```
<div style="color: blue; font-weight:1000">因此我们布局的时候，尽量不要使用内联盒子去布局</div>

## 自适应盒模型
```
当给父盒子设定宽高，子盒子设定宽高之后。我们再给子盒子设置margin/padding/border，是不会自适应改变content内容的宽度，子盒子可以溢出父盒子。如果我们不给子盒子设置宽度，并且我们给子盒子设置margin/padding/border，当要超出父盒子时，content的宽度会自适应的变小，这就是自适应盒模型。
```

## 标准盒模型和怪异盒模型
<div style="color:#507b66">(box-sizing:content-box/border-box;)</div>
```
content-box标准盒模型：盒子的宽高用来决定content的宽高，当我们加上margin/padding/border不会改变content的值，而是会使整个盒子的大小变化。
border-box怪异盒模型：盒子的宽高用来决定content/padding/border的总和大小。当给了盒子宽高时，我们后续修改盒子的padding/border/margin大小，会影响content的大小
    怪异盒模型的应用场景：1. 当我们修改padding/margin/border的值时，标准盒模型的盒子大小发生了变化，改变了布局。
                         2. 标准盒模型设定宽度或高度为父盒子的百分之多少时，我们再添加padding/margin/border值，此时
                            盒子实际占据的百分比的值将偏大
                         3.  
```