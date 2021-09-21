package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.Review;
import au.edu.sydney.web.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Chris
 * @date 2021-09-14 22:10
 * @description
 */

@CrossOrigin
@RestController
@RequestMapping("/review")
public class ReviewController {

    @Resource
    ReviewService reviewService;

    @ApiOperation("get review by id")
    @GetMapping("/{id}")
    public Result getReview(@PathVariable int id) {
        return reviewService.getReviewById(id);
    }

    @GetMapping("/spid/{spid}")
    public Result getReviewBySpid(@PathVariable int spid) {
        return reviewService.getReviewBySpid(spid);
    }
}
