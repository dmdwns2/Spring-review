package com.example.review.service;

import com.example.review.Repository.HospitalRepository;
import com.example.review.Repository.UserRepository;
import com.example.review.Repository.VisitRepository;
import com.example.review.controller.VisitCreateRequest;
import com.example.review.domain.Hospital;
import com.example.review.domain.User;
import com.example.review.domain.Visit;
import com.example.review.domain.VisitResponse;
import com.example.review.exception.ErrorCode;
import com.example.review.exception.HospitalReviewAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VisitService {

    private final VisitRepository visitRepository;
    private final HospitalRepository hospitalRepository;
    private final UserRepository userRepository;

    public void createVisit(VisitCreateRequest dto, String userName) {

        // hospital이 없을 때 등록불가
        Hospital hospital = hospitalRepository.findById(dto.getHospital().getId())
                .orElseThrow(() -> new HospitalReviewAppException(ErrorCode.NOT_FOUND_HOSPITAL, String.format("hospitalId:%s 가 없습니다.", dto.getHospital().getId())));

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

    public List<VisitResponse> findAllByPage(Pageable pageable) {
        Page<Visit> visits = visitRepository.findAll(pageable);

        // Visits --> VisitResponse
        return visits.stream()
                .map(Visit::toResponse)
                .collect(Collectors.toList());
    }
}