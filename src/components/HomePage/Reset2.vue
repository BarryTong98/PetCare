<template>
  <div clas>
    <div class="now">
      <h2 class="resetH2">Password Reset</h2>
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="Passwrod" prop="pass">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Confirm" prop="checkPass">
          <el-input type="password" v-model="ruleForm.checkPass" class="code" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button class="btn-quality" type="primary" @click="submitForm('ruleForm')">Reset</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Password'))
      } else {
        if(this.ruleForm.checkPass !== '' && (value.length < 6 || value.length >15)){
          callback(new Error('Please Enter Your Password Between 6 And 15'))
        }
        else if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Password Again'))
      } else if (value !== this.ruleForm.pass) {
        callback(new Error('The Password Are Not Same'))
      } else {
        callback()
      }
    }
    return {
      ruleForm: {
        email: '',
        pass: '',
        checkPass: '',
      },
      rules: {
        pass:[
          { required: true, message: 'Please Input Password', trigger: 'blur' },
          { min: 6, max: 15, message: 'Please Enter Your Password Between 6 And 15', trigger: 'blur' }
        ],
        checkPass: [
          {
            validator: validatePass2,
            trigger: 'blur'
          }
        ]
      }
    }
  },
  created() {
    this.ruleForm.email = sessionStorage.getItem("email")
  },
  methods: {
    submitForm(formName) {
      var _this = this;
      this.$refs[formName].validate((valid) => {
        let _this = this
        if (valid) {
          console.log("!!!!!!"+this.ruleForm.email)
          axios.put('http://47.96.6.135:8080/login/reset', {
            email: this.ruleForm.email,
            password: this.ruleForm.pass,
          }).then(function (response) {
            if (response.data.code === 200) {
              console.log(response.data)
              _this.$message({
                message: 'Reset Successfully',
                type: 'success'
              });
              _this.$router.push('/home')
            }
            if (response.data.code === 999) {
              console.log(response.data)
              _this.$message({
                message: 'User doesn\'t exist!',
                type: 'error'
              });
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
  },
}
</script>

<style scoped>
.resetH2 {
  font-family: PPWoodland-Bold;
  text-align: center;
  margin-top: 0%;
  margin-bottom: 7%;
}

.code {
  float: left;
}

.now {
  margin-top: 10%;
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
  margin-top: 9%;
  margin-bottom: 2vw;
}

.el-form-item {
  font-family: PPWoodland-Bold;
}
</style>
