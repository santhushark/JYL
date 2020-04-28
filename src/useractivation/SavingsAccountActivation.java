package useractivation;
import userdetails.SavingsAccountHolderDetails;

import java.util.List;
import java.util.Scanner;

public class SavingsAccountActivation {
    private String accountNumber;
    private String userName;
    private String password;

    public void initAccountActivation(List<SavingsAccountHolderDetails> saListCopy){
        scanDetails();
        if(startActivation(saListCopy)){
            System.out.println("ACCOUNT ACTIVATION SUCCESSFULL!!!");
        }else System.out.println("INVALID CREDENTIALS!! ACTIVATION FAILED");
    }

    private void scanDetails(){
        Scanner sf = new Scanner(System.in);
        System.out.println("######   ENTER CREDENTIALS   ######");
        System.out.println("Enter ACCOUNT NUMBER");
        this.accountNumber = sf.nextLine();
        System.out.println("Enter USERNAME");
        this.userName = sf.nextLine();
        System.out.println("Enter PASSWORD");
        this.password = sf.nextLine();
    }

    private boolean startActivation(List<SavingsAccountHolderDetails> saListCopy){
        for (SavingsAccountHolderDetails temp : saListCopy) {
            if (this.accountNumber.equals(temp.getAccountNumber()) && this.userName.equals(temp.getUserName()) && this.password.equals(temp.getPassword())){
                temp.setAccountActivated(true);
                return true;
            }
        }
        return false;
    }
}
