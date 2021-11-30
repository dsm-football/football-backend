package com.github.football.entity.win;

import com.github.football.entity.club.Club;
import com.github.football.entity.game.Game;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Win {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean gameResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "win_club_id")
    private Club winClubId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lose_club_id")
    private Club loseClubId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_id")
    private Game game;
}
