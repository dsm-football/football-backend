package com.github.football.dto.club.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetClubListRequest {
    private Integer areaId;
    private Boolean isApplication;
    private Integer ageGroup;
    private Integer genderId;
}