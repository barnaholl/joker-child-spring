package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.Member;
import com.codecool.jokerchildspring.service.MemberService;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public ResponseEntity getMemberById(@RequestParam("id") Long id){
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @GetMapping("/all")
    public ResponseEntity getAllMembers(){
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @PostMapping("/")
    public ResponseEntity createMember(@ApiParam(value = "BirthDate format is XXXX-XX-XX(1996-09-09), possible Roles are : STUDENT,TEACHER,ADMIN ") @RequestBody Member member){
        memberService.createMember(member);
        return ResponseEntity.ok("Member created"+member);
    }

    @PutMapping("/")
    public ResponseEntity updateMember(@ApiParam(value = "BirthDate format is XXXX-XX-XX(1996-09-09), possible Roles are : STUDENT,TEACHER,ADMIN ") @RequestBody Member member){
        memberService.updateMember(member);
        return ResponseEntity.ok("Member updated to:"+member);
    }

    @DeleteMapping("/")
    public ResponseEntity deleteMember(@RequestParam("id") Long id){
        memberService.deleteMember(id);
        return ResponseEntity.ok("Member deleted with id: "+ id);
    }
}
