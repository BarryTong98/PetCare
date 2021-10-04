<template>
  <div class="home-container">
    <el-container >
      <el-container>
        <el-aside width="50%">
          <div>
            <a href="http://localhost:8080/#/welcome">
              <img class="dog" src="../../assets/img/dogicon.svg" alt="missing" />
            </a>
            <div class="sign">
              <div class="login">
                <router-link exact style="text-decoration: none; font-size: 20px; font-family: PPWoodland-Bold" to="/homelogin">
                  <div class="back">I'm back</div>
                </router-link>
              </div>
              <div class="register">
                <router-link style="text-decoration: none; font-size: 20px; font-family: PPWoodland-Bold" to="/register" exact>
                  <div class="newHere">I'm new here</div>
                </router-link>
              </div>
              <router-view></router-view>
            </div>
          </div>
        </el-aside>
        <el-main style="padding: 0">
          <img class="people" src="../../assets/img/web1.svg">
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Register from '@/components/HomePage/Register'
export default {
  components: { Register }
}
</script>

<style>




.back{
  float: left;
  margin-left: 24%;
  margin-right: 20%;
}


.router-link-active {
  text-decoraction: none ;
  color: #f8977a;
}

a{
  color: black;
}

.people{
  width: 50%;
  height: 50% ;
  margin-top: 20%;
}
.dog{
  margin: 10% 10% 5%;
  width: 67px;
  height: 70px;
}

.el-aside {
  background-color: #f9f7f4;
  color: #333;
}

.el-main{
  text-align: center;
  background-color: #ffffff;
  padding: 0;
}

.home-container {
  display: flex;
  height: 100%;
}

</style>
