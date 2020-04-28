package useractivation;

import userdetails.CurrentAccountHolderDetails;

import java.util.List;
import java.util.Scanner;

public class CurrentAccountActivation {

    private String accountNumber;
    private String userName;
    private String password;

    public void initAccountActivation(List<CurrentAccountHolderDetails> caListCopy){
        scanDetails();
        if(startActivation(caListCopy)){
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

    private boolean startActivation(List<CurrentAccountHolderDetails> caListCopy){
        for (CurrentAccountHolderDetails temp : caListCopy) {
            if (this.accountNumber.equals(temp.getAccountNumber()) && this.userName.equals(temp.getUserName()) && this.password.equals(temp.getPassword())){
                temp.setAccountActivated(true);
                return true;
            }
        }
        return false;
    }

}
