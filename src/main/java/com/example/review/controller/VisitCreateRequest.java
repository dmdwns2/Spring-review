package com.example.review.controller;

import com.example.review.domain.Hospital;
import com.example.review.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VisitCreateRequest {
    private Long id;
    private Hospital hospital;
    private User user;
    private String disease;
    private float amount;

    public Long getHospitalId(Hospital hospitalId) {
        this.id = 
    }
}
