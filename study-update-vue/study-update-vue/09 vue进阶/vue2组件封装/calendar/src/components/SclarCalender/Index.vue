<template>
  <div class="box">
    <div class="date">日期</div>
    <div class="week">
      <div
        v-for="item in 7"
        :key="item"
        :class="item == weekItem ? 'weekItem' : ''"
      >
        星期{{ item }}
      </div>
    </div>
    <div class="container">
      <div
        v-for="(item, index) in this.dayArr"
        :key="index"
        :class="index + 1 == dayItem ? 'weekItem' : ''"
        @click="addEvent(index)"
      >
        {{ item.day }}
        <ul>
          <li v-for="item2 in item.eventArr" :key="item2.id">
            {{ item2.event + item2.place }}
          </li>
        </ul>
      </div>
    </div>
    <!-- <div class="popup-container" v-show="showPopup" @click="closePopup"> -->
    <div class="popup" v-show="showPopup">
      事件：<input
        type="text"
        :value="inputEvent"
        @input="onInput(...arguments, 'inputEvent')"
      />
      地点：<input
        type="text"
        :value="inputPlace"
        @input="onInput(...arguments, 'inputPlace')"
      />
      <button @click="save">保存</button>
    </div>
    <!-- </div> -->
  </div>
</template>

<script>
export default {
  name: "SolarCalender",
  data() {
    return {
      // 今天是星期几,默认给8，下标从0开始不会遍历到等于8
      weekItem: 8,
      dayItem: 0,
      dayArr: [],
      inputEvent: "",
      inputPlace: "",
      showPopup: false,
      changeEventArrIndex: undefined,
    };
  },
  methods: {
    main() {
      // 获取今天的当前日期
      let currentDay = new Date();
      console.log(currentDay.getDate()); //当前是该月的第几天
      console.log(currentDay.getMonth() + 1); // 当前是该年的第几月
      console.log(currentDay.getFullYear()); // 获取当前的年份
      this.weekItem = currentDay.getDay();
      let c = new Date(currentDay.getFullYear(), currentDay.getMonth() + 1, 0);
      console.log(c.getDate()); // 获取当前月有多少天
      let a = new Date(currentDay.getFullYear(), currentDay.getMonth(), 1);
      console.log(a.getDay()); // 获取当前月第一天是星期几
      // 上个月有多少天
      let lastMouthEnd = new Date(
        currentDay.getFullYear(),
        currentDay.getMonth(),
        0
      ).getDate();
      let arr = [];
      for (let i = 1; i <= c.getDate(); i++) {
        arr.push({ day: i, "eventArr": [] });
      }
      for (let i = 0; i < a.getDay() - 1; i++) {
        arr.unshift({ day: lastMouthEnd - i, "eventArr": [] });
      }
      for (let i = 1; i <= 35 - c.getDate() - a.getDay() + 1; i++) {
        arr.push({ day: i, "eventArr": [] });
      }
      this.dayItem = currentDay.getDate() + a.getDay() - 1;
      this.dayArr = [...arr];
    },
    onInput(e, valueType) {
      e.stopPropagation();
      console.log(e);
      console.log(valueType);
      this[valueType] = e.target.value;
      console.log(2);
    },
    addEvent(index) {
      this.showPopup = true;
      this.changeEventArrIndex = index;
    },
    save(e) {
      console.log(e);
      this.dayArr[this.changeEventArrIndex].eventArr.push({
        event: this.inputEvent,
        place: this.inputPlace,
        id: new Date(),
      });
      this.closePopup(e);
    },
    closePopup(e) {
      this.showPopup = false;
      this.inputPlace = "";
      this.inputEvent = "";
      console.log(e);
    },
  },
  beforeMount() {
    this.main();
  },
};
</script>

<style scoped>
.weekItem {
  color: red;
}
.box {
  width: 100vw;
  height: 100vh;
  position: relative;
}

.date {
  width: 100vw;
  height: 5vh;
}

.week {
  width: 100vw;
  height: 5vh;
  display: flex;
  justify-content: space-around;
}

.week div {
}
.container {
  width: 100vw;
  height: 90vh;
  display: grid;
  grid-template-columns: repeat(7, 1fr);
  grid-template-rows: repeat(5, 1fr);
}

.container div {
  border: 1px solid black;
}

.popup-container {
  background-color: rgba(255, 255, 255, 0.5);
  position: absolute;
  top: 0;
  width: 100vw;
  height: 100vh;
  z-index: 1;
}

.popup {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  width: 300px;
  height: 300px;
  background-color: pink;
  z-index: 2;
}
</style>
