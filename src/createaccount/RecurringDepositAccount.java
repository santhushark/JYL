package createaccount;

import userdetails.RecurringAccountHolderDetails;

import java.util.Scanner;

public class RecurringDepositAccount {
    private String name;
    private String aadharNumber;
    private String panNumber;
    private String userName;
    private String password;
    private String recurringDepositTenure;
    private String recurringDepositAmt;
    private String currentRecurringDeposit;
    private Boolean continueAccountCreation;

    public RecurringDepositAccount() {
        this.name = null;
        this.aadharNumber = null;
        this.panNumber = null;
        this.userName = null;
        this.password = null;
        this.recurringDepositTenure = null;
        this.recurringDepositAmt = null;
        this.currentRecurringDeposit = null;
        this.continueAccountCreation = false;
    }

    public boolean initCreateAccount(RecurringAccountHolderDetails bdOneInstance, RecurringDepositAccount rdaOneInstance, AccountNumberGenerator genNumber){
        if(scanUserDetails(rdaOneInstance)) {
            bdOneInstance.setName(rdaOneInstance.name);
            bdOneInstance.setAadharNumber(rdaOneInstance.aadharNumber);
            bdOneInstance.setPanNumber(rdaOneInstance.panNumber);
            bdOneInstance.setUserName(rdaOneInstance.userName);
            bdOneInstance.setPassword(rdaOneInstance.password);
            bdOneInstance.setRecurringDepositTenure(Integer.parseInt(rdaOneInstance.recurringDepositTenure));
            bdOneInstance.setRecurringDepositAmt(Double.parseDouble(rdaOneInstance.recurringDepositAmt));
            bdOneInstance.setCurrentRecurringDeposit(Double.parseDouble(rdaOneInstance.currentRecurringDeposit));
            bdOneInstance.setAccountNumber(genNumber.generateRecurringDepositAccountNumber());
            return true;
        }
        else{
            System.out.println("TRY CREATING ACCOUNT FROM BEGINNING");
            return false;
        }
    }

    private boolean scanUserDetails(RecurringDepositAccount rdaOneInstance){
        String str;
        Scanner sf = new Scanner(System.in);

        //NAME
        while (true) {
            System.out.println("Enter your NAME");
            rdaOneInstance.name = sf.nextLine();
            if (validateName(rdaOneInstance.name)){
                break;
            }else {
                if(!this.continueAccountCreation)
                    break;
            }
        }
        if (!this.continueAccountCreation)
            return false;

        //AADHAR NUMBER
        while (true) {
            System.out.println("Enter your AADHAR NUMBER");
            rdaOneInstance.aadharNumber = sf.nextLine();
            if (validateAadharNumber(rdaOneInstance.aadharNumber)){
                break;
            }else {
                if (!this.continueAccountCreation)
                    break;
            }
        }
        if (!this.continueAccountCreation)
            return false;

        //PAN NUMBER
        while (true) {
            System.out.println("Enter your PAN NUMBER");
            rdaOneInstance.panNumber = sf.nextLine();
            if (validatePanNumber(rdaOneInstance.panNumber)){
                break;
            }
            else {
                if (!this.continueAccountCreation)
                    break;
            }
        }
        if (!this.continueAccountCreation)
            return false;

        //USERNAME
        while (true) {
            System.out.println("Enter your USERNAME");
            rdaOneInstance.userName = sf.nextLine();
            if (validateUserName(rdaOneInstance.userName)){
                break;
            }else {
                if (!this.continueAccountCreation)
                    break;
            }
        }
        if (!this.continueAccountCreation)
            return false;

        //RECURRING DEPOSIT TENURE
        while (true){
            System.out.println("Enter Recurring DEPOSIT TENURE in MONTHS");
            rdaOneInstance.recurringDepositTenure = sf.nextLine();
            if (validateRdTenure(rdaOneInstance.recurringDepositTenure)){
                break;
            }else {
                if (!this.continueAccountCreation)
                    break;
            }
        }
        if (!this.continueAccountCreation)
            return false;

        //RECURRING DEPOSIT AMOUNT
        while (true){
            System.out.println("Enter the AMOUNT you want to put into RECURRING DEPOSIT every month");
            rdaOneInstance.recurringDepositAmt = sf.nextLine();
            if (validateRdAmount(rdaOneInstance.recurringDepositAmt)){
                break;
            }else {
                if (!this.continueAccountCreation)
                    break;
            }
        }
        if (!this.continueAccountCreation)
            return false;


        //CURRENT RECURRING DEPOSIT AMOUNT
        {
            System.out.println("PRESS Y/y to make your first month DEPOSIT else any other character");
            char choice = userDecides();
            if (choice == 'Y' || choice == 'y')
                this.currentRecurringDeposit = this.recurringDepositAmt;
            else this.currentRecurringDeposit = "0";
        }


        //PASSWORD
        while (true) {
            System.out.println("Enter your PASSWORD");
            rdaOneInstance.password = sf.nextLine();
            System.out.println("RE-Enter your PASSWORD");
            str = sf.nextLine();
            if (rdaOneInstance.password.equals(str)) {
                break;
            } else
                System.out.println("PASSWORDS DO NOT MATCH");
        }

        //DONE SCANNING ALL THE DETAILS
        return true;

//            if (validateUserData(saOneInstance)) {
//                System.out.println("USER DATA VALIDATED!!");
//                return true;
//            } else {
//                if(retries == MAX_DATA_ENTRY_RETRIES){
//                    return false;
//                }else {
//                    System.out.println("INVALID USER DATA, PLEASE RE-ENTER");
//                }
//            }
        //}
    }

