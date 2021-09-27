<template>
  <div class="login_container">
    <div class="login_box">
      <!--头像区域-->
      <div class="avatar_box">
        <img src="../../assets/d.png" alt="">
      </div>
      <!-- 登陆表单区域-->
      <el-form ref="loginFormRef" :model="loginForm" :rules="loginFormRules"  label-width="0px" class="login_form">
        <!--用户名-->
        <el-form-item prop="username">
          <el-input v-model="loginForm.username" prefix-icon="el-icon-user"></el-input>
        </el-form-item>
        <!--密码-->
        <el-form-item prop="password">
          <el-input v-model="loginForm.password" prefix-icon="el-icon-lock" type="password"></el-input>
        </el-form-item>
        <!--按钮区-->
        <el-form-item class="btns">
          <el-button type="primary" @click="login">Login</el-button>
          <el-button type="info" @click="signup">Signup</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>

</template>

<script>
export default {
  data () {
    return {
      //这是登陆表单的数据绑定对象
      loginForm: {
        username: 'PetCare',
        password: 'PetCare'
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

<style lang="less" scoped>
.login_container {
  background-color: #0cc3f1;
  height: 100%;
}

.login_box {
  width: 450px;
  height: 300px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  left: 50%;
  top: 50%;
  transform: translate(-50%, -50%);

  .avatar_box {
    height: 130px;
    width: 130px;
    border: 1px solid #eee;
    border-radius: 50%;
    padding: 10px;
    box-shadow: 0 0 10px #ddd;
    position: absolute;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;

    img {
      width: 100%;
      height: 100%;
      border-radius: 50%;
      background-color: #eee;
    }
  }

  .btns {
    display: flex;
    justify-content: flex-end;
  }

  .login_form {
    position: absolute;
    bottom: 0;
    width: 100%;
    padding: 0 30px;
    box-sizing: border-box;
  }
}

</style>
