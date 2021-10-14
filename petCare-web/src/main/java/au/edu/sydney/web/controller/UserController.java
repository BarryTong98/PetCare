package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.User;
import au.edu.sydney.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Chris
 * @date 2021-09-14 21:08
 */

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation("query all the users")
    @GetMapping("/findAll")
    public Result findAll() {
        return userService.findAll();
    }

    @ApiOperation("get user by id")
    @GetMapping("/{id}")
    public Result getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @CrossOrigin
    @ApiOperation("register")
    @PostMapping("/register")
    public Result insert(@RequestBody User user) {
        return userService.insert(user);
    }

    @ApiOperation("GoogleUserRegister")
    @PostMapping("/register/google")
    public Result GoogleUserInsert(@RequestBody User user) {
        return userService.insertGoogleUser(user);
    }

    @ApiOperation("update user information")
    @PutMapping("/update")
    public Result update(@RequestBody User record) {
        System.out.println(record.toString());
        return userService.updateUser(record);
    }
}
