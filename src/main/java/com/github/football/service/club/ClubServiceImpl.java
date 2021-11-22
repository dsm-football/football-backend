package com.github.football.service.club;

import com.github.football.dto.club.request.*;
import com.github.football.dto.club.response.*;
import com.github.football.entity.application.ClubApplicant;
import com.github.football.entity.application.ClubApplicantRepository;
import com.github.football.entity.club.Club;
import com.github.football.entity.club.ClubAge;
import com.github.football.entity.club.ClubAgeRepository;
import com.github.football.entity.club.ClubRepository;
import com.github.football.entity.club.embedded.ClubAgeGroupId;
import com.github.football.entity.code.*;
import com.github.football.entity.game.GameList;
import com.github.football.entity.game.GameListRepository;
import com.github.football.entity.game.embedded.GameListId;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.*;
import com.github.football.security.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private final GameListRepository gameListRepository;

    @Override
    @Transactional
    public void postClub(PostClubRequest request) {
        if (clubRepository.findByName(request.getName()).isPresent())
            throw new AlreadyUsedNameException();

        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        if (user.getClub() != null)
            throw new AlreadyJoinedClubException();

        Area area = areaRepository.findByName(request.getArea()).orElseGet(() -> areaRepository.save(
                Area.builder()
                        .name(request.getArea())
                        .build()
        ));

        Cycle cycle = cycleRepository.findById(request.getCycleCode())
                .orElseThrow(CycleNotFoundException::new);

        Gender gender = genderRepository.findById(request.getGenderCode())
                .orElseThrow(GenderNotFoundException::new);

        AgeGroup ageGroup = ageGroupRepository.findById(request.getAgeGroupCode())
                .orElseThrow(AgeGroupNotFoundException::new);

        Club club = clubRepository.save(
                Club.builder()
                        .mainProfile(request.getMainProfile())
                        .subProfile(request.getSubProfile())
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
    public GetClubResponse getClub(Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(ClubNotFoundException::new);

        return new GetClubResponse(club.getMainProfile(), club.getSubProfile(), club.getName(), club.getDescription(), club.getSns(),
                club.getArea().getName(), club.getCycle().getName(), club.getGender().getName());
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

    @Override
    public List<GetMemberListResponse> getMemberList(Long id) {
        Club club = clubRepository.findById(id)
                .orElseThrow(ClubNotFoundException::new);

        return club.getUsers().stream().map(user -> {

            Integer clubBackNum = Optional.ofNullable(user.getClubBackNum())
                    .orElse(null);

            GetMemberListResponse response;
            response = GetMemberListResponse.builder()
                    .age(user.getAge())
                    .clubBackNum(clubBackNum)
                    .area(user.getArea().getName())
                    .position(user.getPosition().getType())
                    .profile(user.getProfile())
                    .name(user.getName())
                    .gender(user.getGender().getName())
                    .userId(user.getId())
                    .build();
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void kickMember(KickMemberRequest request) {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);
        if (user.getClub_executive() == null)
            throw new ClubForbiddenException();

        User member = userRepository.findById(request.getUserId())
                .orElseThrow(UserNotFoundException::new);
        if(user.getClub() != member.getClub() || member.getClub_executive() != null)
            throw new KickNotAllowedException();
        member.kicked();
    }

    @Override
    @Transactional
    public void modifyBacknum(ModifyBacknumRequest request) {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);
        if (user.getClub_executive() == null)
            throw new ClubForbiddenException();

        User member = userRepository.findById(request.getUserId())
                .orElseThrow(UserNotFoundException::new);
        if(user.getClub() != member.getClub())
            throw new ModifyNotAllowedException();
        member.setClubBackNum(request.getBackNum());
    }

    @Override
    public CheckClubNameResponse checkClubName(CheckClubNameRequest request) {
        Club club = clubRepository.findByName(request.getName())
                .orElse(null);

        return new CheckClubNameResponse(club != null);
    }

    @Override
    public List<GetGameApplicantResponse> getGameApplicantResponse() {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);
        if(user.getClub_executive() == null)
            throw new ClubForbiddenException();

        Club club = user.getClub();
        List<GameList> gameLists = club.getGameLists();

        return gameLists.stream().map(gameList -> {
            Club gameListClub = gameList.getGameListId().getClub();

           GetGameApplicantResponse response;
           response = GetGameApplicantResponse.builder()
                   .clubProfile(gameListClub.getMainProfile())
                   .clubName(gameListClub.getName())
                   .clubId(gameListClub.getId())
                   .build();
           return response;
        }).collect(Collectors.toList());
    }
}