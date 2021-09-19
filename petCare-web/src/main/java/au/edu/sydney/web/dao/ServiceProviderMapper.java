package au.edu.sydney.web.dao;

import au.edu.sydney.web.entity.pojo.ServiceProvider;

import java.util.List;

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

    int updateByPrimaryKeySelective(ServiceProvider record);

    int updateByPrimaryKey(ServiceProvider record);

    List<ServiceProvider> getServiceProviderByTag(String tag);
}