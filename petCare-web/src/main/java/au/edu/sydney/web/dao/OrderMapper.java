package au.edu.sydney.web.dao;

import au.edu.sydney.web.pojo.entity.Order;
import au.edu.sydney.web.pojo.vo.OrderVO;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer oid);
    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderVO> searchOrders(Integer userId, String keyword,Integer code);

    List<OrderVO> getOrderByUid(Integer id);

}