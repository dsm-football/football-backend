package com.github.football.exception.type;

import com.github.football.exception.FootBallException;
import com.github.football.exception.error.ErrorCode;

public class ChatHistoryNotFoundException extends FootBallException {

    public ChatHistoryNotFoundException() {
        super(ErrorCode.CHAT_HISTORY_NOT_FOUND);
    }
}
