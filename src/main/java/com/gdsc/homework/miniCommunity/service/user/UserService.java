package com.gdsc.homework.miniCommunity.service.user;

import com.gdsc.homework.miniCommunity.controller.user.dto.request.UserRequest;
import com.gdsc.homework.miniCommunity.domain.user.User;
import com.gdsc.homework.miniCommunity.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public final void signUp(UserRequest userRequest) {
        checkEmailValidation(userRequest.getEmail());
        checkNicknameValidation(userRequest.getNickname());

        userRepository.save(User.newInstance(
                userRequest.getEmail(),
                userRequest.getNickname()
        ));
    }
    private void checkEmailValidation(String email) {
        userRepository.findUserByEmail(email).ifPresent(user -> {
            throw new IllegalArgumentException("E-mail already exists.");
        });
    }

    private void checkNicknameValidation(String nickname) {
        userRepository.findUserByNickname(nickname).ifPresent(user -> {
            throw new IllegalArgumentException("Nickname already exists.");
        });
    }

    public final void signIn(UserRequest userRequest) {
        Optional<User> foundUser = userRepository.findUserByEmail(userRequest.getEmail());
        if (foundUser.isEmpty()) {
            throw new IllegalArgumentException("User does not exist.");
        }
        if (!(foundUser.get().getNickname().equals(userRequest.getNickname()))) {
            throw new IllegalArgumentException("Information does not match.");
        }
    }
}
