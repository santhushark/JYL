package com.highpeaksw.accounts;

import com.highpeaksw.customer.BankCustomer;
import com.highpeaksw.utils.Utilities;

import java.util.Scanner;

public class BankingOperations {

    public void initLogin(BankCustomer customerInstance){
        String accountNumber;
        String userName;
        String password;
        byte retryCount = 1;
        boolean logout = false;
        Scanner sf = new Scanner(System.in);
        System.out.println("YOUR LIST OF ACCOUNTS");
        System.out.println("***********************");
        for (BankAccounts temp : customerInstance.getAccountsList()){
            System.out.println(temp.getAccountType()+"  "+ temp.getAccountNumber());
        }
        System.out.println("***********************");
        System.out.println("PLEASE LOGIN");
        while (true) {
            System.out.println("Please enter Account Number");
            accountNumber = sf.nextLine();
            System.out.println("Enter USERNAME");
            userName = sf.nextLine();
            System.out.println("Enter PASSWORD");
            password = sf.nextLine();
            for (BankAccounts temp : customerInstance.getAccountsList()) {
                if (Integer.parseInt(accountNumber) == temp.getAccountNumber() && userName.equals(temp.getUserName()) && password.equals(temp.getPassword())) {
                    initBankOperations(temp);
                    logout = true;
                }
            }
            if(!logout) {
                if (++retryCount < 3) {
                    System.out.println("INVALID CREDENTIALS: PLEASE TRY LOGGING IN AGAIN");
                } else {
                    System.out.println("REACHED MAX RETRIES");
                    break;
                }
            }
            else break;
        }
    }

    private void initBankOperations(BankAccounts accountInstance) {
        Scanner sf = new Scanner(System.in);
        boolean logout = false;
        char choice;
        while (!logout) {
            System.out.println("PLEASE SELECT THE KIND OF OPERATION YOU WANT TO PERFORM");
            System.out.println("*****   A) DEPOSIT     B) WITHDRAW    C) BALANCE ENQUIRY     D) LOGOUT    ******");
            choice = Character.toUpperCase(sf.next().charAt(0));
            switch (choice){

                case 'A' : {
                    if(accountInstance.getAccountType().equals("SAVINGS")){
                        accountInstance.setAccountBalance(Utilities.scanDepositAmount() + accountInstance.getAccountBalance());
                    }
                    else if (accountInstance.getAccountType().equals("CURRENT")){
                        accountInstance.setAccountBalance(Utilities.scanDepositAmount() + accountInstance.getAccountBalance());
                    }
                    else if (accountInstance.getAccountType().equals("FIXEDDEPOSIT")){
                        if (accountInstance.isAccountActivated()){
                            System.out.println("FD ACCOUNT!! ONLY ONE TIME DEPOSIT");
                        }else {
                            accountInstance.setAccountBalance(Utilities.scanDepositAmount());
                            accountInstance.setAccountActivated(true);
                            accountInstance.setTenure(Utilities.scanTenure("FIXEDDEPOSIT"));
                        }
                    }
                    else if (accountInstance.getAccountType().equals("RECURRINGDEPOSIT")){
                        if (accountInstance.isAccountActivated()){
                            System.out.println("Would you like to make your monthly deposit ? ");
                            choice = sf.next().charAt(0);
                            if (choice == 'Y' || choice == 'y')
                                accountInstance.setAccountBalance(accountInstance.getAccountBalance() + accountInstance.getRecurringDepositAmt());
                        }else {
                            System.out.println("MONTHLY DEPOSIT AMOUNT");
                            accountInstance.setRecurringDepositAmt(Utilities.scanDepositAmount());
                            accountInstance.setAccountActivated(true);
                            accountInstance.setTenure(Utilities.scanTenure("RECURRINGDEPOSIT"));
                        }
                    }
                    else System.out.println("INVALID ACCOUNT TYPE!! DEBUG CODE");

                }break;

                case 'B' : {

                    if (accountInstance.getAccountType().equals("SAVINGS")){
                        double withdrawAmount = Utilities.scanWithdrawAmount();
                        if (accountInstance.getAccountBalance() >= withdrawAmount){
                            accountInstance.setAccountBalance(accountInstance.getAccountBalance() - withdrawAmount);
                        }
                        else System.out.println("INSUFFICIENT BALANCE");
                    }

                    else if (accountInstance.getAccountType().equals("CURRENT")){
                        double withdrawAmount = Utilities.scanWithdrawAmount();
                        if (accountInstance.getAccountBalance() >= withdrawAmount){
                            accountInstance.setAccountBalance(accountInstance.getAccountBalance() - withdrawAmount);
                        }
                        else System.out.println("INSUFFICIENT BALANCE");
                    }

                    else if (accountInstance.getAccountType().equals("FIXEDDEPOSIT")){
                        System.out.println("CANNOT WITHDRAW UNTIL FD DEPOSIT TENURE EXPIRES");
                    }

                    else if (accountInstance.getAccountType().equals("RECURRINGDEPOSIT")){
                        System.out.println("CANNOT WITHDRAW UNTIL RD TENURE EXPIRES");
                    }

                    else System.out.println("INVALID ACCOUNT TYPE!! DEBUG CODE");

                }break;

                case 'C' : {
                  System.out.println("YOUR BALANCE IS : "+ accountInstance.getAccountBalance());

                }break;

                case 'D' : {
                    logout = true;
                }break;

                default:System.out.println("INVALID OPTION!! NO OPERATION ASSOCIATED WITH IT");
                break;
            }

        }
    }
}
