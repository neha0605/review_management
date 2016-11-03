package com.library.controller;

import com.library.repository.models.Review;
import com.library.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nehaojha on 02/11/16.
 */
@RestController
@RequestMapping(value = "/reviews")
public class ReviewController extends BaseController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(method = RequestMethod.POST, headers = ACCEPT_JSON)
    public ResponseEntity addNewReview(@RequestBody Review review) {
        reviewService.addReview(review);
        return new ResponseEntity("review added successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/name/{propertyName}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Review> getReviewByPropertyName(@PathVariable String propertyName) {
        return reviewService.findReviewByPropertyName(propertyName);
    }

    @RequestMapping(value = "/user/{name}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Review> getReviewsByName(@PathVariable String name) {
        return reviewService.findByUserName(name);
    }

    @RequestMapping(value = "/number/{number}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Review> getReviewsByPhoneNumber(@PathVariable String number) {
        return reviewService.findReviewByPhoneNumber(number);
    }

    @RequestMapping(value = "/propertyid/{propertyId}", method = RequestMethod.GET, headers = ACCEPT_JSON)
    public List<Review> getReviewByPropertyId(@PathVariable int propertyId) {
        return reviewService.findReviewByPropertyId(propertyId);
    }
}

