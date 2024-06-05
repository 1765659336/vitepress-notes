## vue动画

### 自定义动画

如果元素或组件离开，完成一个淡出效果：

```vue
<transition name="fade">
  <p v-if="show">100</p>
</transition>
<style>
.fade-leave {
    opacity: 1
}
.fade-leave-active {
    transition: all 1s;
}
.fade-leave-to {
    opcaity: 0
}
</style>
```

+ 进入（显示，创建）

  + v-enter 进入前 （vue3.0 v-enter-from）
  + v-enter-active 进入中

  + v-enter-to 进入后离开（隐藏，移除）

+ 离开（隐藏，移除）

  + v-leave 离开前 （vue3.0 v-leave-from）
  + v-leave-active 离开中
  + v-leave-to 离开后

1. 使用<transition>包裹要过度的元素，并配置name属性：

```vue
<transition name="hello">
	<h1 v-show="isShow">你好啊！</h1>
</transition>
```

2. 备注：若有多个元素需要过度，则需要使用：<transition-group>，且每个元素都要指定key值（number/string）。

`注意：多个transition使用不同动画，可以添加name属性，name属性的值替换v即可`

### animate.css

1. 安装

`npm i animate.css`

2. 引入

```js
import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
// // 引入animation.css动画库
import 'animate.css';
Vue.config.productionTip = false;

new Vue({
    router,
    store,
    render: (h) => h(App),
}).$mount("#app");
```

3. 使用

```vue
<template>
  <div>
    <button @click="isShow = !isShow">显示/隐藏</button>
    <transition-group
      appear
      name="animate__animated animate__bounce"
      enter-active-class="animate__swing"
      leave-active-class="animate__backOutUp"
    >
      <h1 v-show="!isShow" key="1">你好！</h1>
      <h1 v-show="isShow" key="2">hi!</h1>
    </transition-group>
  </div>
</template>

<script>
export default {
  name: "web-a",
  data() {
    return {
      isShow: true,
    };
  },
};
</script>

<style lang="less" scoped>
</style>
```

