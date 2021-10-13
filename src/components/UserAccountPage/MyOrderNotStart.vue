<template>
  <div>
    <!--面包屑-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item :to="{ path: '/' }">Home</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/myaccount' }">My Account</el-breadcrumb-item>
      <el-breadcrumb-item :to="{ path: '/myaccount' }">My Order</el-breadcrumb-item>
      <el-breadcrumb-item>Not Start</el-breadcrumb-item>
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
                    <span> Date: {{ order.serviceTime }}</span>
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
                    <i class="el-icon-s-finance"></i>
                    <span> Price: ${{ order.amount }}</span>
                  </div>
                </li>
              </ul>
            </div>
          </el-col>
          <el-col :span="2" style="text-align:left;">
            <el-button icon="el-icon-delete" id="cancel_button" type="danger" @click="cancelOrder(order.oid)">Cancel</el-button>
          </el-col>
        </el-container>
      </li>
    </ul>
    <!--分页功能-->
    <el-pagination hide-on-single-page
                   style="margin-top: 10px"  class="pagination-store"
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
  name: "MyOrderNotStart",
  data(){
    return{
      status:'1',
      searchInfo: '',
      orders: [],

      //分页展示个数以及展示商店数组
      storePageSize: 5,
      storeDisplay: [],
      currentPage: 1,
      show:true
    }
  },
  methods:{
    //处理分页展示
    handleCurrentChange(currentPage) {
      if(this.orders.length === 0){
        this.countStore = false
        this.show = false
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

    //取消订单
    cancelOrder(oid) {
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

    //搜索框
    searchOrders() {
      const _this = this;
      _this.$http.get("http://47.96.6.135:8080//order/search?userId=" + 1 + "&keyword=" + _this.searchInfo + "&code=" + 1) //1目前是瞎写的，到时候从localdatabse拿
        .then(function (response) {
          let temporders = response.data.data;
          if (temporders != null) {
            _this.orders.length = 0;
            for (var item = 0; item < temporders.length; item++) {  //遍历对象数组，item表示某个具体的对象
              console.log(temporders[item])
              temporders.forEach(function (element) {
                console.log(element);
                //把得到的jason转化为字符串
                const newstr = JSON.stringify(element);
                if (newstr.search(_this.searchInfo)) {
                  _this.orders.push(temporders[item]);
                  console.log("成功")
                }
              })
            }
          }else {
            //如果输入的内容不匹配，则清空列表
            while(_this.orders.length > 0) {
              _this.orders.pop();
            }
            console.log("失败")
          }
        });
    },

    //搜索之前先判断一下搜索框中有没有输入内容，如果没有输入内容就显示所有订单
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

    findAll(){
      const _this = this;
      _this.$http.get("http://47.96.6.135:8080/order/user/" + 1) //1目前是瞎写的，到时候从localdatabse拿
        .then(function (response) {
          let temporders = response.data.data;
          for(var item=0;item< temporders.length;item++){  //遍历对象数组，item表示某个具体的对象
            if (temporders[item].status == 1){
              console.log(temporders[item])
              _this.orders.push(temporders[item]);
            }
          };
          _this.handleCurrentChange(1);
        });
    },
  },

  created() {
    this.findAll();

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

#evaluate_button{
  margin-top: 70px;
  width: 120px;
  color: #fff;
  background-color: #fa997e;
  border-color: #fa997e;
}
#cancel_button{
  margin-top: 70px;
  width: 120px;
}
</style>
