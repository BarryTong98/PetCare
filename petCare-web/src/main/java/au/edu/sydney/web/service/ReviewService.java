package au.edu.sydney.web.service;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.entity.pojo.Review;

/**
 * @author Chris
 * @date 2021-09-14 22:05
 * @description
 */
public interface ReviewService {

    Result getReviewById(int id);

    Result getReviewBySpid(int id);

    Result insert(Review review);
}
