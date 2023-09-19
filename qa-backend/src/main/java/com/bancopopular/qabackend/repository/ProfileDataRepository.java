package com.bancopopular.qabackend.repository;

import com.bancopopular.qabackend.model.ProfileData;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileDataRepository extends JpaRepository<ProfileData, String> {
    List<ProfileData> findByEnvironment(String environment);
    List<ProfileData> findByIntendedUse(String intendedUse);
    List<ProfileData> findByInUse(boolean inUse);
    ProfileData findByProfileUserId(String profileUserId);
    ProfileData findByUsername(String username);
    ProfileData findByPass(String pass);
    ProfileData findByEmail(String email);
    List<ProfileData> findByFirstName(String firstName);
    List<ProfileData> findByLastName(String lastName);
    List<ProfileData> findByMaidenName(String maidenName);
    List<ProfileData> findByBirthdate(String birthdate);
    List<ProfileData> findByAccountType(String accountType);
    List<ProfileData> findByAccountSubType(String accountSubType);
    ProfileData findByAccountNumber(String accountNumber);
    List<ProfileData> findByAccountNickname(String accountNickname);
    List<ProfileData> findByAccountBalance(String accountBalance);
}


