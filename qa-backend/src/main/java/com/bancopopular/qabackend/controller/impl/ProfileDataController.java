package com.bancopopular.qabackend.controller.impl;

import com.bancopopular.qabackend.controller.dto.ProfileDataDTO;
import com.bancopopular.qabackend.controller.interfaces.IProfileDataController;
import com.bancopopular.qabackend.model.ProfileData;
import com.bancopopular.qabackend.repository.ProfileDataRepository;
import com.bancopopular.qabackend.service.impl.ProfileDataService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

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
    @GetMapping("/{id}")
    public Optional<ProfileData> getProfileDataById(@PathVariable String id) {
        return profileDataRepository.findById(id);
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
    @GetMapping("/searchByUsername/{username}")
    @ResponseStatus(HttpStatus.OK)
    public ProfileData getProfilesByUsername(String username) {
        return profileDataRepository.findByUsername(username);
    }
    @GetMapping("/searchByPass/{pass}")
    @ResponseStatus(HttpStatus.OK)
    public ProfileData getProfilesByPass(String pass) {
        return profileDataRepository.findByPass(pass);
    }
    @GetMapping("/searchByEmail/{email}")
    @ResponseStatus(HttpStatus.OK)
    public ProfileData getProfilesByEmail(String email) {
        return profileDataRepository.findByEmail(email);
    }
    @GetMapping("/searchByFirstName/{firstName}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByFirstName(String firstName) {
        return profileDataRepository.findByFirstName(firstName);
    }
    @GetMapping("/searchByLastName/{lastName}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByLastName(String lastName) {
        return profileDataRepository.findByLastName(lastName);
    }
    @GetMapping("/searchByMaidenName/{maidenName}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByMaidenName(String maidenName) {
        return profileDataRepository.findByMaidenName(maidenName);
    }
    @GetMapping("/searchByBirthdate/{birthdate}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByBirthdate(String birthdate) {
        return profileDataRepository.findByBirthdate(birthdate);
    }
    @GetMapping("/searchByAccountType/{accountType}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByAccountType(String accountType) {
        return profileDataRepository.findByAccountType(accountType);
    }
    @GetMapping("/searchByAccountSubType/{accountSubType}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByAccountSubType(String accountSubType) {
        return profileDataRepository.findByAccountSubType(accountSubType);
    }
    @GetMapping("/searchByAccountNumber/{accountNumber}")
    @ResponseStatus(HttpStatus.OK)
    public ProfileData getProfilesByAccountNumber(String accountNumber) {
        return profileDataRepository.findByAccountNumber(accountNumber);
    }
    @GetMapping("/searchByAccountNickname/{accountNickname}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByAccountNickname(String accountNickname) {
        return profileDataRepository.findByAccountNickname(accountNickname);
    }
    @GetMapping("/searchByAccountBalance/{accountBalance}")
    @ResponseStatus(HttpStatus.OK)
    public List<ProfileData> getProfilesByAccountBalance(String accountBalance) {
        return profileDataRepository.findByAccountBalance(accountBalance);
    }
    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public Set<ProfileData> searchProfiles(
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
            Set<ProfileData> results = new HashSet<>();
            if (environment != null) results.addAll(profileDataRepository.findByEnvironment(environment));
            if (intendedUse != null) results.addAll(profileDataRepository.findByIntendedUse(intendedUse));
            if (inUse) results.addAll(profileDataRepository.findByInUse(true));
            if (profileUserId != null) results.add(profileDataRepository.findByProfileUserId(profileUserId));
            if (username != null) results.addAll(profileDataRepository.findByUsernameContaining(username));
            if (pass != null) results.add(profileDataRepository.findByPass(pass));
            if (email != null) results.addAll(profileDataRepository.findByEmailContaining(email));
            if (firstName != null) results.addAll(profileDataRepository.findByFirstNameContaining(firstName));
            if (lastName != null) results.addAll(profileDataRepository.findByLastNameContaining(lastName));
            if (maidenName != null) results.addAll(profileDataRepository.findByMaidenNameContaining(maidenName));
            if (birthdate != null) results.addAll(profileDataRepository.findByBirthdate(birthdate));
            if (accountType != null) results.addAll(profileDataRepository.findByAccountType(accountType));
            if (accountSubType != null) results.addAll(profileDataRepository.findByAccountSubType(accountSubType));
            if (accountNumber != null) results.add(profileDataRepository.findByAccountNumber(accountNumber));
            if (accountNickname != null) results.addAll(profileDataRepository.findByAccountNicknameContaining(accountNickname));
            if (accountBalance != null) results.addAll(profileDataRepository.findByAccountBalance(accountBalance));
            return results;
        } catch (ResponseStatusException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Query params not found", e);
        }
    }

    // **************************************************  POST  ******************************************************

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProfileData(@RequestBody ProfileData profileData) {
        profileDataRepository.save(profileData);
    }

    @PostMapping("/export")
    @ResponseStatus(HttpStatus.CREATED)
    public void exportProfileDataJson(HttpServletResponse response, @RequestBody List<String> ids){
        String jsonProfiles = profileDataService.exportProfileDataJson(ids);
        response.setContentType("application/json");
        response.setHeader("Content-Disposition", "attachment; filename\"jsonProfiles.json\"");
        try {
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(jsonProfiles.getBytes());
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/import/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void importProfileDataFromJson(@RequestBody List<ProfileData> profileDataList) {
        try {
            profileDataService.importProfileDataJson(profileDataList);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to import profiles from JSON", e);
        }
    }

    @PostMapping("/import")
    @ResponseStatus(HttpStatus.CREATED)
    public void importProfileData(@RequestBody List<ProfileData> profileDataList) {
        try {
            profileDataService.importProfileData(profileDataList);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Failed to import profiles from JSON", e);
        }
    }
    // **************************************************  PUT  *******************************************************

    // *************************************************  PATCH  ******************************************************

    @PatchMapping("/{id}/environment")
    @ResponseStatus(HttpStatus.OK)
    public void updateEnvironment(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateEnvironment(profileDataDTO, id);
    }

    @PatchMapping("/{id}/intendedUse")
    @ResponseStatus(HttpStatus.OK)
    public void updateIntendedUse(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateIntendedUse(profileDataDTO, id);
    }

    @PatchMapping("/{id}/inUse")
    @ResponseStatus(HttpStatus.OK)
    public void updateInUse(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateInUse(profileDataDTO, id);
    }

    @PatchMapping("/{id}/profileUserId")
    @ResponseStatus(HttpStatus.OK)
    public void updateProfileUserId(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateProfileUserId(profileDataDTO, id);
    }
    @PatchMapping("/{id}/username")
    @ResponseStatus(HttpStatus.OK)
    public void updateUsername(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateUsername(profileDataDTO, id);
    }

    @PatchMapping("/{id}/pass")
    @ResponseStatus(HttpStatus.OK)
    public void updatePass(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updatePass(profileDataDTO, id);
    }

    @PatchMapping("/{id}/email")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmail(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateEmail(profileDataDTO, id);
    }

    @PatchMapping("/{id}/firstName")
    @ResponseStatus(HttpStatus.OK)
    public void updateFirstName(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateFirstName(profileDataDTO, id);
    }
    @PatchMapping("/{id}/lastName")
    @ResponseStatus(HttpStatus.OK)
    public void updateLastName(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateLastName(profileDataDTO, id);
    }

    @PatchMapping("/{id}/maidenName")
    @ResponseStatus(HttpStatus.OK)
    public void updateMaidenName(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateMaidenName(profileDataDTO, id);
    }

    @PatchMapping("/{id}/birthdate")
    @ResponseStatus(HttpStatus.OK)
    public void updateBirthdate(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateBirthdate(profileDataDTO, id);
    }

    @PatchMapping("/{id}/accountType")
    @ResponseStatus(HttpStatus.OK)
    public void updateAccountType(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateAccountType(profileDataDTO, id);
    }
    @PatchMapping("/{id}/accountSubType")
    @ResponseStatus(HttpStatus.OK)
    public void updateAccountSubType(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateAccountSubType(profileDataDTO, id);
    }

    @PatchMapping("/{id}/accountNumber")
    @ResponseStatus(HttpStatus.OK)
    public void updateAccountNumber(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateAccountNumber(profileDataDTO, id);
    }

    @PatchMapping("/{id}/accountNickname")
    @ResponseStatus(HttpStatus.OK)
    public void updateAccountNickname(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateAccountNickname(profileDataDTO, id);
    }
    @PatchMapping("/{id}/accountBalance")
    @ResponseStatus(HttpStatus.OK)
    public void updateAccountBalance(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateAccountBalance(profileDataDTO, id);
    }
    @PatchMapping("/{id}/personalInformationEmail")
    @ResponseStatus(HttpStatus.OK)
    public void updatePersonalInformationEmail(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updatePersonalInformationEmail(profileDataDTO, id);
    }
    @PatchMapping("/{id}/personalInformationPhone")
    @ResponseStatus(HttpStatus.OK)
    public void updatePersonalInformationPhone(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updatePersonalInformationPhone(profileDataDTO, id);
    }
    @PatchMapping("/{id}/personalInformationAddress")
    @ResponseStatus(HttpStatus.OK)
    public void updatePersonalInformationAddress(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updatePersonalInformationAddress(profileDataDTO, id);
    }
    @PatchMapping("/{id}/personalInformationPassword")
    @ResponseStatus(HttpStatus.OK)
    public void updatePersonalInformationPassword(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updatePersonalInformationPassword(profileDataDTO, id);
    }
    @PatchMapping("/{id}/personalInformationQuestions")
    @ResponseStatus(HttpStatus.OK)
    public void updatePersonalInformationQuestions(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updatePersonalInformationQuestions(profileDataDTO, id);
    }
    @PatchMapping("/{id}/paymentMakePayments")
    @ResponseStatus(HttpStatus.OK)
    public void updatePaymentMakePayments(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updatePaymentMakePayments(profileDataDTO, id);
    }
    @PatchMapping("/{id}/cancelFutureTransfer")
    @ResponseStatus(HttpStatus.OK)
    public void updateCancelFutureTransfer(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateCancelFutureTransfer(profileDataDTO, id);
    }
    @PatchMapping("/{id}/makeFuturePayment")
    @ResponseStatus(HttpStatus.OK)
    public void updateMakeFuturePayment(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateMakeFuturePayment(profileDataDTO, id);
    }
    @PatchMapping("/{id}/makeFutureTransfer")
    @ResponseStatus(HttpStatus.OK)
    public void updateMakeFutureTransfer(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateMakeFutureTransfer(profileDataDTO, id);
    }
    @PatchMapping("/{id}/deleteFuturePayment")
    @ResponseStatus(HttpStatus.OK)
    public void updateDeleteFuturePayment(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateDeleteFuturePayment(profileDataDTO, id);
    }
    @PatchMapping("/{id}/editFuturePayment")
    @ResponseStatus(HttpStatus.OK)
    public void updateEditFuturePayment(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateEditFuturePayment(profileDataDTO, id);
    }
    @PatchMapping("/{id}/onOffService")
    @ResponseStatus(HttpStatus.OK)
    public void updateOnOffService(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateOnOffService(profileDataDTO, id);
    }
    @PatchMapping("/{id}/addPayee")
    @ResponseStatus(HttpStatus.OK)
    public void updateAddPayee(@PathVariable String id, @RequestBody ProfileDataDTO profileDataDTO){
        profileDataService.updateAddPayee(profileDataDTO, id);
    }

    //  ***********************************************  DELETE  ******************************************************
}
