package com.gdsc.homework.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByEmail(String email);

    Optional<Users> findByNickName(String nickName);

    Optional<Users> findByUserID(Long userId);

    Optional<Users> findByEmailAndPassword(String email, String password);
}
