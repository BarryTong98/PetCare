package au.edu.sydney.web.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author Chris
 * @date 2021-09-21 14:08
 * @description
 */
@ApiModel(value="emailVerificationREQ", description="email verification request object")
@Data
public class EmailVerificationREQ {
    @ApiParam(value = "email", required = true)
    String email;
    @ApiParam(value = "verification code", required = true)
    String verificationCode;
}
