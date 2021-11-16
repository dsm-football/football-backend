package com.github.football.dto.club.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostClubRequest {

    private String name;
    private String description;
    private String mainProfile;
    private String subProfile;
    private String area;
    private int cycleCode;
    private int genderCode;
    private int ageGroupCode;
}
