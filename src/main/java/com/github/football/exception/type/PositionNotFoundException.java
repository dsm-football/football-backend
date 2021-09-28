package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class PositionNotFoundException extends FootBallException {

    public PositionNotFoundException() {
        super(ErrorCode.POSITION_NOT_FOUND);
    }
}
