package com.example.review.service;


import com.example.review.Repository.HospitalRepository;
import com.example.review.Repository.ReviewRepository;
import com.example.review.controller.Review;
import com.example.review.controller.ReviewCreateRequest;
import com.example.review.controller.ReviewCreateResponse;
import com.example.review.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final HospitalRepository hospitalRepository;

    public ReviewService(ReviewRepository reviewRepository, HospitalRepository hospitalRepository) {
        this.reviewRepository = reviewRepository;
        this.hospitalRepository = hospitalRepository;
    }

    public ReviewCreateResponse add(ReviewCreateRequest reviewCreateRequest) {
        Optional<Hospital> hospital = hospitalRepository.findById(reviewCreateRequest.getHospitalId());
        Review review = Review.builder()
                .title(reviewCreateRequest.getTitle())
                .content(reviewCreateRequest.getContent())
                .userName(reviewCreateRequest.getUserName())
                .hospital(hospital.get())
                .build();
        Review savedReview = reviewRepository.save(review);
        return new ReviewCreateResponse(savedReview.getId(), savedReview.getTitle(), savedReview.getContent(), savedReview.getContent(),
                "리뷰 등록이 성공 했습니다.");
    }

    public void create(ReviewCreateRequest dto) {
// hospitalId를 받아서 Hospital을 select함
        Optional<Hospital> optionalHospital = hospitalRepository.findById(dto.getHospitalId());
        Review savedReview = reviewRepository.save(Review.of(
                optionalHospital.orElseThrow(() -> new IllegalArgumentException("해당 hospitalId에 해당하는 병원이 없습니다.")),
                        dto.getTitle(), dto.getContent(), dto.getUserName()));
    }


    // 작성해봤는데 맞는지 모르겠음
    public Page<Review> get(Long hospitalId, Pageable pageable) {
        return reviewRepository.findByHospitalId(hospitalId,pageable);
    }
}