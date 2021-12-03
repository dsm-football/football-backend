package com.github.football.dto.game.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostResultRequest {
    private Long gameId;
    private Integer hostScore;
    private Integer participantScore;
}
