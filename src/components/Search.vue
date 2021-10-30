<template>
  <el-container class="search-container">
    <!--头部区域-->
    <el-header>
      <div>
        <a href="http://localhost:8080/#/welcome">
          <img class="dogimg" src="../assets/img/dogicon.svg" alt="missing" />
        </a>
        <span class="homeName">Pet Care</span>
      </div>
      <div class="searchInput" style="font-family: PPWoodland-Bold">
        <el-button class="twoinput" type="primary">Find</el-button>
        <el-input placeholder="Search" v-model="input1"> </el-input>
        <el-button class="twoinput" type="primary">Near</el-button>
        <el-input placeholder="Sydney" v-model="input2"> </el-input>
        <router-link
          :to="{
            name: 'search',
            params: { keyword: input1, address: input2, checked: 4095 }
          }"
        >
          <el-button
            class="searchBtn"
            type="info"
            icon="el-icon-search"
          ></el-button>
        </router-link>
        <el-button
          v-if="!isToken"
          style="margin-right: -55%;margin-left: 55%"
          type="info"
          class="signoutButton"
          @click="login"
          >Login
        </el-button>
        <el-col v-else :span="2">
          <el-dropdown @command="handleCommand" style="margin-left: 400%">
            <el-button
              type="primary"
              style="color: #fff;
                       background-color: #fa997e;
                       border-color: #fa997e;"
            >
              My Account<i class="el-icon-arrow-down el-icon--right"></i>
            </el-button>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item command="order">My orders</el-dropdown-item>
              <el-dropdown-item command="information"
                >Personal information</el-dropdown-item
              >
              <el-dropdown-item command="logout">Logout</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-col>
      </div>
    </el-header>

    <el-main style="text-align: left">
      <el-row :gutter="20">
        <el-col :span="18" :offset="3">
          <span class="description0" v-if="yelp === true">
            <font size="3"> All these service providers come from Yelp </font>
          </span>
        </el-col>
      </el-row>

      <!--分类导航-->
      <el-row :gutter="20">
        <el-col :span="18" :offset="3">
          <!--展示搜索信息-->
          <div class="filter-table">
            <el-form ref="form">
              <el-row :gutter="10">
                <!--按照含有的服务筛选-->
                <el-form-item>
                  <el-col :span="1">
                    <div>
                      <label>Filters:</label>
                    </div>
                  </el-col>
                  <!--Health 分类-->
                  <el-col :span="1" :offset="1">
                    <label>Health:</label>
                  </el-col>
                  <el-col :span="20" :offset="1" class="checkFilter">
                    <div>
                      <el-checkbox
                        :indeterminate="isHealthIndeterminate"
                        v-model="checkHealthAll"
                        @change="handleHealthCheckAllChange"
                      >
                        All
                      </el-checkbox>
                      <el-checkbox-group
                        v-model="checkedHealth"
                        @change="handleCheckedHealthChange"
                      >
                        <el-checkbox
                          v-for="health in healthFilters"
                          :label="health"
                          :key="health"
                          >{{ health }}
                        </el-checkbox>
                      </el-checkbox-group>
                    </div>
                  </el-col>

                  <!--Grooming 分类-->
                  <el-col :span="1" :offset="2">
                    <label>Grooming:</label>
                  </el-col>
                  <el-col :span="20" :offset="1" class="checkFilter">
                    <div>
                      <el-checkbox
                        :indeterminate="isGroomingIndeterminate"
                        v-model="checkGroomingAll"
                        @change="handleGroomingCheckAllChange"
                      >
                        All
                      </el-checkbox>
                      <el-checkbox-group
                        v-model="checkedGrooming"
                        @change="handleCheckedGroomingChange"
                      >
                        <el-checkbox
                          v-for="grooming in groomingFilters"
                          :label="grooming"
                          :key="grooming"
                          >{{ grooming }}
                        </el-checkbox>
                      </el-checkbox-group>
                    </div>
                  </el-col>

                  <!--Boarding 分类-->
                  <el-col :span="1" :offset="2">
                    <label>Boarding:</label>
                  </el-col>
                  <el-col :span="20" :offset="1" class="checkFilter">
                    <div>
                      <el-checkbox
                        :indeterminate="isBoardingIndeterminate"
                        v-model="checkBoardingAll"
                        @change="handleBoardingCheckAllChange"
                      >
                        All
                      </el-checkbox>
                      <el-checkbox-group
                        v-model="checkedBoarding"
                        @change="handleCheckedBoardingChange"
                      >
                        <el-checkbox
                          v-for="boarding in boardingFilters"
                          :label="boarding"
                          :key="boarding"
                          >{{ boarding }}
                        </el-checkbox>
                      </el-checkbox-group>
                    </div>
                  </el-col>
                </el-form-item>
                <!-- 分割线 -->
                <el-divider></el-divider>
                <!-- 提交更改 -->
                <el-col :span="2" :offset="2">
                  <router-link
                    :to="{
                      name: 'search',
                      params: {
                        keyword: saveKeyword,
                        address: saveAddress,
                        checked: changeCheckNum()
                      }
                    }"
                  >
                    <el-button type="primary">
                      Submit the change
                    </el-button>
                  </router-link>
                </el-col>
              </el-row>
            </el-form>
          </div>
        </el-col>
      </el-row>

      <!--展示筛选商家-->
      <el-row :gutter="20">
        <el-col :span="18" :offset="3">
          <div class="display-search">
            <el-form ref="form">
              <!--排序方式-->
              <el-form-item>
                <div>
                  <!--默认推荐-->
                  <el-col :span="3" :offset="12">
                    <el-link
                      class="display-title"
                      :underline="false"
                      :type="type1"
                      @click="changeRecommendRating"
                      ><font size="3">Recommend</font></el-link
                    >
                  </el-col>
                  <!--按照评分排序-->
                  <el-col :span="3">
                    <el-link
                      class="display-title"
                      :underline="false"
                      :type="type2"
                      @click="changeRankRating"
                    >
                      <font size="3">&nbsp; Rating </font>
                      <i class="el-icon-arrow-down" v-if="rankRating"></i>
                      <i class="el-icon-arrow-up" v-if="!rankRating"></i>
                    </el-link>
                  </el-col>
                  <!--按照销量排序-->
                  <el-col :span="3">
                    <el-link
                      class="display-title"
                      :underline="false"
                      :type="type3"
                      @click="changeRankVolume"
                    >
                      <font size="3"> Sales </font>
                      <i class="el-icon-arrow-down" v-if="rankVolume"></i>
                      <i class="el-icon-arrow-up" v-if="!rankVolume"></i>
                    </el-link>
                  </el-col>
                  <!--按照价格排序-->
                  <el-col :span="3">
                    <el-link
                      class="display-title"
                      :underline="false"
                      :type="type4"
                      @click="changeRankPrice"
                    >
                      <font size="3"> Price </font>
                      <i class="el-icon-arrow-down" v-if="rankPrice"></i>
                      <i class="el-icon-arrow-up" v-if="!rankPrice"></i>
                    </el-link>
                  </el-col>
                </div>
              </el-form-item>
              <!--分割线-->
              <el-divider></el-divider>
              <!--展示商家信息-->
              <el-form-item v-if="countStore === false" style="height: 50px">
                <div class="noFound">
                  <font size="3"> No relevant service provider was found </font>
                </div>
              </el-form-item>
              <el-form-item
                v-if="countStore === true"
                class="search-item"
                v-for="item in JSON.parse(JSON.stringify(storeDisplay))"
              >
                <router-link
                  :to="{
                    name: 'information',
                    params: { yelp: yelp, id: item.id }
                  }"
                >
                  <!--商家图片-->
                  <el-col :span="6">
                    <img :src="item.src" height="208" width="100%" />
                  </el-col>
                  <el-col :span="17">
                    <div>
                      <!--商家姓名-->
                      <span class="store-title">
                        {{ item.name }}
                      </span>
                      <!--营业时间-->
                      <span class="time">
                        <font size="3"> {{ item.time }} </font>
                      </span>
                    </div>
                  </el-col>

                  <!--评分-->
                  <el-col :span="5">
                    <el-rate
                      v-model="item.numStar"
                      disabled
                      show-score
                      text-color="#ff9900"
                      score-template="{value}"
                    >
                    </el-rate>
                  </el-col>
                  <!--价格和销量-->
                  <el-col :span="12">
                    <div class="priceAndvolume" v-if="item.price !== ''">
                      <font size="3">
                        Average Price:&nbsp;${{
                          item.price
                        }}&nbsp;&nbsp;&nbsp;&nbsp;{{ item.volume }} times/month
                      </font>
                    </div>
                  </el-col>
                  <!--地址-->
                  <el-col :span="17">
                    <div class="address">
                      <font size="3"> Address:&nbsp;{{ item.Address }} </font>
                    </div>
                  </el-col>
                  <!--描述-->
                  <el-col :span="17">
                    <div class="description">
                      <span v-if="item.description !== ''">
                        <font size="2"> Description: &nbsp; </font>
                      </span>
                      <font size="2"> {{ item.description }} </font>
                    </div>
                  </el-col>
                </router-link>
              </el-form-item>
              <!--分页功能-->
              <el-pagination
                class="pagination-store"
                :current-page.sync="currentPage"
                background
                @current-change="handleCurrentChange"
                layout="prev, pager, next"
                :total="storeArr.length"
                :page-size="storePageSize"
              >
              </el-pagination>
            </el-form>
          </div>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
