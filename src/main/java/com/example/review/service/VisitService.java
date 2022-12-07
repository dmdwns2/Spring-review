package com.example.review.service;

import com.example.review.Repository.HospitalRepository;
import com.example.review.Repository.UserRepository;
import com.example.review.Repository.VisitRepository;
import com.example.review.controller.VisitCreateRequest;
import com.example.review.domain.Hospital;
import com.example.review.domain.User;
import com.example.review.domain.Visit;
import com.example.review.exception.ErrorCode;
import com.example.review.exception.HospitalReviewAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;

    public void createVisit(VisitCreateRequest dto, String userName) {

        // hospital이 없을 때 등록불가
        Hospital hospital = hospitalRepository.findById(dto.getHospitalId())
                .orElseThrow(() -> new HospitalReviewAppException(ErrorCode.NOT_FOUND_HOSPITAL, String.format("hospitalId:%s 가 없습니다.", dto.getHospitalId())));

        // user가 없을 때 등록불가
        User user = userRepository.findByUserName(userName)
                .orElseThrow(() -> new HospitalReviewAppException(ErrorCode.NOT_FOUND_USER, String.format("%s user가 없습니다.", userName)));

        Visit visit = Visit.builder()
                .user(user)
                .hospital(hospital)
                .disease(dto.getDisease())
                .amount(dto.getAmount())
                .build();
        visitRepository.save(visit);
    }
}