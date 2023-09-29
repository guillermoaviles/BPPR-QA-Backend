package com.bancopopular.qabackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String environment;
    private String intendedUse;
    private boolean inUse;
    private String profileUserId;
    private String username;
    private String pass;
    private String email;
    private String firstName;
    private String lastName;
    private String maidenName;
    private String birthdate;

    // Customer Bank Accounts Data
    private String accountType;
    private String accountSubType;
    private String accountNumber;
    private String accountNickname;
    private String accountBalance;

    //Customer Alerts Configuration
    private boolean personalInformationEmail;
    private boolean personalInformationPhone;
    private boolean personalInformationAddress;
    private boolean personalInformationPassword;
    private boolean personalInformationQuestions;
    private boolean paymentMakePayments;
    private boolean cancelFutureTransfer;
    private boolean makeFuturePayment;
    private boolean makeFutureTransfer;
    private boolean deleteFuturePayment;
    private boolean editFuturePayment;
    private boolean onOffService;
    private boolean addPayee;

    // Payee Data
    private String nickname;
    private String payeeName;
    private String payeeAccountNumber;
    private boolean eBill;

    // User
    private String user;
}
