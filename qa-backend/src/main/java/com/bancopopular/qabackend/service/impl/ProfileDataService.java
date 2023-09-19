package com.bancopopular.qabackend.service.impl;

import com.bancopopular.qabackend.controller.dto.ProfileDataDTO;
import com.bancopopular.qabackend.model.ProfileData;
import com.bancopopular.qabackend.repository.ProfileDataRepository;
import com.bancopopular.qabackend.service.interfaces.IProfileDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileDataService implements IProfileDataService {

    @Autowired
    ProfileDataRepository profileDataRepository;

    // POST
    @Override
    public ProfileData createProfileData(ProfileData profileData) {
        try {
            return profileDataRepository.save(profileData);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create new profile.", e);
        }
    }

    // PUT
    @Override
    public ProfileData updateProfileData(ProfileDataDTO profileDataDTO, String id) {
       try {
           Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
           if (profileDataOptional.isPresent()) {
               ProfileData profileData = profileDataOptional.get();
               profileData.setProfileUserId(id);
               profileData.setUsername(profileDataDTO.getUsername());
               profileData.setPass(profileDataDTO.getPass());
               profileData.setEmail(profileDataDTO.getEmail());
               profileData.setFirstName(profileDataDTO.getFirstName());
               profileData.setLastName(profileDataDTO.getLastName());
               if (profileDataDTO.getMaidenName() != null) profileData.setMaidenName(profileDataDTO.getMaidenName());
               profileData.setBirthdate(profileDataDTO.getBirthdate());
               return profileDataRepository.save(profileData);
           } else {
               throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
           }
       } catch (Exception e) {
           throw new RuntimeException("Failed to update profile data.", e);
       }
    }

    // PATCH
    @Override
    public void updateLastName(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setLastName(profileDataDTO.getLastName());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
        }
    }

    @Override
    public void updateMaidenName(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setMaidenName(profileDataDTO.getMaidenName());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
        }
    }

    @Override
    public void updateBirthdate(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setBirthdate(profileDataDTO.getBirthdate());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
        }
    }

    @Override
    public void updateAccountType(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountType(profileDataDTO.getAccountType());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
        }
    }

    @Override
    public void updateAccountSubType(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountSubType(profileDataDTO.getAccountSubType());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
        }
    }

    @Override
    public void updateAccountNumber(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountNumber(profileDataDTO.getAccountNumber());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
        }
    }

    @Override
    public void updateAccountNickname(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountNickname(profileDataDTO.getAccountNickname());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
        }
    }

    @Override
    public void updateAccountBalance(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountBalance(profileDataDTO.getAccountBalance());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
        }
    }

    // DELETE
    @Override
    public void deleteProfile(String id) {
        try {
            if (profileDataRepository.existsById(id)) {
                profileDataRepository.deleteById(id);
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID " + id + " not found.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete profile", e);
        }
    }
}
