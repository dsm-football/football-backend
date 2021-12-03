package com.github.football.entity.game;

import com.github.football.entity.club.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findByHostClub(Club club);
    Optional<Game> findByIdAndHostClub(Long gameId, Club hostClub);
}
