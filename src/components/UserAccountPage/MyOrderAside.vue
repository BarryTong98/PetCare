<template>
<div>
    <el-col :span="24">
      <el-menu
        background-color="#fa997e"
        text-color="#FFFFFF"
        active-text-color="#ffd04b"
        unique-opened :collapse="isCollapse"
        :router="true"
        :collapse-transition="false">

        <el-menu-item index="/order">
          <i class="el-icon-s-order" style="color: #FFFFFF"></i>
          <span slot="title">My Order</span>
        </el-menu-item>
        <el-menu-item index="/information">
          <i class="el-icon-user-solid" style="color: #FFFFFF"></i>
          <span slot="title">Personal Information</span>
        </el-menu-item>
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

</style>
