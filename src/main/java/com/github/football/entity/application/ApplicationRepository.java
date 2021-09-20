package com.github.football.entity.application;

import com.github.football.entity.application.embedded.ApplicationId;
import com.github.football.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ApplicationRepository extends CrudRepository<Application, ApplicationId> {

    List<Application> findByApplicationId_ClubApplicant(ClubApplicant clubApplicant);
}
