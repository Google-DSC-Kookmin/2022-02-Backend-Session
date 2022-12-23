package com.gdsc.homework.fifthhomework.service.user;

import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.domain.user.UserRepository;
import com.gdsc.homework.fifthhomework.dto.user.request.SignInDto;
import com.gdsc.homework.fifthhomework.dto.user.request.SignUpDto;
import com.gdsc.homework.fifthhomework.session.SessionManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final SessionManager sessionManager;


    @Transactional
    @Override
    public void SignUp(SignUpDto signUpDto) {

        // validation 구간
        Optional<User> findUser = userRepository.findByEmail(signUpDto.getEmail());
        if(findUser.isPresent()){
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }


        // user 객체 생성
        User newUser = User.newInstance(signUpDto.getEmail(),
                signUpDto.getNickname(),
                signUpDto.getPassword());

        // 레포지토리에 등록
        userRepository.save(newUser);
    }

    @Transactional
    @Override
    public void SignIn(SignInDto signInDto, HttpServletResponse httpServletResponse) {
        Optional<User> byEmail = userRepository.findByEmail(signInDto.getEmail());
        if(byEmail.isEmpty()){
            throw new IllegalArgumentException("회원가입을 해주세요");
        }
        Optional<User> byPassword = userRepository.findByPassword(signInDto.getPassword());
        if(byPassword.isEmpty()){
            throw new IllegalArgumentException("회원가입을 해주세요");
        }
        sessionManager.createSession(signInDto.getEmail(),httpServletResponse);


    }
}
