package com.example.review.controller;


import com.example.review.domain.Response;
import com.example.review.domain.dto.UserDto;
import com.example.review.domain.dto.UserJoinRequest;
import com.example.review.domain.dto.UserJoinResponse;
import com.example.review.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {


    private final UserService userService;

    @PostMapping("/join")
    public Response<UserJoinResponse> Join(@RequestBody UserJoinRequest userJoinRequest){
        UserDto userDto = userService.join(userJoinRequest);
        return Response.suceess(new UserJoinResponse());
    }

}
