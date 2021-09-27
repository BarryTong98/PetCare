<template>
    <div>
      <el-carousel :interval="4000" type="card">
        <el-carousel-item v-for="item in itemList" :key="item">
          <img :src="item" alt="missing"/>
        </el-carousel-item>
      </el-carousel>
    </div>
</template>

<script>
export default {
  data () {
    return {
      itemList: [
        require('../../assets/img/cristian-castillo-73pyV0JJOmE-unsplash.jpeg'),
        require('../../assets/img/martha-dominguez-de-gouveia-nMyM7fxpokE-unsplash.jpeg'),
        require('../../assets/img/autri-taheri-l0Gq4BmboYY-unsplash.jpeg'),
        require('../../assets/img/markus-winkler-PcKhVNNyEio-unsplash.jpeg')
      ]
    }
  }
}
</script>

<style scoped>
div{
  font-family: Arial,Helvetica,sans-serif;
}
</style>