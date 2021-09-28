package com.github.football.entity.code;

import com.github.football.entity.club.Club;
import com.github.football.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "code_area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, nullable = false)
    private String name;

    @Builder
    public Area(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "area")
    private List<User> users = new LinkedList<>();

    @OneToMany(mappedBy = "area")
    private List<Club> clubs = new LinkedList<>();
}
