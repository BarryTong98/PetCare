package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.req.EmailVerificationREQ;
import au.edu.sydney.web.service.EmailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Chris
 * @date 2021-09-21 13:10
 * @description
 */
@RestController
@RequestMapping("/email")
@CrossOrigin
public class EmailController {

    @Resource
    EmailService emailService;


    @ApiOperation("获取邮箱验证码")
    @PostMapping("/send")
    public Result sendEmail(@ApiParam(value = "邮箱", required = true)
                            @RequestBody String email) {
        return emailService.sendEmailVerificationCode(email);
    }

    @ApiOperation("核对验证码")
    @PostMapping("/verify")
    public Result checkCode(
            @RequestBody EmailVerificationREQ emailVerificationREQ) {
        return emailService.verifyCode(emailVerificationREQ.getEmail(),emailVerificationREQ.getVerificationCode());
    }


}
