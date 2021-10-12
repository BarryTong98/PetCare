<template>
<div>
    <el-col :span="24">
      <el-menu
        background-color="#fa997e"
        text-color="#FFFFFF"
        active-text-color="#ffd04b"
        unique-opened :collapse="false"
        :router="true"
        :collapse-transition="true">

        <el-submenu index="1">
          <template slot="title">
            <i class="el-icon-s-order myicon" ></i>
            <span>My Order</span>
          </template>
          <el-menu-item index="/ordernotstart">
            <i class="el-icon-s-flag myicon" ></i>Not start
          </el-menu-item>
          <el-menu-item index="/ordercom">
            <i class="el-icon-success myicon"></i>Completed
          </el-menu-item>
          <el-menu-item index="/ordercancel">
            <i class="el-icon-error myicon"></i>Canceled
          </el-menu-item>
        </el-submenu>

        <el-submenu index="2">
          <template slot="title">
            <i class="el-icon-setting myicon"></i>
            <span slot="title">Personal Information</span>
          </template>
          <el-menu-item index="/information">
            <i class="el-icon-user-solid myicon" ></i>User Information
          </el-menu-item>
          <el-menu-item index="/myaccountreset">
            <i class="el-icon-edit myicon"></i>Reset Password
          </el-menu-item>
        </el-submenu>

      </el-menu>
    </el-col>
</div>
</template>

<script>
export default {
  name: "MyOrderAside",
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style scoped>
.myicon{
  color: #FFFFFF
}


</style>
