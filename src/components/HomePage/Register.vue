<template>
  <div class="now">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="Email" prop="email">
        <el-input v-model="ruleForm.email" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Password" prop="pass">
        <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
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
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data () {
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
      gender: '',
      radio: 'male',
      ruleForm: {
        email: '',
        pass: '',
        checkPass: '',
        username: '',
        phone: '',
      },
      rules:{
        username:[
          { required: true, message: 'Please Input Username', trigger: 'blur' }
        ],
        pass:[
          { required: true, message: 'Please Input Password', trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        phone:[
          { required: true, message: 'Please Input Phone Number', trigger: 'blur' },
        ],
        email:[
          { required: true, message: 'Please Input Email', trigger: 'blur' },
          { type: 'email', message: 'Email format is incorrect', trigger: ['blur', 'change'] }
        ],
      }
    }
  },
  methods: {
    submitForm (formName) {
      let _this = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(formName)
          axios.post('http://110.40.184.115:8080/user/register', {
            email: this.ruleForm.email,
            password: this.ruleForm.pass  ,
            phoneNumber: this.ruleForm.phone,
            userName: this.ruleForm.username,
          }).then(function (response) {
            if (response.data.code === 200) {
              alert('Resister Successfully')
               _this.$router.push('/home')
            }
            if (response.data.code === 999) {
              alert('Account Already Exist')
            }
            console.log(response.data)
          }).catch(function (err) {
            console.log(err)
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
  }
}
</script>

<style scoped>

.el-form-item {
  color: #f8977a;
  margin-left: 5%;
}

.el-input {
  width: 80%;
}

.now {
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

.el-form-item {
  font-family: PPWoodland-Bold;
}


</style>