package com.github.football.controller;

import com.github.football.dto.club.response.GetClubResponse;
import com.github.football.dto.profile.request.UpdateProfileRequest;
import com.github.football.dto.profile.response.GetProfileResponse;
import com.github.football.service.profile.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("profile")
@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;
    
    @GetMapping("{id}")
    public ResponseEntity<GetProfileResponse> getProfile(@PathVariable("id") Long id) {
        return new ResponseEntity<>(profileService.getProfile(id), HttpStatus.OK);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(@RequestBody UpdateProfileRequest request) {
        profileService.updateProfile(request);
    }
}
