<template>

  <div>
    <el-carousel :interval="4000" type="card" height="300px">
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
      // itemList: [
      //   {url: '../assets/img/agathe-marty-2cdvYh6ULCs-unsplash.jpeg', name: "missing"},
      //   {url: '../assets/img/abstract-low-poly-minimalist-minimalism-y710.jpg', name: "missing"},
      //   {url: '../assets/img/amored-titan-vs-attack-titan-attack-on-titan-shingeki-no-kyojin-t461.jpg', name: "missing"},
      // ]
      itemList: [
        require('../assets/img/agathe-marty-2cdvYh6ULCs-unsplash.jpeg'),
        require('../assets/img/abstract-low-poly-minimalist-minimalism-y710.jpg'),
        require('../assets/img/amored-titan-vs-attack-titan-attack-on-titan-shingeki-no-kyojin-t461.jpg'),
        require('../assets/img/boruto-cute-boruto-anime-y741.jpg')
      ]
    }
  }
}
</script>

<style>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}
.el-carousel__item img {
  display: inline-block;
  height: auto;
  max-width: 100%;
}



.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
</style>
