package com.github.football.entity.game;

import com.github.football.entity.game.embedded.GameOptionHasAgeGroupId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class GameOptionHasAgeGroup {

    @EmbeddedId
    private GameOptionHasAgeGroupId gameOptionHasAgeGroupId;
}
