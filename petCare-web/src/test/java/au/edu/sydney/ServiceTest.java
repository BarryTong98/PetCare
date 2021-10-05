package au.edu.sydney;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.service.ServiceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author hjs
 * @Date 2021/10/5 20:45
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Resource
    ServiceService serviceService;

    @Test
    public void getServiceById(){
        Result result = serviceService.getServiceById(1);
        System.out.println(result);
    }

    @Test
    public void getServiceBySpid(){
        Result result = serviceService.getServiceBySpid(1);
        System.out.println(result);
    }
}
