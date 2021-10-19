import Vue from 'vue'
import App from './App.vue'
import router from './router'
import './plugins/element.js'
// 載入 vue2-leaflet，依照自己需要載入組件
import { LMap, LTileLayer, LMarker, LPopup, LIcon } from "vue2-leaflet";
// 載入 css
import "leaflet/dist/leaflet.css";

// 啟用載入的各組件
Vue.component("l-map", LMap);
Vue.component("l-tile-layer", LTileLayer);
Vue.component("l-marker", LMarker);
Vue.component("l-popup", LPopup);
Vue.component("l-icon", LIcon);

// 設定預設 icon
import { Icon } from "leaflet";
delete Icon.Default.prototype._getIconUrl;
Icon.Default.mergeOptions({
  iconRetinaUrl: require("leaflet/dist/images/marker-icon-2x.png"),
  iconUrl: require("leaflet/dist/images/marker-icon.png"),
  shadowUrl: require("leaflet/dist/images/marker-shadow.png")
});

Vue.config.productionTip = false;

//导入全局样式表
import './assets/css/global.css'
import './assets/style/font.less'
//导入字体图标
import './assets/fonts/iconfont.css'
import axios from 'axios'
import VueAxios from "vue-axios";


import { LoaderPlugin,GoogleLogin } from 'vue-google-login';

Vue.use(LoaderPlugin, {
  client_id: '870223928949-0h13cc4egdup97kjmjp2d9e39io95lc7.apps.googleusercontent.com'
});


Vue.GoogleAuth.then(auth2 => {
  console.log(auth2.isSignedIn.get());
  console.log(auth2.currentUser.get())
})
Vue.use(GoogleLogin)

Vue.config.productionTip = false
//配置请求的根路径
axios.defaults.baseURL = 'http://110.40.184.115:8080'
Vue.prototype.$http = axios
Vue.use(axios,VueAxios)
// axios({
//   url: 'http://110.40.184.115:8080/serviceProvider/search/sydney/16?keyword='
// }).then(res=> {
//   console.log(res);
// })

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
