package netbanking.bankingoperations.depositmoney;

import userdetails.SavingsAccountHolderDetails;

import java.util.Scanner;

public class SavingAccountDepositMoney {

    private double depositAmount;

    public void initDepositMoney(SavingAccountDepositMoney oneInstance, SavingsAccountHolderDetails userInstance){
        System.out.println("**** DEPOSIT MONEY ****");
        this.depositAmount = scanDepositAmount();
        updateAccountBalance(userInstance, this.depositAmount);
    }

    private double scanDepositAmount(){
        Scanner sf = new Scanner(System.in);
        System.out.println("Enter the amount of MONEY you want to DEPOSIT");
        while (true) {
            System.out.println("Type a double-type number:");
            try {
                this.depositAmount = Double.parseDouble(sf.next());
                break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
        return this.depositAmount;
    }

    private void updateAccountBalance(SavingsAccountHolderDetails userInstance, double amountToDeposit){
        userInstance.setAccountBalance((userInstance.getAccountBalance()+amountToDeposit));
        System.out.println("YOUR BALANCE IS : "+ userInstance.getAccountBalance());
    }

}
