package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class AlreadyUsedNameException extends FootBallException {

    public AlreadyUsedNameException() {
        super(ErrorCode.ALREADY_USED_NAME);
    }
}
