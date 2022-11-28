package com.example.review.service;

import com.example.review.Repository.UserRepository;
import com.example.review.domain.User;
import com.example.review.domain.dto.UserDto;
import com.example.review.domain.dto.UserJoinRequest;
import com.example.review.exception.ErrorCode;
import com.example.review.exception.HospitalReviewAppException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto join(UserJoinRequest request) {
        // 비즈니스 로직 - 회원 가입
        // 회원 userName(id) 중복 Checkis
        // 중복이면 회원가입 x --> Exception(예외)발생
        userRepository.findByUserName(request.getUserName())
                .ifPresent(user ->{
                    throw new HospitalReviewAppException(ErrorCode.DUPLICATED_USER_NAME, String.format("UserName:%s", request.getUserName()));
                });

        // 회원가입 .save()
        User savedUser = userRepository.save(request.toEntity());
        return UserDto.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .email(savedUser.getEmailAddress())
                .build();
    }
}