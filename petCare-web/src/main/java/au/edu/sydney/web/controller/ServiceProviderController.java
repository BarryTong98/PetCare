package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.ServiceProvider;
import au.edu.sydney.web.service.ServiceProviderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 22:09
 * @description
 */

@RestController
@RequestMapping("/serviceProvider")
public class ServiceProviderController {

    @Resource
    ServiceProviderService serviceProviderService;

    @ApiOperation("get service provider by id")
    @GetMapping("/{id}")
    public Result getServiceProvider(@PathVariable int id) {
        ServiceProvider serviceProvider = serviceProviderService.getServiceProviderById(id);
        if (serviceProvider == null) {
            return Result.error("Service provider doesn't exist!");
        }
        return Result.ok(serviceProvider);
    }

    @ApiOperation("get service provider by tag such as health, beauty")
    @GetMapping("/type/{type}")
    public Result getServiceProviderByType(@PathVariable int type) {
        List<ServiceProvider> serviceProviderList = serviceProviderService.getServiceProviderByType(type);
        if (serviceProviderList == null) {
            return Result.error("No related service provider");
        }
        return Result.ok(serviceProviderList);
    }


}
