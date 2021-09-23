package com.github.football.controller;

import com.github.football.dto.application.request.PostApplicationRequest;
import com.github.football.dto.application.response.GetApplicationResponse;
import com.github.football.service.application.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseEntity postApplication(@RequestBody PostApplicationRequest request) {
        applicationService.postApplication(request);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<GetApplicationResponse>> getApplication() {
        return new ResponseEntity<>(applicationService.getApplication(), HttpStatus.OK);
    }

    @PutMapping("{user_id}")
    public ResponseEntity acceptApplication(@PathVariable("user_id") Long userId) {
        applicationService.acceptApplication(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{user_id}")
    public ResponseEntity rejectApplication(@PathVariable("user_id") Long userId) {
        applicationService.rejectApplication(userId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
