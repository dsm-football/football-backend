package com.github.football.entity.application;

import com.github.football.entity.club.Club;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class ClubApplicant {

    @Id
    @Column(name = "club_id")
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "club_id")
    private Club club_id;

    @Column(nullable = false)
    private Integer count;

    @Column(nullable = false)
    private Boolean is_open;

    @OneToMany(mappedBy = "applicationId.clubApplicant")
    private List<Application> clubApplication = new ArrayList<>();


    @Builder
    public ClubApplicant(Club club_id, Integer count, Boolean is_open) {
        this.club_id = club_id;
        this.count = count;
        this.is_open = is_open;
    }

    public Boolean toggleApplicant(Integer count) {
        this.count = count;
        this.is_open = !this.is_open;
        return this.is_open;
    }
}
