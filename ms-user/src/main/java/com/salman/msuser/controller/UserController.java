package com.salman.msuser.controller;

import com.salman.msuser.dto.request.UserCreateRequest;
import com.salman.msuser.dto.response.UserDetailResponse;
import com.salman.msuser.service.abstraction.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDetailResponse> createUser(@RequestBody @Valid UserCreateRequest userCreateRequest) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(userCreateRequest));
    }
}
