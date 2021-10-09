package au.edu.sydney.web.entity.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value="Review", description="评论对象")
@Data
public class Review {

    @ApiModelProperty(value = "评论ID")
    private Integer rid;

    @ApiModelProperty(value = "对应的用户ID")
    private Integer userId;

    @ApiModelProperty(value = "对应的服务提供者ID")
    private Integer serviceProviderId;

    @ApiModelProperty(value = "评分")
    private Double rating;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "评论发布时间")
    private String createTime;

    @ApiModelProperty(value = "点赞数")
    private Integer numberOfLikes;
}