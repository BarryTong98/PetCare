package au.edu.sydney;

import au.edu.sydney.web.dao.ServiceProviderMapper;
import au.edu.sydney.web.entity.pojo.ServiceProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Chris
 * @date 2021-09-16 15:59
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceProviderTest {

    @Autowired
    ServiceProviderMapper serviceProviderMapper;

    @Test
    public void getRecommendProvidersTest(){
        List<ServiceProvider> recommendProviders = serviceProviderMapper.getRecommendProviders();
        if (!recommendProviders.isEmpty()) {
            for (ServiceProvider recommendProvider : recommendProviders) {
                System.out.println(recommendProvider);
            }
        }else {
            System.out.println("No recommend provider");
        }
    }
}
