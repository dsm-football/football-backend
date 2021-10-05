package com.github.football.controller;

import com.github.football.dto.club.request.PostClubRequest;
import com.github.football.dto.game.request.PostGameRequest;
import com.github.football.service.game.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postGame(@RequestBody PostGameRequest request) {
        gameService.postGame(request);
    }
}
