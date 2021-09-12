package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class GenderNotFoundException extends FootBallException {

    public GenderNotFoundException() {
        super(ErrorCode.GENDER_NOT_FOUND);
    }
}
