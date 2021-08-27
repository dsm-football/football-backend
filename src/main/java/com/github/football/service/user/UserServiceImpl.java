package com.github.football.service.user;

import com.github.football.dto.user.response.LinkResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final String GOOGLE_LOGIN_LINK = "https://accounts.google.com/o/oauth2/v2/auth";

    @Value("${oauth.google.client_id}")
    private String googleClientId;

    @Value("${oauth.google.client_secret}")
    private String googleClientSecret;

    @Value("${oauth.google.redirect_uri}")
    private String googleRedirectUri;

    @Override
    public LinkResponse getGoogleLink() {
        return new LinkResponse(GOOGLE_LOGIN_LINK +
                "?client_id=" + googleClientId +
                "&scope=https://www.googleapis.com/auth/userinfo.email%20https://www.googleapis.com/auth/userinfo.profile" +
                "&response_type=code" +
                "&access_type=offline" +
                "&redirect_uri=" + URLEncoder.encode(googleRedirectUri, StandardCharsets.UTF_8)
        );
    }
}
