package com.github.football.entity.code;

import com.github.football.entity.club.Club;
import com.github.football.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity(name = "code_cycle")
public class Cycle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 30, nullable = false)
    private String name;

    @OneToMany(mappedBy = "cycle")
    private List<Club> clubs = new LinkedList<>();
}
