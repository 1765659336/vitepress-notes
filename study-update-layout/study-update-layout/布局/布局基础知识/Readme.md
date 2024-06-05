# 布局基础知识

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

## 浮动float
<div style="color:#507b66">(float:left/right;)</div>
```
浮动会脱离文档流,浮动到文档流的上面
```
<div style="color: #fd3f31;font-weight:1000">使用盒模型的注意事项：</div>
```
1. 当父盒子没有设定高，子盒子都进行了浮动，那么父盒子的高度将为0，我们称为高度塌陷
    清除浮动：1. 上下关系的盒子，一个盒子设置浮动，两个盒子会重叠？使用clear，上面的盒子是左浮动，那么就给后面一个盒子添加clear:left,反之亦然。
                也可以直接设置clear:both;不管是左右都清除
              2. 不给父盒子高度，子盒子全部浮动，父盒子高度为0？
                2.1 使用BFC给父盒子添加overflow: hidden;
                2.2 给父盒子加一个空标签，空标签设置clear: both;
                2.3 after伪类（空标签的升级写法）给父盒子加上
                    .father::after {
                        content: "";
                        /* 伪类是一个内联盒子，内联盒子设置clear:both不起作用 */
                        display: block;
                        clear: both;
                    }
2. 浮动只会影响后面的盒子，而不会影响之前的盒子
3. 文本不会被浮动元素覆盖，标准文档布局的盒子虽然可以被浮动盒子覆盖，但是标准文档里的盒子的文本不会被浮动的盒子覆盖
4. 浮动的盒子具有内联盒子的特性，宽度,宽度由内容决定，不换行
5. 浮动放不下时，会换行。
```

## 定位position
<div style="color:#507b66">(position:static/relative/absolute/sticky/fixed)</div>
```
static标准文档流定位
relative相对定位：1. 相对于原本标准流位置的偏移
                  2. 不影响其它元素的布局，依然还是处于文档流中
absolute绝对定位：1. 脱离文档流
                  2. 具备内联盒子的特性，宽度由内容决定，也可以设置宽高不换行
                  3. 相对于离当前盒子最近的带有“定位”的祖先偏移。
                  4. z-index设置层级
fixed固定定位：1. 固定在可视区内
               2. 具备内联盒子的特性，宽度由内容决定
               3. 具备块级盒子的特性，可以设置宽高
               4. 固定定位元素不受祖先元素的影响
               5. 脱离文档流
sticky粘性定位：1. 处于相对定位与固定定位之间，低于这个阈值时，使用相对定位，跨越这个阈值时，使用固定定位
                2. 占据原本的文档流，不影响其它盒子的布局
```