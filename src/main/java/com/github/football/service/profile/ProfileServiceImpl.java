package com.github.football.service.profile;

import com.github.football.dto.profile.request.UpdateProfileRequest;
import com.github.football.dto.profile.response.GetProfileResponse;
import com.github.football.entity.club.Club;
import com.github.football.entity.code.*;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.AreaNotFoundException;
import com.github.football.exception.type.CredentialsNotFoundException;
import com.github.football.exception.type.PositionNotFoundException;
import com.github.football.exception.type.UserNotFoundException;
import com.github.football.security.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;
    private final PositionRepository positionRepository;
    private final AreaRepository areaRepository;

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

        String genderName = Optional.ofNullable(user.getGender())
                .map(Gender::getName)
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
                .gender(genderName)
                .name(user.getName())
                .build();
    }

    @Override
    @Transactional
    public void updateProfile(UpdateProfileRequest request) {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        Position position = positionRepository.findById(request.getPositionId())
                        .orElseThrow(PositionNotFoundException::new);

        Area area = areaRepository.findByName(request.getArea()).orElseGet(() -> areaRepository.save(
                Area.builder()
                        .name(request.getArea())
                        .build()
        ));
        user.updateProfile(request.getAge(), position, area, request.getBio());
    }
}
