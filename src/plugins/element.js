import Vue from 'vue'
//导入弹框提示组件
import { Button, Form, FormItem, Input, Message , Container, Header, Aside, Main, Carousel, CarouselItem, Menu,MenuItemGroup,MenuItem,Submenu, Card, Row,Radio,RadioGroup,DropdownMenu,Dropdown,DropdownItem} from 'element-ui'

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
Vue.use(Submenu)
Vue.use(Menu)
Vue.use(MenuItem)
Vue.use(MenuItemGroup)
Vue.use(Card)
Vue.use(Row)
Vue.use(Radio)
Vue.use(RadioGroup)
Vue.use(Dropdown)
Vue.use(DropdownMenu)
Vue.use(DropdownItem)
Vue.prototype.$message = Message