import axios from "axios";

const healthOptions = [
  "Veterinarians",
  "Disease",
  "Sterilization",
  "Check-ups",
  "Vaccination"
];
const groomingOptions = ["Groom", "Washing", "Deworming", "Cleaning"];
const boardingOptions = ["Hosting", "Training", "Playground"];
export default {
  data() {
    return {
      input1: " ",
      input2: " ",

      countStore: true,

      type1: "primary",
      type2: "",
      type3: "",
      type4: "",

      //控制health筛选
      checkHealthAll: false,

      healthFilters: healthOptions,
      isHealthIndeterminate: true,

      //控制grooming筛选
      checkGroomingAll: false,
      groomingFilters: groomingOptions,
      isGroomingIndeterminate: true,

      //控制boarding筛选
      checkBoardingAll: false,
      boardingFilters: boardingOptions,
      isBoardingIndeterminate: true,

      //初始化店铺数组
      storeArr: [],

      //排序方式
      rankRating: false,
      rankVolume: false,
      rankPrice: false,

      //分页展示个数以及展示商店数组
      storePageSize: 10,
      storeDisplay: [],
      currentPage: 1,

      //检查分类勾选初始数组
      checkedHealth: [],
      checkedBoarding: [],
      checkedGrooming: [],

      //储存搜索关键词
      saveKeyword: " ",
      saveAddress: " ",

      yelp: false,
      isToken: false
    };
  },
  methods: {
    //******************
    logout() {
      window.sessionStorage.clear();
      this.$router.go(0);
      //this.$router.push('/home')
    },
    login() {
      this.$router.push("/homelogin");
    },

    toggleCollapse() {
      this.isCollapse = !this.isCollapse;
    },
    handleCommand(command) {
      if (command == "order") {
        this.myorder();
      } else if (command == "information") {
        this.information();
      } else {
        this.logout();
      }
    },
    myorder() {
      this.$router.replace("/ordernotstart");
    },
    information() {
      this.$router.replace("/information");
    },
    //******************

    //处理Health分类勾选
    handleHealthCheckAllChange(val) {
      this.checkedHealth = val ? healthOptions : [];
      this.isHealthIndeterminate = false;
    },
    handleCheckedHealthChange(value) {
      let checkedCount = value.length;
      this.checkHealthAll = checkedCount === this.healthFilters.length;
      this.isHealthIndeterminate =
        checkedCount > 0 && checkedCount < this.healthFilters.length;
    },
    //处理Grooming分类勾选
    handleGroomingCheckAllChange(val) {
      this.checkedGrooming = val ? groomingOptions : [];
      this.isGroomingIndeterminate = false;
    },
    handleCheckedGroomingChange(value) {
      let checkedCount = value.length;
      this.checkGroomingAll = checkedCount === this.groomingFilters.length;
      this.isGroomingIndeterminate =
        checkedCount > 0 && checkedCount < this.groomingFilters.length;
    },
    //处理Boarding分类勾选
    handleBoardingCheckAllChange(val) {
      this.checkedBoarding = val ? boardingOptions : [];
      this.isBoardingIndeterminate = false;
    },
    handleCheckedBoardingChange(value) {
      let checkedCount = value.length;
      this.checkBoardingAll = checkedCount === this.boardingFilters.length;
      this.isBoardingIndeterminate =
        checkedCount > 0 && checkedCount < this.boardingFilters.length;
    },

    changeRecommendRating() {
      this.storeArr.sort(function(a, b) {
        var x = a["numStar"] * a["volume"];
        var y = b["numStar"] * b["volume"];
        return x > y ? -1 : x > y ? 1 : 0;
      });
      this.handleCurrentChange(1);
      this.currentPage = 1;
      this.type1 = "primary";
      this.type2 = "";
      this.type3 = "";
      this.type4 = "";
    },

    //改变商店数组排序方式: 评分
    changeRankRating() {
      this.rankRating = !this.rankRating;
      if (!this.rankRating) {
        this.storeArr.sort(function(a, b) {
          var x = a["numStar"];
          var y = b["numStar"];
          return x < y ? -1 : x < y ? 1 : 0;
        });
      } else {
        this.storeArr.sort(function(a, b) {
          var x = a["numStar"];
          var y = b["numStar"];
          return x > y ? -1 : x > y ? 1 : 0;
        });
      }
      this.handleCurrentChange(1);
      this.currentPage = 1;

      this.type1 = "";
      this.type2 = "primary";
      this.type3 = "";
      this.type4 = "";
    },
    //改变商店数组排序方式: 销量
    changeRankVolume() {
      this.rankVolume = !this.rankVolume;
      if (!this.rankVolume) {
        this.storeArr.sort(function(a, b) {
          var x = a["volume"];
          var y = b["volume"];
          return x < y ? -1 : x < y ? 1 : 0;
        });
      } else {
        this.storeArr.sort(function(a, b) {
          var x = a["volume"];
          var y = b["volume"];
          return x > y ? -1 : x > y ? 1 : 0;
        });
      }
      this.handleCurrentChange(1);
      this.currentPage = 1;

      this.type1 = "";
      this.type2 = "";
      this.type3 = "primary";
      this.type4 = "";
    },
    //改变商店数组排序方式: 价格
    changeRankPrice() {
      this.rankPrice = !this.rankPrice;
      if (!this.rankPrice) {
        this.storeArr.sort(function(a, b) {
          var x = a["price"];
          var y = b["price"];
          return x < y ? -1 : x < y ? 1 : 0;
        });
      } else {
        this.storeArr.sort(function(a, b) {
          var x = a["price"];
          var y = b["price"];
          return x > y ? -1 : x > y ? 1 : 0;
        });
      }
      this.handleCurrentChange(1);
      this.currentPage = 1;

      this.type1 = "";
      this.type2 = "";
      this.type3 = "";
      this.type4 = "primary";
    },

    //处理勾选展示
    changeChecked(value) {
      var num = Number(value);
      var binary = num.toString(2);
      var binaryArr = [
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0",
        "0"
      ];
      for (var i = 0; i < binary.length; i++) {
        binaryArr[i] = binary[binary.length - (i + 1)];
      }
      if (binaryArr[0] === "1") {
        this.checkedHealth.push("Veterinarians");
      }
      if (binaryArr[1] === "1") {
        this.checkedHealth.push("Disease");
      }
      if (binaryArr[2] === "1") {
        this.checkedHealth.push("Sterilization");
      }
      if (binaryArr[3] === "1") {
        this.checkedHealth.push("Check-ups");
      }
      if (binaryArr[4] === "1") {
        this.checkedHealth.push("Vaccination");
      }
      if (binaryArr[5] === "1") {
        this.checkedGrooming.push("Groom");
      }
      if (binaryArr[6] === "1") {
        this.checkedGrooming.push("Washing");
      }
      if (binaryArr[7] === "1") {
        this.checkedGrooming.push("Deworming");
      }
      if (binaryArr[8] === "1") {
        this.checkedGrooming.push("Cleaning");
      }
      if (binaryArr[9] === "1") {
        this.checkedBoarding.push("Hosting");
      }
      if (binaryArr[10] === "1") {
        this.checkedBoarding.push("Training");
      }
      if (binaryArr[11] === "1") {
        this.checkedBoarding.push("Playground");
      }
    },

    //处理分页展示
    handleCurrentChange(currentPage) {
      if (this.storeArr.length === 0) {
        this.countStore = false;
      } else {
        this.countStore = true;
        this.storeDisplay = [];
        var m = 0;

        if (currentPage * this.storePageSize > this.storeArr.length) {
          m = this.storeArr.length;
        } else {
          m = currentPage * this.storePageSize;
        }
        for (var i = (currentPage - 1) * this.storePageSize; i < m; i++) {
          this.storeDisplay.push(JSON.parse(JSON.stringify(this.storeArr[i])));
        }
      }
    },

    //从后端获取商店数组
    addStoreArr(
      id,
      src,
      name,
      time,
      numStar,
      price,
      volume,
      Address,
      description
    ) {
      var newArr = {
        id: id,
        src: src,
        name: name,
        time: time,
        numStar: numStar,
        price: price,
        volume: volume,
        Address: Address,
        description: description
      };

      this.storeArr.push(JSON.parse(JSON.stringify(newArr)));
    },

    //改变勾选筛选项，改变传递数值
    changeCheckNum() {
      var Veterinarians = "0";
      var Disease = "0";
      var Sterilization = "0";
      var Check_ups = "0";
      var Vaccination = "0";
      var Groom = "0";
      var Washing = "0";
      var Deworming = "0";
      var Cleaning = "0";
      var Hosting = "0";
      var Training = "0";
      var Playground = "0";

      for (
        var i = 0;
        i < JSON.parse(JSON.stringify(this.checkedHealth)).length;
        i++
      ) {
        if (
          JSON.parse(JSON.stringify(this.checkedHealth))[i] === "Veterinarians"
        ) {
          Veterinarians = "1";
        } else if (
          JSON.parse(JSON.stringify(this.checkedHealth))[i] === "Disease"
        ) {
          Disease = "1";
        } else if (
          JSON.parse(JSON.stringify(this.checkedHealth))[i] === "Sterilization"
        ) {
          Sterilization = "1";
        } else if (
          JSON.parse(JSON.stringify(this.checkedHealth))[i] === "Check-ups"
        ) {
          Check_ups = "1";
        } else if (
          JSON.parse(JSON.stringify(this.checkedHealth))[i] === "Vaccination"
        ) {
          Vaccination = "1";
        }
      }
      for (
        var i = 0;
        i < JSON.parse(JSON.stringify(this.checkedGrooming)).length;
        i++
      ) {
        if (JSON.parse(JSON.stringify(this.checkedGrooming))[i] === "Groom") {
          Groom = "1";
        } else if (
          JSON.parse(JSON.stringify(this.checkedGrooming))[i] === "Washing"
        ) {
          Washing = "1";
        } else if (
          JSON.parse(JSON.stringify(this.checkedGrooming))[i] === "Deworming"
        ) {
          Deworming = "1";
        } else if (
          JSON.parse(JSON.stringify(this.checkedGrooming))[i] === "Cleaning"
        ) {
          Cleaning = "1";
        }
      }
      for (
        var i = 0;
        i < JSON.parse(JSON.stringify(this.checkedBoarding)).length;
        i++
      ) {
        if (JSON.parse(JSON.stringify(this.checkedBoarding))[i] === "Hosting") {
          Hosting = "1";
        } else if (
          JSON.parse(JSON.stringify(this.checkedBoarding))[i] === "Training"
        ) {
          Training = "1";
        } else if (
          JSON.parse(JSON.stringify(this.checkedBoarding))[i] === "Playground"
        ) {
          Playground = "1";
        }
      }
      var binary =
        Playground +
        Training +
        Hosting +
        Cleaning +
        Deworming +
        Washing +
        Groom +
        Vaccination +
        Check_ups +
        Sterilization +
        Disease +
        Veterinarians;
      return parseInt(binary, 2);
    }
  },
  watch: {
    $route(to, from) {
      this.$router.go(0);
    }
  },

  created() {
    const loading = this.$loading({
      lock: true,
      text: "Loading",
      spinner: "el-icon-loading",
      background: "rgba(0, 0, 0, 0.7)"
    });

    const token = sessionStorage.getItem("token");
    console.log("token:" + token);
    console.log(token === null);
    if (token === null) {
      this.isToken = false;
    } else {
      this.isToken = true;
    }
    console.log(this.isToken);

    this.checkedHealth = [];
    this.checkedBoarding = [];
    this.checkedGrooming = [];

    this.changeChecked(this.$route.params.checked);

    var that = this;

    this.saveKeyword = this.$route.params.keyword;
    this.saveAddress = this.$route.params.address;

    axios
      .get(
        "http://47.96.6.135:8080/serviceProvider/search/" +
          this.$route.params.address +
          "/" +
          this.$route.params.checked +
          "?keyword=" +
          this.$route.params.keyword
      )
      .then(
        function(response) {
          console.log(response);

          const reqs = response.data.data;

          for (var i = 0; i < reqs.length; i++) {
            var mStore = reqs[i];
            if (response.data.code === 200) {
              that.yelp = false;
              that.addStoreArr(
                mStore.spid,
                mStore.imageUrl,
                mStore.serviceProviderName,
                mStore.businessHours,
                mStore.rating,
                mStore.averagePrice,
                mStore.sales,
                mStore.address,
                mStore.description
              );
            } else if (response.data.code === 201) {
              that.yelp = true;
              that.addStoreArr(
                mStore.id,
                mStore.image_url,
                mStore.name,
                "",
                mStore.rating,
                "",
                "",
                mStore.address,
                ""
              );
            }
          }
          that.changeRecommendRating();
          that.handleCurrentChange(1);
          loading.close();
        },
        function(err) {}
      );
  }
};
</script>

