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
@Entity(name = "code_gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 10, nullable = false)
    private String name;

    @OneToMany(mappedBy = "gender")
    private List<User> users = new LinkedList<>();

    @OneToMany(mappedBy = "gender")
    private List<Club> clubs = new LinkedList<>();
}
