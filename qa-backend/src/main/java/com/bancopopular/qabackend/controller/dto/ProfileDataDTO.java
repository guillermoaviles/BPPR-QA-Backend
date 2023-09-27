package com.bancopopular.qabackend.controller.dto;

public class ProfileDataDTO {

    // Customer Information and User Specific Fields
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

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getIntendedUse() {
        return intendedUse;
    }

    public void setIntendedUse(String intendedUse) {
        this.intendedUse = intendedUse;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public String getProfileUserId() {
        return profileUserId;
    }

    public void setProfileUserId(String profileUserId) {
        this.profileUserId = profileUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountSubType() {
        return accountSubType;
    }

    public void setAccountSubType(String accountSubType) {
        this.accountSubType = accountSubType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNickname() {
        return accountNickname;
    }

    public void setAccountNickname(String accountNickname) {
        this.accountNickname = accountNickname;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public boolean getPersonalInformationEmail() {
        return personalInformationEmail;
    }

    public boolean isPersonalInformationEmail() {
        return personalInformationEmail;
    }

    public void setPersonalInformationEmail(boolean personalInformationEmail) {
        this.personalInformationEmail = personalInformationEmail;
    }

    public boolean isPersonalInformationPhone() {
        return personalInformationPhone;
    }

    public void setPersonalInformationPhone(boolean personalInformationPhone) {
        this.personalInformationPhone = personalInformationPhone;
    }

    public boolean isPersonalInformationAddress() {
        return personalInformationAddress;
    }

    public void setPersonalInformationAddress(boolean personalInformationAddress) {
        this.personalInformationAddress = personalInformationAddress;
    }

    public boolean isPersonalInformationPassword() {
        return personalInformationPassword;
    }

    public void setPersonalInformationPassword(boolean personalInformationPassword) {
        this.personalInformationPassword = personalInformationPassword;
    }

    public boolean isPersonalInformationQuestions() {
        return personalInformationQuestions;
    }

    public void setPersonalInformationQuestions(boolean personalInformationQuestions) {
        this.personalInformationQuestions = personalInformationQuestions;
    }

    public boolean isPaymentMakePayments() {
        return paymentMakePayments;
    }

    public void setPaymentMakePayments(boolean paymentMakePayments) {
        this.paymentMakePayments = paymentMakePayments;
    }

    public boolean isCancelFutureTransfer() {
        return cancelFutureTransfer;
    }

    public void setCancelFutureTransfer(boolean cancelFutureTransfer) {
        this.cancelFutureTransfer = cancelFutureTransfer;
    }

    public boolean isMakeFuturePayment() {
        return makeFuturePayment;
    }

    public void setMakeFuturePayment(boolean makeFuturePayment) {
        this.makeFuturePayment = makeFuturePayment;
    }

    public boolean isMakeFutureTransfer() {
        return makeFutureTransfer;
    }

    public void setMakeFutureTransfer(boolean makeFutureTransfer) {
        this.makeFutureTransfer = makeFutureTransfer;
    }

    public boolean isDeleteFuturePayment() {
        return deleteFuturePayment;
    }

    public void setDeleteFuturePayment(boolean deleteFuturePayment) {
        this.deleteFuturePayment = deleteFuturePayment;
    }

    public boolean isEditFuturePayment() {
        return editFuturePayment;
    }

    public void setEditFuturePayment(boolean editFuturePayment) {
        this.editFuturePayment = editFuturePayment;
    }

    public boolean isOnOffService() {
        return onOffService;
    }

    public void setOnOffService(boolean onOffService) {
        this.onOffService = onOffService;
    }

    public boolean isAddPayee() {
        return addPayee;
    }

    public void setAddPayee(boolean addPayee) {
        this.addPayee = addPayee;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public String getPayeeAccountNumber() {
        return payeeAccountNumber;
    }

    public void setPayeeAccountNumber(String payeeAccountNumber) {
        this.payeeAccountNumber = payeeAccountNumber;
    }

    public boolean iseBill() {
        return eBill;
    }

    public void setEBill(boolean eBill) {
        this.eBill = eBill;
    }
}

