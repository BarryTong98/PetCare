package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.Service;
import au.edu.sydney.web.service.ServiceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Result getService(@PathVariable int id) {
        Service service = serviceService.getServiceById(id);
        if (service==null){
            return Result.error("Service doesn't exist!");
        }
        return Result.ok(service);
    }
}
