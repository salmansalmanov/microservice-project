package com.salman.msuser.repository;

import com.salman.msuser.entity.User;
import com.salman.msuser.enums.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);

    Boolean existsByPhoneNumber(String phoneNumber);

    Page<User> findAllByStatus(Status status, Pageable pageable);
}
