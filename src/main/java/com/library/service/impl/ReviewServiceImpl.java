package com.library.service.impl;

import com.library.repository.ReviewRepo;
import com.library.repository.models.Review;
import com.library.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Review> findReviewByPropertyName(String propertyName) {
        return reviewRepo.findByPropertyName(propertyName);
    }

    @Override
    public List<Review> findByUserName(String name) {
        return reviewRepo.findByName(name);
    }

    @Override
    public List<Review> findReviewByPhoneNumber(String number) {
        return reviewRepo.findByPhoneNumber(number);
    }

    @Override
    public List<Review> findReviewByPropertyId(int propertyId) {
        return reviewRepo.findByPropertyId(propertyId);
    }


}
