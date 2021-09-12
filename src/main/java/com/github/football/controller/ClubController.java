package com.github.football.controller;

import com.github.football.dto.feed.request.PostClubRequest;
import com.github.football.service.club.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("club")
@RequiredArgsConstructor
public class ClubController {

    private final ClubService clubService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postClub(@RequestBody PostClubRequest request) {
        clubService.postClub(request);
    }
}
