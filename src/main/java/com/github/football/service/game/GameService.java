package com.github.football.service.game;

import com.github.football.dto.game.request.PostGameApplicationRequest;
import com.github.football.dto.game.request.PostGameRequest;

public interface GameService {
    void postGame(PostGameRequest request);
    void postGameApplication(PostGameApplicationRequest request);
}
