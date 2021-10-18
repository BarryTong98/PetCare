package au.edu.sydney.web.dao;

import au.edu.sydney.web.pojo.entity.ServiceProvider;

import java.util.List;
import java.util.Map;

public interface ServiceProviderMapper {
    int deleteByPrimaryKey(Integer spid);

    int insert(ServiceProvider record);

    int insertSelective(ServiceProvider record);

    ServiceProvider selectByPrimaryKey(Integer spid);

    /**
     * get all the recommend providers（Show on home page）
     *
     * @return
     */
    List<ServiceProvider> getRecommendProviders();

    List<ServiceProvider> searchByKeyword(Map<String,String> map);

    int updateByPrimaryKeySelective(ServiceProvider record);

    int updateByPrimaryKey(ServiceProvider record);

    List<ServiceProvider> getServiceProviderByType(Integer type);
}