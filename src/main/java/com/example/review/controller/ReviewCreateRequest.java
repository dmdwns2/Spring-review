package com.example.review.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewCreateRequest {
    private Long hospitalId;
    private String title;
    private String content;
    private String userName;
}