package au.edu.sydney.web.pojo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author Chris
 * @date 2021-10-01 20:08
 * @description
 */
@Data
@ApiModel(value="PasswordREQ", description="password request object")
public class PasswordREQ {

    @ApiParam("email")
    private String email;

    @ApiParam("password")
    private String password;
}
