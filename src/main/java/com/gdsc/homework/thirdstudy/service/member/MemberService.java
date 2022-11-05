package com.gdsc.homework.thirdstudy.service.member;

import com.gdsc.homework.thirdstudy.domain.member.Member;
import com.gdsc.homework.thirdstudy.domain.member.MemberRepository;
import com.gdsc.homework.thirdstudy.service.member.dto.request.MemberDto;
import com.gdsc.homework.thirdstudy.service.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
        private final MemberRepository memberRepository;

        public void signUp(MemberDto dto){
            memberRepository.save(Member.newInstance(dto.getName()));
        }

    public MemberResponse getMember(Long userId) {
        Member findMember = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("없는 유저 입니다."));
        return MemberResponse.of(findMember.getId(), findMember.getName());
    }

    public MemberResponse getMemberByName(String name) {
        Optional<Member> findMember = memberRepository.findMemberByName(name);
        return MemberResponse.of(findMember.get().getId(), findMember.get().getName());
    }
}
