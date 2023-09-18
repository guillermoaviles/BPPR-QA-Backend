package com.bancopopular.qabackend.controller.impl;

import com.bancopopular.qabackend.controller.interfaces.IProfileDataController;
import com.bancopopular.qabackend.model.ProfileData;
import com.bancopopular.qabackend.repository.ProfileDataRepository;
import com.bancopopular.qabackend.service.impl.ProfileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileDataController implements IProfileDataController {

    @Autowired
    ProfileDataRepository profileDataRepository;
    @Autowired
    ProfileDataService profileDataService;

    // **************************************************** GET ***********************************************
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getAllProfiles(){
        return profileDataRepository.findAll();
    }
    @GetMapping("/searchByEnvironment/{environment}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByEnvironment(String environment) {
        return profileDataRepository.findByEnvironment(environment);
    }
    @GetMapping("/searchByIntendedUse/{intendedUse}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByIntendedUse(String intendedUse) {
        return profileDataRepository.findByIntendedUse(intendedUse);
    }
    @GetMapping("/searchByInUse/{inUse}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByInUse(boolean inUse) {
        return profileDataRepository.findByInUse(inUse);
    }
    @GetMapping("/searchByProfileUserId/{profileUserId}")
    @ResponseStatus(HttpStatus.OK)
    public ProfileData getProfilesByProfileUserId(String profileUserId) {
        return profileDataRepository.findByProfileUserId(profileUserId);
    }
    @GetMapping("/searchByUsername/{profileUserId}")
    @ResponseStatus(HttpStatus.OK)
    public ProfileData getProfilesByUsername(String username) {
        return profileDataRepository.findByUsername(username);
    }

    // **************************************************  POST  ******************************************************

    // **************************************************  PUT  *******************************************************

    // *************************************************  PATCH  ******************************************************

    //  ***********************************************  DELETE  ******************************************************
}
