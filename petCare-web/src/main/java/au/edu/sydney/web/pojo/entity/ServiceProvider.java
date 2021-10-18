package au.edu.sydney.web.pojo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="ServiceProvider", description="service provider object")
@Data
public class ServiceProvider {

    @ApiModelProperty(value = "service provider ID")
    private Integer spid;

    @ApiModelProperty(value = "service provider name (search match field)")
    private String serviceProviderName;

    @ApiModelProperty(value = "address (search match field)")
    private String address;

    @ApiModelProperty(value = "contact phone number")
    private String contactNumber;

    @ApiModelProperty(value = "type 1 Health 2 Beauty 3 Boarding")
    private Integer type;

    @ApiModelProperty(value = "Specific services provided  (search match field)  \n" +
            "Health: veterinarians, disease treatment,sterilization,medical check-ups \n" +
            "Grooming：grooming washing deworming cleaning boarding: boarding training playground ")
    private String serviceContent;

    @ApiModelProperty(value = "average price")
    private Double averagePrice;

    @ApiModelProperty(value = "provider's self-description information (search match field)")
    private String description;

    @ApiModelProperty(value = "total sales")
    private Integer sales;

    @ApiModelProperty(value = "review")
    private Double rating;

    @ApiModelProperty(value = "region")
    private String region;

    @ApiModelProperty(value = "business hours")
    private String businessHours;

    @ApiModelProperty(value = "latitude")
    private String latitude;

    @ApiModelProperty(value = "longitude")
    private String longitude;

    @ApiModelProperty(value = "image url of provider")
    private String imageUrl;

    @ApiModelProperty(value = "Whether to show on the front page (1 Show 0 No)")
    private Integer recommend;
}