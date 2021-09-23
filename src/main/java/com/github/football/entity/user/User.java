package com.github.football.entity.user;

import com.github.football.entity.application.Application;
import com.github.football.entity.club.Club;
import com.github.football.entity.code.Area;
import com.github.football.entity.code.Gender;
import com.github.football.entity.code.Position;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false, unique = true)
    private String email;

    @Column(length = 16, nullable = false)
    private String name;

    @Column(length = 150, nullable = false)
    private String profile;

    @Column
    private Integer age;

    @OneToMany(mappedBy = "applicationId.user")
    private List<Application> applications = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_id")
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "club_executive_id")
    private Club club_executive;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Builder
    public User(String email, String profile, String name) {
        this.email = email;
        this.profile = profile;
        this.name = name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void postClub(Club club) {
        this.club = club;
        this.club_executive = club;
    }

    public void accept(Club club) {
        this.club = club;
    }
}
