package com.highpeaksw.customer;

import com.highpeaksw.accounts.*;
import com.highpeaksw.utils.Utilities;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BankCustomer {
    private String name;
    private String aadharNumber;
    private String panNumber;
    private List<BankAccounts> accountsList;



    public BankCustomer() {
        this.name = null;
        this.aadharNumber = null;
        this.panNumber = null;
        this.accountsList = new LinkedList<>();
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

    public List<BankAccounts> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<BankAccounts> accountsList) {
        this.accountsList = accountsList;
    }

    public void initCreateAccount(BankCustomer currentInstance, List<BankCustomer> customerList){
        currentInstance = isExistingCustomer(customerList);
        if(currentInstance != null){
            System.out.println("You are an exisiting customer.Please provide the detials to continue creating account.");
         char choice;
         Scanner sf = new Scanner(System.in);
         System.out.println("SELECT THE TYPE OF ACCOUNT YOU WANT TO CREATE");
         System.out.println("**** A) SAVINGS ACCOUNT    B) CURRENT ACCOUNT    C) FD ACCOUNT    D) RD ACCOUNT");
         choice = Character.toUpperCase(sf.next().charAt(0));
         switch (choice){

             case 'A' : {
                BankAccounts savingAccount;
                SavingsAccount createAccount = new SavingsAccount();
                if(createAccount.initCreateAccount(currentInstance)) {
                    savingAccount = createAccount;
                    currentInstance.accountsList.add(savingAccount);
                    System.out.println("Account creation successful.Continue banking.");
                }else
                    System.out.println("ACCOUNT CREATION FAILED!! Retry");
             }
             break;

             case 'B' : {
                 BankAccounts currentAccount;
                 CurrentAccount createAccount = new CurrentAccount();
                 if(createAccount.initCreateAccount(currentInstance)) {
                     currentAccount = createAccount;
                     currentInstance.accountsList.add(currentAccount);
                     System.out.println("Account creation successful.Continue banking.");
                 }else
                     System.out.println("ACCOUNT CREATION FAILED!! Retry");
             }
             break;

             case 'C' : {
                 BankAccounts fdAccount;
                 FdAccount createAccount = new FdAccount();
                 if (createAccount.initCreateAccount(currentInstance)){
                     fdAccount = createAccount;
                     currentInstance.accountsList.add(fdAccount);
                     System.out.println("Account creation successful.Continue banking.");
                 }else
                     System.out.println("ACCOUNT CREATION FAILED!! Retry");
             }
             break;

             case 'D' : {
                 BankAccounts rdAccount;
                 RdAccount createAccount = new RdAccount();
                 if (createAccount.initCreateAccount(currentInstance)){
                     rdAccount = createAccount;
                     currentInstance.accountsList.add(rdAccount);
                     System.out.println("Account creation successful.Continue banking.");
                 }else
                     System.out.println("ACCOUNT CREATION FAILED!! Retry");
             }
             break;

             default:{
                 System.out.println("INVALID OPTION!!");
             }break;
         }

     }else {
            currentInstance = new BankCustomer();
         if(customerRegistration(currentInstance, customerList))
             System.out.println("CUSTOMER REGISTRATION SUCCESSFULL");
         else System.out.println("CUSTOMER REGISTRATION FAILED");
     }

    }

    private BankCustomer isExistingCustomer( List<BankCustomer> customerList){
        String aadharNumber;
        //Scanner sf = new Scanner(System.in);
        //System.out.println("ENTER your AADHAR number for Verification.");
        //aadharNumber = sf.nextLine().replaceAll(" ","");
        aadharNumber = Utilities.scanAadharNumber();
        for (BankCustomer temp : customerList){
            if (aadharNumber.equals(temp.getAadharNumber())){
                return temp;
            }
        }
        return null;
    }

    public boolean customerRegistration(BankCustomer currentInstance, List<BankCustomer> customerList){
        System.out.println("You are a new customer.Please enter details to register with the bank before account creation.");
        currentInstance.setName(Utilities.scanCustomerName());
        if (currentInstance.getName() == null)return false;

        currentInstance.setAadharNumber(Utilities.scanAadharNumber());
        if (currentInstance.getAadharNumber() == null)return false;

        currentInstance.setPanNumber(Utilities.scanPanNumber());
        if (currentInstance.getPanNumber() == null)return false;

        customerList.add(currentInstance);
        return true;
    }

    public void initNetBanking(List<BankCustomer> customerList){
        String aadharNumber;
        boolean isValidCustomer = false;
        aadharNumber = Utilities.scanAadharNumber();
        for (BankCustomer temp : customerList){
            if(aadharNumber.equals(temp.getAadharNumber()) ){
                if (!temp.accountsList.isEmpty()) {
                    isValidCustomer = true;
                    System.out.println("CUSTOMER EXISTS");
                    BankingOperations loginInstance = new BankingOperations();
                    loginInstance.initLogin(temp);
                }else {
                    isValidCustomer = true;
                    System.out.println("THERE IS NO ACCOUNT CREATED FOR THIS CUSTOMER.PLEASE CREATE ACCOUNT BEFORE USING NET BANKING.!!");
                    break;
                }
            }
            else isValidCustomer = false;
        }
        if (!isValidCustomer)
        System.out.println("INVALID CUSTOMER");
    }

}
