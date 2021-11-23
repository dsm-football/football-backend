package com.github.football.entity.chat;

import com.github.football.entity.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoomRepository extends CrudRepository<Room, Long> {

    Optional<Room> findByUserAndHostUser(User user, User hostUSer);
}
