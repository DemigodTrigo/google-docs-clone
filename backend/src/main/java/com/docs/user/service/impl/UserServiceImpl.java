package com.docs.user.service.impl;

import com.docs.auth.dto.RegisterUserRequest;
import com.docs.user.dto.UserResponse;
import com.docs.user.entity.User;
import com.docs.user.mapper.UserMapper;
import com.docs.user.repository.UserRepository;
import com.docs.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserResponse register(RegisterUserRequest request) {


        User user = UserMapper.toEntity(request);


        User savedUser = userRepository.save(user);


        return UserMapper.toResponse(savedUser);

    }
}
