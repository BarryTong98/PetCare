package au.edu.sydney.web.service;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.pojo.entity.Order;

/**
 * @author Chris
 * @date 2021-09-14 22:06
 * @description
 */
public interface OrderService {

    Result getOrderByUid(Integer id);

    Result getOrderById(Integer id);

    Result insert(Order order);

    Result updateStatus(Integer orderId,Integer code);

    Result searchOrders(Integer userId,String keyword,Integer code);
}
