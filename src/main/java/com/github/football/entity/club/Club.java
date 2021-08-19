package com.github.football.entity.club;

import com.github.football.entity.application.ClubApplicant;
import com.github.football.entity.code.Area;
import com.github.football.entity.code.Cycle;
import com.github.football.entity.code.Gender;
import com.github.football.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 150, nullable = false)
    private String main_profile;

    @Column(length = 150, nullable = false)
    private String sub_profile;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(length = 150)
    private String sns;

    @OneToOne(mappedBy = "club_id")
    private ClubApplicant clubApplicant;

    @OneToMany(mappedBy = "club")
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "clubExecutiveId.club")
    private List<ClubExecutive> clubExecutives = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cycle_id", nullable = false)
    private Cycle cycle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;
}
