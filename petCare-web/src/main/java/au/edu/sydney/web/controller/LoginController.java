package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.pojo.req.LoginREQ;
import au.edu.sydney.web.pojo.req.PasswordREQ;
import au.edu.sydney.web.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Chris
 * @date 2021-09-14 22:06
 * @description
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class LoginController {

    @Resource
    private UserService userService;

    @ApiOperation("login")
    @PostMapping("/login")
    public Result login(@RequestBody LoginREQ loginREQ) {
        return userService.login(loginREQ.getUsername(), loginREQ.getPassword());
    }

    @ApiOperation("resetPassword")
    @PutMapping("/reset")
    public Result updatePwd(@RequestBody PasswordREQ passwordREQ) {
        return userService.resetPassword(passwordREQ.getPassword(), passwordREQ.getEmail());
    }
}
