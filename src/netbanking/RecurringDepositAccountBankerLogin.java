package netbanking;

import netbanking.bankingoperations.depositmoney.RecurringAccountDepositMoney;
import userdetails.RecurringAccountHolderDetails;

import java.util.List;
import java.util.Scanner;

public class RecurringDepositAccountBankerLogin {
    private String userName;
    private String password;
    private String accountNumber;
    private final byte MAX_LOGIN_RETRIES = 3;

    public void initUserLogin(List<RecurringAccountHolderDetails> listCopy, RecurringDepositAccountBankerLogin loginInstance){
        Scanner sf = new Scanner(System.in);
        RecurringAccountHolderDetails loggedInUserInstance = new RecurringAccountHolderDetails();
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
            for (RecurringAccountHolderDetails temp : listCopy) {
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
            }else break;
        }
            if (continueBanking){
                //System.out.println("ADD BANKING OPERATIONS MENU HERE");
                bankingOperationsMenu(loggedInUserInstance);

            }

        //}
    }

    private void bankingOperationsMenu(RecurringAccountHolderDetails userInstance){
        Scanner sf = new Scanner(System.in);
        Boolean logout = false;
        char choice;
        while (true) {
            System.out.println("PLEASE select the kind of Operation you want to perform, Select A or B:");
            System.out.println("****    A) DEPOSIT MONEY" + "   B) BALANCE ENQUIRY     C) LOGOUT    ****");
            choice = sf.next().charAt(0);
            switch (choice){

                case 'A' : {
                    RecurringAccountDepositMoney oneInstance = new RecurringAccountDepositMoney();
                    oneInstance.initDepositMoney(oneInstance, userInstance);
                }
                break;

                case 'B' : {
                    System.out.println("Your BALANCE IS : "+ userInstance.getCurrentRecurringDeposit());
                }
                break;

                case 'C' : {
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
