<template>
  <el-container class="information-container">
    <!--头部区域-->
    <el-header>
      <div>
        <img src="../assets/Dog.png" alt="missing"/>
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
      <el-button type="info" @click="logout">Sign Out</el-button>
    </el-header>

    <el-main>
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
                <el-col :span=9 :offset=3>
                  <div class="store-title">{{ store.name }}</div>
                </el-col>
                <!--营业时间-->
                <el-col :span=6 :offset=2>
                  <div class="time">{{ store.time }}</div>
                </el-col>
                <!--评分-->
                <el-col :span=5 :offset=3>
                  <i class="el-icon-star-on" v-for="star in store.numStar"></i>
                </el-col>
                <!--价格和销量-->
                <el-col :span=6>
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
              <el-col :offset="4">
                <div class="address">Address:&nbsp;{{ store.Address }}</div>
              </el-col>
            </el-form-item>
          </el-form>
        </el-col>
        <!-- 订单展示-->
        <el-col :span=10>
          <el-form ref="form" class="display-orders">
            <!--订单详细信息-->
            <el-form-item class="order" v-for="itemFeature in orderDisplay">
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
                <el-button type="primary">
                  Book
                </el-button>
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
            <el-form-item v-for="item in commentDisplay" class="comment-item">
              <div>
                <!--评论用户头像-->
                <el-col :span=3>
                  <div class="avatar_box">
                    <img :src="item.src" alt="">
                  </div>
                </el-col>
                <!--评论用户名-->
                <el-col :span=20>
                  <div class="userName">
                    {{ item.userName }}
                  </div>
                </el-col>
                <!--评论评分-->
                <el-col :span=20>
                  <img src="../assets/img/icon_star.png" height="50" width="50" v-for="star in item.commentStar">
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
export default {
  data() {
    return {
      //商店具体信息
      store: {
        src: require('../assets/img/2.png'),
        name: "Auckland Pet Hospital",
        time: "08:30 -- 21:30",
        numStar: 5,
        price: 100,
        volume: 56,
        Address: "address of Auckland Pet Hospital",
        //商店含有具体订单功能
        feature: [
          {
            featureName: "Insect repellent",
            featurePrice: 100
          },
          {
            featureName: "Insect repellent1",
            featurePrice: 90
          },
          {
            featureName: "Insect repellent2",
            featurePrice: 80
          },
          {
            featureName: "Insect repellent3",
            featurePrice: 50
          }
        ],
        description: "description of Auckland Pet Hospital description of" +
          "Auckland Pet Hospital description of Auckland Pet Hospital description of Auckland Pet Hospital description of Auckland Pet Hospital",
        comments: [
          {
            src: require('../assets/d.png'),
            userName: "Yiheng Guo",
            commentStar: 5,
            comment: "This hospital provided excellent, and I no longer had to worry that our kitten would somehow get pregnant." +
              "This hospital provided excellent, and I no longer had to worry that our kitten would somehow get pregnant." +
              "This hospital provided excellent, and I no longer had to worry that our kitten would somehow get pregnant."
          },
          {
            src: require('../assets/img_1.png'),
            userName: "Yiheng Guo",
            commentStar: 4,
            comment: "This hospital provided excellent, and I no longer had to worry that our kitten would somehow get pregnant." +
              "This hospital provided excellent, and I no longer had to worry that our kitten would somehow get pregnant."

          }]
      },
      //订单功能分页展示
      orderPageSize: 3,
      orderDisplay: [],

      //评论分页展示
      commentPageSize: 2,
      commentDisplay: []

    }
  },
  methods: {
    //处理订单功能分页
    handleCurrentChange(currentPage) {
      this.orderDisplay = []
      var m = 0
      if (currentPage * this.orderPageSize > this.store.feature.length) {
        m = this.store.feature.length
      } else {
        m = currentPage * this.orderPageSize
      }
      for (var i = (currentPage - 1) * this.orderPageSize; i < m; i++) {
        this.orderDisplay.push(this.store.feature[i])
      }
    },

    //处理评论分页
    handleCommentCurrentChange(currentPage){
      this.commentDisplay = []
      var m = 0
      if(currentPage * this.commentPageSize > this.store.comments.length){
        m = this.store.comments.length
      }else{
        m = currentPage * this.commentPageSize
      }
      for(var i = (currentPage - 1) * this.commentPageSize; i < m; i++){
        this.commentDisplay.push(this.store.comments[i])
      }
    }
  },
  created() {
    this.handleCurrentChange(1)
    this.handleCommentCurrentChange(1)
  }
}
</script>

<style scoped lang="less" scoped>
body {
  font-family: "American Typewriter", serif;
}

.search-container {
  height: 100%;
}

.el-header {
  background-color: #b3ddce;
  display: flex;
  justify-content: space-between;
  padding-left: 0;
  align-items: center;
  color: #fff;
  font-size: 20px;

  > div {
    display: flex;
    align-items: center;

    span {
      margin-left: 15px;
    }

    img {
      width: 50px;
      height: 50px;
      margin-left: 10px;
    }
  }
}

.el-input {
  margin-left: -19%;
  width: 700px;
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
  height: 424px;
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
  font-size: 30px;
  margin-left: 20px;
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
}

.comment-context {
  font-size: 15px;
}

.comment-item {
  padding: 15px;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 #B3B3B3;

}

.pagination-comment{
  position: absolute;
  left: 45%;
}


</style>
