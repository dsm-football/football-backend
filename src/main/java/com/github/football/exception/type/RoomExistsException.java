package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class RoomExistsException extends FootBallException {

    public RoomExistsException() {
        super(ErrorCode.ROOM_EXISTS);
    }
}
