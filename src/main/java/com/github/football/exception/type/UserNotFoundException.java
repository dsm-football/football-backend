package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class UserNotFoundException extends FootBallException {

    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
