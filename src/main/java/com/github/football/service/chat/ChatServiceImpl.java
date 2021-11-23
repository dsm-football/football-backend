package com.github.football.service.chat;

import com.github.football.dto.chat.PostChatRoomRequest;
import com.github.football.entity.chat.Room;
import com.github.football.entity.chat.RoomRepository;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.CredentialsNotFoundException;
import com.github.football.exception.type.RoomExistsException;
import com.github.football.security.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

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
}
