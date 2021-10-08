package au.edu.sydney.web.entity.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Service", description = "服务对象")
public class Service {

    @ApiModelProperty(value = "服务ID")
    private Integer sid;

    @ApiModelProperty(value = "对应服务提供者ID")
    private Integer serviceProviderId;

    @ApiModelProperty(value = "服务名")
    private String serviceName;

    @ApiModelProperty(value = "（预期）价格")
    private String price;

    @ApiModelProperty(value = "是否是托管服务 1 是 0 否")
    private Integer isBoarding;

    @ApiModelProperty(value = "服务日期")
    private Date serviceDate;

    @ApiModelProperty(value = "服务时间")
    private String serviceTime;

}