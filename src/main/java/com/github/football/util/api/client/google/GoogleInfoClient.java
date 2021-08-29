package com.github.football.util.api.client.google;

import com.github.football.util.api.dto.google.response.GoogleInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "googleInfoClient", url = "https://openidconnect.googleapis.com")
public interface GoogleInfoClient {

    @GetMapping("/v1/userinfo")
    GoogleInfoResponse getInfo(@RequestHeader("Authorization") String accessToken);
}
