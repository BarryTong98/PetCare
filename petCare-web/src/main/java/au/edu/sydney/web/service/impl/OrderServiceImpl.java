package au.edu.sydney.web.service.impl;

import au.edu.sydney.web.dao.OrderMapper;
import au.edu.sydney.web.entity.pojo.Order;
import au.edu.sydney.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chris
 * @date 2021-09-14 22:06
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public Order getOrderById(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

}
