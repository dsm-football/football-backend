package com.github.football.dto.club.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class CheckClubNameResponse {
    private Boolean isDuplicate;
}
