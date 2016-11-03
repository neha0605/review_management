package com.library.repository;

import com.library.repository.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by nehaojha on 02/11/16.
 */
@Repository
public interface ReviewRepo extends JpaRepository<Review, Integer> {
}
