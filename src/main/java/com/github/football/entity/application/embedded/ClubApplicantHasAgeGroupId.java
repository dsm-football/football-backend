package com.github.football.entity.application.embedded;

import com.github.football.entity.application.ClubApplicant;
import com.github.football.entity.club.Club;
import com.github.football.entity.code.AgeGroup;
import com.github.football.entity.user.User;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@Embeddable
public class ClubApplicantHasAgeGroupId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_applicant_id")
    private ClubApplicant clubApplicant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "age_group_id")
    private AgeGroup ageGroup;
}
