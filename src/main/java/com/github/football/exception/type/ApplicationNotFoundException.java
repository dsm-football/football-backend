package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class ApplicationNotFoundException extends FootBallException {

    public ApplicationNotFoundException() {
        super(ErrorCode.APPLICATION_NOT_FOUND);
    }
}
