package com.bancopopular.qabackend.controller;

import com.bancopopular.qabackend.service.ProfileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profiles")
public class ProfileDataController {

    @Autowired
    ProfileDataService profileDataService;
}
