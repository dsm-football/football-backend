package com.github.football.service.application;

import com.github.football.dto.application.request.PostApplicationRequest;
import com.github.football.entity.application.Application;
import com.github.football.entity.application.ApplicationRepository;
import com.github.football.entity.application.ClubApplicant;
import com.github.football.entity.application.embedded.ApplicationId;
import com.github.football.entity.club.Club;
import com.github.football.entity.club.ClubRepository;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.*;
import com.github.football.security.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ClubRepository clubRepository;
    private final UserRepository userRepository;

    @Override
    public void postApplication(PostApplicationRequest request) {
        Club club = clubRepository.findById(request.getClubId())
                .orElseThrow(ClubNotFoundException::new);

        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        if(user.getClub() != null)
            throw new AlreadyJoinedClubException();

        ClubApplicant clubApplicant = club.getClubApplicant();

        if(clubApplicant.getIsOpen() == false)
            throw new ApplicationNotAllowedException();

        if(applicationRepository.findById(new ApplicationId(user, clubApplicant)).isPresent())
            throw new ApplicationExistsException();

        applicationRepository.save(
                Application.builder()
                        .applicationId(new ApplicationId(user, clubApplicant))
                        .build()
        );
    }
}
