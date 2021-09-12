package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class CycleNotFoundException extends FootBallException {

    public CycleNotFoundException() {
        super(ErrorCode.CYCLE_NOT_FOUND);
    }
}
