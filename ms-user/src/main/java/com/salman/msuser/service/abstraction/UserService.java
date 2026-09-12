package com.salman.msuser.service.abstraction;

import com.salman.msuser.dto.request.UserCreateRequest;
import com.salman.msuser.dto.response.PageResponse;
import com.salman.msuser.dto.response.UserDetailResponse;
import com.salman.msuser.dto.response.UserSummaryResponse;
import com.salman.msuser.enums.Status;

public interface UserService {
    UserDetailResponse createUser(UserCreateRequest userCreateRequest);

    PageResponse<UserSummaryResponse> getAllUsers(int page, int size, String statusStr);
}
