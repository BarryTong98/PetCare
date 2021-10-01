package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.req.PasswordREQ;
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
    @GetMapping("/login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        return userService.login(username, password);
    }

    @ApiOperation("resetPassword")
    @PutMapping("/reset")
    public Result updatePwd(@RequestBody PasswordREQ passwordREQ) {
        return userService.resetPassword(passwordREQ.getPassword(), passwordREQ.getUserId());
    }
}
