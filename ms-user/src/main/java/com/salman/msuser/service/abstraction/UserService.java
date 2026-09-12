package com.salman.msuser.service.abstraction;

import com.salman.msuser.dto.request.UserCreateRequest;
import com.salman.msuser.dto.request.UserUpdateRequest;
import com.salman.msuser.dto.response.PageResponse;
import com.salman.msuser.dto.response.UserDetailResponse;
import com.salman.msuser.dto.response.UserSummaryResponse;

public interface UserService {
    UserDetailResponse createUser(UserCreateRequest userCreateRequest);

    PageResponse<UserSummaryResponse> getAllUsers(int page, int size, String statusStr);

    UserDetailResponse getUserById(Long id);

    UserDetailResponse updateUserById(Long id, UserUpdateRequest userUpdateRequest);
}
