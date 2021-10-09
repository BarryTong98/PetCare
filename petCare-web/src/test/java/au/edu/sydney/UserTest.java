package au.edu.sydney;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.UserMapper;
import au.edu.sydney.web.entity.pojo.User;
import au.edu.sydney.web.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Chris
 * @date 2021-09-16 14:57
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserServiceImpl userService;

    @Test
    public void queryAllByUserNameTest() {
        List<User> users = userMapper.queryAllByUserName("user");
        if (users.isEmpty()) {
            System.out.println("No user has similar user name");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }

    }

    @Test
    public void selectByUserNameTest() {
        User user = userMapper.selectByUserName("user1");
        if (user == null) {
            System.out.println("No such user");
        } else {
            System.out.println(user);
        }

    }

    @Test
    public void selectByEmailTest() {
        User user = userMapper.selectByEmail("123@qq.com");
        if (user == null) {
            System.out.println("No such user");
        } else {
            System.out.println(user);
        }

    }

    @Test
    public void resetPasswordTest() {
        Result result = userService.resetPassword("12345678","947079912@qq.com" );
        System.out.println(result);

    }


}
