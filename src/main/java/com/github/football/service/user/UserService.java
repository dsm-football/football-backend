package com.github.football.service.user;

import com.github.football.dto.user.request.GetGoogleTokenByCodeRequest;
import com.github.football.dto.user.response.LinkResponse;
import com.github.football.dto.user.response.TokenResponse;

public interface UserService {

    LinkResponse getGoogleLink();
    TokenResponse getGoogleTokenByCode(GetGoogleTokenByCodeRequest request);
}
