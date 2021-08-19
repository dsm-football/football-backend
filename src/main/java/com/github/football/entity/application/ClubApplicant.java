package com.github.football.entity.application;

import com.github.football.entity.club.Club;
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
}
