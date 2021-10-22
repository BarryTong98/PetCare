package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.UserMapper;
import au.edu.sydney.web.domain.entity.User;
import au.edu.sydney.web.service.EmailService;
import au.edu.sydney.web.util.VerCodeGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @author Chris
 * @date 2021-09-21 09:32
 * @description
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    JavaMailSenderImpl mailSender;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * Get the sender from the configuration file
     */
    @Value("${spring.mail.username}")
    private String sender;

    @Override
    @Transactional
    @Async
    public Result sendEmailVerificationCode(String email) {

        User user = getUserByEmail(email);
        if (user == null) {
            return Result.error("User doesn't exists");
        }


        String verCode = VerCodeGenerateUtil.generateVerCode();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("security code");
        message.setText("Hello " + user.getUserName() + ":\n"
                + "\nThe email verification code for this request is: " + verCode + "（Do not disclose this code）\n"
                + "\nIf you are not doing it yourself, please ignore the email.");
        message.setTo(email);
        message.setFrom(sender);
        try {
            mailSender.send(message);
        } catch (Exception e) {
            return Result.error("Send email failed");

        }
        try {
            redisTemplate.opsForValue().set("petCare:email:code:" + email, verCode, 5, TimeUnit.MINUTES);

        } catch (Exception e) {
            return Result.error("Fail to save code to redis");
        }

        return Result.ok("Send email successfully");


    }

    @Override
    public Result verifyCode(String email, String code) {

        User user = getUserByEmail(email);
        if (user == null) {
            return Result.error("User doesn't exists");
        }
        String redisValue = (String) redisTemplate.opsForValue().get("petCare:email:code:" + email);
        if (redisValue != null && redisValue.equals(code)) {
            return Result.ok("Verification succeed");
        }
        return Result.error("Wrong verification code");
    }

    private User getUserByEmail(String email) {
        return userMapper.selectByEmail(email);
    }


}
