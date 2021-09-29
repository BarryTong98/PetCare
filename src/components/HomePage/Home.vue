<template>
  <el-container class="home-container">
    <!--头部区域-->
    <el-header>
      <div>
        <a href="http://localhost:8080/#/welcome">
          <img src="../../assets/img/dogicon.svg" alt="missing" />
        </a>
        <span class="homeName">Pet Care</span>
      </div>
      <div>
        <el-input
            placeholder="Search "
            v-model="input"
            clearable>
        </el-input>
        <el-button type="primary" icon="el-icon-search"></el-button>
      </div>
      <el-button type="info" class="signoutButton" @click="logout">Sign Out</el-button>
    </el-header>
    <!--页面主题区域-->
    <el-container>
      <!--侧边栏-->
      <el-aside :width="isCollapse ? '64px' : '200px'">
        <div class="toggle-button" @click="toggleCollapse" router><-></div>
        <!--侧边栏Menu区域-->
        <el-menu
            background-color="#fa997e"
            text-color="#2C3D50"
            active-text-color="#fff"
            unique-opened :collapse="isCollapse"
            :collapse-transition="false">
          <!--一级菜单-->
          <el-submenu index="1">
            <!--一级菜单的模板区域-->
            <template slot="title">
              <!--图标-->
              <svg t="1632402758059" class="icon" viewBox="0 0 1024 1024" version="1.1"
                   xmlns="http://www.w3.org/2000/svg" p-id="4015" width="32" height="32">
                <path
                    d="M113.777778 426.666667h768v56.888889H113.777778zM483.555556 725.333333V568.888889c0-15.644444 12.8-28.444444 28.444444-28.444445s28.444444 12.8 28.444444 28.444445v156.444444c0 15.644444-12.8 28.444444-28.444444 28.444445s-28.444444-12.8-28.444444-28.444445z"
                    fill="#404042" p-id="4016"></path>
                <path
                    d="M597.333333 682.666667H426.666667c-15.644444 0-28.444444-12.8-28.444445-28.444445s12.8-28.444444 28.444445-28.444444h170.666666c15.644444 0 28.444444 12.8 28.444445 28.444444s-12.8 28.444444-28.444445 28.444445z"
                    fill="#404042" p-id="4017"></path>
                <path
                    d="M113.777778 384v384c0 62.577778 51.2 113.777778 113.777778 113.777778h568.888888c62.577778 0 113.777778-51.2 113.777778-113.777778V384c0-62.577778-51.2-113.777778-113.777778-113.777778H227.555556c-62.577778 0-113.777778 51.2-113.777778 113.777778z m682.666666 440.888889H227.555556c-31.288889 0-56.888889-25.6-56.888889-56.888889V384c0-31.288889 25.6-56.888889 56.888889-56.888889h568.888888c31.288889 0 56.888889 25.6 56.888889 56.888889v384c0 31.288889-25.6 56.888889-56.888889 56.888889z"
                    fill="#404042" p-id="4018"></path>
                <path
                    d="M369.777778 284.444444v-28.444444c0-31.288889 25.6-56.888889 56.888889-56.888889h170.666666c31.288889 0 56.888889 25.6 56.888889 56.888889v28.444444h56.888889v-28.444444c0-62.577778-51.2-113.777778-113.777778-113.777778H426.666667c-62.577778 0-113.777778 51.2-113.777778 113.777778v28.444444h56.888889z"
                    fill="#404042" p-id="4019"></path>
              </svg>
              <!--文本-->
              <span>Health</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">Health Examination</el-menu-item>
              <el-menu-item index="1-2">Vaccine</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">Vaccine</template>
              <!--二级菜单-->
              <el-menu-item index="1-4-1">Canine parvovirus</el-menu-item>
              <el-menu-item index="1-4-1">Rabies</el-menu-item>
            </el-submenu>
          </el-submenu>

          <el-submenu index="2">
            <!--一级菜单的模板区域-->
            <template slot="title">
              <!--图标-->
              <!--<i class="el-icon-location"></i>-->
              <!--文本-->
              <!--ICON-->
              <svg t="1632402499676" class="icon" viewBox="0 0 1024 1024" version="1.1"
                   xmlns="http://www.w3.org/2000/svg" p-id="3019" width="32" height="32">
                <path
                    d="M514.56 424.8832c-146.688 0-266.6752 192.6144-266.6752 266.6752 0 146.688 119.9872 148.1472 266.6752 148.1472 146.6624 0 266.6496-1.4848 266.6496-148.1472 0-74.0608-119.9872-266.6752-266.6496-266.6752z m0 355.584c-114.0736 0-207.4112 0-207.4112-88.9088 0-44.4416 93.3376-207.4112 207.4112-207.4112s207.3856 162.9696 207.3856 207.4112c0 103.7056-93.312 88.8832-207.3856 88.8832zM207.872 365.6192a86.5024 86.5024 0 0 0-86.656 86.656 86.5024 86.5024 0 0 0 86.656 86.656 86.5024 86.5024 0 0 0 86.6816-86.656 86.5024 86.5024 0 0 0-86.6816-86.656z m0 119.9872a33.024 33.024 0 0 1-33.3312-33.3312c0-18.688 14.6688-33.3312 33.3312-33.3312 18.688 0 33.3568 14.6688 33.3568 33.3312A33.024 33.024 0 0 1 207.872 485.632z m606.6688-106.6752a86.5024 86.5024 0 0 0-86.656 86.6816 86.5024 86.5024 0 0 0 86.656 86.656 86.5024 86.5024 0 0 0 86.6816-86.656 86.5024 86.5024 0 0 0-86.6816-86.6816z m0 120.0128a33.024 33.024 0 0 1-33.3312-33.3312c0-18.688 14.6688-33.3312 33.3312-33.3312 18.688 0 33.3312 14.6688 33.3312 33.3312a33.024 33.024 0 0 1-33.3312 33.3312z m-160-280.0128a86.5024 86.5024 0 0 0-86.656 86.6816 86.5024 86.5024 0 0 0 86.656 86.656 86.5024 86.5024 0 0 0 86.6816-86.656 86.5024 86.5024 0 0 0-86.6816-86.6816z m0 120.0128a33.024 33.024 0 0 1-33.3312-33.3312c0-18.688 14.6688-33.3312 33.3312-33.3312 18.688 0 33.3312 14.6688 33.3312 33.3312a33.024 33.024 0 0 1-33.3312 33.3312z m-253.312-133.3248c-54.6816 0-100.0192 45.312-100.0192 99.9936 0 54.656 45.3376 99.9936 100.0192 99.9936 54.656 0 99.9936-45.312 99.9936-99.9936s-45.3376-99.9936-99.9936-99.9936z m0 146.6624c-25.344 0-46.6688-21.3504-46.6688-46.6688 0-25.344 21.3248-46.6688 46.6688-46.6688s46.6432 21.3248 46.6432 46.6688-21.3248 46.6688-46.6432 46.6688z"
                    p-id="3020"></path>
              </svg>
              <span>Beauty</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1">*****</el-menu-item>
              <el-menu-item index="1-2">*****</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
        </el-menu>
      </el-aside>
      <!--右侧主题内容-->
      <el-main>
        <HomeProfile/>
        <Welcome/>
        <Aboutus/>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Aboutus from '@/components/HomePage/Aboutus'
