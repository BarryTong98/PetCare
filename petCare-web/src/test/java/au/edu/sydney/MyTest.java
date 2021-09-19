package au.edu.sydney;

import au.edu.sydney.web.dao.UserMapper;
import au.edu.sydney.web.entity.pojo.User;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
        User user = new User();
        user.setUserName("hjs");
        user.setNickName("huang");
        user.setPassword("111");
        user.setPhoneNumber("110");
        user.setEmail("111@qq.com");
        System.out.println(new JSONObject().toJSONString(user));
    }
}
