package com.github.football.entity.chat;

import com.github.football.entity.chat.embedded.RoomJoinId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class RoomJoin {

    @EmbeddedId
    private RoomJoinId roomJoinId;
}
