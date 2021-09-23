import Vue from 'vue'
//导入弹框提示组件
import { Button, Form, FormItem, Input, Message , Container, Header, Aside, Main, Carousel, CarouselItem} from 'element-ui'

Vue.use(Button)
Vue.use(Form)
Vue.use(Input)
Vue.use(FormItem)
Vue.use(Container)
Vue.use(Header)
Vue.use(Aside)
Vue.use(Main)
Vue.use(Carousel)
Vue.use(CarouselItem)
Vue.prototype.$message = Message
