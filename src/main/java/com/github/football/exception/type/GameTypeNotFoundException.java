package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class GameTypeNotFoundException extends FootBallException {

    public GameTypeNotFoundException() {
        super(ErrorCode.GAME_TYPE_NOT_FOUND);
    }
}
