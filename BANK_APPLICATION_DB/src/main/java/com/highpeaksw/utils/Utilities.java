package com.highpeaksw.utils;

import java.util.Random;
import java.util.Scanner;

public class Utilities {



    private static boolean validateName(String nameReplica){
        if (nameReplica.matches("[a-zA-Z ]+")){
            return true;
        }else {
            return false;
        }
    }

    private static boolean validateAadharNumber(String aadharNumberReplica){
        if (aadharNumberReplica.length() == 12 && aadharNumberReplica.matches("[0-9 ]+")){
            return true;
        }else {
            return false;
        }
    }

    private static boolean validatePanNumber(String panNumberReplica){
        if (panNumberReplica.matches("[A-Za-z]{5}[0-9]{4}[A-Za-z]{1}")){
            return true;
        }else {
            return false;
        }
    }

    private static boolean validateUserName(String userName){
        if (userName.matches("[a-zA-Z]+[0-9]+")){
            return true;
        }else {
            return false;
        }
    }

    private static boolean validatePassword(String password){
        if (password.matches("[a-zA-Z]+[0-9]+") && (password.length() > 5))return true;
        else return false;
    }


    public static String scanCustomerName(){
        Scanner sf = new Scanner(System.in);
        String name;
        byte retryCount = 0;
        while (true) {
            System.out.println("Enter your NAME");
            name = sf.nextLine();
            if (validateName(name)){
                return name;
            }else {
                if (retryCount++ < 3){
                    System.out.println("INVALID !! NAME should have characters between [A - Z]");
                }else {
                    System.out.println("3 RETRIES OVER !! TRY REGISTERING FROM BEGINNING");
                    return null;
                }
            }
        }
    }

    public static String scanAadharNumber(){
        Scanner sf = new Scanner(System.in);
        String aadharNumber;
        byte retryCount = 0;
        while (true) {
            System.out.println("Enter your AADHAR NUMBER");
            aadharNumber = sf.nextLine();
            String a=aadharNumber.replaceAll(" ","");
            if (validateAadharNumber(a)){
                return a;
            }else {
                if (retryCount++ < 3){
                    System.out.println("INVALID !! AADHAR NUMBER should be of 12 characters [0 - 9]");
                }else {
                    System.out.println("3 RETRIES OVER !! TRY REGISTERING FROM BEGINNING");
                    return null;
                }
            }
        }
    }

    public static String scanPanNumber(){
        Scanner sf = new Scanner(System.in);
        String panNumber;
        byte retryCount = 0;
        while (true) {
            System.out.println("Enter your PAN NUMBER");
            panNumber = sf.nextLine();
            if (validatePanNumber(panNumber)){
                return panNumber;
            }
            else {
                if (retryCount++ < 3){
                    System.out.println("INVALID !! PAN NUMBER should have characters atleast [A-Z]{5 char}[0-9]{4 char}[A-Z]{1 char}");
                }else {
                    System.out.println("3 RETRIES OVER !! TRY REGISTERING FROM BEGINNING");
                    return null;
                }
            }
        }
    }
    public static String scanUserName() {
        Scanner sf = new Scanner(System.in);
        String userName;
        byte retryCount = 0;
        while (true) {
            System.out.println("Enter your USERNAME");
            userName = sf.nextLine();
            if (validateUserName(userName)) {
                return userName;
            } else {
                if (retryCount++ < 3){
                    System.out.println("INVALID !! USERNAME should have [a-z][A-Z][0-9] characters");
                }else {
                    System.out.println("3 RETRIES OVER");
                }
            }
        }
    }


    public static String scanAccountNumber(){
        String accountNumber;
        Scanner sf = new Scanner(System.in);
        while (true){
            System.out.println("Enter ACCOUNT NUMBER");
            accountNumber = sf.nextLine();
            if (accountNumber.matches("[0-9]+") && (accountNumber.length() >= 4)){
                return accountNumber;
            }
            else System.out.println("INVALID ACCOUNT NUMBER");
        }
    }


    //PASSWORD
    public static String scanPassword() {
        String str;
        Scanner sf = new Scanner(System.in);
        String password;
        byte retryCount = 0;
        while (true) {
            System.out.println("Enter your PASSWORD");
            password = sf.nextLine();
            System.out.println("RE-Enter your PASSWORD");
            str = sf.nextLine();
            if (password.equals(str) && validatePassword(password)) {
                return password;
            } else
            if (retryCount++ < 3){
                System.out.println("INVALID PASSWORD !! [a-z][A-Z][0-9] and length greater than 5");
            }else {
                System.out.println("3 RETRIES OVER!! TRY ACCOUNT CREATION FROM BEGINNING");
            }
        }
    }

    public static int generateAccountNumber(){
        Random rand = new Random();
        int value = rand.nextInt(10000000);
        return value;
    }

    public static double scanDepositAmount(){
        Scanner sf = new Scanner(System.in);
        double depositAmount;
        while (true) {
            System.out.println("Enter the amount of MONEY you want to DEPOSIT");
            try {
                depositAmount = Double.parseDouble(sf.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
        return Math.abs(depositAmount);
    }


    public static double scanWithdrawAmount(){
        Scanner sf = new Scanner(System.in);
        double depositAmount;
        while (true) {
            System.out.println("Enter the amount of MONEY you want to WITHDRAW");
            try {
                depositAmount = Double.parseDouble(sf.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
        return Math.abs(depositAmount);
    }


    public static int scanTenure(String type){
        String tenure;
        Scanner sf = new Scanner(System.in);
        while (true) {
            if (type.equals("FIXED DEPOSIT")) {
                System.out.println("ENTER FD ACCOUNT TENURE IN YEARS");
            } else {
                System.out.println("ENTER RD ACCOUNT TENURE IN MONTHS");
            }
            tenure = sf.nextLine();
            if(validateRdFdTenure(tenure))
                return Integer.parseInt(tenure);
            else System.out.println("INVALID INPUT");
        }
    }

    private static boolean validateRdFdTenure(String recurringDepositTenureReplica){
        if(recurringDepositTenureReplica.matches("[0-9]+")){
            return true;
        }else return false;
    }

}