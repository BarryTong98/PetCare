package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.User;
import au.edu.sydney.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if (user==null){
            return Result.error("User doesn't exist!");
        }
        return Result.ok(user);
    }

}
