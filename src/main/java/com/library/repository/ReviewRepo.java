package com.library.repository;

import com.library.repository.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by nehaojha on 02/11/16.
 */
@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {

    List<Review> findByPropertyName(String propertyName);

    List<Review> findByName(String name);

    List<Review> findByPhoneNumber(String number);

    List<Review> findByPropertyId(int propertyId);
}
