package com.gdsc.homework.HW5.repository;

import com.gdsc.homework.HW5.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User save(User user);

    @Override
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
