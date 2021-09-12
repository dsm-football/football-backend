package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class AreaNotFoundException extends FootBallException {

    public AreaNotFoundException() {
        super(ErrorCode.AREA_NOT_FOUND);
    }
}
