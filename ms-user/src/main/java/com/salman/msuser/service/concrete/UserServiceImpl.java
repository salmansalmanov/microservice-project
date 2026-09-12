package com.salman.msuser.service.concrete;

import com.salman.msuser.dto.request.UserCreateRequest;
import com.salman.msuser.dto.response.UserDetailResponse;
import com.salman.msuser.entity.User;
import com.salman.msuser.exception.custom.AlreadyExistsException;
import com.salman.msuser.mapper.UserMapper;
import com.salman.msuser.repository.UserRepository;
import com.salman.msuser.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    public UserDetailResponse createUser(UserCreateRequest userCreateRequest) {
        if (userRepository.existsByEmail(userCreateRequest.email())) {
            throw new AlreadyExistsException("Email already exists");
        }
        if (userRepository.existsByPhoneNumber(userCreateRequest.phoneNumber())) {
            throw new AlreadyExistsException("Phone number already exists");
        }

        User user = userMapper.createRequestToEntity(userCreateRequest);
        User savedUser = userRepository.save(user);
        return userMapper.entityToDetailResponse(savedUser);
    }
}
