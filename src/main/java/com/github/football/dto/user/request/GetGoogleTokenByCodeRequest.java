package com.github.football.dto.user.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetGoogleTokenByCodeRequest {

    private String code;
    private String name;
    private Integer age;
    private Boolean isPro;
    private Integer positionId;
    private Integer genderId;
    private String area;
}
