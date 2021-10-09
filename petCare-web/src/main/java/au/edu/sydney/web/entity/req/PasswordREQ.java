package au.edu.sydney.web.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author Chris
 * @date 2021-10-01 20:08
 * @description
 */
@Data
@ApiModel(value="PasswordREQ", description="密码请求对象")
public class PasswordREQ {

    @ApiParam("邮箱")
    private String email;

    @ApiParam("密码")
    private String password;
}
