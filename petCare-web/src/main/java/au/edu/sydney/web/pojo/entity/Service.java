package au.edu.sydney.web.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel(value = "Service", description = "service object")
public class Service {

    @ApiModelProperty(value = "service ID")
    private Integer sid;

    @ApiModelProperty(value = "service provider ID")
    private Integer serviceProviderId;

    @ApiModelProperty(value = "service name")
    private String serviceName;

    @ApiModelProperty(value = "(expected) price")
    private String price;

    @ApiModelProperty(value = "Is it a hosting service (1 Yes 0 No)")
    private Integer isBoarding;

    @ApiModelProperty(value = "service date")
    private Date serviceDate;

    @ApiModelProperty(value = "service time")
    private String serviceTime;

}