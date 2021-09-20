package com.github.football.service.application;

import com.github.football.dto.application.request.PostApplicationRequest;
import com.github.football.dto.application.response.GetApplicationResponse;

import java.util.List;

public interface ApplicationService {

    void postApplication(PostApplicationRequest request);
    List<GetApplicationResponse> getApplication();
}
