package com.github.football.service.profile;

import com.github.football.dto.profile.request.UpdateProfileRequest;
import com.github.football.dto.profile.response.GetProfileResponse;

public interface ProfileService {
    GetProfileResponse getProfile(Long id);
    void updateProfile(UpdateProfileRequest request);
}
