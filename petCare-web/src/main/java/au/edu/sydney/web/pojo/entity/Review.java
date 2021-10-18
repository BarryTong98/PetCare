package au.edu.sydney.web.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value="Review", description="review object")
@Data
public class Review {

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

    @ApiModelProperty(value = "review publish time")
    private String createTime;

    @ApiModelProperty(value = "number of likes")
    private Integer numberOfLikes;
}