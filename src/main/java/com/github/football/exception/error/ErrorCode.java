package com.github.football.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    ALREADY_JOINED_CLUB(400, "Already joined club"),
    ALREADY_USED_NAME(400, "Already used name"),
    APPLICATION_NOT_ALLOWED(400, "Application not allowed"),
    KICK_NOT_ALLOWED(400, "Kick not allowed"),
    MODIFY_NOT_ALLOWED(400, "Modify not allowed"),
    APPLICATION_EXISTS(400, "Application exists"),
    ROOM_EXISTS(400, "Room exists"),
    GAME_EXISTS(400, "Game exists"),
    GAME_LIST_EXISTS(400, "Game list exists"),
    INVALID_TOKEN(401, "Invalid token"),
    EXPIRED_ACCESS_TOKEN(401, "Expired access token"),
    CREDENTIALS_NOT_FOUND(401, "Credentials not found"),
    CLUB_FORBIDDEN(403, "Club forbidden"),
    USER_NOT_FOUND(404, "User not found"),
    AREA_NOT_FOUND(404, "Area not found"),
    CYCLE_NOT_FOUND(404, "Cycle not found"),
    GENDER_NOT_FOUND(404, "Gender not found"),
    AGE_GROUP_NOT_FOUND(404, "Age group not found"),
    CLUB_NOT_FOUND(404, "Club not found"),
    APPLICATION_NOT_FOUND(404, "Application not found"),
    CLUB_APPLICANT_NOT_FOUND(404, "Club applicant not found"),
    POSITION_NOT_FOUND(404, "Position not found"),
    GAME_TYPE_NOT_FOUND(404, "Game type not found"),
    GAME_NOT_FOUND(404, "Game not found"),
    CHAT_HISTORY_NOT_FOUND(404, "Chat history not found");

    private final int status;
    private final String message;
}
