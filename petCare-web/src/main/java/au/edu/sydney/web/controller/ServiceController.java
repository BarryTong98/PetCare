package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.service.ServiceService;
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
@RequestMapping("/service")
public class ServiceController {

    @Resource
    ServiceService serviceService;

    @ApiOperation("get service by id")
    @GetMapping("/{id}")
    public Result getServiceById(@PathVariable int id) {
        return serviceService.getServiceById(id);
    }

    @ApiOperation("get service by spid")
    @GetMapping("/spid/{spid}")
    public Result getServiceBySpid(@PathVariable int spid) {
        return serviceService.getServiceBySpid(spid);
    }
}
