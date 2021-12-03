package com.github.football.entity.chat;

import com.github.football.dto.chat.response.GetChatHistoryResponse;
import com.github.football.dto.chat.response.QGetChatHistoryResponse;
import com.github.football.entity.user.User;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.github.football.entity.chat.QChat.chat;
import static com.github.football.entity.chat.QRoom.room;
import static com.github.football.entity.club.QClub.club;

@Repository
@RequiredArgsConstructor
public class ChatQuerydslRepository {

    private final JPAQueryFactory queryFactory;

    public GetChatHistoryResponse getUserChatHistoryResponses(User user, Long roomId) {
        String lastMessage = queryFactory.select(chat.message)
                .from(chat)
                .where(room.id.eq(roomId))
                .orderBy(chat.created_at.desc())
                .fetchFirst();

        GetChatHistoryResponse getChatHistoryResponse = queryFactory
                .select(new QGetChatHistoryResponse(
                        club.mainProfile.as("profile"),
                        club.name.as("name"),
                        room.hostUser.id.as("hostUserId"),
                        room.user.id.as("userId")
                ))
                .from(room)
                .innerJoin(room.user.club, club)
                .where(room.user.eq(user))
                .fetchOne();

        return GetChatHistoryResponse.builder()
                .name(getChatHistoryResponse.getName())
                .profile(getChatHistoryResponse.getProfile())
                .lastMessage(lastMessage)
                .build();
    }

    public GetChatHistoryResponse getHostUserChatHistoryResponses(User user, Long roomId) {
        String lastMessage = queryFactory.select(chat.message)
                .from(chat)
                .where(room.id.eq(roomId))
                .orderBy(chat.created_at.desc())
                .fetchFirst();

        GetChatHistoryResponse getChatHistoryResponse = queryFactory
                .select(new QGetChatHistoryResponse(
                        club.mainProfile.as("profile"),
                        club.name.as("name"),
                        room.hostUser.id.as("hostUserId"),
                        room.user.id.as("userId")
                ))
                .from(room)
                .innerJoin(room.user.club, club)
                .where(room.hostUser.eq(user))
                .fetchOne();

        return GetChatHistoryResponse.builder()
                .name(getChatHistoryResponse.getName())
                .profile(getChatHistoryResponse.getProfile())
                .lastMessage(lastMessage)
                .build();
    }
}
