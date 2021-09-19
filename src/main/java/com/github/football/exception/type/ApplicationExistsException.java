package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class ApplicationExistsException extends FootBallException {

    public ApplicationExistsException() {
        super(ErrorCode.APPLICATION_EXISTS);
    }
}
