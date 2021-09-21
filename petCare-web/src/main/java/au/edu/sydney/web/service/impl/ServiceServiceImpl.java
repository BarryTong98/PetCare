package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.ServiceMapper;
import au.edu.sydney.web.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 22:03
 */
@Service
public class ServiceServiceImpl implements ServiceService {

    @Resource
    ServiceMapper serviceMapper;


    @Override
    public Result getServiceById(int id) {
        au.edu.sydney.web.entity.pojo.Service service = serviceMapper.selectByPrimaryKey(id);
        if (service == null) {
            return Result.error("Service doesn't exist!");
        }
        return Result.ok(service);
    }

    @Override
    public Result getServiceBySpid(int spid) {
        List list = serviceMapper.selectBySpid(spid);
        if (list.isEmpty()) {
            return Result.error("Service doesn't exist!");
        }
        return Result.ok(list);
    }
}
