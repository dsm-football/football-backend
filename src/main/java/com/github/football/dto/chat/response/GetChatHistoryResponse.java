package com.github.football.dto.chat.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetChatHistoryResponse {

    private String profile;
    private String name;
    private String lastMessage;
    private Long hostUserId;
    private Long userId;

    @QueryProjection
    public GetChatHistoryResponse(String profile, String name, Long hostUserId, Long userId) {
        this.profile = profile;
        this.name = name;
        this.hostUserId = hostUserId;
        this.userId = userId;
    }

    @Builder
    public GetChatHistoryResponse(String profile, String name, String lastMessage, Long hostUserId, Long userId) {
        this.profile = profile;
        this.name = name;
        this.lastMessage = lastMessage;
        this.hostUserId = hostUserId;
        this.userId = userId;
    }
}
