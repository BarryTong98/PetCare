package au.edu.sydney.web.service;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.ServiceProvider;

import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 22:03
 * @description
 */
public interface ServiceProviderService {

    Result getServiceProviderById(int id);

    Result getServiceProviderByType(int type);
}
