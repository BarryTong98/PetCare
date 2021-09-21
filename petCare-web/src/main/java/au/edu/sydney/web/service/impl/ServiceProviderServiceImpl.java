package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.ServiceProviderMapper;
import au.edu.sydney.web.entity.pojo.ServiceProvider;
import au.edu.sydney.web.service.ServiceProviderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
}
