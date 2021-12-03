package com.github.football.entity.club;

import com.github.football.dto.club.request.GetClubListRequest;
import com.github.football.dto.club.response.GetClubListResponse;

import java.util.List;

public interface ClubRepositoryCustom {
    List<GetClubListResponse> getClubsByFilter(GetClubListRequest request);
}
