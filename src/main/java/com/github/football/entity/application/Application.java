package com.github.football.entity.application;

import com.github.football.entity.application.embedded.ApplicationId;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@NoArgsConstructor
@Entity
public class Application {

    @EmbeddedId
    private ApplicationId applicationId;
}
