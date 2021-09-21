package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.UserMapper;
import au.edu.sydney.web.entity.pojo.User;
import au.edu.sydney.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 21:07
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Result findAll() {
        List<User> users = userMapper.findAll();
        return Result.ok(users);
    }

    @Override
    public Result getUser(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return Result.error("User doesn't exist!");
        }
        return Result.ok(user);
    }

    @Override
    public Result insert(User user) {
        try{
            userMapper.insertSelective(user);
        }catch (Exception e){
            return Result.error("Failed to register user");
        }
        return Result.ok(null);
    }

    @Override
    public Result selectUidByUserName(String userName) {
        int id=-1;
        try{
            id = userMapper.selectUidByUserName(userName);
        }catch (Exception e){
            return Result.error("Can not find user");
        }
        return Result.ok(id);
    }

    @Override
    public Result updateUser(User record) {
        try{
            userMapper.updateByPrimaryKey(record);
        }catch (Exception e){
            return Result.error("Failed to update user information");
        }
        return Result.ok("success", null);
    }
}
