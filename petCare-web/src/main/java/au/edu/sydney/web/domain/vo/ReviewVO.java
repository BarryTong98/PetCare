package au.edu.sydney.web.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Chris
 * @date 2021-10-09 10:00
 * @description
 */
@Data
public class ReviewVO {

    @ApiModelProperty(value = "review ID")
    private Integer rid;

    @ApiModelProperty(value = "user ID")
    private Integer userId;

    @ApiModelProperty(value = "service provider ID")
    private Integer serviceProviderId;

    @ApiModelProperty(value = "rating")
    private Double rating;

    @ApiModelProperty(value = "review content")
    private String content;

    @ApiModelProperty(value = "review create time")
    private String createTime;

    @ApiModelProperty(value = "number of likes ")
    private Integer numberOfLikes;

    @ApiModelProperty(value = "user nick name")
    private String nickName;

    @ApiModelProperty(value = "image url of user avatar")
    private String imageUrl;


}

