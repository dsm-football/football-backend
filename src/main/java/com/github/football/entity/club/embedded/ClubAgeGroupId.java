package com.github.football.entity.club.embedded;

import com.github.football.entity.club.Club;
import com.github.football.entity.code.AgeGroup;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ClubAgeGroupId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "age_group_id")
    private AgeGroup ageGroup;
}
