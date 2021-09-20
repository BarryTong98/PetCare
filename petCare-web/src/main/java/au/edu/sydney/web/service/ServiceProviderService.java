package au.edu.sydney.web.service;

import au.edu.sydney.web.entity.pojo.ServiceProvider;

import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 22:03
 * @description
 */
public interface ServiceProviderService {

    ServiceProvider getServiceProviderById(int id);

    List<ServiceProvider> getServiceProviderByType(int type);
}
