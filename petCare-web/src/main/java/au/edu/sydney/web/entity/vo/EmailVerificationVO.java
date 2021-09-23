package au.edu.sydney.web.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Chris
 * @date 2021-09-21 14:08
 * @description
 */
@ApiModel(value="emailVerificationVO", description="邮箱验证post请求对象")
@AllArgsConstructor
@Getter
@Setter
public class EmailVerificationVO {
    @ApiParam(value = "邮箱", required = true)
    String email;
    @ApiParam(value = "验证码", required = true)
    String verificationCode;
}
