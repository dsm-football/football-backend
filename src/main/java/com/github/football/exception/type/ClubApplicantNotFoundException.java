package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class ClubApplicantNotFoundException extends FootBallException {

    public ClubApplicantNotFoundException() {
        super(ErrorCode.CLUB_APPLICANT_NOT_FOUND);
    }
}
