package com.github.football.util.api.client.google;

import com.github.football.util.api.dto.google.response.GoogleTokenResponse;
import com.github.football.util.api.dto.google.request.GoogleTokenRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(value = "googleAuthClient", url = "https://oauth2.googleapis.com")
public interface GoogleAuthClient {

    @PostMapping(value = "/token")
    GoogleTokenResponse getTokenByCode(GoogleTokenRequest request);
}
