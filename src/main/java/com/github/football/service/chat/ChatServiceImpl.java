package com.github.football.service.chat;

import com.github.football.dto.chat.request.PostChatRoomRequest;
import com.github.football.dto.chat.response.GetChatHistoryResponse;
import com.github.football.entity.chat.ChatQuerydslRepository;
import com.github.football.entity.chat.Room;
import com.github.football.entity.chat.RoomRepository;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.ChatHistoryNotFoundException;
import com.github.football.exception.type.CredentialsNotFoundException;
import com.github.football.exception.type.RoomExistsException;
import com.github.football.security.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final ChatQuerydslRepository chatQuerydslRepository;

    @Override
    @Transactional
    public void postChatRoom(PostChatRoomRequest request) {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        User otherUser = userRepository.findById(request.getUserId())
                .orElseThrow(CredentialsNotFoundException::new);

        Room room = roomRepository.findByUserAndHostUser(otherUser, user)
                        .orElse(null);

        if(room != null)
            throw new RoomExistsException();

        roomRepository.save(
                Room.builder()
                        .user(otherUser)
                        .hostUser(user)
                        .build()
        );
    }

    @Override
    public List<GetChatHistoryResponse> getChatHistory() {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        List<Room> userRoomLists = user.getRooms();
        List<Room> hostUserRoomLists = user.getHostRooms();

        List<GetChatHistoryResponse> userChatHistoryResponses = new ArrayList<>();
        List<GetChatHistoryResponse> hostUserChatHistoryResponses;


        if(!userRoomLists.isEmpty()) {
             userChatHistoryResponses = userRoomLists.stream().map(roomList -> {
                System.out.println(roomList);
                GetChatHistoryResponse response;

                response = chatQuerydslRepository.getUserChatHistoryResponses(user, roomList.getId());
                return response;
            }).collect(Collectors.toList());
        }

        if(!hostUserRoomLists.isEmpty()) {
            hostUserChatHistoryResponses = hostUserRoomLists.stream().map(roomList -> {
                System.out.println(roomList);
                GetChatHistoryResponse response;

                response = chatQuerydslRepository.getHostUserChatHistoryResponses(user, roomList.getId());
                return response;
            }).collect(Collectors.toList());

            userChatHistoryResponses.addAll(hostUserChatHistoryResponses);
        }

        if(userChatHistoryResponses.isEmpty())
            throw new ChatHistoryNotFoundException();

        return userChatHistoryResponses;
    }
}