import CardList from '@/components/HomePage/CardList'
import Welcome from '@/components/HomePage/Welcome'
import HomeProfile from '@/components/HomePage/HomeProfile'
export default {
  components: { HomeProfile, Welcome, CardList, Aboutus },
  data () {
    return {
      isCollapse: true
    }
  },
  methods: {
    refersh(){
      this.$router.push('/home')
    },
    logout () {
      window.sessionStorage.clear()
      this.$router.push('/login')
    },
    toggleCollapse () {
      this.isCollapse = !this.isCollapse
    }
  }
}
</script>

<style lang="less" scoped>

body {

  //font-family: "American Typewriter", serif;
  font-family: "Object Sans","Helvetica Neue", Helvetica,Arial,sans-serif;
}
.homeName{
  font-family: PPWoodland-Ultralight;
}
.signoutButton{
  font-family: "Object Sans","Helvetica Neue", Helvetica,Arial,sans-serif;
  background-color: #fa997e;
  border: transparent;
}

.home-container {
  height: 100%;
}

.el-header {
  background-color: #fcb517;
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
      margin-left: 15px;
    }

    img {
      width: 50px;
      height: 50px;
      margin-left: 10px;
    }
  }
}

.el-aside {
  background-color: #fa997e;

  .el-menu {
    border-right: none;
  }
}

.el-main {
  padding: 0;
  background-color: #fff;
}

.el-menu {
  svg {
    margin-right: 5%;
  }
}

.el-input {
  margin-left: -19%;
  width: 700px;
}

.toggle-button {
  background-color: #bbfad6;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;
}
</style>
