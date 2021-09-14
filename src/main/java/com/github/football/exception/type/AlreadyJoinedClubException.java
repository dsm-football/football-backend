package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class AlreadyJoinedClubException extends FootBallException {

    public AlreadyJoinedClubException() {
        super(ErrorCode.ALREADY_JOINED_CLUB);
    }
}
