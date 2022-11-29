package com.example.review.controller;


import com.example.review.domain.Response;
import com.example.review.domain.dto.*;
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
        log.info("join으로 요청이 들어왔습니다.");
        UserDto userDto = userService.join(userJoinRequest);
        return Response.suceess(new UserJoinResponse(userDto.getUserName(), userDto.getEmail()));
    }

    @PostMapping("/login")
    public Response<UserLoginResponse> login(@RequestBody UserLoginRequest userLoginRequest) {
        log.info("login 요청이 들어왔습니다.");
        String token = userService.login(userLoginRequest.getUserName(), userLoginRequest.getPassword());
        return Response.suceess(new UserLoginResponse(token));
    }

}
