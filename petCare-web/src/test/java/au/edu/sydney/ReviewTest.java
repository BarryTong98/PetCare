package au.edu.sydney;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.service.ReviewService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author hjs
 * @Date 2021/10/5 20:59
 * @Version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewTest {

    @Resource
    ReviewService reviewService;

    @Test
    public void getReviewBySpid(){
        Result reviews = reviewService.getReviewBySpid(1);
        System.out.println(reviews);
    }

    @Test
    public void getReviewByUid(){
        Result reviews = reviewService.getReviewByUid(1);
        System.out.println(reviews);
    }
}
