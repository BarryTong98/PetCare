package au.edu.sydney.web.entity.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="ServiceProvider", description="服务提供者对象")
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

    public Integer getSpid() {
        return spid;
    }

    public void setSpid(Integer spid) {
        this.spid = spid;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public void setServiceProviderName(String serviceProviderName) {
        this.serviceProviderName = serviceProviderName == null ? null : serviceProviderName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getServiceContent() {
        return serviceContent;
    }

    public void setServiceContent(String serviceContent) {
        this.serviceContent = serviceContent == null ? null : serviceContent.trim();
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region == null ? null : region.trim();
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours == null ? null : businessHours.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public Integer getRecommend() {
        return recommend;
    }

    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "ServiceProvider{" +
                "spid=" + spid +
                ", serviceProviderName='" + serviceProviderName + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", type=" + type +
                ", serviceContent='" + serviceContent + '\'' +
                ", averagePrice=" + averagePrice +
                ", description='" + description + '\'' +
                ", sales=" + sales +
                ", rating=" + rating +
                ", region='" + region + '\'' +
                ", businessHours='" + businessHours + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}