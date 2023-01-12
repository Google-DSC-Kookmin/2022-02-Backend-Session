package com.gdsc.homework.service;

import com.gdsc.homework.domain.User;
import com.gdsc.homework.domain.UserRepository;
import com.gdsc.homework.service.dto.request.SignUpDto;
import com.gdsc.homework.service.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public Long signUp(final SignUpDto request) {
        final User user = User.newInstance(request.getNickname());
        final User saveUser = userRepository.save(user);
        return saveUser.getId();
    }

    public UserResponse getUser(final Long userId) {
        final User foundUser = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        return UserResponse.of(foundUser.getId(), foundUser.getNickname());
    }
}
