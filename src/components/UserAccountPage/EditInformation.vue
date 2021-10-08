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
          action="http://110.40.184.115:8080/oss/upload?module=avatar&&userName=TL"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
      </el-col>
    </el-row>

    <!--更新用户信息表单-->
    <el-form
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
   // this.handle(this.$route.query.id);
    this.getInfo();
  },

  handle(id){
    let config = {
      url:'http://localhost:3000/users/'+id,
      method: 'get',
    }
    axios(config)
      .then((response) => {
        console.log(response)
        this.customer = response.data
        //  console.log(customer)
      })
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
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //  alert('submit!');
          let updateCustomer = {
            uid:1,
            email: this.customer.email,
            userName:this.customer.userName,
            nickName:this.customer.nickName,
            phoneNumber:this.customer.phoneNumber,
            password:this.customer.password,
          }

          _this.$http.put('http://110.40.184.115:8080/user/update',updateCustomer)
            .then((response) => {
              this.$message({
                message: 'Update successfully!',
                type: 'success'
              });
              // this.$router.push({path:'/customers',query:{alert:'success'}})
            })
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
      _this.$http.get("http://110.40.184.115:8080/user/" + 1) //userid是1目前是瞎写的，到时候从localdatabse拿
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
