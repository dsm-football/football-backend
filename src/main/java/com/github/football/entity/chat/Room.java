package com.github.football.entity.chat;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "room")
    private List<Chat> chatList = new ArrayList<>();

    @OneToMany(mappedBy = "roomJoinId.room")
    private List<RoomJoin> roomJoinList = new ArrayList<>();
}
