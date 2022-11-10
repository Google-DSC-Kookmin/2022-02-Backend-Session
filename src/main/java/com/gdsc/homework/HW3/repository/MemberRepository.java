package com.gdsc.homework.HW3.repository;

import com.gdsc.homework.HW3.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member save(Member member);
    Optional<Member> findMemberByEmail(String email);
    Optional<Member> findMemberById(Long id);
    List<Member> findAll();
}
