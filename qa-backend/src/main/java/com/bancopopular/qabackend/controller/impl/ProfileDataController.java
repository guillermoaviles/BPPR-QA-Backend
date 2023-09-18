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
            @RequestParam(required = false) String environment,
            @RequestParam(required = false) String intendedUse,
            @RequestParam(required = false) boolean inUse,
            @RequestParam(required = false) String profileUserId,
            @RequestParam(required = false) String username,
            @RequestParam(required = false) String pass,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String maidenName,
            @RequestParam(required = false) String birthdate,
            @RequestParam(required = false) String accountType,
            @RequestParam(required = false) String accountSubType,
            @RequestParam(required = false) String accountNumber,
            @RequestParam(required = false) String accountNickname,
            @RequestParam(required = false) String accountBalance
    ) throws ResponseStatusException {
        try {
            List<ProfileData> results = new ArrayList<>();
            if (environment != null) results.addAll(profileDataRepository.findByEnvironment(environment));
            if (intendedUse != null) results.addAll(profileDataRepository.findByIntendedUse(intendedUse));
            if (inUse) results.addAll(profileDataRepository.findByInUse(true));
            if (profileUserId != null) results.addAll(profileDataRepository.findByProfileUserId(profileUserId));
            if (username != null) results.addAll(profileDataRepository.findByUsername(username));
            if (pass != null) results.addAll(profileDataRepository.findByPass(pass));
            if (email != null) results.addAll(profileDataRepository.findByEmail(email));
            if (firstName != null) results.addAll(profileDataRepository.findByFirstName(firstName));
            if (lastName != null) results.addAll(profileDataRepository.findByLastName(lastName));
            if (maidenName != null) results.addAll(profileDataRepository.findByMaidenName(maidenName));
            if (birthdate != null) results.addAll(profileDataRepository.findByBirthdate(birthdate));
            if (accountType != null) results.addAll(profileDataRepository.findByAccountType(accountType));
            if (accountSubType != null) results.addAll(profileDataRepository.findByAccountSubType(accountSubType));
            if (accountNumber != null) results.addAll(profileDataRepository.findByAccountNumber(accountNumber));
            if (accountNickname != null) results.addAll(profileDataRepository.findByAccountNickname(accountNickname));
            if (accountBalance != null) results.addAll(profileDataRepository.findByAccountBalance(accountBalance));
            return results;
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Query params not found", e);
        }

    }
}
