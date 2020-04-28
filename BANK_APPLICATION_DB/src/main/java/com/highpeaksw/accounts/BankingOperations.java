package com.highpeaksw.accounts;

import com.highpeaksw.customer.BankCustomer;
import com.highpeaksw.utils.SqlUtilities;
import com.highpeaksw.utils.Utilities;

import java.util.Scanner;

public class BankingOperations {

    public void initLogin(BankCustomer customerInstance) {
        byte retryCount = 1;
        boolean logout = false;
        System.out.println("PLEASE LOGIN");
        BankAccount temp;
        while (true) {
            if ((temp = SqlUtilities.tryLogin(customerInstance)) != null) {
                initBankOperations(temp);
                logout = true;
            }
            if (!logout) {
                if (++retryCount < 3) {
                    System.out.println("INVALID CREDENTIALS: PLEASE TRY LOGGING IN AGAIN");
                } else {
                    System.out.println("REACHED MAX RETRIES");
                    break;
                }
            } else break;
        }
    }

    private void initBankOperations(BankAccount accountInstance) {
        Scanner sf = new Scanner(System.in);
        boolean logout = false;
        char choice;
        while (!logout) {
            System.out.println("PLEASE SELECT THE KIND OF OPERATION YOU WANT TO PERFORM");
            System.out.println("*****   A) DEPOSIT     B) WITHDRAW    C) BALANCE ENQUIRY     D) LOGOUT    ******");
            choice = Character.toUpperCase(sf.next().charAt(0));
            switch (choice) {

                case 'A': {
                    if (accountInstance.getAccountType().equals("SAVINGS")) {
                        if (accountInstance.isAccountActive()) {
                            accountInstance.setAccountBalance(Utilities.scanDepositAmount() + accountInstance.getAccountBalance());
                            SqlUtilities.updateAccountTable(accountInstance);
                            System.out.println("DEPOSIT SUCCESSFULL!!");
                        }else {
                            System.out.println("ACCOUNT IS INACTIVE");
                        }
                    } else if (accountInstance.getAccountType().equals("CURRENT")) {
                        if (accountInstance.isAccountActive()) {
                            accountInstance.setAccountBalance(Utilities.scanDepositAmount() + accountInstance.getAccountBalance());
                            SqlUtilities.updateAccountTable(accountInstance);
                            System.out.println("DEPOSIT SUCCESSFULL!!");
                        }else {
                            System.out.println("ACCOUNT IS INACTIVE");
                        }
                    } else if (accountInstance.getAccountType().equals("FIXED DEPOSIT")) {
                        if (accountInstance.isAccountActive()) {
                            System.out.println("FD ACCOUNT!! ONLY ONE TIME DEPOSIT");
                        }else {
                            System.out.println("ACCOUNT IS INACTIVE");
                        }
                    } else if (accountInstance.getAccountType().equals("RECURRING DEPOSIT")) {
                        if (accountInstance.isAccountActive()) {
                            if (accountInstance.getRdCount() < accountInstance.getTenure()) {
                                System.out.println("PRESS Y/y to make your monthly deposit ? ");
                                choice = sf.next().charAt(0);
                                if (choice == 'Y' || choice == 'y') {
                                    accountInstance.setAccountBalance(accountInstance.getAccountBalance() + accountInstance.getRecurringDepositAmt());
                                    int rdCount = accountInstance.getRdCount();
                                    accountInstance.setRdCount(++rdCount);
                                    SqlUtilities.updateAccountTable(accountInstance);
                                    System.out.println("Monthly DEPOSIT Successfull !!");
                                }
                            } else {
                                System.out.println("YOUR RD Amount has MATURED. PLEASE WITHDRAW");
                            }
                        }else {
                            System.out.println("INACTIVE ACCOUNT! NO operations can be performed!!");
                            System.out.println("ACCOUNT HAS MATURED AND MONEY IS WITHDRAWN");
                        }
                    } else System.out.println("INVALID ACCOUNT TYPE!!");
                }
                break;

                case 'B': {

                    if (accountInstance.getAccountType().equals("SAVINGS")) {
                        if (accountInstance.isAccountActive()) {
                            double withdrawAmount = Utilities.scanWithdrawAmount();
                            if (accountInstance.getAccountBalance() >= withdrawAmount) {
                                accountInstance.setAccountBalance(accountInstance.getAccountBalance() - withdrawAmount);
                                SqlUtilities.updateAccountTable(accountInstance);
                            } else System.out.println("INSUFFICIENT BALANCE");
                        }else {
                            System.out.println("ACCOUNT IS INACTIVE");
                        }
                    } else if (accountInstance.getAccountType().equals("CURRENT")) {
                        if (accountInstance.isAccountActive()) {
                            double withdrawAmount = Utilities.scanWithdrawAmount();
                            if (accountInstance.getAccountBalance() >= withdrawAmount) {
                                accountInstance.setAccountBalance(accountInstance.getAccountBalance() - withdrawAmount);
                                SqlUtilities.updateAccountTable(accountInstance);
                            } else System.out.println("INSUFFICIENT BALANCE");
                        }else {
                            System.out.println("ACCOUNT IS INACTIVE");
                        }
                    } else if (accountInstance.getAccountType().equals("FIXED DEPOSIT")) {
                        if (accountInstance.isAccountActive()) {
                            System.out.println("CANNOT WITHDRAW UNTIL FD DEPOSIT TENURE EXPIRES");
                        }else {
                            System.out.println("ACCOUNT IS INACTIVE");
                        }
                    } else if (accountInstance.getAccountType().equals("RECURRING DEPOSIT")) {
                        if (accountInstance.isAccountActive()) {
                            if (accountInstance.getRdCount() == accountInstance.getTenure()) {
                                System.out.println("YOUR Account has matured");
                                System.out.println("WITHDRAW Amount: " + accountInstance.getAccountBalance());
                                System.out.println("Withdraw SUCCESSFULL!!");
                                accountInstance.setAccountActive(false);
                                accountInstance.setRecurringDepositAmt(0);
                                SqlUtilities.updateAccountTable(accountInstance);
                            } else {
                                System.out.println("CANNOT WITHDRAW UNTIL ACCOUNT MATURITY");
                            }
                        }else {
                            System.out.println("INACTIVE ACCOUNT! NO operations can be performed!!");
                            System.out.println("ACCOUNT HAS MATURED AND MONEY IS WITHDRAWN");
                        }
                    } else System.out.println("INVALID ACCOUNT TYPE!! DEBUG CODE");

                }
                break;

                case 'C': {
                    if (accountInstance.isAccountActive()) {
                        System.out.println("YOUR BALANCE IS : " + accountInstance.getAccountBalance());
                    }else {
                        System.out.println("INACTIVE ACCOUNT!!");
                    }
                }
                break;

                case 'D': {
                    logout = true;
                }
                break;

                default:
                    System.out.println("INVALID OPTION!! NO OPERATION ASSOCIATED WITH IT");
                    break;
            }

        }
    }
}