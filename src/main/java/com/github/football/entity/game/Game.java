package com.github.football.entity.game;

import com.github.football.entity.BaseTimeEntity;
import com.github.football.entity.club.Club;
import com.github.football.entity.code.Area;
import com.github.football.entity.code.GameType;
import com.github.football.entity.win.Win;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Game extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private LocalDate end_date;

    @Column
    private Boolean isWin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "game_type_id")
    private GameType gameType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_club_id")
    private Club hostClub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participants_club_id")
    private Club participantsClub;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;

    @OneToOne(mappedBy = "game")
    private Win win;

    @Builder
    public Game(LocalDateTime date, LocalDate end_date, GameType gameType, Club hostClub, Area area) {
        this.date = date;
        this.end_date = end_date;
        this.gameType = gameType;
        this.hostClub = hostClub;
        this.area = area;
    }
}
