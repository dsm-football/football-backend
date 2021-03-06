package com.github.football.dto.club.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
public class GetMemberListResponse {

    private Long userId;
    private String profile;
    private String name;
    private String area;
    private Integer age;
    private String gender;
    private String position;
    private Integer clubBackNum;
}
