<template>
<div>
  <el-row>
    <el-page-header @back="back2Order" content="Evaluate Page" title="Back" style="color:#fa997e">
    </el-page-header>
  </el-row>

</div>
</template>

<script>
export default {
  name: "OrderEvaluate",
  data(){
    return{

    }
  },
  methods:{
    //回到完成的订单界面
    back2Order(){
      this.$router.replace('/ordercom')
    },

    //提交评价
    evaluate(oid){
      const _this = this;

      this.$http.post("http://110.40.184.115:8080/review/add",{
        content: "string",
        createTime:'',
        numberOfLikes:0,
        rating: 0,
        rid: 0,
        serviceProviderId: 0,
        userId: uid
      }).then(function(response){
        console.log("添加："+response.data);
        if (response.data.success == true){
          alert("添加成功");
          _this.$router.push("/user");//切换路由
        }
      }).catch(function(err){
        console.log(err);
      });
    },

  }
}
</script>

<style scoped>

</style>
