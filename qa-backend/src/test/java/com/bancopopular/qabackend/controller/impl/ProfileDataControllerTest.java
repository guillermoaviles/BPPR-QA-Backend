package com.bancopopular.qabackend.controller.impl;

import com.bancopopular.qabackend.model.ProfileData;
import com.bancopopular.qabackend.repository.ProfileDataRepository;
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
        profileData = new ProfileData(null, "dev", "Certification", true, "q23764dy273", "Test 1", "1234", "email@email.com", "Test", "Test", "Test", "10/10/2000", "Credit", "Premia", "347687324", "test_1", "100.00", true, false, false, true, false, false, true, false, false, false, true, true , true, "test1", "Test 1", "347687324", true, null);
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
    void importProfileData() throws Exception {
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
    void updateProfileData() {
    }

    @Test
    void updateInUse() {
    }

    @Test
    void deleteProfile() {
    }
}