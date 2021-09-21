package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.ReviewMapper;
import au.edu.sydney.web.entity.pojo.Review;
import au.edu.sydney.web.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Chris
 * @date 2021-09-14 22:05
 * @description
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    @Resource
    ReviewMapper reviewMapper;

    @Override
    public Result getReviewById(int id) {
        Review review = reviewMapper.selectByPrimaryKey(id);
        if (review == null) {
            return Result.error("Review doesn't exist!");
        }
        return Result.ok(review);
    }

    @Override
    public Result getReviewBySpid(int id) {
        List<Review> list = reviewMapper.selectBySpid(id);
        if (list.isEmpty()) {
            return Result.error("Review doesn't exist!");
        }
        return Result.ok(list);
    }
}
