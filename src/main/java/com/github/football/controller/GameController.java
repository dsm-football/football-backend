package com.github.football.controller;

import com.github.football.dto.game.request.PostGameApplicationRequest;
import com.github.football.dto.game.request.PostGameRequest;
import com.github.football.dto.game.request.PostResultRequest;
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

    @PostMapping("application")
    @ResponseStatus(HttpStatus.CREATED)
    public void postGameApplication(@RequestBody PostGameApplicationRequest request) {
        gameService.postGameApplication(request);
    }

    @PostMapping("result")
    @ResponseStatus(HttpStatus.CREATED)
    public void postResult(@RequestBody PostResultRequest request) {
        gameService.postResult(request);
    }
}
