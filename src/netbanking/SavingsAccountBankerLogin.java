package netbanking;

import netbanking.bankingoperations.depositmoney.SavingAccountDepositMoney;
import netbanking.bankingoperations.fundtransfer.SavingAccountFundTransfer;
import netbanking.bankingoperations.moneywithdraw.WithdrawMoneyFromSavingsAccount;
import userdetails.CurrentAccountHolderDetails;
import userdetails.SavingsAccountHolderDetails;

import java.util.List;
import java.util.Scanner;

public class SavingsAccountBankerLogin {
    private String userName;
    private String password;
    private String accountNumber;
    private final byte MAX_LOGIN_RETRIES = 3;

    public void initUserLogin(List<SavingsAccountHolderDetails> sbListCopy, List<CurrentAccountHolderDetails> caListCopy, SavingsAccountBankerLogin loginInstance){
        Scanner sf = new Scanner(System.in);
        SavingsAccountHolderDetails loggedInUserInstance = new SavingsAccountHolderDetails();
        byte retryCount = 0;
        Boolean continueBanking = false;
        Boolean inValidCredentials = false;
        System.out.println("WELCOME TO NETBANKING");
        while (true) {
            retryCount++;
            System.out.println("Enter ACCOUNT NUMBER");
            loginInstance.accountNumber = sf.nextLine();
            System.out.println("Enter USERNAME");
            loginInstance.userName = sf.nextLine();
            System.out.println("Enter PASSWORD");
            loginInstance.password = sf.nextLine();
            for (SavingsAccountHolderDetails temp : sbListCopy) {
                if (temp.getAccountNumber().equals(loginInstance.accountNumber) && temp.getUserName().equals(loginInstance.userName) && temp.getPassword().equals(loginInstance.password)) {
                    if (temp.getAccountActivated() == true) {
                        System.out.println("LOGIN SUCCESSFULL !! ");
                        loggedInUserInstance = temp;
                        continueBanking = true;
                        inValidCredentials = false;
                        break;
                    } else {
                        System.out.println("PLEASE ACTIVATE YOUR ACCOUNT!!");
                        continueBanking = false;
                        inValidCredentials = false;
                    }
                } else {
                    inValidCredentials = true;
                    continueBanking = false;
                }
            }
            if (inValidCredentials) {
                if (retryCount < MAX_LOGIN_RETRIES) {
                    System.out.println("INVALID CREDENTIALS! PLEASE RETRY");
                    continue;
                } else {
                    System.out.println("REACHED MAX RETRIES, TRY LOGGING IN AGAIN");
                    break;
                }
            }else
                break;
        }
            if (continueBanking) {
                //System.out.println("ADD BANKING OPERATIONS MENU HERE");
                bankingOperationsMenu(loggedInUserInstance, sbListCopy, caListCopy);

            }

        //}
    }

    private void bankingOperationsMenu(SavingsAccountHolderDetails userInstance, List<SavingsAccountHolderDetails> sbListCopy, List<CurrentAccountHolderDetails> caListCopy){
        Scanner sf = new Scanner(System.in);
        Boolean logout = false;
        char choice;
        while (true) {
            System.out.println("PLEASE select the kind of Operation you want to perform, Select A B C or D");
            System.out.println("****    A) DEPOSIT MONEY" + "   B) FUND TRANSFER" + "   C) WITHDRAW MONEY" + "   D) BALANCE ENQUIRY     E) LOGOUT    ****");
            choice = sf.next().charAt(0);
            switch (choice){

                case 'A' : {
                    SavingAccountDepositMoney oneInstance = new SavingAccountDepositMoney();
                    oneInstance.initDepositMoney(oneInstance, userInstance);
                }
                break;

                case 'B' : {
                    System.out.println("SELECT the type of account to which you want to transfer money, Select A or B");
                    System.out.println("****   A) SAVINGS ACCOUNT      B) CURRENT ACCOUNT   ****");
                    choice = sf.next().charAt(0);
                    switch (choice){

                        case 'A' :{
                            SavingAccountFundTransfer oneInstance = new SavingAccountFundTransfer();
                            oneInstance.initFundTransferToSavingAccount(userInstance,sbListCopy);
                        }
                        break;

                        case 'B' :{
                            SavingAccountFundTransfer oneInstance = new SavingAccountFundTransfer();
                            oneInstance.initFundTransferToCurrentAccount(userInstance,caListCopy);
                        }
                        break;

                        default: System.out.println("INVALID INPUT !!!");
                        break;

                    }

                }
                break;

                case 'C' : {
                    WithdrawMoneyFromSavingsAccount oneInstance = new WithdrawMoneyFromSavingsAccount();
                    oneInstance.initWithdrawMoney(userInstance);
                }
                break;

                case 'D' : {
                    System.out.println("Your Balance is : "+ userInstance.getAccountBalance());
                }
                break;

                case 'E' : {
                    logout = true;

                }
                break;

                default: {
                    System.out.println("INVALID OPTION!! NO OPERATION ASSOCIATED WITH IT.");
                }
                break;
            }

            if (logout)
                break;
        }
    }

}
