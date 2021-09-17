package com.github.football.service.club;

import com.github.football.dto.club.request.PostClubRequest;
import com.github.football.dto.club.request.ToggleApplicantRequest;
import com.github.football.dto.club.response.GetClubApplicantResponse;
import com.github.football.dto.club.response.ToggleApplicantResponse;

public interface ClubService {

    void postClub(PostClubRequest request);
    ToggleApplicantResponse toggleApplicant(ToggleApplicantRequest request);
    GetClubApplicantResponse getClubApplicant();
}
