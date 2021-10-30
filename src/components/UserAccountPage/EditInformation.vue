<template>
  <div class="edit">
    <el-row>
      <el-page-header @back="back2Info" content="Edit Page" title="Back" style="color:#fa997e">
      </el-page-header>
    </el-row>
    <el-row style="margin-top: 20px">
      <!--当前头像-->
      <el-col :span="2" :offset="9" >
        <div id="userImg">
          <img :src="customer.imageUrl" alt="" style="width: 100px; height: 100px"></img>
        </div>
      </el-col>
      <!--上传图片-->
      <el-col  :span="4" :offset="1">
        <el-upload id="uploadImg"
          class="avatar-uploader"
           ref="upload"
          :action="'http://47.96.6.135:8080//oss/upload?module=avatar&&userName='+ this.customer.userName"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :auto-upload="false"
          :before-upload="beforeAvatarUpload">
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-col>
    </el-row>

    <!--更新用户信息表单-->
    <el-form
      status-icon
      :label-position="labelPosition"
      label-width="170px"
      :model="customer"
      :rules="rules"
      ref="ruleForm"
      style="margin-top: 20px"
    >
      <el-form-item label="Username" prop="userName">
        <el-input v-model="customer.userName"></el-input>
      </el-form-item>
      <el-form-item label="Nickname" prop="nickName">
        <el-input v-model="customer.nickName"></el-input>
      </el-form-item>
      <el-form-item label="Phone" prop="phoneNumber">
        <el-input v-model="customer.phoneNumber"></el-input>
      </el-form-item>
      <el-form-item label="Email" prop="email">
        <el-input v-model="customer.email"></el-input>
      </el-form-item>

      <el-form-item >
        <el-button id="update_button" type="primary" @click="submitForm('ruleForm')">Update</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>


<script>
export default {
  name: "EditInformation",
  data(){
    return {
      imageUrl: '',
      labelPosition: 'right',
      userid:0,
      //表单
      customer:{
        userName:'',
        nickName:'',
        phoneNumber:'',
        email:'',
        password: '',
      },
      rules:{
        userName:[
          { required: true, message: 'Please input username', trigger: 'blur' }
        ],
        nickName:[
          { required: true, message: 'Please input nickname', trigger: 'blur' }
        ],
        phoneNumber:[
          { required: true, message: 'Please input phone number', trigger: 'blur' },
        ],
        email:[
          { required: true, message: 'Please input email', trigger: 'blur' },
          { type: 'email', message: 'Email format is incorrect', trigger: ['blur', 'change'] }
        ],
      }
    }
  },

  created() {
    this.userid =sessionStorage.getItem("userId"),
    this.getInfo();
  },

  methods:{
    //回到用户信息界面
    back2Info(){
      this.$router.replace('/information')
    },

    //提交表单
    //这里的uid是乱写的，到时候记得改为从localhost中拿来的uid
    submitForm(formName) {
      const _this = this;
      this.$refs.upload.submit();
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //  alert('submit!');
          let updateCustomer = {
            uid:_this.userid,
            email: _this.customer.email,
            userName:_this.customer.userName,
            nickName:_this.customer.nickName,
            phoneNumber:_this.customer.phoneNumber,
            password:_this.customer.password,
          }

          _this.$http.put('http://47.96.6.135:8080/user/update',updateCustomer)
            .then((response) => {
              this.$message({
                message: 'Update successfully!',
                type: 'success'
              });
            })
          _this.$router.go(0);
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },

    //上传头像
    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
      console.log(URL.createObjectURL(file.raw))
      console.log(this.imageUrl)
      console.log(res)
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg';
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!');
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!');
      }
      return isJPG && isLt2M;
    },

    //获取用户信息
    getInfo(){
      const _this = this;
      _this.$http.get("http://47.96.6.135:8080/user/" + _this.userid) //userid是1目前是瞎写的，到时候从localdatabse拿
        .then(function (response) {
          console.log(response.data.data);
          _this.customer = response.data.data;
        });
    }
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

/*头像上传*/
#uploadImg{
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  width: 100px;
  height: 100px;
  line-height: 100px;
}

#uploadImg:hover {
  border-color: #fa997e;
}

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  line-height: 100px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
#update_button{
  color: #fff;
  background-color: #fa997e;
  border-color: #fa997e;
}

</style>
