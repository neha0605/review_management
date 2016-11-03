package com.library.service.impl;

import com.library.repository.ReviewRepo;
import com.library.repository.models.Review;
import com.library.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by nehaojha on 02/11/16.
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Override
    public void addReview(Review review) {
        reviewRepo.save(review);
    }
}
