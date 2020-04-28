package createaccount;

import userdetails.SavingsAccountHolderDetails;

import java.util.*;

public class SavingsAccount {

    private String name;
    private String aadharNumber;
    private String panNumber;
    private String userName;
    private String password;
    //private final byte MAX_DATA_ENTRY_RETRIES = 3;
    private Boolean continueAccountCreation;

    public Boolean initCreateAccount(SavingsAccountHolderDetails bdOneInstance, SavingsAccount saOneInstance, AccountNumberGenerator genNumber ){
        if(scanUserDetails(saOneInstance)) {
            bdOneInstance.setName(saOneInstance.name);
            bdOneInstance.setAadharNumber(saOneInstance.aadharNumber);
            bdOneInstance.setPanNumber(saOneInstance.panNumber);
            bdOneInstance.setUserName(saOneInstance.userName);
            bdOneInstance.setPassword(saOneInstance.password);
            bdOneInstance.setAccountNumber(genNumber.generateSavingsAccountNumber());
            return true;
        }
        else{
            System.out.println("TRY CREATING ACCOUNT FROM BEGINNING");
            return false;
        }
    }

    private boolean scanUserDetails(SavingsAccount saOneInstance) {
       // byte retries = 0;
       // while (true) {
            String str;
            Scanner sf = new Scanner(System.in);

            //NAME
            while (true) {
                System.out.println("Enter your NAME");
                saOneInstance.name = sf.nextLine();
                if (validateName(saOneInstance.name)){
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
                saOneInstance.aadharNumber = sf.nextLine();
                if (validateAadharNumber(saOneInstance.aadharNumber)){
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
                saOneInstance.panNumber = sf.nextLine();
                if (validatePanNumber(saOneInstance.panNumber)){
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
                saOneInstance.userName = sf.nextLine();
                if (validateUserName(saOneInstance.userName)){
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
                saOneInstance.password = sf.nextLine();
                System.out.println("RE-Enter your PASSWORD");
                str = sf.nextLine();
                if (saOneInstance.password.equals(str)) {
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

//    private boolean validateUserData(SavingsAccount saOneInstance) {
//        if (saOneInstance.name.matches("[a-zA-Z_]+") && (saOneInstance.aadharNumber.length() == 12 && aadharNumber.matches("[0-9]+")) && saOneInstance.panNumber.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}") && saOneInstance.userName.matches("[a-z][0-9]"))
//            return true;
//        else
//            return false;
//    }
}