<style scoped lang="less" scoped>
.twoinput {
  background-color: #fb9a7f;
  border: transparent;
}

.searchInput {
  margin-left: 20%;
}

body {
  //font-family: "American Typewriter", serif;
  font-family: "Object Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
}

.homeName {
  font-family: PPWoodland-Ultralight;
}

.signoutButton {
  font-family: "Object Sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  background-color: #fa997e;
  border: transparent;
}

.searchBtn {
  background-color: #fb9a7f;
  border: transparent;
}

.el-header {
  background-color: #fcb517;
  display: flex;
  padding-left: 0;
  align-items: center;
  color: #fff;
  font-size: 20px;

  > div {
    display: flex;
    align-items: center;

    .dogimg {
      width: 50px;
      height: 50px;
      margin-left: 10px;
      margin-right: 15px;
    }
  }
}

.el-icon-arrow-down {
  font-size: 12px;
}

.el-icon-arrow-up {
  font-size: 12px;
}

.el-row {
  margin-bottom: 10px;

  &:last-child {
    margin-bottom: 0;
  }
}

.el-col {
  border-radius: 4px;
}

.filter-table {
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  padding-top: 30px;
  padding-left: 30px;
  padding-right: 30px;
  padding-bottom: 21px;
  margin-top: 20px;
}

