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
