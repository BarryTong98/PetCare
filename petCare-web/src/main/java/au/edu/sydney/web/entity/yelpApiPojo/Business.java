package au.edu.sydney.web.entity.yelpApiPojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.*;

import java.util.List;

/**
 * @author Chris
 * @date 2021-09-27 16:38
 * @description
 */

@Data
@ApiModel(value="BusinessPojo", description="yelp商家信息对象")
public class Business {

    @ApiParam(value = "商家id")
    private String id;

    @ApiParam(value = "商家名")
    private String name;

    @ApiParam(value = "商家图片地址")
    private String image_url;

    @ApiParam(value = "当前是否开门")
    private boolean is_closed;

    @ApiParam(value = "对应的yelp网址")
    private String url;

    @ApiParam(value = "yelp上的评论数")
    private int review_count;

    @ApiParam(value = "商家类别 如 pet hospital pet groomer")
    private String category;

    @ApiParam(value = "yelp上的评分")
    private double rating;

    @ApiParam(value = "商家联系电话")
    private String phone;

    @ApiParam(value = "纬度")
    private double latitude;

    @ApiParam(value = "经度")
    private double longitude;

    @ApiParam(value = "商家照片地址列表")
    private List<String>  photos;
}

