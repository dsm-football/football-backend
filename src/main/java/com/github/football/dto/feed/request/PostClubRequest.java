package com.github.football.dto.feed.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostClubRequest {

    private String name;
    private String description;
    private String mainProfile;
    private String subProfile;
    private int areaCode;
    private int cycleCode;
    private int genderCode;
}
