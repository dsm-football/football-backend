package com.github.football.service.club;

import com.github.football.dto.club.request.PostClubRequest;
import com.github.football.dto.club.request.ToggleApplicantRequest;
import com.github.football.dto.club.response.GetClubApplicantResponse;
import com.github.football.dto.club.response.ToggleApplicantResponse;
import com.github.football.entity.application.ClubApplicant;
import com.github.football.entity.application.ClubApplicantRepository;
import com.github.football.entity.club.Club;
import com.github.football.entity.club.ClubAge;
import com.github.football.entity.club.ClubAgeRepository;
import com.github.football.entity.club.ClubRepository;
import com.github.football.entity.club.embedded.ClubAgeGroupId;
import com.github.football.entity.code.*;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.*;
import com.github.football.security.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ClubServiceImpl implements ClubService {

    private final UserRepository userRepository;
    private final ClubRepository clubRepository;
    private final ClubAgeRepository clubAgeRepository;
    private final AreaRepository areaRepository;
    private final CycleRepository cycleRepository;
    private final GenderRepository genderRepository;
    private final AgeGroupRepository ageGroupRepository;
    private final ClubApplicantRepository clubApplicantRepository;

    @Override
    @Transactional
    public void postClub(PostClubRequest request) {
        if (clubRepository.findByName(request.getName()).isPresent())
            throw new AlreadyUsedNameException();

        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        if (user.getClub() != null)
            throw new AlreadyJoinedClubException();

        Area area = areaRepository.findById(request.getAreaCode())
                .orElseThrow(AreaNotFoundException::new);

        Cycle cycle = cycleRepository.findById(request.getCycleCode())
                .orElseThrow(CycleNotFoundException::new);

        Gender gender = genderRepository.findById(request.getGenderCode())
                .orElseThrow(GenderNotFoundException::new);

        AgeGroup ageGroup = ageGroupRepository.findById(request.getAgeGroupCode())
                .orElseThrow(AgeGroupNotFoundException::new);

        Club club = clubRepository.save(
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

        clubAgeRepository.save(
                ClubAge.builder()
                        .clubAgeGroupId(new ClubAgeGroupId(club, ageGroup))
                        .build()
        );

        clubApplicantRepository.save(
                ClubApplicant.builder()
                        .club_id(club)
                        .count(0)
                        .isOpen(false)
                        .build()
        );

        user.postClub(club);
    }

    @Override
    @Transactional
    public ToggleApplicantResponse toggleApplicant(ToggleApplicantRequest request) {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        if (user.getClub_executive() == null)
            throw new ClubForbiddenException();

        ClubApplicant clubApplicant = user.getClub().getClubApplicant();
        int tempCount = request.count == 0 ? clubApplicant.getCount() : request.count;
        Boolean is_open = clubApplicant.toggleApplicant(tempCount);

        return new ToggleApplicantResponse(is_open);
    }

    @Override
    public GetClubApplicantResponse getClubApplicant() {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        if(user.getClub_executive() == null)
            throw new ClubForbiddenException();

        ClubApplicant clubApplicant = user.getClub().getClubApplicant();
        return new GetClubApplicantResponse(clubApplicant.getIsOpen(), clubApplicant.getCount());
    }
}
