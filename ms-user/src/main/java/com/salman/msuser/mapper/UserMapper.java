package com.salman.msuser.mapper;

import com.salman.msuser.dto.request.UserCreateRequest;
import com.salman.msuser.dto.request.UserUpdateRequest;
import com.salman.msuser.dto.response.UserDetailResponse;
import com.salman.msuser.dto.response.UserSummaryResponse;
import com.salman.msuser.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "status", constant = "ACTIVE")
    User createRequestToEntity(UserCreateRequest userCreateRequest);

    UserDetailResponse entityToDetailResponse(User user);

    UserSummaryResponse entityToSummaryResponse(User user);

    User updateRequestToEntity(UserUpdateRequest userUpdateRequest, @MappingTarget User user);
}
