package com.gdsc.homework.repository;

import com.gdsc.homework.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByNickName(String nickName);

    Optional<User> findByUserID(Long userId);

    Optional<User> findByEmailAndPassword(String email, String password);
}
