package netbanking.bankingoperations.depositmoney;

import userdetails.RecurringAccountHolderDetails;

import java.util.Scanner;

public class RecurringAccountDepositMoney {

    public void initDepositMoney(RecurringAccountDepositMoney oneInstance, RecurringAccountHolderDetails userInstance){
        System.out.println("**** DEPOSIT MONEY ****");
        char choice = userDecides();
        if (choice == 'Y' || choice == 'y')
            updateAccountBalance(userInstance);
        else
            System.out.println("NO PROBLEM! YOU MAY DEPOSIT LATER BEFORE DEADLINE");
    }

    private void updateAccountBalance(RecurringAccountHolderDetails userInstance){
        userInstance.setCurrentRecurringDeposit((userInstance.getCurrentRecurringDeposit() + userInstance.getRecurringDepositAmt()));
        System.out.println("YOUR ACCOUNT BALANCE IS : "+ userInstance.getCurrentRecurringDeposit());
    }

    private char userDecides(){
        Scanner sf = new Scanner(System.in);
        System.out.println("Press Y/y to continue Depositing Money");
        return sf.next().charAt(0);
    }
}
