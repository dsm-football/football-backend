package com.github.football.entity.game;

import com.github.football.entity.game.embedded.GameListId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameListRepository extends CrudRepository<GameList, GameListId> {
}
