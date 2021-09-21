package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.OrderMapper;
import au.edu.sydney.web.entity.pojo.Order;
import au.edu.sydney.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Chris
 * @date 2021-09-14 22:06
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;

    @Override
    public Result getOrderById(int id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        if (order==null){
            return Result.error("Order doesn't exist!");
        }
        return Result.ok(order);
    }
}
