package com.salman.msuser.repository;

import com.salman.msuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);

    Boolean existsByPhoneNumber(String phoneNumber);
}
