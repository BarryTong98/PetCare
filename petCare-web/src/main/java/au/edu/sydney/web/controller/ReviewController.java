package au.edu.sydney.web.controller;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.Review;
import au.edu.sydney.web.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chris
 * @date 2021-09-14 22:10
 * @description
 */

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @ApiOperation("get review by id")
    @GetMapping("/{id}")
    public Result getReview(@PathVariable int id) {
        Review review = reviewService.getReviewById(id);
        if (review == null) {
            return Result.error("Review doesn't exist!");
        }
        return Result.ok(review);
    }
}
