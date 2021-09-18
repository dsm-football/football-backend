package com.github.football.entity.application.embedded;

import com.github.football.entity.application.ClubApplicant;
import com.github.football.entity.club.Club;
import com.github.football.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ApplicationId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_applicant_id")
    private ClubApplicant clubApplicant;
}
