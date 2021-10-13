package com.github.football.service.profile;

import com.github.football.dto.profile.response.GetProfileResponse;
import com.github.football.entity.club.Club;
import com.github.football.entity.code.Area;
import com.github.football.entity.code.Position;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;

    @Override
    public GetProfileResponse getProfile(Long id) {
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        String clubName = Optional.ofNullable(user.getClub())
                .map(Club::getName)
                .orElse(null);

        String areaName = Optional.ofNullable(user.getArea())
                .map(Area::getName)
                .orElse(null);

        String positionType = Optional.ofNullable(user.getPosition())
                .map(Position::getType)
                .orElse(null);

        return GetProfileResponse.builder()
                .age(user.getAge())
                .area(areaName)
                .club(clubName)
                .email(user.getEmail())
                .isPro(user.getIsPro())
                .position(positionType)
                .profile(user.getProfile())
                .bio(user.getBio())
                .build();
    }
}
