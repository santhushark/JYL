package netbanking.bankingoperations.fundtransfer;

import userdetails.CurrentAccountHolderDetails;
import userdetails.SavingsAccountHolderDetails;

import java.util.List;
import java.util.Scanner;

public class SavingAccountFundTransfer {

    private double transferAmount;
    private int beneficiaryAccountNumber;
    public void initFundTransferToSavingAccount(SavingsAccountHolderDetails loggedInUser, List<SavingsAccountHolderDetails> sbListCopy){
        if(scanTransferAmount() < loggedInUser.getAccountBalance()){
            if(scanBeneficiaryAccountNumber()){
                SavingsAccountHolderDetails temp = isValidSbAccountNumber(sbListCopy);
                if(temp != null){
                    temp.setAccountBalance(temp.getAccountBalance()+this.transferAmount);
                    loggedInUser.setAccountBalance(loggedInUser.getAccountBalance() - this.transferAmount);
                } else {
                    System.out.println("INVALID ACCOUNT NUMBER!! NO BENEFICIARY!!");
                }
            }
        }
        else
            System.out.println("INSUFFICIENT BALANCE !! FUND TRANSFER FAILED");
    }


    public void initFundTransferToCurrentAccount(SavingsAccountHolderDetails loggedInUser, List<CurrentAccountHolderDetails> caListCopy){
        if(scanTransferAmount() < loggedInUser.getAccountBalance()){
            if(scanBeneficiaryAccountNumber()){
                CurrentAccountHolderDetails temp = isValidCaAccountNumber(caListCopy);
                if(temp != null){
                    temp.setAccountBalance(temp.getAccountBalance()+this.transferAmount);
                    loggedInUser.setAccountBalance(loggedInUser.getAccountBalance() - this.transferAmount);
                } else {
                    System.out.println("INVALID ACCOUNT NUMBER!! NO BENEFICIARY!!");
                }
            }
        }
        else
            System.out.println("INSUFFICIENT BALANCE !! FUND TRANSFER FAILED");
    }


    private double scanTransferAmount(){
        System.out.println("Enter the Amount of money you want to Transfer");
        Scanner sf = new Scanner(System.in);
        while (true) {
            System.out.println("Type a double-type number:");
            try {
                this.transferAmount = Double.parseDouble(sf.next());
                return this.transferAmount;
                //break;
            } catch (NumberFormatException ignore) {
                System.out.println("Invalid input");
            }
        }
    }

    private boolean scanBeneficiaryAccountNumber(){
        System.out.println("Enter Beneficiary Account Number");
        Scanner sf = new Scanner(System.in);
        while (true){
            System.out.println("Type a Integer-type number:");
            try {
                this.beneficiaryAccountNumber = Integer.parseInt(sf.next());
                return true;
            }catch (NumberFormatException ignore){
                System.out.println("Invalid Input!!");
            }
        }
    }

    private SavingsAccountHolderDetails isValidSbAccountNumber(List<SavingsAccountHolderDetails> sbListCopy){
        for (SavingsAccountHolderDetails temp : sbListCopy){
            if (Integer.toString(this.beneficiaryAccountNumber).equals(temp.getAccountNumber()))
                return temp;
        }
        return null;
    }

    private CurrentAccountHolderDetails isValidCaAccountNumber(List<CurrentAccountHolderDetails> caListCopy){
        for (CurrentAccountHolderDetails temp : caListCopy){
            if (Integer.toString(this.beneficiaryAccountNumber).equals(temp.getAccountNumber()))
                return temp;
        }
        return null;
    }



}
