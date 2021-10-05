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
          <img src="../../assets/d.png" alt="" style="width: 100px; height: 100px"></img>
        </div>
      </el-col>
      <!--上传图片-->
      <el-col  :span="4" :offset="1">
        <h2>Lin Tang</h2>
      </el-col>
    </el-row>

    <!--用户信息-->
    <el-descriptions style="margin: 50px;" class="margin-top"  :column="2" :size="size" border>
      <el-descriptions-item>
        <template  slot="label">
          <i class="el-icon-user"></i>
          Username
        </template>
        Lin Tang
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-user"></i>
          Nickname
        </template>
        kooriookami
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-view"></i>
          Password
        </template>
        qwertyui123
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          Phone number
        </template>
        18100000000
      </el-descriptions-item>
      <el-descriptions-item>
        <template slot="label">
          <i class="el-icon-message"></i>
          Email
        </template>
        871616433@qq.com
      </el-descriptions-item>
    </el-descriptions>

  </div>
</template>

<script>
export default {
  name: "PersonalInformation",
  data() {
    return {

    };
  },
  methods:{
    editinfo(){
      this.$router.replace('/editinfo')
    }
  }
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
