package com.github.football.service.user;

import com.github.football.dto.user.request.LoginRequest;
import com.github.football.dto.user.request.RegisterRequest;
import com.github.football.dto.user.response.GetUserIdResponse;
import com.github.football.dto.user.response.LinkResponse;
import com.github.football.dto.user.response.LoginResponse;
import com.github.football.dto.user.response.TokenResponse;

public interface UserService {

    LinkResponse getGoogleLink();
    TokenResponse register(RegisterRequest request);
    LoginResponse login(LoginRequest request);
    GetUserIdResponse getUserId();
}
