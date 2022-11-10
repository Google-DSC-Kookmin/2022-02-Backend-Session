package com.gdsc.homework.HW3.service;

import com.gdsc.homework.HW3.domain.Member;
import com.gdsc.homework.HW3.repository.MemberRepository;
import com.gdsc.homework.HW3.service.dto.request.MemberServiceRequest;
import com.gdsc.homework.HW3.service.dto.response.MemberServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
/*
* @Service: 서비스 어노테이션
* @RequiredArgsConstructor: 초기화 되지 않은 final 필드나 @NotNull이 붙은 필드에 대해 생성자를 생성
* */
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberServiceResponse enroll(MemberServiceRequest memberServiceRequest) {
        validateDuplicateMember(memberServiceRequest);
        Member saveMember = memberRepository.save(Member.newInstance(
                memberServiceRequest.getName(),
                memberServiceRequest.getUserId(),
                memberServiceRequest.getDescription()
        ));

        return MemberServiceResponse.of(saveMember.getId(), saveMember.getName(), saveMember.getUserId(), saveMember.getDescription());
    }

    public MemberServiceResponse search(String userId) {
        validateNoMember(userId);
        Optional<Member> member = memberRepository.findMemberByUserId(userId);
        return MemberServiceResponse.of(
                        member.get().getId(),
                        member.get().getName(),
                        member.get().getUserId(),
                        member.get().getDescription());
    }

    private void validateDuplicateMember(MemberServiceRequest memberServiceRequest) {
        memberRepository.findMemberByUserId(memberServiceRequest.getUserId())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    private void validateNoMember(String userId) {
        if (memberRepository.findMemberByUserId(userId).isEmpty()) {
            throw new IllegalStateException("해당 아이디로 가입한 회원이 없습니다.");
        }

    }

}
