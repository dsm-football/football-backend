package com.github.football.service.club;

import com.github.football.dto.club.request.ModifyBacknumRequest;
import com.github.football.dto.club.response.GetMemberListResponse;
import com.github.football.dto.club.request.KickMemberRequest;
import com.github.football.dto.club.request.PostClubRequest;
import com.github.football.dto.club.request.ToggleApplicantRequest;
import com.github.football.dto.club.response.GetClubApplicantResponse;
import com.github.football.dto.club.response.GetClubResponse;
import com.github.football.dto.club.response.ToggleApplicantResponse;

import java.util.List;

public interface ClubService {

    void postClub(PostClubRequest request);
    GetClubResponse getClub(Long id);
    ToggleApplicantResponse toggleApplicant(ToggleApplicantRequest request);
    GetClubApplicantResponse getClubApplicant();
    List<GetMemberListResponse> getMemberList(Long id);
    void kickMember(KickMemberRequest request);
    void modifyBacknum(ModifyBacknumRequest request);
}
