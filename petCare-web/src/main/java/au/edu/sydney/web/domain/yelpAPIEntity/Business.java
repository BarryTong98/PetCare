package au.edu.sydney.web.domain.yelpAPIEntity;

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
@ApiModel(value = "BusinessPojo", description = "yelp business info object")
public class Business {

    @ApiParam(value = "business id")
    private String id;

    @ApiParam(value = "business name")
    private String name;

    @ApiParam(value = "busines image url")
    private String image_url;

    @ApiParam(value = "is it closed now")
    private boolean is_closed;

    @ApiParam(value = "yelp url of the business")
    private String url;

    @ApiParam(value = "the number of review on yelp")
    private int review_count;

    @ApiParam(value = "business category (like pet hospital pet groomer)")
    private String category;

    @ApiParam(value = "rating on the yelp")
    private double rating;

    @ApiParam(value = "phone number")
    private String phone;

    @ApiParam(value = "latitude")
    private double latitude;

    @ApiParam(value = "longitude")
    private double longitude;

    @ApiParam(value = "photos list of the business ")
    private List<String> photos;

    @ApiParam(value = "address")
    private String address;
}

