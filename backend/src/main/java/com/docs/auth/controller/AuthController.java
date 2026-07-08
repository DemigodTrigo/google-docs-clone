package com.docs.auth.controller;

import com.docs.auth.dto.RegisterUserRequest;
import com.docs.common.response.ApiResponse;
import com.docs.user.dto.UserResponse;
import com.docs.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    public final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(

            @Valid
            @RequestBody
            RegisterUserRequest request

    ){


        UserResponse response =
                userService.register(request);


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);

    }

}
