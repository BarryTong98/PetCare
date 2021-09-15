package au.edu.sydney.web.service;

import au.edu.sydney.web.entity.pojo.Order;

/**
 * @author Chris
 * @date 2021-09-14 22:06
 * @description
 */
public interface OrderService {

    Order getOrderById(int id);

}
