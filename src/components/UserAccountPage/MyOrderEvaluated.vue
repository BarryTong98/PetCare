<template>
  <div>
    <!--面包屑-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/myaccount' }">My Account</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/myaccount' }">My Order</el-breadcrumb-item>
      <el-breadcrumb-item>Evaluated</el-breadcrumb-item>
    </el-breadcrumb>

    <!--预定订单搜索框-->
    <div class="search bar1">
      <form>
        <input type="text"
               @keydown.enter="checKSearch"
               v-model="searchInfo"
               placeholder="Please input service provider or service name...">
        <button type="submit" @click="checKSearch">
          <i class="el-icon-search"></i> search
        </button>
      </form>
    </div>

    <!--预定的商家列表-->
    <ul style="margin-left: 60px;margin-right: 60px" v-for="order in storeDisplay">
      <li>
        <el-container style="box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)">
          <!--医院图片-->
          <el-aside style="width: 200px;height: 150px;margin: 10px;text-align: center">
            <img :src="order.imageUrl" style="width: 200px;height: 150px" ></img>
          </el-aside>

          <!--预定医院的信息-->
          <el-col :span="15" style="text-align: left;">
            <div style="margin: 10px;">
              <span
                style="font-family: Arial;font-size: 18px;font-weight: bolder">{{ order.serviceProviderName }}</span>
              <ul>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-date"></i>
                    <span> Order create time: {{ order.createTime }}</span>
                  </div>
                </li>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-map-location"></i>
                    <span> Location: {{ order.address }}</span>
                  </div>
                </li>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-service"></i>
                    <span> Contact number: {{ order.contactNumber }}</span>
                  </div>
                </li>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-bell"></i>
                    <span> Service name: {{ order.serviceName }}</span>
                  </div>
                </li>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-watch"></i>
                    <span> Service time: {{ order.serviceTime }}</span>
                  </div>
                </li>
                <li>
                  <div style="margin-top: 7px">
                    <i class="el-icon-s-finance"></i>
                    <span> Price: ${{ order.amount }}</span>
                  </div>
                </li>
              </ul>
            </div>
          </el-col>
        </el-container>
      </li>
    </ul>
    <!--分页功能-->
    <el-pagination style="margin-top: 10px"
                   class="pagination-store"
                   hide-on-single-page
                   :current-page.sync="currentPage"
                   background
                   @current-change="handleCurrentChange"
                   layout="prev, pager, next"
                   :total="orders.length"
                   :page-size="storePageSize">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: "MyOrderEvaluated",
  data() {
    return {
      searchInfo: '',
      orders: [],
      userid:1,

      //分页展示个数以及展示商店数组
      storePageSize: 5,
      storeDisplay: [],
      currentPage: 1,
      show: true
    }
  },
  methods: {
    //转化时间格式
    //2021-10-03T22:48:29.000+0000 --> 2021-10-03 22:48:29
    convertTime(date) {
      var dateee = new Date(date).toJSON();
      return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
    },

    //处理分页展示
    handleCurrentChange(currentPage) {
      if(this.orders.length === 0){
        this.countStore = false
        this.show = false
        this.storeDisplay = []
      }
      else{
        this.countStore = true
        this.storeDisplay = []
        var m = 0

        if (currentPage * this.storePageSize > this.orders.length) {
          m = this.orders.length
        } else {
          m = currentPage * this.storePageSize
        }
        for (var i = (currentPage - 1) * this.storePageSize; i < m; i++) {
          this.storeDisplay.push(JSON.parse(JSON.stringify(this.orders[i])))
        }
      }
    },

    //搜索框
    searchOrders() {
      const _this = this;
      _this.$http.get("http://47.96.6.135:8080/order/search?userId="
        + _this.userid
        + "&keyword="
        + _this.searchInfo
        + "&code=" + 4)
        .then(function (response) {
          let temporders = response.data.data;
          if (temporders != null) {
            _this.orders.length = 0;
            for (var item = 0; item < temporders.length; item++) {
              _this.orders.push(temporders[item]);
            }
            _this.handleCurrentChange(1);

          } else {
            while (_this.orders.length > 0) {
              _this.orders.pop();
            }
            _this.handleCurrentChange(1);
          }
        });
    },

    checKSearch(){
      if (this.searchInfo == ''){
        while(this.orders.length > 0) {
          this.orders.pop();
        }
        this.findAll();
        console.log("显示所有订单")
      }else{
        this.searchOrders();

      }
    },

    //查找所有订单
    findAll() {
      const _this = this;
      _this.$http.get("http://47.96.6.135:8080/order/user/" + _this.userid)
        .then(function (response) {
          let temporders = response.data.data;
          if (temporders != null) {
            for (var item = 0; item < temporders.length; item++) {  //遍历对象数组，item表示某个具体的对象
              if (temporders[item].status == 4) {
                _this.orders.push(temporders[item]);
              }
            }
          }
          //遍历orders数组,把createTime改格式
          for (var i = 0; i < _this.orders.length; i++) {
            _this.orders[i].createTime = _this.convertTime(_this.orders[i].createTime)
          }
          _this.handleCurrentChange(1);
        });
    },
  },
  created() {
    this.userid =sessionStorage.getItem("userId"),
    this.findAll()
  },
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

#evaluate_button {
  margin-top: 45px;
  width: 120px;
  color: #fff;
  background-color: #fa997e;
  border-color: #fa997e;
}

</style>
