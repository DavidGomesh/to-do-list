package com.petize.todolist.domain.services.auth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.petize.todolist.domain.models.UserAuthenticated;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthenticationService {
    
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    public String authenticate(Authentication authentication) {
        return jwtService.generateToken(authentication);
    }

    public UserAuthenticated getUserAuthenticated() {
        var auth = SecurityContextHolder.getContext().getAuthentication();        
        return (UserAuthenticated) userDetailsService.loadUserByUsername(auth.getName());
    }
}
