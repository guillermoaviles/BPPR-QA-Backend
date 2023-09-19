package com.bancopopular.qabackend.service.interfaces;

import com.bancopopular.qabackend.controller.dto.ProfileDataDTO;
import com.bancopopular.qabackend.model.ProfileData;

import java.util.List;

public interface IProfileDataService {
    List<ProfileData> getAllProfiles();


    void updateLastName(ProfileDataDTO profileDataDTO, String id);

    void updateMaidenName(ProfileDataDTO profileDataDTO, String id);

    void updateBirthdate(ProfileDataDTO profileDataDTO, String id);

    void updateAccountType(ProfileDataDTO profileDataDTO, String id);

    void updateAccountSubType(ProfileDataDTO profileDataDTO, String id);

    void updateAccountNumber(ProfileDataDTO profileDataDTO, String id);

    void updateAccountNickname(ProfileDataDTO profileDataDTO, String id);

    void updateAccountBalance(ProfileDataDTO profileDataDTO, String id);

    void updateEnvironment(ProfileDataDTO profileDataDTO, String id);

    void updateIntendedUse(ProfileDataDTO profileDataDTO, String id);

    void updateInUse(ProfileDataDTO profileDataDTO, String id);

    void updateProfileUserId(ProfileDataDTO profileDataDTO, String id);

    void updateUsername(ProfileDataDTO profileDataDTO, String id);

    void updatePass(ProfileDataDTO profileDataDTO, String id);

    void updateEmail(ProfileDataDTO profileDataDTO, String id);

    void updateFirstName(ProfileDataDTO profileDataDTO, String id);

    void updatePersonalInformationEmail(ProfileDataDTO profileDataDTO, String id);

    void updatePersonalInformationPhone(ProfileDataDTO profileDataDTO, String id);

    void updatePersonalInformationAddress(ProfileDataDTO profileDataDTO, String id);

    void updatePersonalInformationPassword(ProfileDataDTO profileDataDTO, String id);

    void updatePersonalInformationQuestions(ProfileDataDTO profileDataDTO, String id);

    void updatePaymentMakePayments(ProfileDataDTO profileDataDTO, String id);

    void updateCancelFutureTransfer(ProfileDataDTO profileDataDTO, String id);

    void updateMakeFuturePayment(ProfileDataDTO profileDataDTO, String id);

    void updateMakeFutureTransfer(ProfileDataDTO profileDataDTO, String id);

    void updateDeleteFuturePayment(ProfileDataDTO profileDataDTO, String id);

    void updateEditFuturePayment(ProfileDataDTO profileDataDTO, String id);

    void updateOnOffService(ProfileDataDTO profileDataDTO, String id);

    void updateAddPayee(ProfileDataDTO profileDataDTO, String id);
}