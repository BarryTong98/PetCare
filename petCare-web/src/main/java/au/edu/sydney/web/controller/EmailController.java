package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.pojo.req.EmailVerificationREQ;
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


    @ApiOperation("get email verification code")
    @PostMapping("/send")
    public Result sendEmail(@ApiParam(value = "email address", required = true)
                            @RequestBody EmailVerificationREQ emailVerificationREQ) {
        return emailService.sendEmailVerificationCode(emailVerificationREQ.getEmail());
    }

    @ApiOperation("verify the verification code")
    @PostMapping("/verify")
    public Result checkCode(
            @RequestBody EmailVerificationREQ emailVerificationREQ) {
        return emailService.verifyCode(emailVerificationREQ.getEmail(),emailVerificationREQ.getVerificationCode());
    }


}
