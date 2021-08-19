package com.github.football.entity.application;

import com.github.football.entity.application.embedded.ClubApplicantHasAgeGroupId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class ClubApplicantHasAgeGroup {

    @EmbeddedId
    private ClubApplicantHasAgeGroupId clubApplicantHasAgeGroupId;
}
