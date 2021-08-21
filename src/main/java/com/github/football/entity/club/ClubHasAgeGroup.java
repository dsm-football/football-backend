package com.github.football.entity.club;

import com.github.football.entity.club.embedded.ClubHasAgeGroupId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class ClubHasAgeGroup {

    @EmbeddedId
    private ClubHasAgeGroupId clubHasAgeGroupId;
}
