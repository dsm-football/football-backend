package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class GameNotFoundException extends FootBallException {

    public GameNotFoundException() {
        super(ErrorCode.GAME_TYPE_NOT_FOUND);
    }
}
