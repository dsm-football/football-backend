package com.github.football.util.api.dto.google.response;

import lombok.Getter;

@Getter
public class GoogleTokenResponse {

    private String access_token;
    private String expires_in;
    private String token_type;
    private String scope;
    private String refresh_token;
}
