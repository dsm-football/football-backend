package com.github.football.exception;

import com.github.football.exception.error.ErrorCode;

public class UserNotFoundException extends FootBallException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
