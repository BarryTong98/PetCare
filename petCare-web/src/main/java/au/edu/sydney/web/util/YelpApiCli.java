package au.edu.sydney.web.util;


import au.edu.sydney.web.entity.yelpApiPojo.Business;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chris
 * @date 2021-09-27 14:50
 * @description
 */
@Slf4j
@Component
public class YelpApiCli {

    private static final String baseURL = "https://api.yelp.com/v3/businesses/";
    private static final String ApiKey = "u-7Cog_F20Wa7WhRFyDKAIOLAFW13pvIt9cEHXBxLLLJM8ps8uQM6EvJKV2HXDJUO20sAyo2VEzqWS4T3jKILuaK2mNqT5I_cbd0N67KV_07sd0ZxatjDYv_fytNYXYx";

    Map<String, String> params;

    public YelpApiCli() {
        params = new HashMap<>();
        params.put("categories", "pets,All");
    }


    @Autowired
    private OkHttpClient okHttpClient;


    public List<Business> getServiceProviders(String term, String location) {
        StringBuilder sb = new StringBuilder(baseURL + "search");
        params.put("location", location);
        params.put("term", term);
        boolean firstFlag = true;
        for (String key : params.keySet()) {
            if (firstFlag) {
                sb.append("?").append(key).append("=").append(params.get(key));
                firstFlag = false;
            } else {
                sb.append("&").append(key).append("=").append(params.get(key));
            }
        }


        Request.Builder builder = new Request.Builder();
        builder.addHeader("Authorization", "Bearer " + ApiKey);
        Request request = builder.url(sb.toString()).build();
        log.info("do get request and url[{}]", sb.toString());
        //log.info(builder.head().toString());
        String serviceProvidersJSON = execute(request);
        List<Business> businesses = businessesJsonToList(serviceProvidersJSON);
        for (Business business : businesses) {
            System.out.println(business);
        }
        return businesses;
    }


    public Business getServiceProviderDetails(String id) {
        StringBuilder sb = new StringBuilder(baseURL + id);
        Request.Builder builder = new Request.Builder();
        builder.addHeader("Authorization", "Bearer " + ApiKey);
        Request request = builder.url(sb.toString()).build();
        log.info("do get request and url[{}]", sb.toString());
        log.info(builder.head().toString());
        String serviceProvider = execute(request);
        Business business = businessJsonToObject(serviceProvider);
        return business;

    }

    private Business businessJsonToObject(String serviceProviderJSON) {
        JSONObject businessJSONObject = JSON.parseObject(serviceProviderJSON);
        Business business = new Business();
        business.setId(businessJSONObject.getString("id"));
        business.setImage_url(businessJSONObject.getString("image_url"));
        business.setName(businessJSONObject.getString("name"));
        business.set_closed(businessJSONObject.getBoolean("is_closed"));
        business.setUrl(businessJSONObject.getString("url"));
        business.setReview_count(businessJSONObject.getInteger("review_count"));
        business.setRating(businessJSONObject.getDouble("rating"));
        business.setPhone(businessJSONObject.getString("display_phone"));
        JSONArray categories = businessJSONObject.getJSONArray("categories");
        String addressString = businessJSONObject.getJSONObject("location").getString("display_address");
        addressString = addressString.substring(2, addressString.length() - 2).replace("\"","");
        business.setAddress(addressString);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < categories.size(); j++) {
            sb.append(categories.getJSONObject(j).getString("title")).append(",");
        }
        business.setCategory(sb.toString().substring(0, sb.length() - 1));
        JSONObject coordinates = businessJSONObject.getJSONObject("coordinates");
        business.setLatitude(coordinates.getDoubleValue("latitude"));
        business.setLongitude(coordinates.getDoubleValue("longitude"));
        JSONArray photos = businessJSONObject.getJSONArray("photos");
        List<String> photosArray = new ArrayList<>();
        for (int i = 0; i < photos.size(); i++) {
            photosArray.add((String) photos.get(i));
        }
        business.setPhotos(photosArray);
        return business;
    }

    private List<Business> businessesJsonToList(String serviceProvidersJSON) {
        List<Business> result = new ArrayList<>();
        JSONObject jsonObject = JSON.parseObject(serviceProvidersJSON);
        JSONArray businesses = jsonObject.getJSONArray("businesses");
        for (int i = 0; i < businesses.size(); i++) {
            JSONObject businessJSONObject = businesses.getJSONObject(i);
            Business business = new Business();
            business.setId(businessJSONObject.getString("id"));
            business.setImage_url(businessJSONObject.getString("image_url"));
            business.setName(businessJSONObject.getString("name"));
            business.set_closed(businessJSONObject.getBoolean("is_closed"));
            business.setUrl(businessJSONObject.getString("url"));
            business.setReview_count(businessJSONObject.getInteger("review_count"));
            business.setRating(businessJSONObject.getDouble("rating"));
            business.setPhone(businessJSONObject.getString("display_phone"));
            String addressString = businessJSONObject.getJSONObject("location").getString("display_address");
            addressString = addressString.substring(2, addressString.length() - 2).replace("\"","");
            business.setAddress(addressString);
            JSONArray categories = businessJSONObject.getJSONArray("categories");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < categories.size(); j++) {
                sb.append(categories.getJSONObject(j).getString("title")).append(",");
            }
            business.setCategory(sb.toString().substring(0, sb.length() - 1));
            JSONObject coordinates = businessJSONObject.getJSONObject("coordinates");
            business.setLatitude(coordinates.getDoubleValue("latitude"));
            business.setLongitude(coordinates.getDoubleValue("longitude"));
            result.add(business);
        }
        return result;
    }

    private String execute(Request request) {
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        } finally {
            if (response != null) {
                response.close();
            }
        }
        return "";
    }

}
