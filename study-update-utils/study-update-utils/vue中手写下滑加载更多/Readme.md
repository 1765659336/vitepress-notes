## 代码实现

```vue
<template>
  ...
</template>

<script>

export default {
  name: "web-archives",
  
  data() {
    return {
      articleLists: [
        { id: "a" },
        { id: "b" },
        { id: "c" },
        { id: "d" },
        { id: "e" },
        { id: "f" },
        { id: "g" },
        { id: "h" },
      ],
    };
  },
  methods: {
    scrollBottom() {
      /* 
        document.documentElement和document.body的区别
        documentElement 对应的是 html 标签，body 对应的是 body 标签，
        在w3c标准下，document.body.scrollTop是恒为0的，需要用document.documentElement.scrollTop来代替，所以需要进行一下判断
      */
      // 变量scrollTop为当前页面的滚动条纵坐标位置
      let scrollTop =
        document.documentElement.scrollTop || document.body.scrollTop;
      // 变量 windowHeight 是可视区的高度
      const windowHeight =
        document.documentElement.clientHeight || document.body.clientHeight;
      // 变量 scrollHeight 是滚动条的总高度
      const scrollHeight =
        document.documentElement.scrollHeight || document.body.scrollHeight;

      // scrollTop在移动端可能会是小数,导致到底时，判断条件不相等
      if (Math.floor(scrollTop) + windowHeight == scrollHeight || Math.ceil(scrollTop) + windowHeight == scrollHeight) {
          const timer = setTimeout(()=>{
            this.articleLists = [...this.articleLists,...[{id:"0"},{id:"0"},{id:"0"},{id:"0"},{id:"0"}]]
            clearTimeout(timer);
          },1000)
      }
    },
  },
  mounted() {
    // 添加滚动事件
    window.addEventListener("scroll", this.scrollBottom);
  },
  destroyed() {
    // 组件销毁清除滚动条事件
    window.removeEventListener("scroll", this.scrollBottom);
  },
};
</script>

<style lang="less" scoped>
	...
</style>
```

