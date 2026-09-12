package com.salman.msuser.service.abstraction;

import com.salman.msuser.dto.request.UserCreateRequest;
import com.salman.msuser.dto.response.UserDetailResponse;

public interface UserService {
    UserDetailResponse createUser(UserCreateRequest userCreateRequest);
}
