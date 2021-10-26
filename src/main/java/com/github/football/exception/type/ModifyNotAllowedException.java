package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class ModifyNotAllowedException extends FootBallException {

    public ModifyNotAllowedException() {
        super(ErrorCode.MODIFY_NOT_ALLOWED);
    }
}
