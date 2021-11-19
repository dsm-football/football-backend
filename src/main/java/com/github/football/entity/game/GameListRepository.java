package com.github.football.entity.game;

import com.github.football.entity.game.embedded.GameListId;
import org.springframework.data.repository.CrudRepository;

public interface GameListRepository extends CrudRepository<GameList, GameListId> {
}
