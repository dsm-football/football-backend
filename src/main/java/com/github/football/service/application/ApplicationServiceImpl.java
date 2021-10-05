package com.github.football.service.application;

import com.github.football.dto.application.request.PostApplicationRequest;
import com.github.football.dto.application.response.GetApplicationResponse;
import com.github.football.entity.application.Application;
import com.github.football.entity.application.ApplicationRepository;
import com.github.football.entity.application.ClubApplicant;
import com.github.football.entity.application.ClubApplicantRepository;
import com.github.football.entity.application.embedded.ApplicationId;
import com.github.football.entity.club.Club;
import com.github.football.entity.club.ClubRepository;
import com.github.football.entity.user.User;
import com.github.football.entity.user.UserRepository;
import com.github.football.exception.type.*;
import com.github.football.security.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationServiceImpl implements ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final ClubRepository clubRepository;
    private final ClubApplicantRepository clubApplicantRepository;
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

        if(!clubApplicant.getIsOpen())
            throw new ApplicationNotAllowedException();

        if(applicationRepository.findById(new ApplicationId(user, clubApplicant)).isPresent())
            throw new ApplicationExistsException();

        applicationRepository.save(
                Application.builder()
                        .applicationId(new ApplicationId(user, clubApplicant))
                        .build()
        );
    }

    @Override
    public List<GetApplicationResponse> getApplication() {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        if (user.getClub_executive() == null)
            throw new ClubForbiddenException();

        ClubApplicant clubApplicant = clubApplicantRepository.findById(user.getClub().getId()).get();

        List<Application> applications = applicationRepository.findByApplicationId_ClubApplicant(clubApplicant);

        return applications.stream().map(application -> {
            User applicationUser = application.getApplicationId().getUser();

            GetApplicationResponse response;
            response = GetApplicationResponse.builder()
                    .name(applicationUser.getName())
                    .area(applicationUser.getArea().getName())
                    .age(applicationUser.getAge())
                    .gender(applicationUser.getGender().getName())
                    .profile(applicationUser.getProfile())
                    .build();
            return response;
        }).collect(Collectors.toList());
    }

    @Override
    public void acceptApplication(Long userId) {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        Club club = clubRepository.findById(user.getClub().getId())
                .orElseThrow(ClubNotFoundException::new);

        if(user.getClub_executive() == null)
            throw new ClubForbiddenException();

        User applicant = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        ClubApplicant clubApplicant = clubApplicantRepository.findById(club.getId())
                .orElseThrow(ClubApplicantNotFoundException::new);

        Application application = applicationRepository.findById(new ApplicationId(applicant, clubApplicant))
                .orElseThrow(ApplicationNotFoundException::new);

        applicant.accept(club);
        applicationRepository.delete(application);
    }

    @Override
    public void rejectApplication(Long userId) {
        User user = userRepository.findByEmail(UserFacade.getEmail())
                .orElseThrow(CredentialsNotFoundException::new);

        Club club = clubRepository.findById(user.getClub().getId())
                .orElseThrow(ClubNotFoundException::new);

        if(user.getClub_executive() == null)
            throw new ClubForbiddenException();

        User applicant = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        ClubApplicant clubApplicant = clubApplicantRepository.findById(club.getId())
                .orElseThrow(ClubApplicantNotFoundException::new);

        Application application = applicationRepository.findById(new ApplicationId(applicant, clubApplicant))
                .orElseThrow(ApplicationNotFoundException::new);

        applicationRepository.delete(application);
    }
}
