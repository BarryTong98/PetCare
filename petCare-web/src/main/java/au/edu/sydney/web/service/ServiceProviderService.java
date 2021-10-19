package au.edu.sydney.web.service;

import au.edu.sydney.base.Result;

/**
 * @author Chris
 * @date 2021-09-14 22:03
 * @description
 */
public interface ServiceProviderService {

    Result getServiceProviderById(int id);

    Result getServiceProviderByType(int type);

    Result getRecommendedServiceProvider();

    Result search(String region,int filter,String keyword);

    Result getYelpBusinessDetail(String id);
}
