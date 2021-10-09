package au.edu.sydney.web.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Chris
 * @date 2021-10-09 10:00
 * @description
 */
@Data
public class ReviewVO {

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

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "用户头像照片url")
    private String imageUrl;


}

