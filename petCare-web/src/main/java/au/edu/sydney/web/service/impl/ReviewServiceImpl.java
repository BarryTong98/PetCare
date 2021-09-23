package au.edu.sydney.web.service.impl;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.dao.ReviewMapper;
import au.edu.sydney.web.dao.ServiceProviderMapper;
import au.edu.sydney.web.entity.pojo.Review;
import au.edu.sydney.web.entity.pojo.ServiceProvider;
import au.edu.sydney.web.service.ReviewService;
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

    @Resource
    ServiceProviderMapper serviceProviderMapper;

    @Override
    public Result getReviewById(int id) {
        Review review = reviewMapper.selectByPrimaryKey(id);
        if (review == null) {
            return Result.error("Review doesn't exist!");
        }
        return Result.ok(review);
    }

    @Override
    public Result getReviewBySpid(int spid) {
        List<Review> list = reviewMapper.selectBySpid(spid);
        return Result.ok(list);
    }

    @Override
    public Result getReviewByUid(int uid) {
        List<Review> list = reviewMapper.selectByUid(uid);
        return Result.ok(list);
    }

    @Override
    public Result insert(Review review) {
        Integer spid = review.getServiceProviderId();
        ServiceProvider serviceProvider = serviceProviderMapper.selectByPrimaryKey(spid);
        Double rating = (serviceProvider.getRating() + review.getRating()) / 2;
        serviceProvider.setRating(rating);
        reviewMapper.insert(review);
        serviceProviderMapper.updateByPrimaryKeySelective(serviceProvider);
        return Result.ok();
    }
}
