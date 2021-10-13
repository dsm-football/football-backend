package com.github.football.dto.profile.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

@Getter
@Builder
public class GetProfileResponse {

    private String profile;
    private Boolean isPro;
    private String email;
    private String club;
    private String position;
    private String area;
    private Integer age;
    private String bio;
}
