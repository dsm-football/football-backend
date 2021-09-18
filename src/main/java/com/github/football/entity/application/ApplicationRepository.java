package com.github.football.entity.application;

import com.github.football.entity.application.embedded.ApplicationId;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, ApplicationId> {


}
