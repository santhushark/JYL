package netbanking.bankingoperations.moneywithdraw;

import userdetails.CurrentAccountHolderDetails;

import java.util.Scanner;

public class WithdrawMoneyFromCurrentAccount {

    private double withdrawalAmount;

    public void initWithdrawMoney(CurrentAccountHolderDetails loggedInUser){
        if (scanWithdrawAmount() <= loggedInUser.getAccountBalance()){
            loggedInUser.setAccountBalance(loggedInUser.getAccountBalance() - this.withdrawalAmount);
            System.out.println("PLEASE COLLECT YOUR CASH OF AMOUNT: "+this.withdrawalAmount);
        }
        else
            System.out.println("INSUFFICIENT BALANCE!! WITHDRAWAL FAILED !!");
    }

    private double scanWithdrawAmount(){
        System.out.println("Enter the Amount of money you want to Transfer");
        Scanner sf = new Scanner(System.in);
        while (true) {
            System.out.println("Type a double-type number:");
            try {
                this.withdrawalAmount = Double.parseDouble(sf.next());
                return this.withdrawalAmount;
                //break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
    }
}
