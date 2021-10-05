package com.github.football.dto.game.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class PostGameRequest {

    private Integer gameType;
    private Integer areaType;
    private LocalDateTime date;
    private LocalDate endDate;
    private Integer personnel;
    private Integer ageType;
    private Integer genderType;
    private Boolean hasReferee;
    private Float longitude;
    private Float latitude;
}
