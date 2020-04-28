package com.highpeaksw.customer;
import com.highpeaksw.accounts.BankingOperations;
import com.highpeaksw.utils.SqlUtilities;
import com.highpeaksw.utils.Utilities;
import com.highpeaksw.accounts.BankAccount;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name = "BankCustomer")
public class BankCustomer {

    @Id
    @Column(name = "customer_Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "customer_Name", length = 100, nullable = false)
    private String name;

    @Column(name = "aadhar_Number", length = 20, nullable = false)
    private String aadharNumber;

    @Column(name = "pan_Number", length = 40, nullable = false)
    private String panNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private List<BankAccount> accounts = new ArrayList<BankAccount>();

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }




    public void initCreateAccount(BankCustomer currentInstance) {
        currentInstance = currentInstance.checkForExistingCustomer();
        if (currentInstance.getPanNumber() != null) {
            System.out.println("You are an EXISTING customer.Please provide BELOW DETAILS to continue creating account.");
            BankAccount accountCreationInstance = scanUserDetails(currentInstance);
            if (accountCreationInstance != null) {
                if (SqlUtilities.addToBankAccountTbl(accountCreationInstance)) {
                    System.out.println("Account creation successful.Continue banking.");
                    System.out.println("YOUR ACCOUNT:- ");
                    System.out.println("A/c Number: "+ accountCreationInstance.getAccountNumber()+"  A/c Type: "+ accountCreationInstance.getAccountType());
                } else {
                    System.out.println("ACCOUNT CREATION FAILED!! Retry");
                }
            } else {
                System.out.println("ACCOUNT CREATION FAILED");
            }
        }else {
            System.out.println("NEW CUSTOMER!! PLEASE REGISTER");
            if (customerRegistration(currentInstance)){
                System.out.println("customer registration SUCCESSFULL");
                System.out.println("Please provide BELOW DETAILS to continue creating account.");
                BankAccount accountCreationInstance = scanUserDetails(currentInstance);
                if (accountCreationInstance != null) {
                    if (SqlUtilities.addToBankAccountTbl(accountCreationInstance)) {
                        System.out.println("Account creation successful.Continue banking.");
                        System.out.println("YOUR ACCOUNT:- ");
                        System.out.println("A/c Number: " + accountCreationInstance.getAccountNumber() + "  A/c Type: " + accountCreationInstance.getAccountType());
                    } else {
                        System.out.println("ACCOUNT CREATION FAILED!! Retry");
                    }
                }
            }
        }
    }



    public BankAccount scanUserDetails(BankCustomer customerInstance) {
        BankAccount accountCreationInstance = new BankAccount();

        accountCreationInstance.setUserName(Utilities.scanUserName());
        if (accountCreationInstance.getUserName() == null)
            return null;

        accountCreationInstance.setPassword(Utilities.scanPassword());
        if (accountCreationInstance.getPassword() == null)
            return null;

        accountCreationInstance.setAccountNumber(Utilities.generateAccountNumber());
        accountCreationInstance.setCustomer(customerInstance);
        char choice;
        Scanner sf = new Scanner(System.in);
        System.out.println("SELECT THE TYPE OF ACCOUNT YOU WANT TO CREATE");
        System.out.println("**** A) SAVINGS ACCOUNT    B) CURRENT ACCOUNT    C) FD ACCOUNT    D) RD ACCOUNT");
        choice = Character.toUpperCase(sf.next().charAt(0));
        switch (choice){
            case 'A' : {
                if (!SqlUtilities.isSavingCurrentAccountExist(customerInstance.getId(), "SAVINGS")) {
                    accountCreationInstance.setAccountType("SAVINGS");
                    accountCreationInstance.setRateOfInterest(5);
                    accountCreationInstance.setAccountActive(true);
                }else {
                    accountCreationInstance = null;
                    System.out.println("Only one SAVINGS ACCOUNT per customer");
                }
            }break;

            case 'B' : {
                if (!SqlUtilities.isSavingCurrentAccountExist(customerInstance.getId(), "CURRENT")) {
                    accountCreationInstance.setAccountType("CURRENT");
                    accountCreationInstance.setRateOfInterest(0);
                    accountCreationInstance.setAccountActive(true);
                }else{
                    accountCreationInstance = null;
                    System.out.println("Only one CURRENT ACCOUNT per customer");
                }
            }break;

            case 'C' : {
                accountCreationInstance.setAccountType("FIXED DEPOSIT");
                accountCreationInstance.setRateOfInterest(10);
                accountCreationInstance.setAccountBalance(Utilities.scanDepositAmount());
                accountCreationInstance.setTenure(Utilities.scanTenure("FIXED DEPOSIT"));
                accountCreationInstance.setAccountActive(true);
            }break;

            case 'D' : {
                accountCreationInstance.setAccountType("RECURRING DEPOSIT");
                accountCreationInstance.setRateOfInterest(10);
                System.out.println("MONTHLY DEPOSIT AMOUNT");
                accountCreationInstance.setRecurringDepositAmt(Utilities.scanDepositAmount());
                accountCreationInstance.setTenure(Utilities.scanTenure("RECURRING DEPOSIT"));
                accountCreationInstance.setAccountActive(true);
            }break;

            default: {
                System.out.println("INVALID CHOICE!!");
                break;
            }
        }
        return accountCreationInstance;
    }



    private BankCustomer checkForExistingCustomer(){
        String aadharNumber = Utilities.scanAadharNumber();
        BankCustomer currentInstance;
        if((currentInstance = SqlUtilities.dbCheckForExistingCustomer(aadharNumber)) == null){
            currentInstance = new BankCustomer();
            currentInstance.setAadharNumber(aadharNumber);
            return currentInstance;
        }else
            return currentInstance;
    }



    public boolean customerRegistration(BankCustomer currentInstance){
        System.out.println("You are a new customer.Please enter details to register with the bank before account creation.");
        currentInstance.setName(Utilities.scanCustomerName());
        if (currentInstance.getName() == null)return false;

        currentInstance.setPanNumber(Utilities.scanPanNumber());
        if (currentInstance.getPanNumber() == null)return false;

        if(SqlUtilities.addToBankCustomerTbl(currentInstance))
            return true;
        else return false;
    }



    public void initNetBanking(String aadharNumber){
        if (aadharNumber == null) {
            aadharNumber = Utilities.scanAadharNumber();
        }
        BankCustomer temp = SqlUtilities.dbCheckForExistingCustomer(aadharNumber);
        if (temp.getPanNumber() != null){
            int id = temp.getId();
            if(SqlUtilities.AccountList(id)){
                BankingOperations loginInstance = new BankingOperations();
                loginInstance.initLogin(temp);
            }else System.out.println("NO Accounts Linked to the CUSTOMER");
        }else System.out.println("INVALID CUSTOMER");
    }

}