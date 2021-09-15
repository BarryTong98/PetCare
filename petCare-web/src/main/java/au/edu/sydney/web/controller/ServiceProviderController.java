package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.ServiceProvider;
import au.edu.sydney.web.service.ServiceProviderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chris
 * @date 2021-09-14 22:09
 * @description
 */

@RestController
@RequestMapping("/serviceProvider")
public class ServiceProviderController {

    @Autowired
    ServiceProviderService serviceProviderService;

    @ApiOperation("get service provider by id")
    @GetMapping("/{id}")
    public Result getServiceProvider(@PathVariable int id) {
        ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(id);
        if (serviceProvider==null){
            return Result.error("Service provider doesn't exist!");
        }
        return Result.ok(serviceProvider);
    }
}
