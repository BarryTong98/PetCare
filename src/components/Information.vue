<template>
  <el-container class="information-container">
    <!--头部区域-->
    <el-header>
      <div>
        <a href="http://localhost:8080/#/welcome">
          <img class="dogimg" src="../assets/img/dogicon.svg" alt="missing"/>
        </a>
        <span class="homeName">Pet Care</span>
      </div>
      <div class="searchInput" style="font-family: PPWoodland-Bold">
        <el-button class="twoinput" type="primary">Find</el-button>
        <el-input placeholder="Search" v-model="input1">
        </el-input>
        <el-button class="twoinput" type="primary">Near</el-button>
        <el-input placeholder="Location" v-model="input2">
        </el-input>
        <router-link :to="{name: 'search', params: {keyword: input1, address: input2, checked: 4095}}">
          <el-button class="searchBtn" type="info" icon="el-icon-search"></el-button>
        </router-link>
        <el-button style="margin-right: -55%;margin-left: 55%" type="info" class="signoutButton" @click="logout">Login
        </el-button>
      </div>

    </el-header>


    <el-main style="text-align: left">
      <!--商家信息-->
      <el-row :gutter="20">
        <el-col :span=18 :offset=3>
          <div class="display-information">
            <el-form ref="form">
              <el-form-item class="search-item">
                <!--商家图片-->
                <el-col :span=4>
                  <img :src="store.src" height="208" width="320"/>
                </el-col>
                <!--商家名称-->
                <el-col :span=10 :offset=3>
                  <div class="store-title">{{ store.name }}</div>
                </el-col>
                <!--营业时间-->
                <el-col :span=6 :offset=1>
                  <div class="time">{{ store.time }}</div>
                </el-col>
                <!--评分-->
                <el-col :span=5 :offset=3>
                  <el-rate
                    v-model="store.numStar"
                    disabled
                    show-score
                    text-color="#ff9900"
                    score-template="{value}">
                  </el-rate>
                </el-col>
                <!--价格和销量-->
                <el-col :span=12>
                  <div class="priceAndvolume">Average Price:&nbsp;${{ store.price }}&nbsp;&nbsp;{{
                      store.volume
                    }}times/month
                  </div>
                </el-col>
                <!--商家描述-->
                <el-col :span=17 :offset=3>
                  <div class="description">Description:&nbsp;{{
                      store.description
                    }}
                  </div>
                </el-col>
              </el-form-item>
            </el-form>
          </div>
        </el-col>
      </el-row>

      <el-row :gutter="20">
        <el-col :span=8 :offset=3>
          <!--地址展示-->
          <el-form ref="form" class="display-address">
            <el-form-item>
              <img src="../assets/img/1.png" height="364" width="560"/>
              <el-col>
                <div class="address">Address:&nbsp;{{ store.Address }}</div>
              </el-col>
            </el-form-item>
          </el-form>
        </el-col>
        <!-- 订单展示-->
        <el-col :span=10>
          <el-form ref="form" class="display-orders">
            <!--订单详细信息-->
            <el-form-item v-if="countOrder === false" class="formItemNoFound">
              <div class="notFoundService">
                The Service Provider did not provide any services yet
              </div>
            </el-form-item>
            <el-form-item v-if="countOrder === true" class="order" v-for="itemFeature in orderDisplay">
              <el-col :span=12>
                <div class="orderTitle">
                  {{ itemFeature.featureName }}
                </div>
              </el-col>
              <el-col :span=6>
                <div class="orderPrice">
                  Price: ${{ itemFeature.featurePrice }}
                </div>
              </el-col>
              <el-col :span=4 :offset=2>
                <router-link
                  :to="{name: 'orderAdd', params: {type: itemFeature.featureType, id: itemFeature.featureId, price: itemFeature.featurePrice}}">
                  <el-button type="primary">
                    Book
                  </el-button>
                </router-link>
              </el-col>
            </el-form-item>

            <!--订单分页-->
            <el-pagination class="pagination-order"
                           background
                           @current-change="handleCurrentChange"
                           layout="prev, pager, next"
                           :total="store.feature.length"
                           :page-size="orderPageSize">
            </el-pagination>
          </el-form>
        </el-col>
      </el-row>

      <el-row :gutter="20">
        <el-col :span=18 :offset=3>
          <el-form ref="form" class="display-comment">
            <!--评论-->
            <el-form-item v-if="countComment === false" style="height: 50px">
              <div class="notFoundComment">
                The Service Provider did not have any reviews yet
              </div>
            </el-form-item>
            <el-form-item v-if="countComment === true" v-for="item in commentDisplay" class="comment-item">
              <div>
                <!--评论用户头像-->
                <el-col :span=3>
                  <div class="avatar_box">
                    <img :src="item.src" alt="">
                  </div>
                </el-col>
                <!--评论用户名-->
                <el-col :span=15>
                  <div class="userName">
                    {{ item.userName }}
                  </div>
                </el-col>
                <!--评论时间-->
                <el-col :span=5>
                  <div class="commentTime">
                    {{ item.commentTime }}
                  </div>
                </el-col>
                <!--评论评分-->
                <el-col :span=20>
                  <el-rate
                    v-model="item.commentStar"
                    disabled
                    show-score
                    text-color="#ff9900"
                    score-template="{value}">
                  </el-rate>
                </el-col>
                <!--评论内容-->
                <el-col :span=20>
                  <div class="comment">
                    <div class="comment-context">
                      {{ item.comment }}
                    </div>
                  </div>
                </el-col>

              </div>

            </el-form-item>
            <!--评论分页-->
            <el-pagination class="pagination-comment"
                           background
                           @current-change="handleCommentCurrentChange"
                           layout="prev, pager, next"
                           :total="store.comments.length"
                           :page-size="commentPageSize">
            </el-pagination>

          </el-form>
        </el-col>
      </el-row>

    </el-main>
  </el-container>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      input1: ' ',
      input2: ' ',
      //商店具体信息
      store: {
        src: "",
        name: "",
        time: "",
        numStar: 0,
        price: 0,
        volume: 0,
        Address: "",
        //商店含有具体订单功能
        feature: [],
        description: "",
        comments: []
      },
      //订单功能分页展示
      orderPageSize: 3,
      orderDisplay: [],

      //评论分页展示
      commentPageSize: 2,
      commentDisplay: [],

      countOrder: true,
      countComment: true

    }
  },
  methods: {
    //处理订单功能分页
    handleCurrentChange(currentPage) {
      this.countOrder = true
      this.orderDisplay = []
      var m = 0
      if (currentPage * this.orderPageSize > this.store.feature.length) {
        m = this.store.feature.length
      } else {
        m = currentPage * this.orderPageSize
      }
      for (var i = (currentPage - 1) * this.orderPageSize; i < m; i++) {
        this.orderDisplay.push(JSON.parse(JSON.stringify(this.store.feature[i])))
      }
    },

    //处理评论分页
    handleCommentCurrentChange(currentPage) {
      if (this.store.comments.length === 0) {
        this.countComment = false
      } else {
        this.countComment = true
        this.commentDisplay = []
        var m = 0
        if (currentPage * this.commentPageSize > this.store.comments.length) {
          m = this.store.comments.length
        } else {
          m = currentPage * this.commentPageSize
        }
        for (var i = (currentPage - 1) * this.commentPageSize; i < m; i++) {
          this.commentDisplay.push(JSON.parse(JSON.stringify(this.store.comments[i])))
        }
      }
    },
    setStore(src, name, time, numStar, price, volume, Address, description) {
      this.store.src = src
      this.store.name = name
      this.store.time = time
      this.store.numStar = numStar
      this.store.price = price
      this.store.volume = volume
      this.store.Address = Address
      this.store.description = description
    },
    setStoreAddOrder(featureName, featurePrice, featureType, featureId) {
      var newArr = {
        featureName: featureName,
        featurePrice: featurePrice,
        featureType: featureType,
        featureId: featureId
      }
      this.store.feature.push(JSON.parse(JSON.stringify(newArr)))
    },
    addStoreComments(userId, src, userName, commentStar, commentTime, comment) {
      var newArr = {
        userId: userId,
        src: src,
        userName: userName,
        commentStar: commentStar,
        commentTime: commentTime,
        comment: comment
      }
      this.store.comments.push(JSON.parse(JSON.stringify(newArr)))
    }
  },
  created() {

    var that = this
    axios.get("http://47.96.6.135:8080/serviceProvider/" + this.$route.params.id).then(
      function (response) {
        const reqs = response.data.data
        that.setStore(reqs.imageUrl, reqs.serviceProviderName, reqs.businessHours, reqs.rating, reqs.averagePrice, reqs.sales, reqs.address, reqs.description)

      }, function (err) {
      }
    )

    axios.get("http://47.96.6.135:8080/service/spid/" + this.$route.params.id).then(
      function (response) {
        const reqs = response.data.data

        if (reqs === null) {
          that.countOrder = false
        } else {
          for (var i = 0; i < reqs.length; i++) {
            var mFeature = reqs[i]
            that.setStoreAddOrder(mFeature.serviceName, mFeature.price, mFeature.isBoarding, mFeature.serviceProviderId)
          }
          that.handleCurrentChange(1)
        }


      }, function (err) {
      }
    )

    axios.get("http://47.96.6.135:8080/review/spid/" + this.$route.params.id).then(
      function (response) {
        const reqs = response.data.data
        for (var i = 0; i < reqs.length; i++) {
          var mReview = reqs[i]
          that.addStoreComments(mReview.userId, mReview.imageUrl, mReview.nickName, mReview.rating, mReview.createTime, mReview.content)
        }
        that.handleCommentCurrentChange(1)
      }, function (err) {
      }
    )

  }
}
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


