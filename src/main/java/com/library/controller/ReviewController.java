package com.library.controller;

import com.library.repository.models.Review;
import com.library.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}

