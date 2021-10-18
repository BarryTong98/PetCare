package au.edu.sydney.web.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @Author hjs
 * @Date 2021/10/14 13:27
 * @Version 1.0
 */
@Data
@ApiModel(value = "LoginREQ", description = "Login request object")
public class LoginREQ {

    @ApiParam("username")
    String username;

    @ApiParam("password")
    String password;
}
