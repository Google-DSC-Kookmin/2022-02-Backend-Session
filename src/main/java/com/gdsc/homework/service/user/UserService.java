package com.gdsc.homework.service.user;

import com.gdsc.homework.domain.user.User;
import com.gdsc.homework.domain.user.UserRepository;
import com.gdsc.homework.service.user.dto.request.UserInfoServiceRequest;
import com.gdsc.homework.service.user.dto.request.UserServiceRequest;
import com.gdsc.homework.service.user.dto.response.UserServiceResponse;
import com.gdsc.homework.validAPI.UserValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserValidation userValidation;

    public final Long enroll(UserServiceRequest userServiceRequest) {
        userValidation.duplicateEmail(userServiceRequest.getEmail());
        userValidation.duplicateNickname(userServiceRequest.getNickname());
        User saveUser = userRepository.save(User.newInstance(
                userServiceRequest.getEmail(),
                userServiceRequest.getNickname(),
                userServiceRequest.getPassword()
        ));

        return saveUser.getId();
    }

    public final void editInfo(UserInfoServiceRequest userInfoServiceRequest) {
        userValidation.duplicateEmail(userInfoServiceRequest.getModifyEmail());
        userValidation.duplicateNickname(userInfoServiceRequest.getNickname());
        User saveUser = userRepository.findByEmail(userInfoServiceRequest.getOriginalEmail()).get();
        saveUser.changeEmailAndNickname(userInfoServiceRequest.getModifyEmail(), userInfoServiceRequest.getNickname());
        userRepository.save(saveUser);

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
