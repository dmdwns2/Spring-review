package com.example.review.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class HospitalDto {
    private Integer id;
    private String content;//roadNameAddress;
    private String title;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private Float totalAreaSize;
}
