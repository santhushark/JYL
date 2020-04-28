package useractivation;
import userdetails.FixedDepositAccountHolderDetails;

import java.util.List;
import java.util.Scanner;

public class FixedDepositAccountActivation {

    private String accountNumber;
    private String userName;
    private String password;

    public void initAccountActivation(List<FixedDepositAccountHolderDetails> fdListCopy){
        scanDetails();
        if(startActivation(fdListCopy)){
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

    private boolean startActivation(List<FixedDepositAccountHolderDetails> fdListCopy){
        for (FixedDepositAccountHolderDetails temp : fdListCopy) {
            if (this.accountNumber.equals(temp.getAccountNumber()) && this.userName.equals(temp.getUserName()) && this.password.equals(temp.getPassword())){
                temp.setAccountActivated(true);
                return true;
            }
        }
        return false;
    }
}
