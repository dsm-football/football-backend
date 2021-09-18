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

    @Column(length = 150, nullable = false, name = "main_profile")
    private String mainProfile;

    @Column(length = 150, nullable = false, name = "sub_profile")
    private String subProfile;

    @Column(length = 30, nullable = false, unique = true)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(length = 150)
    private String sns;

    @OneToOne(mappedBy = "clubId")
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
    public Club(String mainProfile, String subProfile, String name, String description, User clubHead, Area area, Cycle cycle, Gender gender) {
        this.mainProfile = mainProfile;
        this.subProfile = subProfile;
        this.name = name;
        this.description = description;
        this.clubHead = clubHead;
        this.area = area;
        this.cycle = cycle;
        this.gender = gender;
    }
}
