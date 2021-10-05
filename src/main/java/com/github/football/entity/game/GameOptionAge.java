package com.github.football.entity.game;

import com.github.football.entity.game.embedded.GameOptionAgeId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class GameOptionAge {

    @EmbeddedId
    private GameOptionAgeId gameOptionAgeId;

    @Builder
    public GameOptionAge(GameOptionAgeId gameOptionAgeId) {
        this.gameOptionAgeId = gameOptionAgeId;
    }
}
