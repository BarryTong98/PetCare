package au.edu.sydney.web.domain.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="User", description="user object")
public class User {

    @ApiModelProperty(value = "user ID")
    private Integer uid;

    @ApiModelProperty(value = "user name unique")
    private String userName;

    @ApiModelProperty(value = "nick name")
    private String nickName;

    @ApiModelProperty(value = "password")
    private String password;

    @ApiModelProperty(value = "phone number")
    private String phoneNumber;

    @ApiModelProperty(value = "email unique")
    private String email;

    @ApiModelProperty(value = "avatar image url")
    private String imageUrl;


}