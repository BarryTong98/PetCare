package au.edu.sydney.web.dao;

import au.edu.sydney.web.pojo.entity.Review;
import au.edu.sydney.web.pojo.vo.ReviewVO;
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

    List<ReviewVO> selectBySpid(Integer spid);

    List<ReviewVO> selectByUid(Integer uid);
}