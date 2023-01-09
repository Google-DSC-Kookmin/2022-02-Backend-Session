package com.gdsc.homework.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsUserByEmail(String email);
    boolean existsUserByNickname(String nickname);

    Optional<User> findUserByEmail(String email);
    Optional<User> findUserByUserId(Long userId);
}
