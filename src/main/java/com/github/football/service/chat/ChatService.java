package com.github.football.service.chat;

import com.github.football.dto.chat.PostChatRoomRequest;

public interface ChatService {

    void postChatRoom(PostChatRoomRequest request);
}
