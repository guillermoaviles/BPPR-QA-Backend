package com.bancopopular.qabackend.controller.impl;

import com.bancopopular.qabackend.controller.interfaces.IProfileDataController;
import com.bancopopular.qabackend.model.ProfileData;
import com.bancopopular.qabackend.repository.ProfileDataRepository;
import com.bancopopular.qabackend.service.impl.ProfileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/profiles")
public class ProfileDataController implements IProfileDataController {

    @Autowired
    ProfileDataRepository profileDataRepository;
    @Autowired
    ProfileDataService profileDataService;


    public List<ProfileData> getAllProfiles(){
        return profileDataRepository.findAll();
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> searchProfiles(
            @RequestParam(required = false) String pass,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String maidenName,
            @RequestParam(required = false) String birthdate
    ) throws ResponseStatusException {
        try {
            List<ProfileData> results = new ArrayList<>();
            if (pass != null) results.addAll(profileDataRepository.findByPass(pass));
            if (email != null) results.addAll(profileDataRepository.findByEmail(email));
            if (firstName != null) results.addAll(profileDataRepository.findByFirstName(firstName));
            if (lastName != null) results.addAll(profileDataRepository.findByLastName(lastName));
            if (maidenName != null) results.addAll(profileDataRepository.findByMaidenName(maidenName));
            if (birthdate != null) results.addAll(profileDataRepository.findByBirthdate(birthdate));
            return results;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Query params not found", e);
        }

    }
}
