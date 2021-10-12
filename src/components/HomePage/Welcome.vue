<template>
  <div>
    <el-carousel :interval="4000" type="card" :height="bannerHeight + 'px'">
      <el-carousel-item v-for="item in itemList" :key="item">
        <el-row :span="24" class="banner_img">
          <img ref="bannerHeight" :src="item" alt="missing" class="bannerImg" @load="imgLoad"/>
        </el-row>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  data () {
    return {
      bannerHeight: '',
      itemList: [
        require('../../assets/img/cristian-castillo-73pyV0JJOmE-unsplash.jpeg'),
        require('../../assets/img/martha-dominguez-de-gouveia-nMyM7fxpokE-unsplash.jpeg'),
        require('../../assets/img/autri-taheri-l0Gq4BmboYY-unsplash.jpeg'),
        require('../../assets/img/markus-winkler-PcKhVNNyEio-unsplash.jpeg')
      ]
    }
  },
  methods: {
    imgLoad () {
      this.$nextTick(() => {
        this.bannerHeight = this.$refs.bannerHeight[0].height
        console.log(this.$refs.bannerHeight[0].height)
      })
    }
  },
  mounted () {
    this.imgLoad()
    window.addEventListener('resize', () => {
      this.bannerHeight = this.$ref.bannerHeight[0].height
      this.imgLoad()
    },false)
  },
}
</script>

<style scoped>
div {
  font-family: Arial, Helvetica, sans-serif;
}

img {
}
</style>