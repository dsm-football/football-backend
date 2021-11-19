package com.github.football.service.game;

import com.github.football.dto.game.request.PostGameApplicationRequest;
import com.github.football.dto.game.request.PostGameRequest;
import com.github.football.entity.club.Club;
import com.github.football.entity.club.ClubRepository;
import com.github.football.entity.code.*;
import com.github.football.entity.game.*;
import com.github.football.entity.game.embedded.GameListId;
import com.github.football.entity.game.embedded.GameOptionAgeId;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.*;
import com.github.football.security.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final GameTypeRepository gameTypeRepository;
    private final AreaRepository areaRepository;
    private final GameOptionRepository gameOptionRepository;
    private final GenderRepository genderRepository;
    private final GameOptionAgeRepository gameOptionAgeRepository;
    private final GameListRepository gameListRepository;
    private final AgeGroupRepository ageGroupRepository;

    @Override
    @Transactional
    public void postGame(PostGameRequest request) {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        if (user.getClub_executive() == null)
            throw new ClubForbiddenException();

        Club club = user.getClub();

        if (gameRepository.findByHostClub(club).isPresent())
            throw new GameExistsException();

        GameType gameType = gameTypeRepository.findById(request.getGameType())
                .orElseThrow(GameTypeNotFoundException::new);

        Area area = areaRepository.findByName(request.getArea()).orElseGet(() -> areaRepository.save(
                Area.builder()
                        .name(request.getArea())
                        .build()
        ));

        Gender gender = genderRepository.findById(request.getGenderType())
                .orElseThrow(GenderNotFoundException::new);

        AgeGroup ageGroup = ageGroupRepository.findById(request.getAgeType())
                .orElseThrow(AgeGroupNotFoundException::new);

        Game game = gameRepository.save(
                Game.builder()
                        .gameType(gameType)
                        .date(request.getDate())
                        .end_date(request.getEndDate())
                        .hostClub(club)
                        .area(area)
                        .build()
        );

        GameOption gameOption = gameOptionRepository.save(
                GameOption.builder()
                        .gameId(game)
                        .longitude(request.getLongitude())
                        .latitude(request.getLatitude())
                        .gender(gender)
                        .hasReferee(request.getHasReferee())
                        .personnel(request.getPersonnel())
                        .build()
        );

        gameOptionAgeRepository.save(
                GameOptionAge.builder()
                        .gameOptionAgeId(new GameOptionAgeId(gameOption, ageGroup))
                        .build()
        );
    }

    @Override
    @Transactional
    public void postGameApplication(PostGameApplicationRequest request) {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        if (user.getClub_executive() == null)
            throw new ClubForbiddenException();

        Game game = gameRepository.findById(request.getGameId())
                .orElseThrow(GameNotFoundException::new);

        Club club = user.getClub();

        GameList gameList = gameListRepository.findById(new GameListId(game, club))
                .orElse(null);

        if(gameList != null)
            throw new GameListExistException();

        gameListRepository.save(
                GameList.builder()
                        .gameListId(new GameListId(game, club))
                        .is_accept(false)
                        .build());
    }
}
