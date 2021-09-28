package com.github.football.entity.code;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AreaRepository extends CrudRepository<Area, Integer> {

    Optional<Area> findByName(String name);
}
