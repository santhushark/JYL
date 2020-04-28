package createaccount;

import userdetails.FixedDepositAccountHolderDetails;

import java.util.Scanner;

public class FixedDepositAccount {
    private String name;
    private String aadharNumber;
    private String panNumber;
    private String userName;
    private String password;
    private String fixedDepositTenure;
    private String fixedDeposit;
    private boolean continueAccountCreation;

    public FixedDepositAccount() {
        this.name = null;
        this.aadharNumber = null;
        this.panNumber = null;
        this.userName = null;
        this.password = null;
        this.fixedDepositTenure = null;
        this.fixedDeposit = null;
        this.continueAccountCreation = false;
    }

    public boolean initCreateAccount(FixedDepositAccountHolderDetails bdOneInstance, FixedDepositAccount fdOneInstance, AccountNumberGenerator genNumber){
        if(scanUserDetails(fdOneInstance)) {
            bdOneInstance.setName(fdOneInstance.name);
            bdOneInstance.setAadharNumber(fdOneInstance.aadharNumber);
            bdOneInstance.setPanNumber(fdOneInstance.panNumber);
            bdOneInstance.setUserName(fdOneInstance.userName);
            bdOneInstance.setPassword(fdOneInstance.password);
            bdOneInstance.setFixedDepositTenure(Integer.parseInt(fdOneInstance.fixedDepositTenure));
            bdOneInstance.setFixedDeposit(Double.parseDouble(fdOneInstance.fixedDeposit));
            bdOneInstance.setAccountNumber(genNumber.generateFixedDepositAccountNumber());
            return true;
        }
        else{
            System.out.println("TRY CREATING ACCOUNT FROM BEGINNING");
            return false;
        }
    }

    private boolean scanUserDetails(FixedDepositAccount fdOneInstance){
        String str;
        Scanner sf = new Scanner(System.in);

        //NAME
        while (true) {
            System.out.println("Enter your NAME");
            fdOneInstance.name = sf.nextLine();
            if (validateName(fdOneInstance.name)){
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
            fdOneInstance.aadharNumber = sf.nextLine();
            if (validateAadharNumber(fdOneInstance.aadharNumber)){
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
            fdOneInstance.panNumber = sf.nextLine();
            if (validatePanNumber(fdOneInstance.panNumber)){
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
            fdOneInstance.userName = sf.nextLine();
            if (validateUserName(fdOneInstance.userName)){
                break;
            }else {
                if (!this.continueAccountCreation)
                    break;
            }
        }
        if (!this.continueAccountCreation)
            return false;

        //FIXED DEPOSIT TENURE
        while (true){
            System.out.println("Enter FIXED DEPOSIT TENURE in YEARS");
            fdOneInstance.fixedDepositTenure = sf.nextLine();
            if (validateFdTenure(fdOneInstance.fixedDepositTenure)){
                break;
            }else {
                if (!this.continueAccountCreation)
                    break;
            }
        }
        if (!this.continueAccountCreation)
            return false;

        //FIXED DEPOSIT AMOUNT
        while (true){
            System.out.println("Enter the AMOUNT you want to put into FIXED DEPOSIT");
            fdOneInstance.fixedDeposit = sf.nextLine();
            if (validateFdAmount(fdOneInstance.fixedDeposit)){
                break;
            }else {
                if (!this.continueAccountCreation)
                    break;
            }
        }
        if (!this.continueAccountCreation)
            return false;

        //PASSWORD
        while (true) {
            System.out.println("Enter your PASSWORD");
            fdOneInstance.password = sf.nextLine();
            System.out.println("RE-Enter your PASSWORD");
            str = sf.nextLine();
            if (fdOneInstance.password.equals(str)) {
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
        System.out.println("Invalid INPUT");
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

    private boolean validateFdTenure(String fixedDepositTenureReplica){
        if(fixedDepositTenureReplica.matches("[0-9]+")){
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

    private boolean validateFdAmount(String fixedDepositReplica){
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


