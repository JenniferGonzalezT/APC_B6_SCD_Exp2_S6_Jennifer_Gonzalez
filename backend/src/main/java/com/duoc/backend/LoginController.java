package com.duoc.backend;

import com.duoc.backend.user.MyUserDetailsService;
import com.duoc.backend.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder; // IMPORTANTE AGREGAR ESTO
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {

    @Autowired
    JWTAuthenticationConfig jwtAuthtenticationConfig;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("login")
    public String login(@RequestBody User loginRequest) {

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());

        if (!passwordEncoder.matches(loginRequest.getPassword(), userDetails.getPassword())) {
            throw new RuntimeException("Invalid login");
        }

        String token = jwtAuthtenticationConfig.getJWTToken(loginRequest.getUsername());
        return token;
    }
}