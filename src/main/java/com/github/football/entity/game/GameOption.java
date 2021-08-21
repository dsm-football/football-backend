package com.github.football.entity.game;

import com.github.football.entity.club.Club;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class GameOption {

    @Id
    @Column(name = "club_id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "club_id")
    private Club club_id;
}
