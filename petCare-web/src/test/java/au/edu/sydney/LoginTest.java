package au.edu.sydney;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author hjs
 * @Date 2021/10/31 17:26
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginTest {

    @Resource
    UserServiceImpl userService;

    @Test
    public void notExistedUser() {
        Result notExist = userService.login("notExist", "123456");
        Assert.assertFalse(notExist.getFlag());
        Assert.assertEquals("User doesn't exist!",notExist.getMessage());
        Assert.assertTrue(notExist.getCode()==999);
    }

    @Test
    public void emptyParameters(){
        Result nameIsNull = userService.login(null, "123456");
        Assert.assertFalse(nameIsNull.getFlag());
        Assert.assertEquals("Wrong username or password",nameIsNull.getMessage());
        Assert.assertTrue(nameIsNull.getCode()==999);

        Result passwordIsNull = userService.login("123", null);
        Assert.assertFalse(passwordIsNull.getFlag());
        Assert.assertEquals("Wrong username or password",passwordIsNull.getMessage());
        Assert.assertTrue(passwordIsNull.getCode()==999);
    }

    @Test
    public void wrongPassword(){
        Result wrongPassword = userService.login("Jiasheng Huang", "123456789");
        Assert.assertFalse(wrongPassword.getFlag());
        Assert.assertEquals("Username and password don't match",wrongPassword.getMessage());
        Assert.assertTrue(wrongPassword.getCode()==999);
    }

    @Test
    public void rightPassword(){
        Result rightPassword = userService.login("Jiasheng Huang", "123456");
        Assert.assertTrue(rightPassword.getFlag());
        Assert.assertTrue(rightPassword.getCode()==200);
    }
}
