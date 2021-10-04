package au.edu.sydney;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Chris
 * @date 2021-10-04 15:05
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    OrderService orderService;

    @Test
    public void searchOrdersTest(){
        Result result = orderService.searchOrders(1, "pet", null);
        System.out.println(result);

    }
    @Test
    public void updateOrderTest(){
        Result result = orderService.updateStatus(1, 3);
        System.out.println(result);
    }
}
