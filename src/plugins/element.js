import Vue from 'vue'
//导入弹框提示组件
import {
  Button,
  Form,
  FormItem,
  Input,
  Message,
  Container,
  Header,
  Aside,
  Main,
  Carousel,
  CarouselItem,
  Menu,
  MenuItemGroup,
  MenuItem,
  Submenu,
  Card,
  Row,
  Radio,
  RadioGroup,
  DropdownMenu,
  Dropdown,
  DropdownItem,
  Icon, Col, Divider, Breadcrumb, BreadcrumbItem, Tabs, TabPane, Link, CheckboxGroup, Checkbox,
  Image,
  Scrollbar,
  Pagination,
  Rate, Step, Steps, DatePicker, TimePicker, TimeSelect, Select, Option,
} from 'element-ui'
import locale from '../../node_modules/element-ui/lib/locale/lang/en'


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

Vue.use(Icon)
Vue.use(Row)
Vue.use(Col)
Vue.use(Divider)
Vue.use(Breadcrumb)
Vue.use(BreadcrumbItem)
Vue.use(Tabs)
Vue.use(TabPane)
Vue.use(Link)
Vue.use(Checkbox)
Vue.use(CheckboxGroup)
Vue.use(Image)
Vue.use(Scrollbar)
Vue.use(Pagination)
Vue.use(Rate)
Vue.use(Step)
Vue.use(Steps)
Vue.use(DatePicker)
Vue.use(Select)
Vue.use(Option)
Vue.use(Form)

Vue.use(DatePicker,{locale})



Vue.prototype.$message = Message
