package au.edu.sydney;

import au.edu.sydney.web.util.YelpApiCli;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Chris
 * @date 2021-09-27 15:34
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YelpAPITest {

    @Autowired
    YelpApiCli yelpApiCli;

    @Test
    public void getServiceProviders() {
        try {
            System.out.println(yelpApiCli.getServiceProviders("dog", "Sydney"));
        } catch (Exception SocketTimeoutException) {
            System.out.println("connect timed out");
        }
    }

    @Test
    public void getServiceProviderDetail() {
        try {
            System.out.println(yelpApiCli.getServiceProviderDetails("Tz-mCi1VGAbZD0Vv3ZImEg"));
        } catch (Exception SocketTimeoutException) {
            System.out.println("connect timed out");
        }
    }

}
