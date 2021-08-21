package com.github.football.entity.game;

import com.github.football.entity.game.embedded.GameListId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class GameList {

    @EmbeddedId
    private GameListId gameListId;

    @Column(nullable = false)
    private Boolean is_accept;
}
