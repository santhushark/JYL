package netbanking.bankingoperations.depositmoney;

import userdetails.CurrentAccountHolderDetails;

import java.util.Scanner;

public class CurrentAccountDepositMoney {

    private double depositAmount;

    public void initDepositMoney(CurrentAccountDepositMoney oneInstance, CurrentAccountHolderDetails userInstance){
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

    private void updateAccountBalance(CurrentAccountHolderDetails userInstance, double amountToDeposit){
        userInstance.setAccountBalance((userInstance.getAccountBalance() + amountToDeposit));
        System.out.println("YOUR ACCOUNT BALANCE IS : "+ userInstance.getAccountBalance());
    }
}
