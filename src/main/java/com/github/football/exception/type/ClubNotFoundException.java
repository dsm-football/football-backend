package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class ClubNotFoundException extends FootBallException {

    public ClubNotFoundException() {
        super(ErrorCode.CLUB_NOT_FOUND);
    }
}
