<template>
  <div class="main">
    <div>
      <p class="first">
        Personalised Pet care from the comfort of your home
      </p>
      <!--<p>-->
      <!--  We’re here for you, via video calls, house visits and medication delivery.-->
      <!--</p>-->
      <button class="btn-quality" onclick="window.location.href='http://localhost:8080/#/template'">
        Get started
      </button>
    </div>
    <img src="../../assets/img/pet.png" alt="missing">
  </div>
</template>

<script>
export default {
  name: 'HomeProfile'
}
</script>

<style scoped>
@import "../../assets/style/font.less";

.main {
  display: flex;
}

.first {
  margin-left: 2%;
  font-size: 4vw;
  font-family: 'PPWoodland-Bold';
}

img {
  width: 40%;
  height: 40%;
}

.btn-quality {
  width: 28vw;
  height: 4.6vw;
  background-color: #f4511e;
  border: none;
  font-size: 1.25vw;
  opacity: 0.6;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  font-family: "ObjectSans-Bold";
  font-stretch: normal;
  font-style: normal;
  line-height: 1;
  letter-spacing: normal;
  text-align: center;
  color: #ffffff;
  margin-left: 5vw;
  margin-top: 1vw;
  margin-bottom: 2vw;
}
</style>