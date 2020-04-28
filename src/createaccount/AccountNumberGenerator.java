package createaccount;

public class AccountNumberGenerator {

    private int savingsAccountNumber;
    private int currentAccountNumber;
    private int fixedDepositAccountNumber;
    private int recurringDepositAccountNumber;

    public AccountNumberGenerator(){
        this.savingsAccountNumber = 1000;
        this.currentAccountNumber = 10000;
        this.fixedDepositAccountNumber = 20000;
        this.recurringDepositAccountNumber = 40000;
    }

    public String generateSavingsAccountNumber(){
        return Integer.toString(++this.savingsAccountNumber);
    }

    public String generateCurrentAccountNumber(){
        return Integer.toString(++this.currentAccountNumber);
    }

    public String generateFixedDepositAccountNumber(){
        return Integer.toString(++this.fixedDepositAccountNumber);
    }

    public String generateRecurringDepositAccountNumber(){
        return Integer.toString(++this.recurringDepositAccountNumber);
    }

}
