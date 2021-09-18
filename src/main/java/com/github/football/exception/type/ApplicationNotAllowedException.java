package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class ApplicationNotAllowedException extends FootBallException {

    public ApplicationNotAllowedException() {
        super(ErrorCode.APPLICATION_NOT_ALLOWED);
    }
}
