package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.UserMapper;
import au.edu.sydney.web.entity.pojo.User;
import au.edu.sydney.web.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        if (user.getUserName()==null){
            return Result.error("Username can not be empty");
        }
        User checkName=userMapper.selectByUserName(user.getUserName());
        if(checkName!=null){
            return Result.error("Username already exists");
        }
        User checkEmail=userMapper.selectByEmail(user.getEmail());
        if(checkEmail!=null){
            return Result.error("Email already exists");
        }

        String password=new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(password);
        System.out.println(password);
        try {
            userMapper.insertSelective(user);
        } catch (Exception e) {
            return Result.error("Failed to register user");
        }
        return Result.ok(null);
    }

    @Override
    public Result selectUidByUserName(String username) {
        int id;
        try {
            id = userMapper.selectUidByUserName(username);
        } catch (Exception e) {
            return Result.error("Can not find user");
        }
        return Result.ok(id);
    }

    @Override
    public Result updateUser(User record) {
        try {
            userMapper.updateByPrimaryKey(record);
        } catch (Exception e) {
            return Result.error("Failed to update user information");
        }
        return Result.ok("success", null);
    }

    @Override
    public Result login(String username, String password) {
        if (username == null || password == null) {
            return Result.error("Wrong username or password");
        }
        User user = userMapper.selectByUserName(username);
        if (user == null) {
            return Result.error("User doesn't exist!");
        }
        boolean flag = new BCryptPasswordEncoder().matches(password, user.getPassword());
        if (!flag){
            return  Result.error("Username and password don't match");
        }
        return Result.ok("Login success");
    }
}
