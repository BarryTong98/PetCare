package au.edu.sydney;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.service.impl.EmailServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Chris
 * @date 2021-09-21 09:30
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailTest {

    @Autowired
    EmailServiceImpl emailService;

    @Test
    public void sendEmailTest(){
        Result result = emailService.sendEmailVerificationCode("947079912@qq.com");
        System.out.println(result);
    }

    @Test
    public void verifyCodeTest(){
        Result result = emailService.verifyCode("947079912@qq.com","443875");
        System.out.println(result);
    }
}
