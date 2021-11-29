package com.github.football.dto.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private Boolean isFresh;
    private String accessToken;
    private String refreshToken;
}
