package com.example.review.controller;

import com.example.review.Repository.HospitalRepository;
import com.example.review.Repository.ReviewRepository;
import com.example.review.domain.Hospital;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/hospitals")
@Slf4j
public class HospitalController {
    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitalController(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }


    @GetMapping("")
    public String list(@RequestParam(required = false) String keyword, Pageable pageable, Model model) {
        // keyword는 어떻게 받을 것인가?
        log.info("keyword:{}", keyword);
        Page<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining(keyword, pageable);
        model.addAttribute("hospitals", hospitals);
        model.addAttribute("keyword", keyword);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());
        return "hospital/list";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable Integer id, Model model, Pageable pageable) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        Page<Review> reviews = reviewRepository.findByHospitalId(id, pageable);
        log.info("review cnt:{} {}", reviews.getSize(), reviews);
        model.addAttribute("hospital", hospital.get());
        model.addAttribute("reviews", reviews);
        return "hospital/show";
    }
}
