package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class AgeGroupNotFoundException extends FootBallException {

    public AgeGroupNotFoundException() {
        super(ErrorCode.AGE_GROUP_NOT_FOUND);
    }
}
