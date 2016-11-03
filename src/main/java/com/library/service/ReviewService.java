package com.library.service;


import com.library.repository.models.Review;

import java.util.List;

/**
 * Created by nehaojha on 02/11/16.
 */
public interface ReviewService {

    void addReview(Review review);

    List<Review> findReviewByPropertyName(String propertyName);

    List<Review> findByUserName(String name);

    List<Review> findReviewByPhoneNumber(String number);

    List<Review> findReviewByPropertyId(int propertyId);

    void deleteReview(Integer id);

}
