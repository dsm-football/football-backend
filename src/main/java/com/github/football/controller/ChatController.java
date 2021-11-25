package com.github.football.controller;

import com.github.football.dto.chat.request.PostChatRoomRequest;
import com.github.football.dto.chat.response.GetChatHistoryResponse;
import com.github.football.service.chat.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("history")
    public ResponseEntity<List<GetChatHistoryResponse>> getChatHistory() {
        return new ResponseEntity<>(chatService.getChatHistory(), HttpStatus.OK);
    }
}
