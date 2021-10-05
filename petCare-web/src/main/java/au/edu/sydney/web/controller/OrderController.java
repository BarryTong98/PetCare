package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.Order;
import au.edu.sydney.web.entity.req.OrderREQ;
import au.edu.sydney.web.service.OrderService;
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
@RequestMapping("/order")
public class OrderController {

    @Resource
    OrderService orderService;

    @ApiOperation("get order by user id")
    @GetMapping("user/{id}")
    public Result getOrderByUid(@PathVariable int id) {
        return orderService.getOrderByUid(id);
    }

    @ApiOperation("get order by id")
    @GetMapping("/{id}")
    public Result getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @ApiOperation("add new order")
    @PostMapping("/add")
    public Result insert(@RequestBody Order order) {
        return orderService.insert(order);
    }

    @ApiOperation("update order status  1 未开始 2 已完成 3  已取消")
    @PutMapping("/update")
    public Result updateStatus(@RequestBody OrderREQ orderREQ) {
        return orderService.updateStatus(orderREQ.getOrderID(), orderREQ.getCode());
    }

    @ApiOperation("search orders according to userId,keyword(service name,service provider name ) and status code")
    @GetMapping("/search")
    public Result searchOrders(@RequestParam Integer userId, @RequestParam(required = false) String keyword, @RequestParam(required = false) Integer code) {

        return orderService.searchOrders(userId, keyword, code);
    }
}
