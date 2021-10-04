package au.edu.sydney;

import au.edu.sydney.web.dao.UserMapper;
import au.edu.sydney.web.entity.pojo.Order;
import au.edu.sydney.web.entity.pojo.User;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void queryAll() {
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void toJSON(){
        Order order=new Order();
        order.setServiceId(2);
        order.setUserId(1);
        order.setAmount(100.00);
        order.setStatus(1);
        order.setServiceTime("21 September 2021 1pm");
        order.setCreateTime(new Date());
        System.out.println(JSONObject.toJSON(order));
    }
}
