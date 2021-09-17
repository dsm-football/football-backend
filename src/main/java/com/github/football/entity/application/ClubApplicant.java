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
    private Club clubId;

    @Column(nullable = false)
    private Integer count;

    @Column(nullable = false, name = "is_open")
    private Boolean isOpen;

    @OneToMany(mappedBy = "applicationId.clubApplicant")
    private List<Application> clubApplication = new ArrayList<>();


    @Builder
    public ClubApplicant(Club club_id, Integer count, Boolean isOpen) {
        this.clubId = club_id;
        this.count = count;
        this.isOpen = isOpen;
    }

    public Boolean toggleApplicant(Integer count) {
        this.count = count;
        this.isOpen = !this.isOpen;
        return this.isOpen;
    }
}
