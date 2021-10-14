package com.github.football.dto.profile.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateProfileRequest {

    private String area;
    private Integer positionId;
    private Integer age;
    private String bio;
}
