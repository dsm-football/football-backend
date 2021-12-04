package com.github.football.controller;

import com.github.football.dto.user.request.LoginRequest;
import com.github.football.dto.user.request.RegisterRequest;
import com.github.football.dto.user.response.GetUserIdResponse;
import com.github.football.dto.user.response.LinkResponse;
import com.github.football.dto.user.response.LoginResponse;
import com.github.football.dto.user.response.TokenResponse;
import com.github.football.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("auth")
    public GetUserIdResponse getUserId() {
        return  userService.getUserId();
    }

    @GetMapping("auth/google")
    public ResponseEntity<LinkResponse> getGoogleLink() {
        return new ResponseEntity<>(userService.getGoogleLink(), HttpStatus.OK);
    }

    @PostMapping("auth/google")
    public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequest request) {
        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
    }
}
