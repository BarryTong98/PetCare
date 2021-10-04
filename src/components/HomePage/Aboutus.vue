<template>
  <div>
    <div class="celing" style="color: #e3f2f3">1</div>
    <h2 class="about" style="text-align:center;line-height:1.35em;font-size:40px">ABOUT US</h2>
    <p class="ThatWay">
      <span style="line-height: 1.75em;
  font-size: 18px;">The Way It Should Be</span>
    </p>

    <p class="descrption">
      <span>
     Pets are becoming an important family member since they relieve the pressure of work and life, provide companionship, and increase the fun of life. Therefore, the care and medical facilities for pets are also receiving increasing attention from pet owners. Even though there is a multitude of vet clinics and stores in the current market, it is still a problem for pet owners to get quality pet services efficiently. Pet Care is designed to provide a convenient and high-efficient platform for both pet owners and vet clinics, where users can easily get service provider’s detailed information including contact and reputation even book a pet service appointment and create a scheduled order.
      </span>
    </p>
    <div class="bot" style="color: #e3f2f3">1</div>
    <div class="github">
      <a href="https://github.com/BarryTong98/PetCare" target="_blank">
        <img class="githubicon" src="../../assets/img/GitHub-Mark-64px.png" alt="missing"/>
      </a>
    </div>
    <div class="github">
      <span class="val">©2021 by Pet Care.</span>
    </div>
  </div>
</template>

<script>
export default {
  // methods: {
  //   togithub(){
  //     this.$router.push('https://github.com/BarryTong98/PetCare')
  //   }
  // }
}
</script>

<style scoped>
/*.icon {*/
/*  display: block;*/
/*  text-align: center;*/
/*}*/

.githubicon{
  width: 40%;
  height: 80%;
}

div {
  font-family: Arial, Helvetica, sans-serif;
  background-color: #e3f2f3;
}

.github {
  display: flex;
  justify-content: center;
}

.bot {
  margin-top: 5%;
}

.celing {
  margin-bottom: 5%;
}

.about {
  display: block;
  text-transform: uppercase;
  text-align: center;
  font: var(--font_6)
}

.val {
  font-size: x-small;
  text-align: center;
  margin-top: 0.5%;
}

.ThatWay {
  text-align: center;
  font: var(--font_8)
}

.descrption {
  text-align: center;
  padding-left: 20%;
  padding-right: 20%;
  line-height: 1.875em;
  font-size: 15px
}

:root {
  --font_0: normal normal normal 22px/1.41em brandon-grot-w01-light, sans-serif;
  --font_1: normal normal normal 14px/1.79em avenir-lt-w01_35-light1475496, sans-serif;
  --font_2: normal normal normal 28px/1.375em brandon-grot-w01-light, sans-serif;
  --font_3: normal normal normal 88px/1.2em brandon-grot-w01-light, sans-serif;
  --font_4: normal normal normal 72px/1.25em brandon-grot-w01-light, sans-serif;
  --font_5: normal normal normal 50px/1.34em brandon-grot-w01-light, sans-serif;
  --font_6: normal normal normal 40px/1.35em brandon-grot-w01-light, sans-serif;
  --font_7: normal normal normal 20px/1.67em avenir-lt-w01_35-light1475496, sans-serif;
  --font_8: normal normal normal 18px/1.75em avenir-lt-w01_35-light1475496, sans-serif;
  --font_9: normal normal normal 15px/1.875em avenir-lt-w01_35-light1475496, sans-serif;
  --font_10: normal normal normal 14px/1.79em avenir-lt-w01_35-light1475496, sans-serif;
}
</style>