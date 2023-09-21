package com.bancopopular.qabackend.service.impl;

import com.bancopopular.qabackend.controller.dto.ProfileDataDTO;
import com.bancopopular.qabackend.model.ProfileData;
import com.bancopopular.qabackend.repository.ProfileDataRepository;
import com.bancopopular.qabackend.service.interfaces.IProfileDataService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProfileDataService implements IProfileDataService {

    @Autowired
    ProfileDataRepository profileDataRepository;

    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static final Logger logger = LoggerFactory.getLogger(ProfileData.class);


    // POST
    @Override
    public ProfileData createProfileData(ProfileData profileData) {
        try {
            logger.info("Successfully saved Profile Data");
            return profileDataRepository.save(profileData);
        } catch (Exception e) {
            logger.error("There was an error while creating a new profile: " + e.getMessage(), e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to create new profile.", e);
        }
    }

    // PUT
    @Override
    public ProfileData updateProfileData(ProfileDataDTO profileDataDTO, String id) {
       try {
           Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
           if (profileDataOptional.isPresent()) {
               ProfileData existingProfileData = profileDataOptional.get();
               existingProfileData.setProfileUserId(id);
               existingProfileData.setUsername(profileDataDTO.getUsername());
               existingProfileData.setPass(profileDataDTO.getPass());
               existingProfileData.setEmail(profileDataDTO.getEmail());
               existingProfileData.setFirstName(profileDataDTO.getFirstName());
               existingProfileData.setLastName(profileDataDTO.getLastName());
               existingProfileData.setMaidenName(profileDataDTO.getMaidenName());
               existingProfileData.setBirthdate(profileDataDTO.getBirthdate());
               logger.info("Successfully updated profile data for profile with ID: {}", id);
               return profileDataRepository.save(existingProfileData);
           } else {
               logger.error("Profile with ID: {} was not found", id);
               throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID: " + id + " not found.");
           }
       } catch (Exception e) {
           logger.error("There was an error while updating the data: " + e.getMessage(), e);
           throw new RuntimeException("Failed to update profile data.", e);
       }
    }

    // PATCH
    @Override
    public void updateEnvironment(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setEnvironment(profileDataDTO.getEnvironment());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated environment for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated intended use for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateInUse(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional =profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setInUse(profileDataDTO.isInUse());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated in use for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated username for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated pass for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated email for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated first name for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated last name for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated maiden name for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated birthdate for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated account type for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated account sub-type for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated account number for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated account nickname for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
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
            logger.info("Successfully updated account balance for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updatePersonalInformationEmail(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setPersonalInformationEmail(profileDataDTO.getPersonalInformationEmail());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated personal information email for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updatePersonalInformationPhone(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setPersonalInformationPhone(profileDataDTO.isPersonalInformationPhone());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated personal information phone for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updatePersonalInformationAddress(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setPersonalInformationAddress(profileDataDTO.isPersonalInformationAddress());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated personal information address for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }

    @Override
    public void updatePersonalInformationPassword(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setPersonalInformationPassword(profileDataDTO.isPersonalInformationPassword());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated personal information password for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updatePersonalInformationQuestions(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setPersonalInformationQuestions(profileDataDTO.isPersonalInformationQuestions());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated personal information questions for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updatePaymentMakePayments(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setPaymentMakePayments(profileDataDTO.isPaymentMakePayments());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated [make payments] for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateCancelFutureTransfer(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setCancelFutureTransfer(profileDataDTO.isCancelFutureTransfer());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated [cancel future transfer] for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateMakeFuturePayment(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setMakeFuturePayment(profileDataDTO.isMakeFuturePayment());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated [make future payment] for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateMakeFutureTransfer(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setMakeFutureTransfer(profileDataDTO.isMakeFutureTransfer());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated [make future transfer] for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateDeleteFuturePayment(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setDeleteFuturePayment(profileDataDTO.isDeleteFuturePayment());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated [delete future payment] for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateEditFuturePayment(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setEditFuturePayment(profileDataDTO.isEditFuturePayment());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated [edit future payment] for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }
    @Override
    public void updateOnOffService(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setOnOffService(profileDataDTO.isOnOffService());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated [on off service] for profile with ID: {}", id);
        } else {
            logger.error("Profile with ID: {} was not found", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }

    @Override
    public void updateAddPayee(ProfileDataDTO profileDataDTO, String id) {
        Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
        if (profileDataOptional.isPresent()){
            ProfileData profileData = profileDataOptional.get();
            profileData.setAddPayee(profileDataDTO.isAddPayee());
            profileDataRepository.save(profileData);
            logger.info("Successfully updated [add payee] for profile with ID: {}", id);
        } else {
            logger.error("Error finding profile with ID: {}", id);
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile not found.");
        }
    }

    // DELETE
    @Override
    public void deleteProfile(String id) {
        try {
            if (profileDataRepository.existsById(id)) {
                profileDataRepository.deleteById(id);
                logger.info("Successfully deleted profile with ID: {}", id);
            } else {
                logger.error("Profile with ID: {} was not found", id);
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profile with ID " + id + " not found.");
            }
        } catch (Exception e) {
            logger.error("Failed to delete profile: ", e);
            throw new RuntimeException("Failed to delete profile", e);
        }
    }

    // JSON EXPORT
    @Override
    public String exportProfileDataJson(List<String> ids) {
        List<ProfileData> profileDataList = new ArrayList<>();
        for (String id: ids){
            Optional<ProfileData> profileDataOptional = profileDataRepository.findById(id);
            if (profileDataOptional.isPresent()){
                ProfileData profileData = profileDataOptional.get();
                profileDataList.add(profileData);
            }
        }
        logger.info("Exporting profiles with ID: {}", ids);
        return gson.toJson(profileDataList);
    }

    // JSON IMPORT
    @Override
    public void importProfileDataJson(List<ProfileData> profileDataList){
        for (ProfileData profileData : profileDataList) {
                profileDataRepository.save(profileData);
                logger.info("Saved profile data: " + profileData);
        }
        try {
            FileWriter fileWriter = new FileWriter("profileDataImport-" + LocalDate.now() + ".json");
            gson.toJson(profileDataList, fileWriter);
            fileWriter.close();
            logger.info("Successfully wrote profile data to JSON.");
        } catch (IOException e) {
            logger.error("Failed to import profiles: " + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    @Override
    public void importProfileData(List<ProfileData> profileDataList) {
        logger.info("Importing profiles");
        for (ProfileData profileData : profileDataList) {
            profileDataRepository.save(profileData);
        }
    }
}