<template>
  <div class="home-container">
    <el-container >
      <el-container>
        <el-aside width="50%">
          <div>
            <img class="dog" src="../../assets/img/dogicon.svg"/>
            <div class="sign">
              <div class="login">
                <router-link to="/homelogin">
                  <div>I'm back</div>
                </router-link>
              </div>

              <div class="register">
                <router-link to="/register" exact>
                  <div>I'm new here</div>
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

.sign{
  display: flex;
}


img{
  max-width: 100%;
  max-height: 100%;
}

/*为了让router-link不显示下划线*/
a {
  text-decoraction: none;
}
.router-link-active {
  text-decoration: none;
}


.people{
  width: 50%;
  height: 50% ;
  margin-top: 20%;
}
.dog{
  margin: 10%;
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
