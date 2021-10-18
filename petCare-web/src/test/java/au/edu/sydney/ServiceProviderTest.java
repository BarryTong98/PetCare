package au.edu.sydney;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.ServiceProviderMapper;
import au.edu.sydney.web.pojo.entity.ServiceProvider;
import au.edu.sydney.web.service.ServiceProviderService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chris
 * @date 2021-09-16 15:59
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceProviderTest {

    @Resource
    ServiceProviderMapper serviceProviderMapper;

    @Autowired
    ServiceProviderService serviceProviderService;

    @Test
    public void getRecommendProvidersTest() {
        List<ServiceProvider> recommendProviders = serviceProviderMapper.getRecommendProviders();
        if (!recommendProviders.isEmpty()) {
            for (ServiceProvider recommendProvider : recommendProviders) {
                System.out.println(recommendProvider);
            }
        } else {
            System.out.println("No recommend provider");
        }
    }

    @Test
    public void getProvidersByTypeTest() {
        List<ServiceProvider> providers = serviceProviderMapper.getServiceProviderByType(3);
        if (!providers.isEmpty()) {
            for (ServiceProvider Provider : providers) {
                System.out.println(Provider);
            }
        } else {
            System.out.println("No provider of such type");
        }
    }

    @Test
    public void searchProvider() {
        //data from database
        Result result1 = serviceProviderService.search("Sydney", 511, "dog");
        Assert.assertEquals((long) 200, (long) result1.getCode());
        System.out.println(result1);

        //data from Yelp
        Result result2 = serviceProviderService.search("Sydney", 1, "tiger");
        Assert.assertEquals((long) 201, (long) result2.getCode());
        System.out.println(result2);
    }
}
