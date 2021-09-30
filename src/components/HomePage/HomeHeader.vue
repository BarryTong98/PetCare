<template>
  <div class="el-header">
    <div>
      <img src="../../assets/Dog.png" alt="missing"/>
      <span>Pet Care</span>
    </div>
    <div>
      <el-input
          placeholder="Search "
          v-model="input"
          clearable>
      </el-input>
      <el-button type="primary" icon="el-icon-search"></el-button>
    </div>
  </div>
</template>

<script>
export default {}
</script>

<style scoped>
.el-header {
  background-color: #fcb517;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: #fff;
  font-size: 20px;
}

div {
  display: flex;
  align-items: center;
}

span {
  margin-left: 15px;
}

img {
  width: 50px;
  height: 50px;
  margin-left: 10px;
}


el-input {
  margin-left: -19%;
  width: 700px;
}
</style>