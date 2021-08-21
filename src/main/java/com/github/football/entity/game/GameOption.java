package com.github.football.entity.game;

import com.github.football.entity.club.Club;
import com.github.football.entity.code.Gender;
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
    @JoinColumn(name = "game_id")
    private Game game_id;

    @Column(nullable = false)
    private Boolean has_referee;

    @Column(length = 200, nullable = false)
    private String latitude;

    @Column(length = 200, nullable = false)
    private String longitude;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private Gender gender;
}
