package com.github.football.entity.club;

import com.github.football.entity.application.ClubApplicant;
import com.github.football.entity.code.Area;
import com.github.football.entity.code.Cycle;
import com.github.football.entity.code.Gender;
import com.github.football.entity.user.User;
import lombok.Builder;
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_head")
    private User clubHead;

    @OneToMany(mappedBy = "club", cascade = CascadeType.PERSIST)
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "club_executive")
    private List<User> executiveUsers = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cycle_id", nullable = false)
    private Cycle cycle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id", nullable = false)
    private Gender gender;

    @Builder
    public Club(String main_profile, String sub_profile, String name, String description, User clubHead, Area area, Cycle cycle, Gender gender) {
        this.main_profile = main_profile;
        this.sub_profile = sub_profile;
        this.name = name;
        this.description = description;
        this.clubHead = clubHead;
        this.area = area;
        this.cycle = cycle;
        this.gender = gender;
    }
}
