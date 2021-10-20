package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.ServiceProviderMapper;
import au.edu.sydney.web.pojo.entity.ServiceProvider;
import au.edu.sydney.web.pojo.yelpAPIEntity.Business;
import au.edu.sydney.web.service.ServiceProviderService;
import au.edu.sydney.web.util.YelpAPICli;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 22:04
 * @description
 */
@Service
public class ServiceProviderServiceImpl implements ServiceProviderService {

    @Resource
    ServiceProviderMapper serviceProviderMapper;

    @Resource
    YelpAPICli yelpApiCli;

    @Override
    public Result getServiceProviderById(int id) {
        ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(id);
        if (serviceProvider == null) {
            return Result.error("Service provider doesn't exist!");
        }
        return Result.ok(serviceProvider);
    }

    @Override
    public Result getServiceProviderByType(int type) {
        List<ServiceProvider> lists = serviceProviderMapper.getServiceProviderByType(type);
        if (lists.isEmpty()) {
            return Result.error("Service provider doesn't exist!");
        }
        return Result.ok(lists);
    }

    @Override
    public Result getRecommendedServiceProvider() {
        List<ServiceProvider> recommendProviders = serviceProviderMapper.getRecommendProviders();
        if (recommendProviders.isEmpty()) {
            return Result.error("Recommended service provider doesn't exist!");
        }
        return Result.ok(recommendProviders);
    }

    @Override
    public Result search(String region, int filter, String keyword) {
        String binary = Integer.toBinaryString(filter);
        while (binary.length() < 12) {
            binary = "0" + binary;
        }
        System.out.println("binary"+binary);
        HashMap<String, String> map = new HashMap<>();

        HashMap<Integer, String> filters = new HashMap<>();
        filters.put(11, "hospital");
        filters.put(10, "disease");
        filters.put(9, "sterilization");
        filters.put(8, "medical");
        filters.put(7, "vaccination");
        filters.put(6, "groom");
        filters.put(5, "washing");
        filters.put(4, "repellent");
        filters.put(3, "teeth");
        filters.put(2, "hosting");
        filters.put(1, "training");
        filters.put(0, "playground");

        map.put("keyword", keyword);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                map.put("filter" + i, filters.get(i));
            }
        }
        System.out.println(filters.toString());
        System.out.println(map.toString());
        List<ServiceProvider> serviceProviderList = serviceProviderMapper.searchByKeyword(map);
        if (serviceProviderList.isEmpty()) {
            List<Business> serviceProviders = yelpApiCli.getServiceProviders(keyword, region);
            Result yelpResult = Result.ok(serviceProviders);
            yelpResult.setCode(201);
            return yelpResult;
        }
        return Result.ok(serviceProviderList);
    }

    @Override
    public Result getYelpBusinessDetail(String id) {
        if (id == null) {
            return Result.error("business id can not be empty");
        }
        Business businessDetails = yelpApiCli.getServiceProviderDetails(id);
        if (businessDetails == null) {
            return Result.error("no such business");
        }

        return Result.ok(businessDetails);
    }
}
