package com.codecool.jokerchildspring.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenServices jwtTokenServices;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/auth/**").permitAll()
            .antMatchers(HttpMethod.GET,"/card/**").authenticated()
            .antMatchers(HttpMethod.POST,"/card/**").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.PUT,"/card/**").hasAuthority("ADMIN")
            .antMatchers(HttpMethod.DELETE,"/card/**").hasAuthority("ADMIN")
            .antMatchers("/gameHistory/**").authenticated()
            .antMatchers("/gameSession/**").permitAll()
            .antMatchers("/profession/**").hasAuthority("ADMIN")
            //.antMatchers("/school/**").authenticated()
            //.antMatchers("joinRequest").authenticated()
            .antMatchers("/member/**").permitAll()
            .antMatchers("/swagger-ui.html",
                    "/v2/api-docs",
                    "/configuration/ui",
                    "/swagger-resources/**",
                    "/configuration/security",
                    "/webjars/**").permitAll()


            .anyRequest().denyAll()
            .and()
            .addFilterBefore(new JwtTokenFilter2(jwtTokenServices), UsernamePasswordAuthenticationFilter.class);

    }
    
}
