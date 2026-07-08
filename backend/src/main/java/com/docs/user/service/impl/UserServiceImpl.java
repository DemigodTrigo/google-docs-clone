package com.docs.user.service.impl;

import com.docs.auth.dto.RegisterUserRequest;
import com.docs.common.exception.BadRequestException;
import com.docs.user.dto.UserResponse;
import com.docs.user.entity.User;
import com.docs.user.mapper.UserMapper;
import com.docs.user.repository.UserRepository;
import com.docs.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserResponse register(RegisterUserRequest request) {


        if(userRepository.existsByEmail(request.email())){

            throw new BadRequestException(
                    "Email already registered"
            );

        }


        User user = UserMapper.toEntity(request);


        user.setPassword(
                passwordEncoder.encode(
                        request.password()
                )
        );


        User savedUser =
                userRepository.save(user);


        return UserMapper.toResponse(savedUser);

    }
}
