package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.JoinRequest;
import com.codecool.jokerchildspring.service.JoinRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/joinRequest")
@RestController
@RequiredArgsConstructor
public class JoinRequestController {

    private final JoinRequestService joinRequestService;

    @GetMapping("/")
    public ResponseEntity getJoinRequestBySchoolId(@RequestParam("teacherId") Long teacherId){
        return ResponseEntity.ok(joinRequestService.getJoinRequestByTeacherId(teacherId));
    }

    @PostMapping("/")
    public ResponseEntity createJoinRequest(@RequestBody JoinRequest joinRequest){
        joinRequestService.createJoinRequest(joinRequest);
        return ResponseEntity.ok("New JoinRequest created: "+joinRequest);
    }
}
