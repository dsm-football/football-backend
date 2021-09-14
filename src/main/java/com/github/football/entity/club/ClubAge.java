package com.github.football.entity.club;

import com.github.football.entity.club.embedded.ClubAgeGroupId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class ClubAge {

    @EmbeddedId
    private ClubAgeGroupId clubAgeGroupId;

    @Builder
    public ClubAge(ClubAgeGroupId clubAgeGroupId) {
        this.clubAgeGroupId = clubAgeGroupId;
    }
}