.display-search {
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  margin-top: 20px;
  padding-top: 30px;
  padding-left: 30px;
  padding-right: 30px;
  padding-bottom: 50px;
  margin-bottom: 50px;
}

.store-title {
  margin-top: 10px;
  font-size: 20px;
}

.time {
  margin-left: 40px;
  margin-top: 10px;
  font-size: 12px;
  color: #666666;
}

.search-item {
  padding: 10px;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 #b3b3b3;
}

/deep/ .el-rate__icon {
  font-size: 15px;
}

/deep/ .el-rate__text {
  font-size: 15px;
}

/deep/ .el-rate {
  margin-top: 12px;
}

.priceAndvolume {
  font-size: 8px;
  color: #333333;
}

.address {
  font-size: 10px;
  color: #666666;
}

.checkFilter {
  margin-bottom: 15px;
}

.pagination-store {
  position: absolute;
  left: 45%;
}

.main {
  overflow: visible;
}

a {
  text-decoration: none;
  color: black;
}

.noFound {
  position: absolute;
  left: 38%;
  color: #999999;
}

.description {
  font-size: 8px;
  color: #9e9c9c;
}
.description0 {
  margin-left: 35px;
  font-size: 13px;
  color: #9e9c9c;
}

.display-title {
  font-size: 10px;
}
</style>
