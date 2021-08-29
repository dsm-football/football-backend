package com.github.football.util.api.dto.google.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GoogleTokenRequest {

    private String code;
    private String client_id;
    private String client_secret;
    private String redirect_uri;
    private String grant_type;
}
