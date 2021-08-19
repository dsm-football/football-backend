package com.github.football.entity.application;

import com.github.football.entity.application.embedded.ApplicationId;
import com.github.football.entity.club.embedded.ClubExecutiveId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class Application {

    @EmbeddedId
    private ApplicationId applicationId;
}