    private char userDecides(){
        Scanner sf = new Scanner(System.in);
        System.out.println("INVALID INPUT");
        System.out.println("Press Y/y to continue creating account else any other character");
        return sf.next().charAt(0);
    }

    private boolean validateName(String nameReplica){
        if (nameReplica.matches("[a-zA-Z_]+")){
            this.continueAccountCreation = true;
            return true;
        }else {
            char choice = userDecides();
            if (choice == 'Y' || choice == 'y') {
                this.continueAccountCreation = true;
                return false;
            }else {
                this.continueAccountCreation = false;
                return false;
            }
        }
    }

    private boolean validateAadharNumber(String aadharNumberReplica){
        if (aadharNumberReplica.length() == 12 && aadharNumberReplica.matches("[0-9]+")){
            this.continueAccountCreation = true;
            return true;
        }else {
            char choice = userDecides();
            if (choice == 'Y' || choice == 'y') {
                this.continueAccountCreation = true;
                return false;
            }else {
                this.continueAccountCreation = false;
                return false;
            }
        }
    }

    private boolean validatePanNumber(String panNumberReplica){
        if (panNumberReplica.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}")){
            this.continueAccountCreation = true;
            return true;
        }else {
            char choice = userDecides();
            if (choice == 'Y' || choice == 'y') {
                this.continueAccountCreation = true;
                return false;
            }else {
                this.continueAccountCreation = false;
                return false;
            }
        }
    }

    private boolean validateUserName(String userNameReplica){
        if (userNameReplica.matches("[a-zA-Z]+[0-9]+")){
            this.continueAccountCreation = true;
            return true;
        }else {
            char choice = userDecides();
            if (choice == 'Y' || choice == 'y') {
                this.continueAccountCreation = true;
                return false;
            }else {
                this.continueAccountCreation = false;
                return false;
            }
        }
    }

    private boolean validateRdTenure(String recurringDepositTenureReplica){
        if(recurringDepositTenureReplica.matches("[0-9]+")){
            this.continueAccountCreation = true;
            return true;
        }else {
            char choice = userDecides();
            if (choice == 'Y' || choice == 'y'){
                this.continueAccountCreation = true;
                return false;
            }else {
                this.continueAccountCreation = false;
                return false;
            }
        }
    }

    private boolean validateRdAmount(String fixedDepositReplica){
        if(fixedDepositReplica.matches("[0-9]+")){
            this.continueAccountCreation = true;
            return true;
        }else {
            char choice = userDecides();
            if (choice == 'Y' || choice == 'y'){
                this.continueAccountCreation = true;
                return false;
            }else {
                this.continueAccountCreation = false;
                return false;
            }
        }
    }

//    private boolean validateUserData(SavingsAccount saOneInstance) {
//        if (saOneInstance.name.matches("[a-zA-Z_]+") && (saOneInstance.aadharNumber.length() == 12 && aadharNumber.matches("[0-9]+")) && saOneInstance.panNumber.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}") && saOneInstance.userName.matches("[a-z][0-9]"))
//            return true;
//        else
//            return false;
//    }
}
