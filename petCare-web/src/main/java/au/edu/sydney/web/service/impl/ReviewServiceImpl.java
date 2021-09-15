package au.edu.sydney.web.service.impl;

import au.edu.sydney.web.dao.ReviewMapper;
import au.edu.sydney.web.entity.pojo.Review;
import au.edu.sydney.web.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Chris
 * @date 2021-09-14 22:05
 * @description
 */
@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public Review getReviewById(int id) {
        return reviewMapper.selectByPrimaryKey(id);
    }
}
