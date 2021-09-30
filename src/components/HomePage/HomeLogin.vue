<template>
  <div>
    <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules"  label-width="100px" class="login_form">
      <!--用户名-->
      <el-form-item label="Account" prop="username">
        <el-input v-model="loginForm.username" prefix-icon="el-icon-user"></el-input>
      </el-form-item>
      <!--密码-->
      <el-form-item  label="Password" prop="password">
        <el-input v-model="loginForm.password" prefix-icon="el-icon-lock" type="password"></el-input>
      </el-form-item>
      <!--按钮区-->
      <el-form-item class="btns">
        <el-button class="btn-quality" type="primary" @click="login">Login</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  data () {
    return {
      //这是登陆表单的数据绑定对象
      loginForm: {
        username: '',
        password: ''
      },
      //这是表单的验证规则对象
      loginFormRules: {
        //验证用户名是否合法
        username: [
          { required: true, message: '请输入登陆名称', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
        ],
        //验证密码是否合法
        password: [
          { required: true, message: '请输入登陆密码', trigger: 'blur' },
          { min: 6, max: 15, message: '长度在 6 到 15 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    //点击跳转至注册页面
    signup(){
      this.$router.push('/signup')
    },
    login(){
      this.$router.push("/home")
      // this.$refs.loginFormRef.validate(async  valid =>{
      //   // console.log(valid);
      //   if(!valid) return;
      //     const {data: res} = await this.$http.post("login", this.loginForm);
      //     if(res.meta.status != 200) return  this.$message.error("登陆失败")
      //     this.$message.success("登陆成功");
      //   //1、将登陆成功之后的token，保存到客户端的sessionStroage中
      //   //1、1 项目中除了登陆之外的其他API接口欧，必须在登陆之后才能访问
      //   //1、2 token只应在当前网站打开期间生效，所以将token保存在sessionStorage中
      //   window.sessionStorage.setItem("token",res.data.token);
      //   //2、通过变成是导航跳转到后台主页，路由地址是 /home
      //   this.$router.push("/home")
      // });
    }
  }
}
</script>

<style scoped>


.btn-quality {
  width: 28vw;
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
  margin-left: 5vw;
  margin-top: 1vw;
  margin-bottom: 2vw;
}
.el-form-item{
  font-family: PPWoodland-Bold;
}


</style>
