package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.OrderMapper;
import au.edu.sydney.web.entity.pojo.Order;
import au.edu.sydney.web.service.OrderService;
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
    public Result getOrderById(Integer id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        if (order == null) {
            return Result.error("Order doesn't exist!");
        }
        return Result.ok(order);
    }

    @Override
    public Result insert(Order order) {
        try {
            orderMapper.insert(order);
        } catch (Exception e) {
            return Result.error("failed to add order");
        }
        return Result.ok();
    }

    @Override
    public Result updateStatus(Integer id, Integer code) {
        Order order = orderMapper.selectByPrimaryKey(id);
        if (order == null) {
            return Result.error("No such order");
        }
        if (code < 1 || code > 3) {
            return Result.error("Status code error");
        }
        order.setStatus(code);
        try {
            orderMapper.updateByPrimaryKeySelective(order);
        } catch (Exception e) {
            return Result.error("failed to update order status");
        }
        return Result.ok();
    }


}
