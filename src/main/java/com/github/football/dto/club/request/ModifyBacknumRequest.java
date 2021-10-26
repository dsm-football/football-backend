package com.github.football.dto.club.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ModifyBacknumRequest {

    private Long userId;
    private Integer backNum;
}
