package com.highpeaksw.accounts;

import com.highpeaksw.customer.BankCustomer;
import com.highpeaksw.utils.Utilities;

public class RdAccount extends BankAccounts {
    private String userName;
    private String password;
    private String accountType;
    private int accountNumber;
    private int tenure;
    private final int RECURRING_DEPOSIT_RATE_OF_INTEREST = 10;
    private double recurringDepositAmt;
    private double accountBalance;
    private boolean isAccountActivated;

    public RdAccount() {
        this.userName = null;
        this.password = null;
        this.accountType = "RECURRINGDEPOSIT";
        this.accountNumber = 0;
        this.tenure = 0;
        this.recurringDepositAmt = 0;
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

    public void setTenure(int recurringDepositTenure) {
        this.tenure = recurringDepositTenure;
    }

    public int getRECURRING_DEPOSIT_RATE_OF_INTEREST() {
        return RECURRING_DEPOSIT_RATE_OF_INTEREST;
    }

    public double getRecurringDepositAmt() {
        return recurringDepositAmt;
    }

    public void setRecurringDepositAmt(double recurringDepositAmt) {
        this.recurringDepositAmt = recurringDepositAmt;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double currentRecurringDeposit) {
        this.accountBalance = currentRecurringDeposit;
    }

    public boolean isAccountActivated() {
        return isAccountActivated;
    }

    public void setAccountActivated(boolean accountActivated) {
        isAccountActivated = accountActivated;
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
