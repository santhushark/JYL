import java.util.*;
import netbanking.CurrentAccountBankerLogin;
import netbanking.SavingsAccountBankerLogin;
import userdetails.*;
import useractivation.*;
import netbanking.RecurringDepositAccountBankerLogin;
import createaccount.*;

public class BankApplication {
//iam main class
    public static void main(String[] args) {
        char choice;
        Scanner sf = new Scanner(System.in);
        System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("      $                                      $");
        System.out.println("      $        STATE BANK OF HIGHPEAK        $");
        System.out.println("      $                                      $");
        System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        AccountNumberGenerator generateNumber = new AccountNumberGenerator();

        List<CurrentAccountHolderDetails> currentAccountUserList = new LinkedList<CurrentAccountHolderDetails>();
        List<SavingsAccountHolderDetails> savingsAccountUserList = new LinkedList<SavingsAccountHolderDetails>();
        List<FixedDepositAccountHolderDetails> fixedDepositAccountUserList = new LinkedList<FixedDepositAccountHolderDetails>();
        List<RecurringAccountHolderDetails> recurringAccountUserList = new LinkedList<RecurringAccountHolderDetails>();

        do{
            System.out.println();
            System.out.println("PLEASE enter the kind of operation you want to perform, SELECT A B or C");
            System.out.println();
            System.out.println("****  A) CREATE ACCOUNT"+"    "+"B) NET BANKING"+"    "+"C) ACTIVATE USER  *****");
            System.out.print("-> ");
            choice = sf.next().charAt(0);

            switch (choice){

                case 'A' : {
                    //System.out.println("IAM IN CREATE ACCOUNT");
                    System.out.println("Select the TYPE of ACCOUNT you want to create, SELECT A B C or D");
                    System.out.println("****  A) SAVINGS ACCOUNT"+"    "+"B) CURRENT ACCOUNT"+"    "+"C) FIXED DEPOSIT ACCOUNT"+"    "+"D) RECURRING DEPOSIT ACCOUNT   *****");
                    choice = sf.next().charAt(0);
                    switch (choice){

                        case 'A' : {//SAVINGS ACCOUNT
                            //System.out.println("Creating SB Account");
                            SavingsAccountHolderDetails oneInstance = new SavingsAccountHolderDetails();
                            SavingsAccount saInstance = new SavingsAccount();
                            if(saInstance.initCreateAccount(oneInstance,saInstance,generateNumber)){
                                System.out.println("Account Creation SUCCESSFULL!!");
                                System.out.println("ACTIVATE your Account, ENJOY BANKING!!!");
                                savingsAccountUserList.add(oneInstance);
                            }else{
                                System.out.println("Account Creation FAILED... TRY AGAIN!!!");
                            }
                        }
                        break;

                        case 'B' : {//CURRENT ACCOUNT
                            //System.out.println("Creating Current Account");
                            CurrentAccountHolderDetails oneInstance = new CurrentAccountHolderDetails();
                            CurrentAccount caInstance = new CurrentAccount();
                            if(caInstance.initCreateAccount(oneInstance,caInstance,generateNumber)){
                                System.out.println("Account Creation SUCCESSFULL!!");
                                System.out.println("ACTIVATE your Account, ENJOY BANKING!!!");
                                currentAccountUserList.add(oneInstance);
                            }else{
                                System.out.println("Account Creation FAILED... TRY AGAIN!!!");
                            }
                        }
                        break;

                        case 'C' : {//FD ACCOUNT
                            //System.out.println("Creating FD Account");
                            FixedDepositAccountHolderDetails oneInstance = new FixedDepositAccountHolderDetails();
                            FixedDepositAccount fdInstance = new FixedDepositAccount();
                            if (fdInstance.initCreateAccount(oneInstance,fdInstance,generateNumber)){
                                System.out.println("FIXED DEPOSIT Account Creation SUCCESSFULL!!");
                                System.out.println("ACTIVATE your FIXED DEPOSIT ACCOUNT!!");
                                fixedDepositAccountUserList.add(oneInstance);
                            }else {
                                System.out.println("Account Creation FAILED... TRY AGAIN!!!");
                            }
                        }
                        break;

                        case 'D' : {//RD ACCOUNT
                            //System.out.println("Creating RD Account");
                            RecurringAccountHolderDetails oneInstance = new RecurringAccountHolderDetails();
                            RecurringDepositAccount rdInstance = new RecurringDepositAccount();
                            if (rdInstance.initCreateAccount(oneInstance,rdInstance,generateNumber)){
                                System.out.println("RECURRING DEPOSIT Account Creation SUCCESSFULL!!");
                                System.out.println("ACTIVATE your RECURRING DEPOSIT ACCOUNT!!");
                                recurringAccountUserList.add(oneInstance);
                            }else {
                                System.out.println("ACCOUNT Creation FAILED... TRY AGAIN!!!");
                            }
                        }
                        break;

                        default: {
                            System.out.println("INVALID OPTION : No operation associated with it!");
                        }
                        break;

                    }
                }
                break;

                case 'B' : {
                    //System.out.println("IAM IN NET BANKING");
                    System.out.println("TO BEGIN WITH NET-BANKING SELECT YOUR TYPE OF ACCOUNT, Select A B or C");
                    System.out.println("****   A) SAVINGS ACCOUNT     B) CURRENT ACCOUNT    C) RECURRING DEPOSIT ACCOUNT   ****");
                    choice = sf.next().charAt(0);
                    switch (choice){

                        case 'A' : {//SAVINGS ACCOUNT NET BANKING
                            SavingsAccountBankerLogin oneInstance = new SavingsAccountBankerLogin();
                            oneInstance.initUserLogin(savingsAccountUserList,currentAccountUserList, oneInstance);
                        }
                        break;

                        case 'B' : {//CURRENT ACCOUNT NET BANKING
                            CurrentAccountBankerLogin oneInstance = new CurrentAccountBankerLogin();
                            oneInstance.initUserLogin(currentAccountUserList, savingsAccountUserList, oneInstance);

                        }
                        break;

                        case 'C' : {//RD ACCOUNT NET BANKING
                            RecurringDepositAccountBankerLogin oneInstance = new RecurringDepositAccountBankerLogin();
                            oneInstance.initUserLogin(recurringAccountUserList, oneInstance);

                        }
                        break;

                        default: System.out.println("INVALID OPTION!! THERE IS NO OPERATION ASSOCIATED WITH IT!");
                        break;

                    }

                }
                break;

                case 'C' : {
                    //System.out.println("IAM IN ACTIVATE USER");
                    System.out.println("TO BEGIN WITH ACCOUNT ACTIVATION SELECT YOUR TYPE OF ACCOUNT, Select A B C or D");
                    System.out.println("****   A) SAVINGS ACCOUNT     B) CURRENT ACCOUNT    C) RECURRING DEPOSIT ACCOUNT     D) FIXED DEPOSIT ACCOUNT   ****");
                    choice = sf.next().charAt(0);
                    switch (choice){

                        case 'A' : {//SAVINGS ACCOUNT ACTIVATION
                            SavingsAccountActivation activationInstance = new SavingsAccountActivation();
                            activationInstance.initAccountActivation(savingsAccountUserList);
                        }
                        break;

                        case 'B' : {//CURRENT ACCOUNT ACTIVATION
                            CurrentAccountActivation activationInstance = new CurrentAccountActivation();
                            activationInstance.initAccountActivation(currentAccountUserList);
                        }
                        break;

                        case 'C' : {//RD ACCOUNT ACTIVATION
                            RecurringDepositAccountActivation activationInstance = new RecurringDepositAccountActivation();
                            activationInstance.initAccountActivation(recurringAccountUserList);
                        }
                        break;

                        case 'D' : {//FD ACCOUNT ACTIVATION
                            FixedDepositAccountActivation activationInstance = new FixedDepositAccountActivation();
                            activationInstance.initAccountActivation(fixedDepositAccountUserList);
                        }
                        break;

                        default: System.out.println("INVALID OPTION!! THERE IS NO OPERATION ASSOCIATED WITH IT!!");
                        break;
                    }

                }
                break;

                default: {
                    System.out.println("INVALID OPTION : No operation associated with it!");
                }
                break;

            }

            System.out.println("PRESS Y/y to continue BANKING else any other character");
            choice = sf.next().charAt(0);


        }while(choice == 'y' || choice == 'Y');
    }
}

