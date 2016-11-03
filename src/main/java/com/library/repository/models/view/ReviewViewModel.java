package com.library.repository.models.view;


import com.library.repository.models.Review;

/**
 * Created by nehaojha on 02/11/16.
 */
public class ReviewViewModel {

    private String userReview;

    private String name;

    private String propertyName;

    public ReviewViewModel(Review review) {
        this.userReview = review.getUserReview();
        this.name = review.getName();
        this.propertyName = review.getPropertyName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserReview() {
        return userReview;
    }

    public void setUserReview(String userReview) {
        this.userReview = userReview;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }
}
