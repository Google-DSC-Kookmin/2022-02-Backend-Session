package com.gdsc.homework.thridstudy.service.member;

import com.gdsc.homework.thridstudy.domain.member.Member;
import com.gdsc.homework.thridstudy.domain.member.MemberRepository;
import com.gdsc.homework.thridstudy.service.member.dto.request.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
        private final MemberRepository memberRepository;

        public void signUp(MemberDto dto){
            memberRepository.save(Member.newInstance(dto.getName()));
        }
}
