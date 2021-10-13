<template>
  <el-container class="orderAdd-container">
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

    <el-main>
      <el-row :gutter="20">
        <el-col :span=18 :offset=3>
          <div class="display-orderAdd">
            <el-steps finish-status="success" :active="active" align-center>
              <el-step title="Step 1" description="Select  time"></el-step>
              <el-step title="Step 2" description="Input pet information"></el-step>
              <el-step title="Step 3" description="Submit orders"></el-step>
            </el-steps>
            <!--分割线-->
            <el-divider></el-divider>
            <!--第一步 日期和时间选择其-->
            <!--非寄宿类订单时间选择-->
            <div class="block" v-if="active === 0 && type === 0">
              <el-row :gutter="20">
                <el-col :span="4" :offset="6" class="center">
                  <el-date-picker
                    @change="setOptions()"
                    v-model="value1"
                    type="date"
                    :picker-options="pickerDateOptions"
                    placeholder="Select Date">
                  </el-date-picker>
                </el-col>
                <el-col :span="6" :offset="3">
                  <el-select v-model="value2" placeholder="Select Time" class="center">
                    <el-option
                      v-for="item in options"
                      :key="item.value"
                      :label="item.label"
                      :value="item.value"
                      :disabled="item.disabled">
                    </el-option>
                  </el-select>
                </el-col>
              </el-row>
            </div>
            <!--寄宿类订单时间选择-->
            <div class="block" v-if="active === 0 && type === 1">
              <el-row :gutter="20">
                <el-col :span="4" :offset="8" class="center">
                  <el-date-picker
                    v-model="value1"
                    type="daterange"
                    range-separator="to"
                    start-placeholder="Start Date"
                    :picker-options="pickerDateOptions"
                    end-placeholder="End Date">
                  </el-date-picker>
                </el-col>
              </el-row>
            </div>
            <!--第二步 填写宠物信息-->
            <div v-if="active === 1">
              <el-row :gutter="20">
                <el-col :span="12" :offset="5">
                  <el-form ref="form" :model="form" label-width="120px">
                    <el-form-item label="PetName: ">
                      <el-input v-model="form.petName"></el-input>
                    </el-form-item>
                    <el-form-item label="PetType: ">
                      <el-input v-model="form.petType"></el-input>
                    </el-form-item>
                    <el-form-item label="CaseDescription: ">
                      <el-input type="textarea" :autosize="{ minRows: 4, maxRows: 6}" v-model="form.caseDescription"></el-input>
                    </el-form-item>
                  </el-form>
                </el-col>
              </el-row>
            </div>
            <!--第三步 提交订单-->
            <div class="block" v-if="active === 2">
              <el-row :gutter="20">
                <el-col :span="14" :offset="5">
                  <div class="txt">
                    The order information has been filled in, click "Next Step" to complete the order and go back to the Service Provider
                  </div>
                </el-col>
              </el-row>


            </div>
            <!--分割线-->
            <el-divider></el-divider>
            <el-row :gutter="20">
              <el-col :span="6" :offset="9">
                <el-button style="margin-top: 12px;" @click="previous">previous step</el-button>
                <el-button style="margin-top: 12px;" @click="next">next step</el-button>
              </el-col>
            </el-row>
          </div>
        </el-col>
      </el-row>
    </el-main>

  </el-container>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return{
      input1: ' ',
      input2: ' ',

      type: 0,
      id: 0,
      price: '',
      active: 0,
      value1: '',
      value2: '',
      pickerDateOptions:{
        disabledDate(time) {
        return time.getTime() < Date.now()-24*60*60*1000;
        }
      },
      options: this.getOptions(this.value1),
      form:{
        petName: '',
        petType: '',
        caseDescription: ''
      },

    }
  },
  methods: {
    next() {
      if (++this.active > 2){
        this.submitOrder()
      }
    },
    previous(){
      if(--this.active < 0) this.active = 0;
    },

    getDate(value,hh){
      var date= new Date;
      var y = date.getFullYear()
      var m = date.getMonth() + 1
      var d = date.getDate()
      var h = date.getHours()
      var M = date.getMinutes()+1
      var s = date.getSeconds()+1

      var yy = 2000
      var mm = 1
      var dd = 1

      if(!(this.value1 === undefined)){
        yy = value.getFullYear()
        mm = value.getMonth()+1
        dd = value.getDate()
      }

      return Date.UTC(yy,mm,dd,hh,30,0) < Date.UTC(y,m,d,h,M,s)
    },
    getOptions(value){
      return [{
        value: 'option1',
        label: '08: 30 -- 09:30',
        data: new Date,
        disabled: this.getDate(value,8)
      }, {
        value: 'option2',
        label: '09: 30 -- 10:30',
        disabled: this.getDate(value,9)
      }, {
        value: 'option3',
        label: '10: 30 -- 11:30',
        disabled: this.getDate(value,10)
      }, {
        value: 'option4',
        label: '14: 30 -- 15:30',
        disabled: this.getDate(value,14)
      }, {
        value: 'option5',
        label: '15: 30 -- 16:30',
        disabled: this.getDate(value,15)
      }, {
        value: 'option6',
        label: '16: 30 -- 17:30',
        disabled: this.getDate(value,16)
      }
      ]
    },
    setOptions(){
      this.options = this.getOptions(this.value1)
      console.log(this.options)
      for(var i = 0; i < this.options.length; i++){
        if (this.options[i].value === this.value2 && this.options[i].disabled === true){
          console.log(this.value2)
          this.value2 = ''
        }
      }
      console.log(this.value2)
    },
    submitOrder(){
      var that = this
      if(this.type === 0){
        if(
          this.value1 ==='' || this.value2 === '' || this.form.petType === '' || this.form.petName === '' || this.form.caseDescription === ''
        ){
          alert('Your information is incomplete')
          this.active = 0
        }
        else {
          var date = new Date(this.value1)
          var y = date.getFullYear()
          var m = date.getMonth() + 1
          var d = date.getDate()
          var dateString = y.toString() + "-" + m.toString() + "-" + d.toString()
          var time = ''
          if(this.value2 ==='option1') time = '08: 30 -- 09:30'
          else if(this.value2 ==='option2') time = '09: 30 -- 10:30'
          else if(this.value2 ==='option3') time = '10: 30 -- 11:30'
          else if(this.value2 ==='option4') time = '14: 30 -- 15:30'
          else if(this.value2 ==='option5') time = '15: 30 -- 16:30'
          else if(this.value2 ==='option6') time = '16: 30 -- 17:30'
          var serviceTime = dateString + " " + time
          console.log(this.price.split('/')[0])
          var nowDate = new Date()

          axios.post("http://47.96.6.135:8080/order/add",{
            amount: that.price.split('/')[0],
            createTime: nowDate,
            serviceId: that.id,
            serviceTime: serviceTime,
            status: 1,
            userId: 1
          }).then(function (response){
            console.log(response)
            if (response.data.code === 200) {
              alert('Add Order Successfully')
              that.$router.push({name:'information', params: {id: that.id}})
            }
          })
        }

      }
      else if(this.type === 1){
        if(
          this.value1 ==='' || this.form.petType === '' || this.form.petName === '' || this.form.caseDescription === ''
        ){
          alert('Your information is incomplete')
          this.active = 0
        }
        else {
          var date1 = new Date(this.value1[0])
          var date2 = new Date(this.value1[1])
          var y1 = date1.getFullYear()
          var m1 = date1.getMonth() + 1
          var d1 = date1.getDate()
          var y2 = date2.getFullYear()
          var m2 = date2.getMonth() + 1
          var d2 = date2.getDate()
          var dateString1 = y1.toString() + "-" + m1.toString() + "-" + d1.toString()
          var dateString2 = y2.toString() + "-" + m2.toString() + "-" + d2.toString()
          var dateString0 = dateString1 + " --> " + dateString2
          var days = (date2 -date1) / (1000*60*60*24)
          var amount = this.price.split('/')[0] * days
          var nowDate0 = new Date()

          axios.post("http://47.96.6.135:8080/order/add",{
            amount: amount,
            createTime: nowDate0,
            serviceId: that.id,
            serviceTime: dateString0,
            status: 1,
            userId: 1
          }).then(function (response){
            console.log(response)
            if (response.data.code === 200) {
              alert('Add Order Successfully')
              that.$router.push({name:'information', params: {id: that.id}})
            }
          })
        }
      }
    }
  },
  created() {
    if(this.type === 0){
      this.type = this.$route.params.type
      this.price = this.$route.params.price
      this.id = this.$route.params.id
    }

  }
}
</script>

<style lang="less" scoped>


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






.display-orderAdd {
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  margin-top: 20px;
  padding-top: 60px;
  padding-left: 100px;
  padding-right: 100px;
  padding-bottom: 40px;
}

.block{
  margin-top: 40px;
  margin-bottom: 40px;
  padding-top: 80px;
  height: 100px;
}

.txt{
  text-align:center;
  letter-spacing:2px
}




</style>
