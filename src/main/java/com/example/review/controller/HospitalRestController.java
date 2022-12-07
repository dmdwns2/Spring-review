package com.example.review.controller;

import com.example.review.domain.dto.HospitalResponse;
import com.example.review.service.HospitalService;
import com.example.review.service.ReviewService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalRestController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalRestController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }
    //    @GetMapping("")
//    public ResponseEntity<HospitalResponse> list(Pageable pageable){
//        return ResponseEntity.ok().body(hospitalService.findHospital(pageable));
//    }


    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Long id) { // ResponseEntity도 DTO타입
        HospitalResponse hospitalResponse = hospitalService.getHospital(id); // DTO
        return ResponseEntity.ok().body(hospitalResponse); // Return은 DTO로
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<Page<Review>> getReviews(@PathVariable Long hospitalId) {
        Pageable pageable = Pageable.ofSize(20);
        return ResponseEntity.ok().body(reviewService.get(hospitalId, pageable));
    }
}