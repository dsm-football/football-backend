package com.github.football.entity.game.embedded;

import com.github.football.entity.code.AgeGroup;
import com.github.football.entity.game.GameOption;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class GameOptionHasAgeGroupId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_option_id")
    private GameOption gameOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "age_group_id")
    private AgeGroup ageGroup;
}
