package com.salman.msuser.service.concrete;

import com.salman.msuser.dto.request.UserCreateRequest;
import com.salman.msuser.dto.response.PageResponse;
import com.salman.msuser.dto.response.UserDetailResponse;
import com.salman.msuser.dto.response.UserSummaryResponse;
import com.salman.msuser.entity.User;
import com.salman.msuser.enums.Status;
import com.salman.msuser.exception.custom.AlreadyExistsException;
import com.salman.msuser.exception.custom.NotFoundException;
import com.salman.msuser.mapper.UserMapper;
import com.salman.msuser.repository.UserRepository;
import com.salman.msuser.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public PageResponse<UserSummaryResponse> getAllUsers(int page, int size, String statusStr) {
        Status status = Status.fromString(statusStr);
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<User> userPage = status == null ? userRepository.findAll(pageable) : userRepository.findAllByStatus(status, pageable);
        return PageResponse.of(userPage.map(userMapper::entityToSummaryResponse));
    }

    @Override
    public UserDetailResponse getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        return userMapper.entityToDetailResponse(user);
    }
}
