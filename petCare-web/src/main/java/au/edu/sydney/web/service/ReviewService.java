package au.edu.sydney.web.service;

import au.edu.sydney.web.entity.pojo.Review;

/**
 * @author Chris
 * @date 2021-09-14 22:05
 * @description
 */
public interface ReviewService {

    Review getReviewById(int id);
}
