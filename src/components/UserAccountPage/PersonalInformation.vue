<template>
  <div>
    <el-row>
      <el-col :span="2" :offset="22">
        <el-button id="edit_button" type="primary" @click="editinfo">Edit</el-button>
      </el-col>
    </el-row>
    <el-row style="margin-top: 20px">
      <!--用户头像-->
      <el-col :span="2" :offset="9" >
        <div id="userImg">
          <img :src="user.imageUrl" alt="" style="width: 100px; height: 100px"></img>
        </div>
      </el-col>
      <!--上传图片-->
      <el-col  :span="4" :offset="1">
        <h2>{{ user.userName }}</h2>
      </el-col>
    </el-row>

    <!--用户信息-->
    <el-descriptions style="margin: 50px;" class="margin-top"  :column="2" border>
      <el-descriptions-item>
        <template  slot="label">
          <i class="el-icon-user"></i>
          Username
        </template>
        {{ user.userName }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-user"></i>
          Nickname
        </template>
        {{ user.nickName }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          Phone number
        </template>
        {{ user.phoneNumber }}
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-message"></i>
          Email
        </template>
        {{ user.email }}
      </el-descriptions-item>
    </el-descriptions>

  </div>
</template>

<script>
export default {
  name: "PersonalInformation",
  data() {
    return {
      user: {},
    };
  },
  methods:{
    editinfo(){
      this.$router.replace('/editinfo')
    },

    getInfo(){
      const _this = this;
      _this.$http.get("http://110.40.184.115:8080/user/" + 1) //1目前是瞎写的，到时候从localdatabse拿
        .then(function (response) {
          console.log(response.data.data);
          _this.user = response.data.data;
        });
    }
  },

  created() {
    this.getInfo()
  },
}
</script>

<style scoped>
#userImg{
  width: 100px;
  height: 100px;
  border-radius: 50%;
  border: 1px solid #eee;
  overflow: hidden;
}
#edit_button{
  color: #fff;
  background-color: #fa997e;
  border-color: #fa997e;
}


</style>
