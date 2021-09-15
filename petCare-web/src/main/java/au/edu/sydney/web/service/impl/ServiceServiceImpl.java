package au.edu.sydney.web.service.impl;

import au.edu.sydney.web.dao.ServiceMapper;
import au.edu.sydney.web.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chris
 * @date 2021-09-14 22:03
 */
@Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceMapper serviceMapper;


    @Override
    public au.edu.sydney.web.entity.pojo.Service getServiceById(int id) {
        return serviceMapper.selectByPrimaryKey(id);
    }
}
