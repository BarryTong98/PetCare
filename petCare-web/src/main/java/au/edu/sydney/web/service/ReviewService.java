package au.edu.sydney.web.service;

import au.edu.sydney.base.Result;
import au.edu.sydney.web.pojo.entity.Review;

/**
 * @author Chris
 * @date 2021-09-14 22:05
 * @description
 */
public interface ReviewService {

    Result getReviewById(int id);

    Result getReviewBySpid(int spid);

    Result getReviewByUid(int uid);

    Result insert(Review review);
}
