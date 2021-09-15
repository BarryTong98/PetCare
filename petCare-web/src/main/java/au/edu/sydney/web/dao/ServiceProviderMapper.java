package au.edu.sydney.web.dao;

import au.edu.sydney.web.entity.pojo.ServiceProvider;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ServiceProviderMapper {
    int deleteByPrimaryKey(Integer spid);

    int insert(ServiceProvider record);

    int insertSelective(ServiceProvider record);

    ServiceProvider selectByPrimaryKey(Integer spid);

    int updateByPrimaryKeySelective(ServiceProvider record);

    int updateByPrimaryKey(ServiceProvider record);
}