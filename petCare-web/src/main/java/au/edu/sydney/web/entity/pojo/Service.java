package au.edu.sydney.web.entity.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;


@ApiModel(value="Service", description="服务对象")
public class Service {

    @ApiModelProperty(value = "服务ID")
    private Integer sid;

    @ApiModelProperty(value = "对应服务提供者ID")
    private Integer serviceProviderId;

    @ApiModelProperty(value = "服务名")
    private String serviceName;

    @ApiModelProperty(value = "（预期）价格")
    private Double price;

    @ApiModelProperty(value = "是否是托管服务 1 是 0 否")
    private Integer isBoarding;

    @ApiModelProperty(value = "服务日期")
    private Date serviceDate;

    @ApiModelProperty(value = "服务时间")
    private String serviceTime;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getServiceProviderId() {
        return serviceProviderId;
    }

    public void setServiceProviderId(Integer serviceProviderId) {
        this.serviceProviderId = serviceProviderId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getIsBoarding() {
        return isBoarding;
    }

    public void setIsBoarding(Integer isBoarding) {
        this.isBoarding = isBoarding;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(String serviceTime) {
        this.serviceTime = serviceTime == null ? null : serviceTime.trim();
    }
}