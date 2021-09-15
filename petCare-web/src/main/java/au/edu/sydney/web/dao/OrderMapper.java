package au.edu.sydney.web.dao;

import au.edu.sydney.web.entity.pojo.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

}