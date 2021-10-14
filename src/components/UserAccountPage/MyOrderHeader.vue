<template>
  <div>
    <!--Pet Care logo-->
    <el-col :span="1">
      <router-link to="/home"><img src="../../assets/img/dogicon.svg" style="width: 60px;margin-top: 8px"></router-link>
    </el-col>
    <!--Pet Care 网站名字-->
    <el-col :span="4">
      <router-link to="/home"><div id="homeName">Pet Care</div></router-link>
    </el-col>
    <!--用户头像-->
    <el-col :span="1" :offset="15">
      <div id="userImg">
        <img :src="user.imageUrl" alt="" style="width: 50px; height: 50px"></img>
      </div>
    </el-col>
    <!--顶部右侧下拉菜单栏-->
    <el-col :span="2">
      <el-dropdown @command="handleCommand" style="margin-top: 20px;margin-left: 10px">
        <el-button type="primary"
                   style="color: #fff;
                       background-color: #fa997e;
                       border-color: #fa997e;" >
          My Account<i class="el-icon-arrow-down el-icon--right"></i>
        </el-button>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="order">My orders</el-dropdown-item>
          <el-dropdown-item command="information">Personal information</el-dropdown-item>
          <el-dropdown-item command="logout">Logout</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-col>
  </div>
<!--  </el-header>-->
</template>

<script>
export default {
  name: "MyOrderHeader",
  data() {
    return {
      activeIndex: '1',
      activeIndex2: '1',
      user: {},
      userid:0,
    };
  },
  methods: {
    // 判断下拉菜单指令
    handleCommand(command) {
      if (command == "order"){
        this.myorder()
      }
      else if (command == "information"){
        this.information()
      }else {
        this.logout()
      }
    },
    // 退出
    async logout() {
      window.sessionStorage.clear()
      this.$router.push('/home')
    },
    //点击改变路由
    myorder(){
      this.$router.replace('/ordernotstart')
    },
    information(){
      this.$router.replace('/information')
    },
    //获取用户信息，得到头像url
    getInfo(){
      const _this = this;
      _this.$http.get("http://110.40.184.115:8080/user/" + _this.userid) //1目前是瞎写的，到时候从localdatabse拿
        .then(function (response) {
          console.log(response.data.data);
          _this.user = response.data.data;
        });
    }
  },

  created() {
    this.userid =sessionStorage.getItem("userId"),
    this.getInfo()
  },
}
</script>

<style scoped>
#homeName{
  font-family: PPWoodland-Ultralight;
  font-size: 30px;
  color: #FFFFFF;
  margin-left: 20px;
  margin-top: 30px;
}

el-button{
  color: #fa997e;
  background-color: #fa997e;
}

#userImg{
  margin-top: 15px;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  border: 1px solid #eee;
  overflow: hidden;
}

a{
  text-decoration:none;
}


</style>
