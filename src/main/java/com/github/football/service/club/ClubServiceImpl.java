package com.github.football.service.club;

import com.github.football.dto.feed.request.PostClubRequest;
import com.github.football.entity.club.Club;
import com.github.football.entity.club.ClubRepository;
import com.github.football.entity.code.*;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.AreaNotFoundException;
import com.github.football.exception.type.CredentialsNotFoundException;
import com.github.football.exception.type.CycleNotFoundException;
import com.github.football.exception.type.GenderNotFoundException;
import com.github.football.security.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final UserRepository userRepository;
    private final ClubRepository clubRepository;
    private final AreaRepository areaRepository;
    private final CycleRepository cycleRepository;
    private final GenderRepository genderRepository;

    @Override
    public void postClub(PostClubRequest request) {

        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        Area area = areaRepository.findById(request.getAreaCode())
                .orElseThrow(AreaNotFoundException::new);

        Cycle cycle = cycleRepository.findById(request.getCycleCode())
                .orElseThrow(CycleNotFoundException::new);

        Gender gender = genderRepository.findById(request.getGenderCode())
                .orElseThrow(GenderNotFoundException::new);

        clubRepository.save(
                Club.builder()
                        .main_profile(request.getMainProfile())
                        .sub_profile(request.getSubProfile())
                        .name(request.getName())
                        .description(request.getDescription())
                        .area(area)
                        .cycle(cycle)
                        .gender(gender)
                        .clubHead(user).build()
        );
    }
}
