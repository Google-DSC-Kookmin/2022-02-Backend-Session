package com.gdsc.homework.validAPI;

import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserValidation {
    private final UserRepository userRepository;

    public void duplicateEmail(String email) {
        userRepository.findByEmail(email).ifPresent(
                u -> {
                    throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
                });
    }

    public void duplicateNickname (String nickname) {
        userRepository.findByNickname(nickname).ifPresent(u->{
            throw new IllegalArgumentException("이미 존재하는 닉네임입니다.");
        });
    }

    public boolean presentUserEmail (String email) {
        if(userRepository.findByEmail(email).isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 이메일입니다.");
        };
        return true;
    }

    public boolean isCorrectPassword(String email, String password) {
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 이메일입니다.");
        }

        if(!user.get().getPassword().equals(password)) {
            throw new IllegalArgumentException("이메일 혹은 비밀번호가 맞지 않습니다.");
        }

        return true;
    }

}
