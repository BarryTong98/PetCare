package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.Order;
import au.edu.sydney.web.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chris
 * @date 2021-09-14 22:09
 * @description
 */

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @ApiOperation("get order by id")
    @GetMapping("/{id}")
    public Result getServiceProvider(@PathVariable int id) {
        Order order = orderService.getOrderById(id);
        if (order==null){
            return Result.error("Order doesn't exist!");
        }
        return Result.ok(order);
    }

}
