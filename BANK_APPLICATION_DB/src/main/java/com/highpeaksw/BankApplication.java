package com.highpeaksw;

import com.highpeaksw.customer.BankCustomer;
import com.highpeaksw.utils.SqlUtilities;

import java.util.Scanner;

public class BankApplication {

    public static void main(String[] args) {
        char choice;
        Scanner sf = new Scanner(System.in);
        System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("      $                                      $");
        System.out.println("      $        STATE BANK OF HIGHPEAK        $");
        System.out.println("      $                                      $");
        System.out.println("      $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        SqlUtilities.initHibernateConfig();

        do {
            System.out.println();
            System.out.println("PLEASE enter the kind of operation you want to perform, SELECT A or B");
            System.out.println();
            System.out.println("****  A. CREATE ACCOUNT" + "    " + "B. NET BANKING        *****");
            choice = Character.toUpperCase(sf.next().charAt(0));
            switch (choice) {

                case 'A': {
                    BankCustomer customer = new BankCustomer();
                    customer.initCreateAccount(customer);
                }
                break;

                case 'B': {
                    BankCustomer customer = new BankCustomer();
                    customer.initNetBanking(null);
                }
                break;

                default: {
                    System.out.println("THERE IS NO OPERATION ASSOCIATED WITH THE OPTION YOU HAVE ENTERED");
                }
                break;

            }

            System.out.println("PRESS Y/y to continue BANKING else any other character to EXIT.");
            choice = sf.next().charAt(0);

        } while (choice == 'Y' || choice == 'y');
    }
}