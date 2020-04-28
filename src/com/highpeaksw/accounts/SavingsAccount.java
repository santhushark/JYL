package com.highpeaksw.accounts;

import com.highpeaksw.customer.BankCustomer;
import com.highpeaksw.utils.Utilities;

import java.util.List;

public class SavingsAccount extends BankAccounts {

    public String userName;
    public String password;
    private String accountType;
    private int accountNumber;
    private double accountBalance;


    public SavingsAccount() {
        this.userName = null;
        this.password = null;
        this.accountType = "SAVINGS";
        this.accountNumber = 0;
        this.accountBalance = 0;
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

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getRecurringDepositAmt() {return 0;}
    public void setRecurringDepositAmt(double recurringDepositAmt) {
        this.accountBalance = recurringDepositAmt;
    }

    public int getTenure() {
        return 0;
    }

    public void setTenure(int recurringDepositTenure) {
        int tenure = recurringDepositTenure;
    }
    public boolean isAccountActivated(){return true;}
    public void setAccountActivated(boolean accountActivated){}

    public boolean initCreateAccount(BankCustomer customerInstance){
        List<BankAccounts> customerAccountList = customerInstance.getAccountsList();
        for (BankAccounts temp : customerAccountList){
            if(temp.getAccountType().equals("SAVINGS")){
                System.out.println("SAVINGS ACCOUNT ALREADY EXISTS FOR THIS CUSTOMER");
                return false;
            }
        }
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
