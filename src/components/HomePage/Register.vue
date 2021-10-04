<template>
  <div class="now">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" >
      <el-form-item label="Email" prop="email">
        <el-input v-model="ruleForm.email" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Password" prop="pass">
        <el-input v-model="ruleForm.pass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Comfirm" prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Username" prop="username">
        <el-input v-model="ruleForm.username" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Phone No." prop="phone">
        <el-input v-model="ruleForm.phone" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Gender" prop="gender">
        <el-radio v-model="radio" label="male">Male</el-radio>
        <el-radio v-model="radio" label="female">Female</el-radio>
      </el-form-item>
      <el-form-item>
        <el-button class="btn-quality" type="primary" @click="submitForm('ruleForm')">Register</el-button>
        <!--<el-button class="btn-quality" @click="resetForm('ruleForm')">重置</el-button>-->
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    var validateEmail = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Email'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('email')
        }
        callback()
      }
    };
    var validateUsername = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Username'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('username')
        }
        callback()
      }
    };
    var validatePhone = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Phone Number'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('phone')
        }
        callback()
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Account'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Password Again'));
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('The Password Are Not Same'));
      } else {
        callback();
      }
    };
    return {
      gender:'',
      radio: 'male',
      ruleForm: {
        email: '',
        pass: '',
        checkPass: '',
        username: '',
        phone: '',
      },
      rules: {
        email: [
          { validator: validateEmail, trigger: 'blur' }
        ],
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        username: [
          { validator: validateUsername, trigger: 'blur' }
        ],
        phone: [
          { validator: validatePhone, trigger: 'blur' }
        ],
      }
    };
  },
  methods: {
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!');
        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
  }
}
</script>

<style scoped>

.el-form-item{
  margin-left: 5%;
}

.el-input{
  width: 80%;
}
.now{
  margin-top: 5%;
}
.btn-quality {
  width: 22vw;
  height: 4.6vw;
  background-color: #f4511e;
  border: none;
  font-size: 1.25vw;
  opacity: 0.6;
  display: inline-block;
  cursor: pointer;
  font-family: "PPWoodland-Bold";
  line-height: 1;
  letter-spacing: normal;
  text-align: center;
  color: #ffffff;
  margin-left: 4.5vw;
  margin-top: 1%;
  margin-bottom: 2vw;
}
.el-form-item{
  font-family: PPWoodland-Bold;
}



</style>