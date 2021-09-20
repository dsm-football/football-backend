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
    @ResponseStatus(HttpStatus.CREATED)
    public void postApplication(@RequestBody PostApplicationRequest request) {
        applicationService.postApplication(request);
    }

    @GetMapping
    public ResponseEntity<List<GetApplicationResponse>> getApplication() {
        return new ResponseEntity<>(applicationService.getApplication(), HttpStatus.OK);
    }
}
