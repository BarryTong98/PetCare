package au.edu.sydney.web.entity.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


@ApiModel(value="Review", description="评论对象")
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
    private Date createTime;

    @ApiModelProperty(value = "点赞数")
    private Integer numberOfLikes;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(Integer serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Integer numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }
}