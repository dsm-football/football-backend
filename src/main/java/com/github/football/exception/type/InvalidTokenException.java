package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class InvalidTokenException extends FootBallException {

    public InvalidTokenException() {
        super(ErrorCode.INVALID_INPUT_VALUE);
    }
}
