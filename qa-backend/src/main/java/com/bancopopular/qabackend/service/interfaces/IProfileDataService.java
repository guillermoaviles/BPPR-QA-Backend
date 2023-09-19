package com.bancopopular.qabackend.service.interfaces;

import com.bancopopular.qabackend.controller.dto.ProfileDataDTO;
import com.bancopopular.qabackend.model.ProfileData;

import java.util.List;
import java.util.Optional;

public interface IProfileDataService {

    // POST
    ProfileData createProfileData(ProfileData profileData);

    // PUT
    ProfileData updateProfileData(ProfileDataDTO profileDataDTO, String id);

    void updateLastName(ProfileDataDTO profileDataDTO, String id);

    void updateMaidenName(ProfileDataDTO profileDataDTO, String id);

    void updateBirthdate(ProfileDataDTO profileDataDTO, String id);

    void updateAccountType(ProfileDataDTO profileDataDTO, String id);

    void updateAccountSubType(ProfileDataDTO profileDataDTO, String id);

    void updateAccountNumber(ProfileDataDTO profileDataDTO, String id);

    void updateAccountNickname(ProfileDataDTO profileDataDTO, String id);

    void updateAccountBalance(ProfileDataDTO profileDataDTO, String id);

    void deleteProfile(String id);
}
