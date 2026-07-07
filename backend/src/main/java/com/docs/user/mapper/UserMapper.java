package com.docs.user.mapper;

import com.docs.auth.dto.RegisterUserRequest;
import com.docs.user.entity.User;
import com.docs.user.dto.UserResponse;

public final class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(RegisterUserRequest request){
        return User.builder()
                .firstName(request.firstName())
                .email(request.email())
                .password(request.password())
                .build();
    }


    public static UserResponse toResponse(
            User user
    ){

        return new UserResponse(
                user.getId(),
                user.getFirstName(),
                user.getEmail()
        );

    }
}
