package au.edu.sydney.web.service.impl;

import au.edu.sydney.web.dao.ServiceProviderMapper;
import au.edu.sydney.web.entity.pojo.ServiceProvider;
import au.edu.sydney.web.service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ServiceProvider getServiceProviderById(int id) {
        return serviceProviderMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<ServiceProvider> getServiceProviderByTag(String tag) {
        return serviceProviderMapper.getServiceProviderByTag(tag);
    }
}
