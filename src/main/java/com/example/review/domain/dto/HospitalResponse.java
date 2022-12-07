package com.example.review.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HospitalResponse {
    private Long id;
    private String roadNameAddress;
    private String hospitalName;
    private Long patientRoomCount;
    private Long totalNumberOfBeds;
    private String businessTypeName;
    private Float totalAreaSize;

    private String businessStatusName;

    public HospitalResponse(Long id, String roadNameAddress, String hospitalName, Long patientRoomCount, Long totalNumberOfBeds, String businessTypeName, Float totalAreaSize) {
        this.id = id;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.businessTypeName = businessTypeName;
        this.totalAreaSize = totalAreaSize;
    }

    public void setBusinessStatusName(String businessStatusName) {
        this.businessStatusName = businessStatusName;
    }
}
