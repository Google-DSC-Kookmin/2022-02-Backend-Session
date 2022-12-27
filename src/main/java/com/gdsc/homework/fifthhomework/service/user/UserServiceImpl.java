package com.gdsc.homework.fifthhomework.service.user;

import com.gdsc.homework.fifthhomework.domain.user.User;
import com.gdsc.homework.fifthhomework.domain.user.UserRepository;
import com.gdsc.homework.fifthhomework.dto.user.request.SignInDto;
import com.gdsc.homework.fifthhomework.dto.user.request.SignUpDto;
import com.gdsc.homework.fifthhomework.session.SessionManager;
import com.gdsc.homework.fifthhomework.validator.Validator;
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


    // 벨리데이터는 컴포넌트를 썼는데 컴포넌트 스캔이 자동으로 되는가?
    private final Validator validator;

    //회원가입
    @Transactional
    @Override
    public void SignUp(SignUpDto signUpDto) {

        validator.validateSignUp(signUpDto);

        // user 객체 생성
        User newUser = User.newInstance(signUpDto.getEmail(),
                signUpDto.getNickname(),
                signUpDto.getPassword());

        // 레포지토리에 등록
        userRepository.save(newUser);
    }
    // 로그인
    @Transactional
    @Override
    public void SignIn(SignInDto signInDto, HttpServletResponse httpServletResponse) {
        validator.validateSignIn(signInDto);
        sessionManager.createSession(signInDto.getEmail(),httpServletResponse);
    }
}
