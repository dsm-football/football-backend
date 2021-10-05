package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class GameExistsException extends FootBallException {

    public GameExistsException() {
        super(ErrorCode.GAME_EXISTS);
    }
}
