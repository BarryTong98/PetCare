<template>
  <div clas>
    <div class="now">
      <h2 class="resetH2">Password Reset</h2>
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm" >
        <el-form-item  label="Passwrod" prop="pass">
          <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="Confirm" prop="checkPass">
          <el-input  type="password" v-model="ruleForm.checkPass" class="code" autocomplete="off"></el-input>
        </el-form-item>

        <el-form-item>
          <el-button class="btn-quality" type="primary" @click="submitForm('ruleForm')">Reset</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Password'))
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
      // 验证码按钮
      flag: false,//按钮是否可取
      content: "Verify via SMS",//按钮内文本
      totalTime: 60,//倒计时时间
      ruleForm: {
        pass: '',
        checkPass: '',
      },
      rules: {
        pass: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ]
      }
    };
  },
  methods:{
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
.resetH2{
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