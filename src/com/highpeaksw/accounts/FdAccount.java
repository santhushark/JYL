package com.highpeaksw.accounts;

import com.highpeaksw.customer.BankCustomer;
import com.highpeaksw.utils.Utilities;

public class FdAccount extends BankAccounts {

    private String userName;
    private String password;
    private String accountType;
    private int accountNumber;
    private int tenure;
    private final int FIXED_DEPOSIT_RATE_OF_INTEREST = 10;
    private double accountBalance;
    private boolean isAccountActivated;


    public FdAccount() {
        this.userName = null;
        this.password = null;
        this.accountType = "FIXEDDEPOSIT";
        this.accountNumber = 0;
        this.tenure = 0;
        this.accountBalance = 0;
        this.isAccountActivated = false;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int fixedDepositTenure) {
        this.tenure = fixedDepositTenure;
    }

    public int getFIXED_DEPOSIT_RATE_OF_INTEREST() {
        return FIXED_DEPOSIT_RATE_OF_INTEREST;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double fixedDeposit) {
        this.accountBalance = fixedDeposit;
    }

    public boolean isAccountActivated() {
        return isAccountActivated;
    }

    public void setAccountActivated(boolean accountActivated) {
        isAccountActivated = accountActivated;
    }

    public double getRecurringDepositAmt() {
        return 0;
    }

    public void setRecurringDepositAmt(double recurringDepositAmt) {
        this.accountBalance = recurringDepositAmt;
    }

    public boolean initCreateAccount(BankCustomer customerInstance){
        userName = Utilities.scanUserName();
        if (userName == null)
            return false;

        password = Utilities.scanPassword();
        if (password == null)
            return false;

        accountNumber = Utilities.generateAccountNumber();

        return true;
    }

}
