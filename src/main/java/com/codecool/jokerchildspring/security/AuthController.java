package com.codecool.jokerchildspring.security;

import com.codecool.jokerchildspring.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Map<Object,Object>> login(@RequestBody UserCredentials data,HttpServletResponse response) {
        return ResponseEntity.ok(authService.login(data, response));
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletResponse response) {
        return ResponseEntity.ok(authService.logout(response));
    }

    @PostMapping("/register")
    public ResponseEntity<Map<Object, Object>> register(@RequestBody Member member, HttpServletResponse response) {
        return ResponseEntity.ok(authService.register(member,response));
    }

    @GetMapping("/current-user-object")
    public ResponseEntity<Member> getCurrentUserObject(HttpServletRequest request) {
       return ResponseEntity.ok(authService.getCurrentUserObject(request));
    }

}