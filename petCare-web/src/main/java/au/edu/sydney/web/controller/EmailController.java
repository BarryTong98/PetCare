package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.vo.EmailVerificationVO;
import au.edu.sydney.web.service.EmailService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chris
 * @date 2021-09-21 13:10
 * @description
 */
@RestController
@RequestMapping("/email")
@CrossOrigin
public class EmailController {

    @Autowired
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
            @RequestBody EmailVerificationVO emailVerificationVO) {
        return emailService.verifyCode(emailVerificationVO.getEmail(),emailVerificationVO.getVerificationCode());
    }


}
