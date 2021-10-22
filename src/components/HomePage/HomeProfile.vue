<template>
  <div class="main">
    <div>
      <p class="first">
        Personalised Pet care from the comfort of your home
      </p>
      <!--<p>-->
      <!--  We’re here for you, via video calls, house visits and medication delivery.-->
      <!--</p>-->
      <router-link v-if="isToken" :to="{name: 'search', params: {keyword: ' ', address: 'Sydney', checked: 4095}}">
        <button class="btn-quality">
          Get started
        </button>
      </router-link>
      <el-button class="btn-quality" v-else @click="jumpToLogin" type="primary">
        Get started
      </el-button>

    </div>
    <img src="../../assets/img/pet.png" alt="missing">
  </div>
</template>

<script>
export default {
  name: 'HomeProfile',
  data(){
    return{
      isToken: false
    }
  },
  methods:{
    jumpToLogin(){
      this.$message({
        message: 'You have not login!',
        type: 'warning'
      });

      this.$router.push('/homelogin')
    }
  },
  created() {
    const token = sessionStorage.getItem("token")
    console.log("token:" + token)
    console.log(token === null)
    if(token === null){
      this.isToken = false
    }else{
      this.isToken = true
    }
    console.log(this.isToken)
  },
}
</script>

<style scoped>
@import "../../assets/style/font.less";

.main {
  display: flex;
}

.first {
  margin-left: 2%;
  font-size: 4vw;
  font-family: 'PPWoodland-Bold';
}

img {
  width: 40%;
  height: 40%;
}

.btn-quality {
  width: 28vw;
  height: 4.6vw;
  background-color: #f4511e;
  border: none;
  font-size: 1.25vw;
  opacity: 0.6;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  font-family: "ObjectSans-Bold";
  font-stretch: normal;
  font-style: normal;
  line-height: 1;
  letter-spacing: normal;
  text-align: center;
  color: #ffffff;
  margin-left: 5vw;
  margin-top: 1vw;
  margin-bottom: 2vw;
}
</style>
