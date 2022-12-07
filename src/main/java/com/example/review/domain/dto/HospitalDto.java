package com.example.review.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class HospitalDto {
    private Long id;
    private String content;//roadNameAddress;
    private String title;
    private Long patientRoomCount;
    private Long totalNumberOfBeds;
    private Float totalAreaSize;
}
