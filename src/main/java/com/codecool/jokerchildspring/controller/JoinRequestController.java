package com.codecool.jokerchildspring.controller;

import com.codecool.jokerchildspring.entity.JoinRequest;
import com.codecool.jokerchildspring.service.JoinRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/joinRequest")
@RestController
@RequiredArgsConstructor
public class JoinRequestController {

    private final JoinRequestService joinRequestService;

    @GetMapping("/")
    public ResponseEntity<List<JoinRequest>> getJoinRequestBySchoolId(@RequestParam("teacherId") Long teacherId){
        return ResponseEntity.ok(joinRequestService.getJoinRequestByTeacherId(teacherId));
    }

    @GetMapping("/all")
    public ResponseEntity<List<JoinRequest>> getAllJoinRequest(){
        return ResponseEntity.ok(joinRequestService.getAllJoinRequest());
    }

    @PostMapping("/")
    public ResponseEntity<String> createJoinRequest(@RequestBody JoinRequest joinRequest){
        joinRequestService.createJoinRequest(joinRequest);
        return ResponseEntity.ok("New JoinRequest created: "+joinRequest);
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteJoinRequestById(@RequestParam("/id") Long id){
        joinRequestService.deleteJoinRequest(id);
        return ResponseEntity.ok("JoinRequest deleted at id: "+id);
    }
}
