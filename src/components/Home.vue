<template>
  <el-container class="home-container">
    <!--头部区域-->
    <el-header>
      <div>
        <img src="../assets/Dog.png">
        <span>Pet Care</span>
      </div>
      <el-button type="info" @click="logout">退出</el-button>
    </el-header>
    <!--页面主题区域-->
    <el-container>
      <!--侧边栏-->
      <el-aside width="200px">Aside</el-aside>
      <!--右侧主题内容-->
      <el-main>
        Main
        <div>
          <el-carousel :interval="4000" type="card" height="300px">
            <el-carousel-item v-for="item in itemList" :key="item">
              <img :src="item" alt="missing"/>
            </el-carousel-item>
          </el-carousel>
        </div>
      </el-main>
    </el-container>
  </el-container>
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
  },
  methods: {
    logout () {
      window.sessionStorage.clear()
      this.$router.push('/login')
    }
  }
}
</script>

<style lang="less" scoped>
.home-container {
  height: 100%;
}

.el-header {
  background-color: #b3ddce;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: #fff;
  font-size: 20px;

  > div {
    display: flex;
    align-items: center;

    span {
      margin-left: 20px;
    }

    img {
      width: 50px;
      height: 50px;
      margin-left: 10px;
    }
  }
}

.el-aside {
  background-color: rgb(244, 244, 245);
}

.el-main {
  background-color: #daebe6;
}

</style>
