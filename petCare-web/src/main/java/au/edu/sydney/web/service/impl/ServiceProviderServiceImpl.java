package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.ServiceProviderMapper;
import au.edu.sydney.web.entity.pojo.ServiceProvider;
import au.edu.sydney.web.entity.yelpApiPojo.Business;
import au.edu.sydney.web.service.ServiceProviderService;
import au.edu.sydney.web.util.YelpApiCli;
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
    YelpApiCli yelpApiCli;

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
        while (binary.length() < 11) {
            binary = "0" + binary;
        }
        HashMap<String, String> map = new HashMap<>();

        HashMap<Integer, String> filters = new HashMap<>();
        filters.put(11, "hospital");//医院
        filters.put(10,"disease");//疾病治疗
        filters.put(9, "sterilization");//绝育
        filters.put(8, "medical");//体检
        filters.put(7, "vaccination");//疫苗
        filters.put(6, "groom");//美容
        filters.put(5, "washing");//洗澡
        filters.put(4, "repellent");//驱虫
        filters.put(3, "teeth");//洁牙
        filters.put(2, "hosting");//托管
        filters.put(1, "training");//训练
        filters.put(0, "playground");//乐园

        map.put("keyword", keyword);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                map.put("filter" + i, filters.get(i));
            }
        }
        List<ServiceProvider> serviceProviderList = serviceProviderMapper.searchByKeyword(map);
        if (serviceProviderList.isEmpty()) {
            List<Business> serviceProviders = yelpApiCli.getServiceProviders(keyword, region);
            Result yelpResult = Result.ok(serviceProviders);
            yelpResult.setCode(201);
            return yelpResult;
        }
        return Result.ok(serviceProviderList);
    }
}
