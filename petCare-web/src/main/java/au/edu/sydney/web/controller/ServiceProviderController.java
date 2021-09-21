package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.ServiceProvider;
import au.edu.sydney.web.service.ServiceProviderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 22:09
 * @description
 */

@CrossOrigin
@RestController
@RequestMapping("/serviceProvider")
public class ServiceProviderController {

    @Resource
    ServiceProviderService serviceProviderService;

    @ApiOperation("get service provider by id")
    @GetMapping("/{id}")
    public Result getServiceProvider(@PathVariable int id) {
        return serviceProviderService.getServiceProviderById(id);
    }

    @ApiOperation("get service provider by tag such as health, beauty")
    @GetMapping("/type/{type}")
    public Result getServiceProviderByType(@PathVariable int type) {
        return serviceProviderService.getServiceProviderByType(type);
    }


}
