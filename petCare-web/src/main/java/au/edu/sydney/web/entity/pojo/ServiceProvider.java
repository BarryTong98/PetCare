package au.edu.sydney.web.entity.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="ServiceProvider", description="服务提供者对象")
@Data
public class ServiceProvider {

    @ApiModelProperty(value = "服务提供者ID")
    private Integer spid;

    @ApiModelProperty(value = "服务提供者名 搜索匹配字段")
    private String serviceProviderName;

    @ApiModelProperty(value = "地址 搜索匹配字段")
    private String address;

    @ApiModelProperty(value = "联系电话")
    private String contactNumber;

    @ApiModelProperty(value = "类型 1 健康 2 美容 3 寄养/托管")
    private Integer type;

    @ApiModelProperty(value = "提供的具体服务内容 搜索匹配字段  \n" +
            "健康: 医院 绝育 体检 疫苗 美容：美容 洗澡 驱虫 洁牙 托管: 托管 乐园 训练 ")
    private String serviceContent;

    @ApiModelProperty(value = "平均价格")
    private Double averagePrice;

    @ApiModelProperty(value = "商家的自我描述信息 搜索匹配字段")
    private String description;

    @ApiModelProperty(value = "总销量")
    private Integer sales;

    @ApiModelProperty(value = "评分")
    private Double rating;

    @ApiModelProperty(value = "地区")
    private String region;

    @ApiModelProperty(value = "营业时间")
    private String businessHours;

    @ApiModelProperty(value = "纬度")
    private String latitude;

    @ApiModelProperty(value = "经度")
    private String longitude;

    @ApiModelProperty(value = "商家照片url")
    private String imageUrl;

    @ApiModelProperty(value = "是否在首页显示 1 显示 0 不显示")
    private Integer recommend;
}