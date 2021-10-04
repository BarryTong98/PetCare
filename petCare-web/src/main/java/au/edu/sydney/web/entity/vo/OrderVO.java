package au.edu.sydney.web.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Chris
 * @date 2021-10-04 15:16
 * @description
 */
@Data
public class OrderVO {

    @ApiModelProperty(value = "订单ID")
    private Integer oid;

    @ApiModelProperty(value = "对应的服务ID")
    private Integer serviceId;

    @ApiModelProperty(value = "对应的用户ID")
    private Integer userId;

    @ApiModelProperty(value = "(预期)金额")
    private Double amount;

    @ApiModelProperty(value = "订单状态 1 未开始 2 已完成 3 已取消")
    private Integer status;

    @ApiModelProperty(value = "预约的服务预期(开始)时间")
    private String serviceTime;

    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;

    @ApiModelProperty(value = "对应的服务名")
    private String serviceName;

    @ApiModelProperty(value = "对应的服务提供者名")
    private String serviceProviderName;


}
