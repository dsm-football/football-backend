package com.github.football.controller;

import com.github.football.dto.club.request.*;
import com.github.football.dto.club.response.*;
import com.github.football.service.club.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("{id}")
    public ResponseEntity<GetClubResponse> getClub(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clubService.getClub(id), HttpStatus.OK);
    }

    @GetMapping("{id}/member")
    public ResponseEntity<List<GetMemberListResponse>> getMemberList(@PathVariable("id") Long id) {
        return new ResponseEntity<>(clubService.getMemberList(id), HttpStatus.OK);
    }

    @PostMapping("applicant")
    public ResponseEntity<ToggleApplicantResponse> toggleApplicant(@RequestBody ToggleApplicantRequest request) {
        return new ResponseEntity<>(clubService.toggleApplicant(request), HttpStatus.OK);
    }

    @GetMapping("applicant")
    public ResponseEntity<GetClubApplicantResponse> getClubApplicant() {
        return new ResponseEntity<>(clubService.getClubApplicant(), HttpStatus.OK);
    }

    @PatchMapping("kick")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void kickMember(@RequestBody KickMemberRequest request) {
        clubService.kickMember(request);
    }

    @PatchMapping("backnum")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyBacknum(@RequestBody ModifyBacknumRequest request) {
        clubService.modifyBacknum(request);
    }

    @GetMapping("check")
    public ResponseEntity<CheckClubNameResponse> checkClubName(CheckClubNameRequest request) {
        return new ResponseEntity<>(clubService.checkClubName(request), HttpStatus.OK);
    }
}
