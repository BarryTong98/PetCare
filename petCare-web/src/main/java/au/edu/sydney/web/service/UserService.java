package au.edu.sydney.web.service;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.domain.entity.User;

/**
 * @author Chris
 * @date 2021-09-14 21:05
 */
public interface UserService {
    Result findAll();

    Result getUser(int id);

    Result insert(User user);

    Result insertGoogleUser(User user);

    Result selectUidByUserName(String userName);

    Result updateUser(User record);

    Result login(String username, String password);

    Result resetPassword(String password, String email);
}
