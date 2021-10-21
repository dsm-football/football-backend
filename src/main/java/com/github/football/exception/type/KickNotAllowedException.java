package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class KickNotAllowedException extends FootBallException {

    public KickNotAllowedException() {
        super(ErrorCode.KICK_NOT_ALLOWED);
    }
}
