<template>
<div>
  <el-breadcrumb separator-class="el-icon-arrow-right">
    <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
    <el-breadcrumb-item>My Account</el-breadcrumb-item>
    <el-breadcrumb-item>My Order</el-breadcrumb-item>
  </el-breadcrumb>

    <!--预定订单搜索框-->
    <div class="search bar1">
      <form>
        <input type="text" placeholder="Please input hospital name or server name...">
        <button type="submit">
          <i class="el-icon-search"></i> search
        </button>
      </form>
    </div>

    <!--预定的商家列表-->
    <ul style="margin-left: 60px;margin-right: 60px">
      <li>
        <el-container style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
          <!--医院图片-->
          <el-aside style="width: 200px; padding: 10px;margin: 10px;text-align: center">
            <img style="width: 100px" ></img>
          </el-aside>

          <!--预定医院的信息-->
          <el-col :span="13" style="text-align: left;">
            <div style="margin: 10px;">
              <span style="font-family: Arial;font-size: 18px;font-weight: bolder">Hospital name</span>
              <ul>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-date"></i>
                    <span> Date: 2021-08-21 18:00-19:00</span>
                  </div>
                </li>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-map-location"></i>
                    <span> Location: Camperdown NSW 2006, Australia</span>
                  </div>
                </li>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-s-finance"></i>
                    <span> Price: $100</span>
                  </div>
                </li>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-service"></i>
                    <span> Server: clean</span>&nbsp
                    <el-tag type="success" >Completed</el-tag>
                  </div>
                </li>
              </ul>
            </div>
          </el-col>
          <el-col :span="11" style="text-align: center;">
            <el-button id="evaluate_button" type="primary">Evaluate</el-button>
          </el-col>
        </el-container>
      </li>
    </ul>
</div>
</template>

<script>
export default {
  name: "MyOrder"
}
</script>

<style scoped>
/*为了让所有的ul都不缩进，并且没有一点*/
ul {
  list-style: none;
  margin: 0px;
  padding: 0px;
}

/*order搜索框*/
.bar1 input {
  border: 2px solid #fb9a7f;
  border-radius: 5px;
  background: #FFFFFF;
  color: #9E9C9C;
}

.bar1 button {
  top: 0;
  right: 0;
  background: #fb9a7f;
  border-radius: 0 5px 5px 0;
}

.bar1 button:before {
  font-family: FontAwesome;
  font-size: 14px;
  color: #FFFFFF;
}

* {
  box-sizing: border-box;
}

div.search {
  padding: 30px 0;
}

form {
  position: relative;
  width: 700px;
  margin: 0 auto;
}

input, button {
  border: none;
  outline: none;
}

input {
  width: 100%;
  height: 42px;
  padding-left: 13px;
}

button {
  height: 42px;
  width: 80px;
  cursor: pointer;
  position: absolute;
  color: #FFFFFF;
}

#evaluate_button{
  margin-top: 45px;
  width: 100px;
  color: #fff;
  background-color: #fa997e;
  border-color: #fa997e;
}

</style>
