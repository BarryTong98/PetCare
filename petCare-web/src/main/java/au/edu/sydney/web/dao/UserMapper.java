package au.edu.sydney.web.dao;

import au.edu.sydney.web.domain.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    /**
     * query all the users with similar username
     *
     * @param userName
     * @return List<User>
     */
    List<User> queryAllByUserName(String userName);

    User selectByUserName(String userName);

    User selectByEmail(String email);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findAll();

    int selectUidByUserName(String userName);
}