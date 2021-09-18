package com.github.football.dto.club.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetClubResponse {

    private String mainProfile;
    private String subProfile;
    private String name;
    private String description;
    private String sns;
    private String area;
    private String cycle;
    private String gender;
}
