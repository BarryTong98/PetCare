package au.edu.sydney.web.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@ApiModel(value="Order", description="order object")
@Data
public class Order {

    @ApiModelProperty(value = "order ID")
    private Integer oid;

    @ApiModelProperty(value = "service ID")
    private Integer serviceId;

    @ApiModelProperty(value = "corresponding user ID")
    private Integer userId;

    @ApiModelProperty(value = "(expected) amount")
    private Double amount;

    @ApiModelProperty(value = "Order status(1 not started 2 completed 3 cancelled 4 evaluated）")
    private Integer status;

    @ApiModelProperty(value = "Expected (start) time of the booked service")
    private String serviceTime;

    @ApiModelProperty(value = "Order creation time")
    private Date createTime;
}