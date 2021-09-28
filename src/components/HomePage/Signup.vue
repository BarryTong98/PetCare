<template>
  <div class="home-container">
    <el-container >
      <el-container>
        <el-aside width="50%">
          <div>
            <img class="dog" src="../../assets/img/dogicon.svg"/>
          </div>
        </el-aside>
        <el-main style="padding: 0">
          <img class="people" src="../../assets/img/web1.svg">
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import Register from '@/components/HomePage/Register'
export default {
  components: { Register }
}
</script>

<style>

img{
  max-width: 100%;
  max-height: 100%;
}

.people{
  width: 50%;
  height: 50% ;
  margin-top: 20%;
}
.dog{
  margin: 10%;
  width: 67px;
  height: 70px;
}

.el-aside {
  background-color: #f9f7f4;
  color: #333;
}

.el-main{
  text-align: center;
  background-color: #ffffff;
  padding: 0;
}

.home-container {
  display: flex;
  height: 100%;
}

</style>
