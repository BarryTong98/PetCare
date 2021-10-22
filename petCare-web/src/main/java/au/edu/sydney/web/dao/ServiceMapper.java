package au.edu.sydney.web.dao;

import au.edu.sydney.web.domain.entity.Service;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ServiceMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Service record);

    int insertSelective(Service record);

    Service selectByPrimaryKey(Integer sid);

    List selectBySpid(Integer spid);

    List searchByKeyword(String keyword);

    int updateByPrimaryKeySelective(Service record);

    int updateByPrimaryKey(Service record);

}