<template>
  <div class="todo-footer" v-show="total">
    <label>
      <!-- 在输入框里面值初始化是一个计算属性，后面也需要修改，推荐使用v-model -->
      <!-- 在输入框里面值初始化是一个props，不推荐使用v-model -->
      <!-- <input type="checkbox" :checked="isAll" @click="selectAll"> -->
      <!-- input为checkbox时，v-model绑定的是checked值 -->
      <input type="checkbox" v-model="isAll">
    </label>
    <span>
      <span>已完成{{statistical}}</span>
      / 全部{{total}}
    </span>
    <button class="btn btn-danger" @click="clearAll">清除已完成任务</button>
  </div>
</template>

<script>
export default {
  name: "MyFooter",
  props: ["todos", "changeSelectAll", "delectDone"],
  computed: {
    statistical() {
      // pre上一次执行reduce的第一个参数函数的返回值，current当前的todos的循环项
      // reduce作为es6新增的方法，一般用来做数组的条件筛选
      return this.todos.reduce((pre, current) => {
        return pre + (current.done ? 1 : 0);
      }, 0);
    },
    total() {
      return this.todos.length;
    },
    isAll: {
      get() {
        return this.total === this.statistical;
      },
      set(checked) {
        // console.log(checked);
        return this.changeSelectAll(checked);
      }
    }
  },
  methods: {
    //  selectAll(e){
    //   this.changeSelectAll(e.target.checked)
    // }
    clearAll() {
      if (confirm("是否删除已完成")) {
        this.delectDone();
      }
    }
  }
};
</script>

<style scoped>
/*footer*/
.todo-footer {
  height: 40px;
  line-height: 40px;
  padding-left: 6px;
  margin-top: 5px;
}

.todo-footer label {
  display: inline-block;
  margin-right: 20px;
  cursor: pointer;
}

.todo-footer label input {
  position: relative;
  top: -1px;
  vertical-align: middle;
  margin-right: 5px;
}

.todo-footer button {
  float: right;
  margin-top: 5px;
}
</style>