package com.bancopopular.qabackend.controller.impl;

import com.bancopopular.qabackend.controller.dto.ProfileDataDTO;
import com.bancopopular.qabackend.model.ProfileData;
import com.bancopopular.qabackend.repository.ProfileDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class ProfileDataControllerTest {

    @Autowired
    ProfileDataRepository profileDataRepository;
    @Autowired
    WebApplicationContext webApplicationContext;
//    @Autowired
    ProfileData profileData;
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        ProfileData profileData1 = new ProfileData(null, null, null, false, "1", "update_test", null, null, null, null, null, null, "Credit", null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, null, null, null, false, null);
        profileDataRepository.save(profileData1);
    }
    @Test
    void whenGetAllProfiles_GivenValidURL_ThenReturnSuccess() throws Exception {
        mockMvc.perform(get("/api/profiles/all").header(HttpHeaders.AUTHORIZATION,"Bearer PutHereMyToken"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void whenImportProfileData_GivenValidInput_ThenReturnSuccess() throws Exception {
        List<ProfileData> profileDataList = new ArrayList<>();

        ProfileData profileData2 = new ProfileData(null, "prod", "Pipeline", false, "q23764dy274", "UserA", "passA", "userA@email.com", "John", "Doe", "MaidenA", "01/15/1985", "Deposit", "Checking", "1234567890", "My Checking", "500.00", false, false, true, false, true, true, false, true, false, false, true, false, false, "payee1", "Payee 1", "987654321", true, null);
        ProfileData profileData3 = new ProfileData(null, "cert", "Sprint", true, "q23764dy275", "UserB", "passB", "userB@email.com", "Jane", "Smith", null, "05/20/1990", "Credit Cards", "Visa Icon", "9876543210", "My Visa", "1000.00", true, true, false, false, false, false, false, false, true, false, true, true , false, "payee2", "Payee 2", "456789123", false, null);
        ProfileData profileData4 = new ProfileData(null, "dev", "Sanity", true, "q23764dy276", "UserC", "passC", "userC@email.com", "Alice", "Johnson", null, "12/03/1988", "Mortgage", "FHA Mortgage", "3456789012", "My Mortgage", "150000.00", true, false, true, false, false, false, true, false, false, true, false, true , false, "payee3", "Payee 3", "654321987", true, null);
        ProfileData profileData5 = new ProfileData(null, "prod", "Certification", false, "q23764dy277", "UserD", "passD", "userD@email.com", "Bob", "Williams", null, "07/10/1995", "Rewards", "Title Insurance", "7890123456", "Title Insurance", "200.00", false, true, false, true, false, true, true, false, true, false, true , false, false, "payee4", "Payee 4", "789654123", true, null);

        //profileDataList.add(profileData);
        profileDataList.add(profileData2);
        profileDataList.add(profileData3);
        profileDataList.add(profileData4);
        profileDataList.add(profileData5);

        mockMvc.perform(post("/api/profiles/import")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(profileDataList)))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void whenUpdateProfileData_GivenValidBody_ThenReturnSuccess() throws Exception {
        ProfileData expectedProfileData = new ProfileData(1, null, null, false, "1", "update_test", null, null, null, null, null, null, "Debit", null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, null, null, null, false, null);

        ProfileDataDTO profileDataDTO = new ProfileDataDTO();
        profileDataDTO.setProfileUserId("1");
        profileDataDTO.setUsername("update_test");
        profileDataDTO.setAccountType("Debit");
        mockMvc.perform(put("/api/profiles/{id}", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(profileDataDTO)))
                .andExpect(status().isOk())
                .andReturn();

        Optional<ProfileData> updatedProfileData = profileDataRepository.findById("1");
        assertEquals(expectedProfileData, updatedProfileData.get());
    }

    @Test
    void whenUpdateInUse_GivenValidParameter_ThenReturnSuccess() throws Exception {
        ProfileData expectedProfileData = new ProfileData(1, null, null, true, "1", "update_test", null, null, null, null, null, null, "Credit", null, null, null, null, false, false, false, false, false, false, false, false, false, false, false, false, false, null, null, null, false, null);

        ProfileDataDTO profileDataDTO = new ProfileDataDTO();
        profileDataDTO.setInUse(true);
        mockMvc.perform(patch("/api/profiles/{id}/inUse", "1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(profileDataDTO)))
                .andExpect(status().isOk())
                .andReturn();

        Optional<ProfileData> updatedProfileData = profileDataRepository.findById("1");
        assertEquals(expectedProfileData, updatedProfileData.get());
    }

    @Test
    void whenDeleteProfile_GivenValidId_ThenReturnSuccess() throws Exception  {
        Optional<ProfileData> profileDataToDelete = profileDataRepository.findById("1");
        assertTrue(profileDataToDelete.isPresent());

        mockMvc.perform(delete("/api/profiles/{id}/delete", "1"))
                .andExpect(status().isNoContent())
                .andReturn();

        Optional<ProfileData> deletedProfileData = profileDataRepository.findById("1");
        assertFalse(deletedProfileData.isPresent());
    }

}