package com.petize.todolist.api.controllers.impl;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RestController;

import com.petize.todolist.api.controllers.AuthenticationController;
import com.petize.todolist.domain.services.auth.AuthenticationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService authenticationService;

    @Override
    public String authenticate(Authentication authentication) {
        return authenticationService.authenticate(authentication);
    }

}
