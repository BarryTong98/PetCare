package au.edu.sydney.web.service;

import au.edu.sydney.web.entity.pojo.User;

import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 21:05
 */
public interface UserService {
    List<User> findAll();

    User getUser(int id);

    int insert(User user);

    int selectUidByUserName(String userName);
}
