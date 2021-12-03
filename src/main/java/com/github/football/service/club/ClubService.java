package com.github.football.service.club;

import com.github.football.dto.club.request.*;
import com.github.football.dto.club.response.*;

import java.util.List;

public interface ClubService {

    void postClub(PostClubRequest request);
    GetClubResponse getClub(Long id);
    ToggleApplicantResponse toggleApplicant(ToggleApplicantRequest request);
    GetClubApplicantResponse getClubApplicant();
    List<GetMemberListResponse> getMemberList(Long id);
    void kickMember(KickMemberRequest request);
    void modifyBacknum(ModifyBacknumRequest request);
    CheckClubNameResponse checkClubName(CheckClubNameRequest request);
    List<GetGameApplicantResponse> getGameApplicantResponse();
    List<GetClubListResponse> getClubList(GetClubListRequest request);
}
