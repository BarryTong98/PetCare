<template>
  <div class="edit">

    <el-row>
      <el-page-header @back="back2Info" content="Edit" title="Back" style="color:#fa997e">
      </el-page-header>
    </el-row>
    <el-row style="margin-top: 20px">
      <!--当前头像-->
      <el-col :span="2" :offset="9" >
        <div id="userImg">
          <img src="../../assets/d.png" alt="" style="width: 100px; height: 100px"></img>
        </div>
      </el-col>
      <!--上传图片-->
      <el-col  :span="4" :offset="1">
        <el-upload id="uploadImg"
          class="avatar-uploader"
          action="https://jsonplaceholder.typicode.com/posts/"
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
      <el-form-item label="Username" prop="name">
        <el-input v-model="customer.name"></el-input>
      </el-form-item>
      <el-form-item label="Nickname" prop="nickname">
        <el-input v-model="customer.nickname"></el-input>
      </el-form-item>
      <el-form-item label="Phone" prop="phone">
        <el-input v-model="customer.phone"></el-input>
      </el-form-item>
      <el-form-item label="Email" prop="email">
        <el-input v-model="customer.email"></el-input>
      </el-form-item>
      <el-form-item label="Password" prop="pass">
        <el-input type="password" v-model="customer.pass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Confirm password" prop="checkPass">
        <el-input type="password" v-model="customer.checkPass" autocomplete="off"></el-input>
      </el-form-item>

      <el-form-item >
        <el-button id="update_button" type="primary" @click="submitForm('update')">Update</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>


<script>
export default {
  name: "EditInformation",
  data(){
    return {
      //表单
      labelPosition: 'right',
      customer:{
        //上传头像
        imageUrl: '',
        name:'',
        nickname:'',
        phone:'',
        email:'',
        pass: '',
        checkPass: ''
      },
      rules:{
        name:[
          { required: true, message: 'Please input username', trigger: 'blur' }
        ],
        nickname:[
          { required: true, message: 'Please input nickname', trigger: 'blur' }
        ],
        phone:[
          { required: true, message: 'Please input phone number', trigger: 'blur' },
        ],
        email:[
          { required: true, message: 'Please input email', trigger: 'blur' },
          { type: 'email', message: 'Email format is incorrect', trigger: ['blur', 'change'] }
        ],
        pass: [
          { required: true, message: 'Please input password', trigger: 'blur' },
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { required: true, message: 'Please confirm email', trigger: 'blur' },
          { validator: validatePass2, trigger: 'blur' }
        ],
      }
    }
    var validatePass = (rule, value, callback) => {
      if (this.ruleForm.checkPass !== '') {
        this.$refs.ruleForm.validateField('checkPass');
      }
      callback();
    };
    var validatePass2 = (rule, value, callback) => {
      if (value !== this.ruleForm.pass) {
        callback(new Error('Two input password must be consistent!'));
      } else {
        callback();
      }
    };
  },

  created() {
    this.handle(this.$route.query.id);
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
    back2Info(){
      this.$router.replace('/information')
    },
    //提交表单
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //  alert('submit!');
          let updateCustomer = {
            name: this.customer.name,
            phone: this.customer.phone,
            email: this.customer.email,
            desc: this.customer.desc,
          }

          axios.put('http://localhost:3000/users/'+this.$route.query.id,updateCustomer)
            .then((response) => {
              this.$message({
                message: '更新用户信息成功',
                type: 'success'
              });
              this.$router.push({path:'/customers',query:{alert:'success'}})
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
