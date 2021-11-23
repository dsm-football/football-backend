package com.github.football.dto.application.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetApplicationResponse {

    public String name;
    public String area;
    public Integer age;
    public String gender;
    public String profile;
    public Long userId;
}
