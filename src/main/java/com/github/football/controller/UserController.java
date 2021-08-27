package com.github.football.controller;

import com.github.football.dto.user.response.LinkResponse;
import com.github.football.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/auth/google")
    public ResponseEntity<LinkResponse> getGoogleLink() {
        return new ResponseEntity<>(userService.getGoogleLink(), HttpStatus.OK);
    }
}
