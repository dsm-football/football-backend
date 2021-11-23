package com.github.football.controller;

import com.github.football.dto.chat.PostChatRoomRequest;
import com.github.football.service.chat.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @PostMapping("room")
    @ResponseStatus(HttpStatus.CREATED)
    public void postChatRoom(@RequestBody PostChatRoomRequest request) {
        chatService.postChatRoom(request);
    }
}
