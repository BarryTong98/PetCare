<template>
  <div clas>
    <div class="now">
      <h2 class="resetH2">Password Reset</h2>
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="Email" prop="pass">
          <el-input v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Verification" prop="checkPass">
          <el-input v-model="ruleForm.checkPass" class="code" style="width: 57%" autocomplete="off"></el-input>
          <el-button
            type="primary"
            plain
            @click="getCaptcha"
            :disabled="flag"
          >{{ content }}
          </el-button>
        </el-form-item>

        <el-form-item>
          <el-button class="btn-quality" type="primary" @click="submitForm('ruleForm')">Next</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Email'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter The Verification Code'))
      } else {
        callback()
      }
    }
    return {
      // 验证码按钮
      flag: false,//按钮是否可取
      content: 'Verify via Email',//按钮内文本
      totalTime: 60,//倒计时时间
      userid:-1,
      ruleForm: {
        pass: '',
        checkPass: '',
        Vcode:'123',
      },
      rules: {
        pass: [
          {
            validator: validatePass,
            trigger: 'blur'
          }
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
  methods: {
    getCaptcha () {
      this.flag = true//点击之后设置按钮不可取
      this.content = this.totalTime + 's'//按钮内文本
      let clock = window.setInterval(() => {
        this.totalTime--
        this.content = this.totalTime + 's to Resend'
        if (this.totalTime < 0) {
          window.clearInterval(clock)
          this.content = 'Resent Email'
          this.totalTime = 60
          this.flag = false //这里重新开启
        }
      }, 1000)
      let _this = this
      axios.post('http://47.96.6.135:8080/email/send', {
        email: this.ruleForm.pass,
        verificationCode: "123",
      }).then(function (response) {
        if (response.data.code === 200) {
          console.log(response.data)
          _this.$message({
            message: 'Email Sent Successfully',
            type: 'success'
          });
        }
        else if (response.data.code === 999) {
          console.log(response.data)
          _this.$message({
            message: 'User Does Not Exists',
            type: 'error'
          });
        }
      }).catch(function (err) {
        console.log(err)
      })
    },

    submitForm (formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          let _this = this

          axios.post('http://47.96.6.135:8080/email/verify', {
            email: this.ruleForm.pass,
            verificationCode: this.ruleForm.checkPass
          }).then(function (response) {
            if (response.data.code === 200) {
              console.log(response.data)
              _this.$message({
                message: 'Code Is Correct',
                type: 'success'
              });
              window.sessionStorage.setItem("email",_this.ruleForm.pass);
              _this.$router.push('/reset2')
              // _this.totalTime = response.data.code;
            }
            if (response.data.code === 999) {
              console.log(response.data)
              _this.$message({
                message: 'Wrong Code',
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

.el-form-item {
  margin-left: 5%;
}

.el-input {
  width: 80%;
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
