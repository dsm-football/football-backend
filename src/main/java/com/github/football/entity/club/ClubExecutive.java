package com.github.football.entity.club;

import com.github.football.entity.club.embedded.ClubExecutiveId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class ClubExecutive {

    @EmbeddedId
    private ClubExecutiveId clubExecutiveId;
}
