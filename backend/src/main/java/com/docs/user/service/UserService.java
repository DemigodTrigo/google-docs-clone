package com.docs.user.service;


import com.docs.auth.dto.RegisterUserRequest;
import com.docs.user.dto.UserResponse;

public interface UserService {

    UserResponse register(RegisterUserRequest request);

}
