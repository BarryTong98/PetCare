package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.service.ServiceProviderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @ApiOperation("get service provider by tag such as health(1),grooming(2),boarding/sitting(3)")
    @GetMapping("/type/{type}")
    public Result getServiceProviderByType(@PathVariable int type) {
        return serviceProviderService.getServiceProviderByType(type);
    }

    @ApiOperation("get (10) recommended providers and show on the home page")
    @GetMapping("/recommend")
    public Result getRecommendServiceProvider() {
        return serviceProviderService.getRecommendedServiceProvider();
    }

    @ApiOperation(value = "get service provider by region and keyword " +
            "\n code:200(data from database)" +
            "\n code:201(data from YelpApi)")
    @GetMapping("/search/{region}/{filter}/{keyword}")
    public Result search(@PathVariable String region, @PathVariable int filter, @PathVariable String keyword) {
        return serviceProviderService.search(region, filter, keyword);
    }
}
