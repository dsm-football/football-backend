package com.github.football.service.chat;

import com.github.football.dto.chat.request.PostChatRoomRequest;
import com.github.football.dto.chat.response.GetChatHistoryResponse;

import java.util.List;

public interface ChatService {

    void postChatRoom(PostChatRoomRequest request);
    List<GetChatHistoryResponse> getChatHistory();
}
