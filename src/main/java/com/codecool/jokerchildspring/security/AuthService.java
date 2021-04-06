package com.codecool.jokerchildspring.security;

import com.codecool.jokerchildspring.entity.Member;
import com.codecool.jokerchildspring.repository.MemberRepository;
import io.jsonwebtoken.JwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

import static ch.qos.logback.core.joran.spi.ConsoleTarget.findByName;

@Service
@RequiredArgsConstructor
public class AuthService {

    public static final String TOKEN = "token";

    private final AuthenticationManager authenticationManager;
    private final JwtTokenServices jwtTokenServices;
    private final MemberRepository memberRepository;
    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(10);



    public Map<Object, Object> login(UserCredentials data, HttpServletResponse response) {
        try {
            String username = data.getUsername();
            String password= data.getPassword();

            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            List<String> roles = authentication.getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());


            String token = jwtTokenServices.createToken(username, roles);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("roles", roles);
            model.put("token", token);

            //addTokenToCookie(response,token);
            return model;
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }


    public String logout(HttpServletResponse response){
        createLogoutCookie(response);
        return "Token has been removed";
    }

    public Map<Object, Object> register(Member member, HttpServletResponse response){
        UserCredentials userCredentials= UserCredentials.builder().username(member.getUsername()).password(member.getPassword()).build();

        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberRepository.saveAndFlush(member);

        return login(userCredentials,response);
    }

    public Member getCurrentUserObject(HttpServletRequest request) {
        Optional<Cookie> jwtToken =
                Arrays.stream(Optional.ofNullable(request.getCookies()).orElse(new Cookie[]{}))
                        .filter(cookie -> cookie.getName().equals(TOKEN))
                        .findFirst();
        if (jwtToken.isPresent()) {
            UsernamePasswordAuthenticationToken userToken = jwtTokenServices.validateTokenAndExtractUserSpringToken(jwtToken.get().getValue());
            return memberRepository.findByName(userToken.getName()).orElseThrow(EntityNotFoundException::new);
        }
        throw new JwtException("There is no active JwtToken");
    }

    public Long getCurrentUserId(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Optional<Member> member = memberRepository.findByName((String) authentication.getPrincipal());
        if(!member.isPresent()){
            throw new EntityNotFoundException();
        }
        return member.get().getId();
    }


    private void addTokenToCookie(HttpServletResponse response, String token) {
        ResponseCookie cookie = ResponseCookie.from("token", token)
                //.domain("localhost") // should be parameterized
                //.sameSite("Strict")  // CSRF
                .maxAge(Duration.ofHours(24))
                .httpOnly(true)      // XSS
                .secure(false)
                //.path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }

    private void createLogoutCookie(HttpServletResponse response) {
        ResponseCookie cookie = ResponseCookie.from("token", "")
                //.domain("localhost") // should be parameterized
                //.sameSite("Strict")  // CSRF
                .maxAge(0)
                .httpOnly(true)      // XSS
                .path("/")
                .build();
        response.addHeader("Set-Cookie", cookie.toString());
    }
}
