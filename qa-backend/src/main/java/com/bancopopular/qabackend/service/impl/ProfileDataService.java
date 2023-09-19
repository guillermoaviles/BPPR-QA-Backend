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

    @Override
    public List<ProfileData> getAllProfiles(){
        return profileDataRepository.findAll();
    }
    @Override
    public void updateEnvironment(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setEnvironment(profileDataDTO.getEnvironment());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateIntendedUse(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setIntendedUse(profileDataDTO.getIntendedUse());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateInUse(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setIntendedUse(profileDataDTO.getIntendedUse());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateProfileUserId(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setProfileUserId(profileDataDTO.getProfileUserId());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateUsername(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setUsername(profileDataDTO.getUsername());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updatePass(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setPass(profileDataDTO.getPass());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateEmail(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setEmail(profileDataDTO.getEmail());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateFirstName(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setEmail(profileDataDTO.getEmail());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateLastName(ProfileDataDTO profileDataDTO, String id){
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setFirstName(profileDataDTO.getFirstName());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateMaidenName(ProfileDataDTO profileDataDTO, String id){
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setMaidenName(profileDataDTO.getMaidenName());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateBirthdate(ProfileDataDTO profileDataDTO, String id){
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()) {
            ProfileData profileData = profileDataOptional.get();
            profileData.setBirthdate(profileDataDTO.getBirthdate());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateAccountType(ProfileDataDTO profileDataDTO, String id){
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountType(profileDataDTO.getAccountType());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateAccountSubType(ProfileDataDTO profileDataDTO, String id){
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountSubType(profileDataDTO.getAccountSubType());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateAccountNumber(ProfileDataDTO profileDataDTO, String id){
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountNumber(profileDataDTO.getAccountNumber());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateAccountNickname(ProfileDataDTO profileDataDTO, String id){
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountNickname(profileDataDTO.getAccountNickname());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateAccountBalance(ProfileDataDTO profileDataDTO, String id){
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setAccountBalance(profileDataDTO.getAccountBalance());
            profileDataRepository.save(profileData);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
}