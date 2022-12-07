package com.example.review.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

class VisitServiceTest {

    // disease에 사용될 String 명칭
    private static final String HEADACHE = "headache"; // 두통
    private static final String TOOTHACHE = "toothache"; // 치통
    private static final String DIABETES = "diabetes"; // 당뇨병
    private static final String COLD = "cold"; //감기
    private static final String BURN = "burn"; //화상

    JpaRepository repository;



}