<template>
  <div>
    <!--最上面返回按钮-->
    <el-row>
      <el-page-header @back="back2Order" content="Evaluate Page" title="Back" style="color:#fa997e">
      </el-page-header>
    </el-row>
    <!--评价表单-->
    <el-form :model="ruleForm"
             :rules="rules"
             ref="ruleForm"
             label-width="100px"
             class="demo-ruleForm">
      <el-form-item label="Rate:" prop="name">
        <el-rate
          v-model="rate"
          :colors="colors">
        </el-rate>
      </el-form-item>
      <el-form-item label="Comment:" prop="desc">
        <el-input type="textarea" v-model="ruleForm.desc"></el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="submitForm('ruleForm')">Evaluate</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>

<script>
export default {
  name: "OrderEvaluate",
  data(){
    return{
      gettime:'',
      spid:0,
      oid:0,
      userid: 1,
      //rate
      rate: null,
      colors: ['#99A9BF', '#F7BA2A', '#FF9900'],

      //评价表单
      ruleForm: {
        desc: ''
      },
      rules:{
        desc: [
          { required: true, message: 'Please input the feedback of this service', trigger: 'blur' }
        ]
      }
    }
  },
  methods:{
    //回到完成的订单界面
    back2Order(){
      this.$router.replace('/ordercom')
    },

    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //获取当前时间并打印
          let yy = new Date().getFullYear();
          let mm = new Date().getMonth()+1;
          let dd = new Date().getDate();
          this.gettime = yy+'-'+mm+'-'+dd;

          //提交数据
          const _this = this;
          this.$http.post("http://47.96.6.135:8080/review/add",{
            content: _this.ruleForm.desc,
            createTime:_this.gettime,
            numberOfLikes:40,
            rating: _this.rate,
            rid: null,
            serviceProviderId: _this.spid,
            userId: _this.userid,
          }).then(function(response){
            if (response.data.message == "success"){

              let updateStatus = {
                code: 4,
                orderID: _this.oid
              }
              _this.$http.put('http://47.96.6.135:8080/order/update', updateStatus)
                .then((response) => {
                  _this.$message({
                    message: 'Evaluate successfully!',
                    type: 'success'
                  });
                });

            }
          }).catch(function(err){
            console.log(err);
          });

        } else {
          console.log('error submit!!');
          return false;
        }
      });
    },
    //改变订单状态
    changeOrderStatus(oid) {
      this.status = 3;
      const _this = this;
      let updateStatus = {
        code: 3,
        orderID: oid
      }
      this.$http.put('http://47.96.6.135:8080/order/update', updateStatus)
        .then((response) => {
          this.$message({
            message: 'Canceled successfully!',
            type: 'success'
          });
        });
    },

  },
  created() {
    this.spid = this.$route.query.currentspid;
    this.oid = this.$route.query.orderid;
    this.userid = sessionStorage.getItem("userId")
  }

}
</script>

<style scoped>
.demo-ruleForm{
  margin-top: 20px;
  padding: 70px;
}
</style>
