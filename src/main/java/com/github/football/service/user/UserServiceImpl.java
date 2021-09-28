package com.github.football.service.user;

import com.github.football.dto.user.request.GetGoogleTokenByCodeRequest;
import com.github.football.dto.user.response.LinkResponse;
import com.github.football.dto.user.response.TokenResponse;
import com.github.football.entity.code.*;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.GenderNotFoundException;
import com.github.football.exception.type.PositionNotFoundException;
import com.github.football.exception.type.UserNotFoundException;
import com.github.football.security.jwt.JwtTokenProvider;
import com.github.football.util.api.client.google.GoogleAuthClient;
import com.github.football.util.api.client.google.GoogleInfoClient;
import com.github.football.util.api.dto.google.response.GoogleInfoResponse;
import com.github.football.util.api.dto.google.response.GoogleTokenResponse;
import com.github.football.util.api.dto.google.request.GoogleTokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

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

    private final GoogleAuthClient googleAuthClient;
    private final GoogleInfoClient googleInfoClient;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final AreaRepository areaRepository;
    private final PositionRepository positionRepository;
    private final GenderRepository genderRepository;

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

    @Override
    public TokenResponse getGoogleTokenByCode(GetGoogleTokenByCodeRequest request) {
        GoogleTokenResponse response = googleAuthClient.getTokenByCode(
                new GoogleTokenRequest(URLDecoder.decode(request.getCode(), StandardCharsets.UTF_8),
                        googleClientId, googleClientSecret, googleRedirectUri, "authorization_code")
        );

        GoogleInfoResponse info = googleInfoClient.getInfo("Bearer" + response.getAccess_token());
        String email = info.getEmail();

        Area area = areaRepository.findByName(request.getArea()).orElseGet(() -> areaRepository.save(
                Area.builder()
                        .name(request.getArea())
                        .build()
        ));
        Gender gender = genderRepository.findById(request.getGenderId())
                .orElseThrow(GenderNotFoundException::new);
        Position position = positionRepository.findById(request.getPositionId())
                .orElseThrow(PositionNotFoundException::new);

        if(userRepository.findByEmail(email).isEmpty()) {
            userRepository.save(
                    User.builder()
                            .email(email)
                            .profile(info.getPicture())
                            .name(request.getName())
                            .age(request.getAge())
                            .area(area)
                            .gender(gender)
                            .position(position)
                            .build()
            );
        }

        return getToken(email);
    }

    private TokenResponse getToken(String email) {
        String accessToken = jwtTokenProvider.generateAccessToken(email);
        String refreshToken = jwtTokenProvider.generateRefreshToken(email);

        return new TokenResponse(accessToken, refreshToken);
    }
}
