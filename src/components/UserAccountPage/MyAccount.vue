<template>
  <el-container class="account-container">
      <el-header style="
          background: #fcb517;
          line-height: 20px;
          height: 80px;">
        <orderheader></orderheader>
      </el-header>
      <el-container>
        <el-aside style="width: 240px;background-color: #fcb517">
          <orderaside></orderaside>
        </el-aside>

        <el-main style="margin: 20px;box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
          <router-view></router-view>
        </el-main>
      </el-container>
  </el-container>
</template>

<script>
import MyOrderHeader from "@/components/UserAccountPage/MyOrderHeader";
import MyOrderAside from "@/components/UserAccountPage/MyOrderAside";
import MyOrder from "@/components/UserAccountPage/MyOrderCompleted";

export default {
  name: "MyAccount",
  components:{
    "orderheader":MyOrderHeader,
    "orderaside":MyOrderAside,
    "myorder":MyOrder,
  },

}
</script>

<style scoped>
.account-container{
  height: 100%;
}


</style>
