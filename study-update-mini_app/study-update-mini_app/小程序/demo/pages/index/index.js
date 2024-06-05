// index.js
// 获取应用实例
const app = getApp()

Page({
  data: {
    message:"Hello",
    movies:["西虹市首富","师傅"],
    count:0
  },

  countAdd: function(){
    this.setData({
      count:this.data.count+1
    })
  },

  countDel:function(){
    this.setData({
      count:this.data.count-1
    })
  }
})
