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
        if (user == null) {
            return Result.error("user is empty");
        }
        int code = userService.insert(user);
        if (code == 1) {
            return Result.ok(user);
        }
        return Result.error("Failed to register user");
    }

}
