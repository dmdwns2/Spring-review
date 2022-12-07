package com.example.review.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class VisitResponse {
    private String hospitalName;
    private String userName;
    private String disease;
    private float amount;
}