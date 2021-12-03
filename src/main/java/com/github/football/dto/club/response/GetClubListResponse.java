package com.github.football.dto.club.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class GetClubListResponse {
    private String name;
    private String profile;
    private String description;
    private String area;
    private String ageGroup;
    private String gender;
    private Long clubId;
    private Long clubMemberCnt;
    private Integer clubApplicationCnt;

    @QueryProjection
    public GetClubListResponse(String name, String profile, String description, String area, String ageGroup, String gender, Long clubId, Long clubMemberCnt, Integer clubApplicationCnt) {
        this.name = name;
        this.profile = profile;
        this.description = description;
        this.area = area;
        this.ageGroup = ageGroup;
        this.gender = gender;
        this.clubId = clubId;
        this.clubMemberCnt = clubMemberCnt;
        this.clubApplicationCnt = clubApplicationCnt;
    }
}
