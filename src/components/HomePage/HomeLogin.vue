<template>
  <div class="now">
    <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
      <el-form-item label="Account" prop="pass">
        <el-input v-model="ruleForm.pass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item label="Password" prop="checkPass">
        <el-input type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
      </el-form-item>
      <el-form-item>
        <div>
          <GoogleLogin style="background-color: #ffffff; color: #757575;border: none;padding: 15px 32px;"
                       :params="params" :onSuccess="onSuccess" :onFailure="onFailure">
            <svg t="1633496778530" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"
                 p-id="3095" width="16" height="16">
              <path
                d="M214.101333 512c0-32.512 5.546667-63.701333 15.36-92.928L57.173333 290.218667A491.861333 491.861333 0 0 0 4.693333 512c0 79.701333 18.858667 154.88 52.394667 221.610667l172.202667-129.066667A290.56 290.56 0 0 1 214.101333 512"
                fill="#FBBC05" p-id="3096"></path>
              <path
                d="M516.693333 216.192c72.106667 0 137.258667 25.002667 188.458667 65.962667L854.101333 136.533333C763.349333 59.178667 646.997333 11.392 516.693333 11.392c-202.325333 0-376.234667 113.28-459.52 278.826667l172.373334 128.853333c39.68-118.016 152.832-202.88 287.146666-202.88"
                fill="#EA4335" p-id="3097"></path>
              <path
                d="M516.693333 807.808c-134.357333 0-247.509333-84.864-287.232-202.88l-172.288 128.853333c83.242667 165.546667 257.152 278.826667 459.52 278.826667 124.842667 0 244.053333-43.392 333.568-124.757333l-163.584-123.818667c-46.122667 28.458667-104.234667 43.776-170.026666 43.776"
                fill="#34A853" p-id="3098"></path>
              <path
                d="M1005.397333 512c0-29.568-4.693333-61.44-11.648-91.008H516.650667V614.4h274.602666c-13.696 65.962667-51.072 116.650667-104.533333 149.632l163.541333 123.818667c93.994667-85.418667 155.136-212.650667 155.136-375.850667"
                fill="#4285F4" p-id="3099"></path>
            </svg>
            Sign in with Google
          </GoogleLogin>
        </div>
        <router-link to="/reset" style="margin-left: 52%">Forget your password?</router-link>
      </el-form-item>
      <el-form-item>
        <el-button class="btn-quality" type="primary" @click="submitForm">Login</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import GoogleLogin from 'vue-google-login'
import axios from 'axios'
//new
export default {
  props: {
    params: Object,
    // It gets called if the action (login/logout) is successful.
    onSuccess: Function,
    // It gets called if the action (login/logout) fails.
    onFailure: Function,
    // It determines if the button is for logging in or for logging out.
    // By default is false so you only need to add it for the logout button
    logoutButton: Boolean,
    // Optional, if provided will call gapi.signin2.render with the provided params and render a button with google UI
    // https://developers.google.com/identity/sign-in/web/reference#gapisignin2renderid-options
    renderParams: Object,
    // If you are logged in it will return the current user when the component mounts
    // The object it's the same as onSuccess
    onCurrentUser: Function,
  },
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Account'))
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass')
        }
        callback()
      }
    }
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('Please Enter Your Password'))
      } else {
        callback()
      }
    }
    return {
      ruleForm: {
        pass: '',
        checkPass: '',
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
        ],
        params: {
          client_id: '870223928949-0h13cc4egdup97kjmjp2d9e39io95lc7.apps.googleusercontent.com'
        },
        // only needed if you want to render the button with the google ui
        renderParams: {
          width: 250,
          height: 50,
          longtitle: true
        },
      }
    }
  },
  components: {
    GoogleLogin
  },
  methods: {
    submitForm() {
      let _this = this;
      if (this.ruleForm.pass === '' || this.ruleForm.checkPass === '') {
        alert('Account & Passwrod is Empty');
      } else {
        axios(
          {
            method: 'post',
            //url: 'http://47.96.6.135:8080/login/login?username=' + this.ruleForm.pass + '&password=' + this.ruleForm.checkPass,
            url: 'http://47.96.6.135:8080/login/login',
            data: {

              password: this.ruleForm.checkPass,
              username: this.ruleForm.pass,
            }
          }
        ).then(function (response) {
          if (response.data.code === 200) {
            alert('Login Successfully')
            window.sessionStorage.setItem("userId", response.data.data.userId)
            window.sessionStorage.setItem("token", response.data.data.token)
            _this.$router.go(-1)
          }
          if (response.data.code === 999) {
            alert('Account or Password Error')
          }
          console.log(response);
        }).catch(function (error) {
          alert('Account or Password Error')
          console.log(error);
        });
      }
    },
    onSuccess(googleUser) {
      let _this = this;
      console.log("Success")
      console.log(googleUser.it.Tt)
      console.log(googleUser)
      axios(
        {
          method: 'post',
          //url: 'http://47.96.6.135:8080/login/login?username=' + this.ruleForm.pass + '&password=' + this.ruleForm.checkPass,
          url: 'http://47.96.6.135:8080/login/login',
          data: {

            password: googleUser.it.Tt,
            username: googleUser.it.Tt,
          }
        }
      ).then(function (response) {
        if (response.data.code === 200) {
          alert('Login Successfully')
          window.sessionStorage.setItem("userId", response.data.data.userId)
          window.sessionStorage.setItem("token", response.data.data.token)
          _this.$router.go(-1)
        }
        if (response.data.code === 999) {
          axios.post('http://47.96.6.135:8080/user/register', {
            email: googleUser.it.Tt,
            password: googleUser.it.Tt  ,
            phoneNumber: googleUser.it.Tt,
            userName: googleUser.it.Tt,
          }).then(function (response) {
            if (response.data.code === 200) {
              alert('Register Successfully')
              axios(
                {
                  method: 'post',
                  //url: 'http://47.96.6.135:8080/login/login?username=' + this.ruleForm.pass + '&password=' + this.ruleForm.checkPass,
                  url: 'http://47.96.6.135:8080/login/login',
                  data: {

                    password: googleUser.it.Tt,
                    username: googleUser.it.Tt,
                  }
                }
              ).then(function(response){
                if(response.data.code === 200){
                  alert('Login Successfully')
                  window.sessionStorage.setItem("userId", response.data.data.userId)
                  window.sessionStorage.setItem("token", response.data.data.token)
                  _this.$router.go(-1)
                }
                console.log(response);
              }).catch(function(error){
                console.log(error);
              });
            }
            console.log(response.data)
          }).catch(function (err) {
            console.log(err)
          })
        }
        console.log(response);
      }).catch(function (error) {
        console.log(error);
      });
    },
  }
}
</script>

<style scoped>

.google-signin-button {
}

.el-form-item {
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
  margin-top: 1vw;
  margin-bottom: 2vw;
}

.el-form-item {
  font-family: PPWoodland-Bold;
}


</style>
