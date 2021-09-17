package com.github.football.controller;

import com.github.football.dto.club.request.PostClubRequest;
import com.github.football.dto.club.request.ToggleApplicantRequest;
import com.github.football.dto.club.response.GetClubApplicantResponse;
import com.github.football.dto.club.response.ToggleApplicantResponse;
import com.github.football.service.club.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/applicant")
    public ResponseEntity<ToggleApplicantResponse> toggleApplicant(@RequestBody ToggleApplicantRequest request) {
        return new ResponseEntity<>(clubService.toggleApplicant(request), HttpStatus.OK);
    }

    @GetMapping("/applicant")
    public ResponseEntity<GetClubApplicantResponse> getClubApplicant() {
        return new ResponseEntity<>(clubService.getClubApplicant(), HttpStatus.OK);
    }
}
