<template>
  <div id="app">
    <SolarCalender />
  </div>
</template>

<script>
import SolarCalender from './components/SclarCalender/Index.vue'

export default {
  name: 'App',
  components: {
    SolarCalender
  }
}
</script>

<style>
 * {
   padding: 0;
   margin: 0;
 }
</style>
