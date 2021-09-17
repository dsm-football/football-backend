package com.github.football.dto.club.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetClubApplicantResponse {

    public boolean isOpen;
    public int count;
}
