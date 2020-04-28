package com.highpeaksw.accounts;

import com.highpeaksw.customer.BankCustomer;

import javax.persistence.*;


@Entity
@Table(name = "BankAccount")
public class BankAccount {

    @Id
    @Column(name = "Account_Number", nullable = false)
    public int accountNumber;

    @Column(name = "User_Name", length = 50, nullable = false)
    public String userName;

    @Column(name = "Password",length = 50, nullable = false)
    public String password;

    @Column(name = "Account_Balance",nullable = false)
    private double accountBalance;

    @ManyToOne()
    @JoinColumn(name = "customer_Id")
    private BankCustomer customer;

    @Column(name = "Rate_Of_Interest")
    private int rateOfInterest;

    @Column(name = "Recurring_Deposit_Count")
    private int rdCount;

    @Column(name = "Account_Type", length = 100,nullable = false)
    private String accountType;

    @Column(name = "Tenure")
    private int tenure;

    @Column(name = "Account_Status")
    private boolean isAccountActive;


//    @Column(name = "account_Activation")
//    private boolean isAccountActivated;


    @Column(name = "Recurring_Deposit_Amount")
    private double recurringDepositAmt;

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
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

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public BankCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(BankCustomer customer) {
        this.customer = customer;
    }

    public int getRateOfInterest() {
        return rateOfInterest;
    }

    public void setRateOfInterest(int rateOfInterest) {
        this.rateOfInterest = rateOfInterest;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getTenure() {
        return tenure;
    }

    public void setTenure(int tenure) {
        this.tenure = tenure;
    }


    public double getRecurringDepositAmt() {
        return recurringDepositAmt;
    }

    public void setRecurringDepositAmt(double recurringDepositAmt) {
        this.recurringDepositAmt = recurringDepositAmt;
    }

    public int getRdCount() {
        return rdCount;
    }

    public void setRdCount(int rdCount) {
        this.rdCount = rdCount;
    }

    public boolean isAccountActive() {
        return isAccountActive;
    }

    public void setAccountActive(boolean accountActive) {
        isAccountActive = accountActive;
    }


}