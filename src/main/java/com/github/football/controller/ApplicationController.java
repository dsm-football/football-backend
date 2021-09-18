package com.github.football.controller;

import com.github.football.dto.application.request.PostApplicationRequest;
import com.github.football.service.application.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("application")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postApplicant(@RequestBody PostApplicationRequest request) {
        applicationService.postApplication(request);
    }
}
