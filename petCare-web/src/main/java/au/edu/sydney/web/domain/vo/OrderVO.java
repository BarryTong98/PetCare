package au.edu.sydney.web.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @ApiModelProperty(value = "orderID")
    private Integer oid;

    @ApiModelProperty(value = "service ID")
    private Integer serviceId;

    @ApiModelProperty(value = "service provider ID")
    private Integer spid;

    @ApiModelProperty(value = "user ID")
    private Integer userId;

    @ApiModelProperty(value = "(expected) amount ")
    private Double amount;

    @ApiModelProperty(value = "Order status(1 not started 2 completed 3 cancelled 4 evaluated)")
    private Integer status;

    @ApiModelProperty(value = "Expected (start) time of the booked service")
    private String serviceTime;

    @ApiModelProperty(value = "Order creation time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    @ApiModelProperty(value = "service name")
    private String serviceName;

    @ApiModelProperty(value = "service provider name")
    private String serviceProviderName;

    @ApiModelProperty(value = "image url of the business")
    private String imageUrl;

    @ApiModelProperty(value = "address of the business")
    private String address;

    @ApiModelProperty(value = "phone number of the business")
    private String contactNumber;




}
