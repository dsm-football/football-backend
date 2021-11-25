package com.github.football.dto.chat.response;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GetChatHistoryResponse {

    private String profile;
    private String name;
    private String lastMessage;

    @QueryProjection
    public GetChatHistoryResponse(String profile, String name) {
        this.profile = profile;
        this.name = name;
    }

    @Builder
    public GetChatHistoryResponse(String profile, String name, String lastMessage) {
        this.profile = profile;
        this.name = name;
        this.lastMessage = lastMessage;
    }
}
