package com.gdsc.homework.service.user;

import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.user.dto.request.UserServiceRequest;
import com.gdsc.homework.service.user.dto.response.UserServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public final Long enroll(UserServiceRequest userServiceRequest) {
        // validation 필요
        User saveUser = userRepository.save(User.newInstance(
                userServiceRequest.getEmail(),
                userServiceRequest.getNickname(),
                userServiceRequest.getPassword()
        ));

        return saveUser.getId();
    }

    public final UserServiceResponse findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return UserServiceResponse.of(
                user.get().getId(),
                user.get().getEmail(),
                user.get().getNickname()
        );
    }
}
