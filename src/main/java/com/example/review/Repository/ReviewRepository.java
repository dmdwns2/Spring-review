package com.example.review.Repository;

import com.example.review.controller.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByHospitalId(Long id, Pageable pageable);
}
