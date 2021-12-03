package com.github.football.service.game;

import com.github.football.dto.game.request.PostGameApplicationRequest;
import com.github.football.dto.game.request.PostGameRequest;
import com.github.football.dto.game.request.PostResultRequest;

public interface GameService {
    void postGame(PostGameRequest request);
    void postGameApplication(PostGameApplicationRequest request);
    void postResult(PostResultRequest request);
}
