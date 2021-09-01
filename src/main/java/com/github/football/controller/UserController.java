package com.github.football.controller;

import com.github.football.dto.user.response.LinkResponse;
import com.github.football.dto.user.response.TokenResponse;
import com.github.football.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("auth/google")
    @ApiOperation("구글 Oauth 로그인 링크 조회")
    public ResponseEntity<LinkResponse> getGoogleLink() {
        return new ResponseEntity<>(userService.getGoogleLink(), HttpStatus.OK);
    }

    @PostMapping("auth/google")
    @ApiOperation("구글 code로 access token 발급받기")
    public ResponseEntity<TokenResponse> getGoogleTokenByCode(@RequestParam("code") String code) {
        return new ResponseEntity<>(userService.getGoogleTokenByCode(code), HttpStatus.OK);
    }
}
