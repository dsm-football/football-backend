package com.github.football.exception;

import com.github.football.exception.error.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FootBallException extends RuntimeException {

    private ErrorCode errorCode;
}
