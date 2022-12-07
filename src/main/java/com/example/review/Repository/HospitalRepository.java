package com.example.review.Repository;


import com.example.review.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {

//    List<Hospital> findByHospitalId(Long id);
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    Page<Hospital> findByRoadNameAddressContaining(String keyword, Pageable pageable); // 포함
    List<Hospital> findByRoadNameAddressStartsWith(String keyword); // 시작
    List<Hospital> findByRoadNameAddressEndingWith(String keyword); // 끝남
    List<Hospital> findByPatientRoomCountGreaterThanAndPatientRoomCountLessThan(int var1, int var2);

}
