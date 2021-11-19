package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class GameListExistException extends FootBallException {

    public GameListExistException() {
        super(ErrorCode.GAME_LIST_EXISTS);
    }
}
