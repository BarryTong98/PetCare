<template>
<div>
  <el-row>
    <el-page-header @back="back2Order" content="Evaluate Page" title="Back" style="color:#fa997e">
    </el-page-header>
  </el-row>
  <el-button type="primary" @click="evaluate">test</el-button>

</div>
</template>

<script>
export default {
  name: "OrderEvaluate",
  data(){
    return{
      content:'hello',
    }
  },
  methods:{
    //回到完成的订单界面
    back2Order(){
      this.$router.replace('/ordercom')
    },

    //提交评价
    evaluate(){
      const _this = this;
      this.$http.post("http://110.40.184.115:8080/review/add",{
        content: this.content,
        createTime:null,
        numberOfLikes:0,
        rating: 0,
        rid: null,
        serviceProviderId: this.$route.query.serviceProviderId,
        userId: 1
      }).then(function(response){
        console.log("添加："+response.data);
        if (response.data.success == true){
          alert("添加成功");
          //切换路由
          _this.$router.push("/ordercom");
        }
      }).catch(function(err){
        console.log(err);
      });
    },

  },
}
</script>

<style scoped>

</style>
