package com.github.football.entity.game;

import com.github.football.entity.club.Club;
import com.github.football.entity.code.Gender;
import lombok.Builder;
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
    private Game gameId;

    @Column(nullable = false)
    private Boolean hasReferee;

    @Column(nullable = false)
    private Float latitude;

    @Column(nullable = false)
    private Float longitude;

    @Column(nullable = false)
    private Integer personnel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Builder
    public GameOption(Game gameId, Boolean hasReferee, Float latitude, Float longitude, Integer personnel, Gender gender) {
        this.gameId = gameId;
        this.hasReferee = hasReferee;
        this.latitude = latitude;
        this.longitude = longitude;
        this.personnel = personnel;
        this.gender = gender;
    }
}