.el-col {
  border-radius: 4px;
}

.display-information {
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  margin-top: 20px;
  padding-top: 30px;
  padding-left: 30px;
  padding-right: 30px;
}

.store-title {
  font-size: 40px;
}

.time {
  font-size: 16px;
}

.search-item {
  padding: 10px;
}

.el-icon-star-on {
  font-size: 30px;
  margin-top: 40px;
  margin-right: 20px;
  margin-bottom: 15px;
}

.priceAndvolume {
  font-size: 16px;
  margin-top: 35px;
}

.address {
  font-size: 17px;
  text-align: center
}

.display-address {
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  margin-top: 20px;
  padding-top: 30px;
  padding-left: 30px;
  padding-right: 30px;
  padding-bottom: 1px;
}

.display-orders {
  height: 468px;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  margin-top: 20px;
  padding-top: 30px;
  padding-left: 30px;
  padding-right: 30px;
  padding-bottom: 15px;
}

.order {
  border-radius: 4px;
  box-shadow: 0 2px 4px rgba(0, 0, 0,), 0 0 6px rgba(0, 0, 0, .04);
  padding: 15px;
  margin-top: 35px;
  margin-bottom: 45px;
}

.pagination-order {
  position: absolute;
  left: 62%;
  bottom: 7%;
}

