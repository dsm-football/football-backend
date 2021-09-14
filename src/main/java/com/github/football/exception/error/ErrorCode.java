package com.github.football.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    INVALID_INPUT_VALUE(400, "Invalid input value."),
    EXPIRED_ACCESS_TOKEN(401, "Expired access token"),
    CREDENTIALS_NOT_FOUND(401, "Credentials not found"),
    USER_NOT_FOUND(404, "User not found"),
    AREA_NOT_FOUND(404, "Area not found"),
    CYCLE_NOT_FOUND(404, "Cycle not found"),
    GENDER_NOT_FOUND(404, "Gender not found");

    private final int status;
    private final String message;
}