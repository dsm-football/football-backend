package com.github.football.entity.club;

import com.github.football.entity.club.embedded.ClubAgeGroupId;
import org.springframework.data.repository.CrudRepository;

public interface ClubAgeRepository extends CrudRepository<ClubAge, ClubAgeGroupId> {
}
