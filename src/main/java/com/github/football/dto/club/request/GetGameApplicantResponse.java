package com.github.football.dto.club.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetGameApplicantResponse {
    private String clubProfile;
    private String clubName;
    private Long clubId;
}
