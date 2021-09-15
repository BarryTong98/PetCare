package au.edu.sydney.web.dao;

import au.edu.sydney.web.entity.pojo.Service;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ServiceMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Integer sid);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);
}