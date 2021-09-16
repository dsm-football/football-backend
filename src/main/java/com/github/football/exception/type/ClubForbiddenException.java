package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class ClubForbiddenException extends FootBallException {

    public ClubForbiddenException() {
        super(ErrorCode.CLUB_FORBIDDEN);
    }
}