.orderTitle {
  font-size: 25px;
  margin-left: 20px;
  font-weight: bold;
}

.display-comment {
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  margin-top: 30px;
  padding-top: 30px;
  padding-left: 30px;
  padding-right: 30px;
  padding-bottom: 50px;
  margin-bottom: 40px;
}

.el-icon-edit-outline {
  font-size: 25px;
}

.commentAdd {
  font-size: 25px;
}

.avatar_box {
  height: 100px;
  width: 100px;
  border: 2px solid #eee;
  border-radius: 50%;
  padding: 10px;
  box-shadow: 0 0 10px #ddd;
  background-color: #fff;

  img {
    width: 100%;
    height: 100%;
    border-radius: 50%;
    background-color: #eee;
  }
}

.userName {
  margin-top: 20px;
  font-size: 20px;
  margin-left: 13px;
}

.comment {
  height: 150px;
  width: 1100px;
  border: 2px solid #cccccc;
  border-radius: 4px;
  padding-top: 10px;
  padding-bottom: 10px;
  padding-left: 20px;
  padding-right: 5px;
  box-shadow: 0 0 10px #ddd;
  margin-top: 30px;
}

.comment-context {
  font-size: 15px;
}

.comment-item {
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 #B3B3B3;

}

.pagination-comment {
  position: absolute;
  left: 45%;
}

/deep/ .el-rate__icon {
  font-size: 30px;

}

/deep/ .el-rate__text {
  font-size: 30px;
}

/deep/ .el-rate {
  margin-top: 30px;
}

.commentTime {
  padding-top: 10px;
  font-size: 15px;
  color: #999999;
}

.notFoundService {

  color: #999999;
}

.notFoundComment {
  position: absolute;
  left: 35%;
  color: #999999;
}
.formItemNoFound{
  position: absolute;
  bottom: 43%;
  left: 57%;
}

</style>
