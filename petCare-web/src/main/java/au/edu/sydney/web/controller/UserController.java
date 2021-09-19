package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.User;
import au.edu.sydney.web.service.UserService;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chris
 * @date 2021-09-14 21:08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("query all the users")
    @GetMapping("/findAll")
    public Result findAll() {
        return Result.ok(userService.findAll());
    }

    @ApiOperation("get user by id")
    @GetMapping("/{id}")
    public Result getUser(@PathVariable int id) {
        User user = userService.getUser(id);
        if (user == null) {
            return Result.error("User doesn't exist!");
        }
        return Result.ok(user);
    }

    @ApiOperation("register")
    @PostMapping("/register")
    public Result insert(@RequestBody User user) {
        int state = userService.insert(user);
        if (state > 0) {
            int uid = userService.selectUidByUserName(user.getUserName());
            user.setUid(uid);
            user.setPassword("hahahahahaha");//假装加密，最后再改
            return Result.ok(user);
        } else {
            return Result.error("Failed to register user");
        }
    }

    @ApiOperation("update user information")
    @PutMapping("/{id}")
    public Result update(@PathVariable int id, @RequestBody User record) {
        int state = userService.updateUser(record);
        if (state < 0) {
            return Result.error("failed to update user information");
        }
        User user = userService.getUser(id);
        return Result.ok("success", user);
    }
}
