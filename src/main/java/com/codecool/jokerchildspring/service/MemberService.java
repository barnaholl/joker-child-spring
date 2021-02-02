package com.codecool.jokerchildspring.service;

import com.codecool.jokerchildspring.entity.Member;
import com.codecool.jokerchildspring.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private MemberRepository memberRepository;

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public void createMember(Member member) {
        memberRepository.save(member);
    }

    public void updateMember(Member member) {
        Member oldMember= memberRepository.findById(member.getId()).orElseThrow(EntityNotFoundException::new);
        oldMember.setName(member.getName());
        oldMember.setNick(member.getNick());
        oldMember.setEmail(member.getEmail());
        oldMember.setPassword(member.getPassword());
        oldMember.setBirthDate(member.getBirthDate());
        oldMember.setRole(member.getRole());
        oldMember.setGameHistory(member.getGameHistory());
        oldMember.setExperience(member.getExperience());
        memberRepository.save(oldMember);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}
