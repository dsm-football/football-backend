package com.github.football.entity.game;

import com.github.football.entity.game.embedded.GameOptionAgeId;
import org.springframework.data.repository.CrudRepository;

public interface GameOptionAgeRepository extends CrudRepository<GameOptionAge, GameOptionAgeId> {
}
