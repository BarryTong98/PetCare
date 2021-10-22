package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.OrderMapper;
import au.edu.sydney.web.dao.ServiceMapper;
import au.edu.sydney.web.dao.UserMapper;
import au.edu.sydney.web.domain.entity.Order;
import au.edu.sydney.web.domain.entity.User;
import au.edu.sydney.web.domain.vo.OrderVO;
import au.edu.sydney.web.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 22:06
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    ServiceMapper serviceMapper;

    @Override
    public Result getOrderByUid(Integer id) {
        List<OrderVO> orders = orderMapper.getOrderByUid(id);
        if (orders.isEmpty()) {
            return Result.error("Order doesn't exist!");
        }
        return Result.ok(orders);
    }

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
        if (order == null) {
            return Result.error("Order doesn't exist!");
        }
        User user = userMapper.selectByPrimaryKey(order.getUserId());
        if (user == null) {
            return Result.error("No such user!");
        }
        au.edu.sydney.web.domain.entity.Service service = serviceMapper.selectByPrimaryKey(order.getServiceId());
        if (service == null) {
            return Result.error("No such service!");
        }
        if (order.getAmount() < 0) {
            return Result.error("Amount can not be negative");
        }
        try {
            orderMapper.insert(order);
        } catch (Exception e) {
            return Result.error("Failed to add order");
        }
        return Result.ok("Create order successfully!");
    }

    @Override
    public Result updateStatus(Integer orderId, Integer code) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (order == null) {
            return Result.error("No such order");
        }
        if (code < 1 || code > 4) {
            return Result.error("Status code error");
        }
        order.setStatus(code);
        try {
            orderMapper.updateByPrimaryKeySelective(order);
        } catch (Exception e) {
            return Result.error("failed to update order status");
        }
        return Result.ok("Update order status successfully");
    }

    @Override
    public Result searchOrders(Integer userId, String keyword, Integer code) {
        List<OrderVO> orderVOS = orderMapper.searchOrders(userId, keyword, code);
        if (orderVOS.isEmpty()) {
            return Result.error("No such order!");
        }
        return Result.ok(orderVOS);
    }


}
