package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.Member;
import com.codecool.jokerchildspring.service.MemberService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public ResponseEntity<Member> getMemberById(@RequestParam("id") Long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @GetMapping("/getXpByMemberId")
    public ResponseEntity<Long> getXpByMemberId(@RequestParam("id") Long memberId){
        return ResponseEntity.ok(memberService.getXpByMemberById(memberId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Member>> getAllMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @PostMapping("/")
    public ResponseEntity<String> createMember(@ApiParam(value = "BirthDate format is XXXX-XX-XX(1996-09-09), possible Roles are : STUDENT,TEACHER,ADMIN ") @RequestBody Member member){
        memberService.createMember(member);
        return ResponseEntity.ok("Member created"+member);
    }

    @PutMapping("/")
    public ResponseEntity<String> updateMember(@ApiParam(value = "BirthDate format is XXXX-XX-XX(1996-09-09), possible Roles are : STUDENT,TEACHER,ADMIN ") @RequestBody Member member){
        memberService.updateMember(member);
        return ResponseEntity.ok("Member updated to:"+member);
    }

    @PutMapping("/updateExperience")
    public ResponseEntity<String> updateExperience(@RequestParam("memberId") Long memberId,@RequestParam("experience") Long experience){
        memberService.updateExperience(memberId,experience);
        return ResponseEntity.ok("Member's("+memberId+") experience updated to "+experience);
    }

    @DeleteMapping("/resetMember")
    public ResponseEntity<String> resetMember(@RequestParam("id") Long id){
        memberService.resetMember(id);
        return ResponseEntity.ok("Member reset with id: "+ id);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteMember(@RequestParam("id") Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member deleted with id: "+ id);
    }
}
