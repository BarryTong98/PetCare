package au.edu.sydney.web.dao;

import au.edu.sydney.web.entity.pojo.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface ReviewMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Review record);

    int insertSelective(Review record);

    Review selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Review record);

    int updateByPrimaryKey(Review record);

    List<Review> selectBySpid(Integer spid);

    List<Review> selectByUid(Integer uid);
}